package com.example.data.source.remote



import android.app.Application
import android.content.Context
import android.util.Log
import com.example.data.model.remote.AAC
import com.example.json.Node
import com.example.json.NodeList
import com.google.gson.Gson
import org.json.JSONArray
import java.io.File
import java.security.KeyStore.TrustedCertificateEntry
import java.lang.ArithmeticException
import java.util.Dictionary

enum class NodeStatus {
    USING,
    NOT_USING,
    Disable
}

// 트리 구조에서 생성될 실제 노드와 포인터
/// 자신 : self_node, 자식 : child_node
class Tree_Node(val self_node : Node) {
    var child_tree_node = ArrayList<Tree_Node>()
    var num_child : Int = 0

    fun setLevel(level: Int) {
        this.self_node.level = level
    }
    fun setChildNodePointer(tree_node_list : ArrayList<Tree_Node>) {
        this.child_tree_node = tree_node_list
        this.num_child = this.child_tree_node.size
    }

    // 현재 노드의 이름 접근
    fun getName() : String = this.self_node.getName()
    fun getId() : Int = this.self_node.getID()
    fun getChildNodeList() : ArrayList<Int> = this.self_node.getChildIndexList()
    fun getNumChild() : Int = this.num_child
    fun getChild() : ArrayList<Tree_Node> = this.child_tree_node
    fun setNodeStatus(status : NodeStatus) { this.self_node.setNodeStatus(status) }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Tree_Node) return false
        return this.self_node == other.self_node
    }
}

// 트리 알고리즘
class AAC_Tree(var root_index :Int, val node_list : NodeList)
{
    // nodes[0] == root
    val nodes = ArrayList<Tree_Node>()
    var root : Node = Node()
    var child_history = ArrayList<ArrayList<Int>>() // 자식 배열 정리
    init{
        try{
            this.root = node_list.getNode(this.root_index)
        } catch(e : ArithmeticException){
            println("Caught exception : ${e.message}")
        }
        println("Create Node  List | ( ${this.root.getName()}) size) ")
        val root_node = Tree_Node(this.root)
        this.makeTree(root_node)
    }
    //재귀함수로 구성해야함
    fun makeTree(root_node : Tree_Node){
        this.nodes.add(root_node)
        this._makeChild(root_node)
    }

    // 재귀 부분
    fun _makeChild(now_node : Tree_Node, currentLevel: Int = 0){
        val child_list : ArrayList<Int> = now_node.getChildNodeList()
        var now_node_list = ArrayList<Tree_Node>()
        // 재귀 탈출 (자식이 더 없을 때)
        if (child_list.size <= 0)
            return
        // 자식 노드를 하나씩 Tree Node로 생성
        for (node in child_list)
        {
            // 노드를 생성
            val temp_node = Tree_Node(this.node_list.getNode(node))
            temp_node.setLevel(currentLevel + 1)  // 레벨 설정
            // Tree node 자식 배열 포인터로 세팅
            now_node_list.add(temp_node)
            // Tree 자체 보관용 포인터
            this.nodes.add(temp_node)
        }
        // 노드 포인터 저장
        now_node.setChildNodePointer(now_node_list)

        // 재귀
        for (node in now_node_list) {
            this._makeChild(node, currentLevel + 1)  // 다음 레벨로 재귀
        }

        // 재귀 탈출 (같은 층에 노드가 더 없을 때)
        return
    }

    //var latest_pick : Tree_Node = this.nodes[0]
    var pick_history = ArrayList<Tree_Node>()
    var now_layer : Int = 0
    var pick_string : ArrayList<String> = arrayListOf()

    // ***** 트리 생성후 바로 루트 노드 받아갈 것  ********
    fun getRootNode() : Tree_Node {
        val childHistory1d = ArrayList<Int>()
        childHistory1d.add(this.root_index)
        this.child_history.add(childHistory1d)
        this.now_layer += 0
        return this.nodes[0]
    }

    // 자식 노드가 있는지 확인해준다. 없다면 -2반환, 있다면  -1 반환
    // 선택된 노드 위치가 이상 layer 값을 반환
    /*
    1. 현재 레이어 위치에 있는 노드가 맞는지 확인한다.
    2. 현재 레이어 위치에 있다면 자식노드가 있는지 확인한다.
    3. 자식노드가 있다면 -1을 반환
    4. 자식노드가 없다면 -2를 반환
    5. 현재 레이어 위치에 없다면 몇번째 레이어인지 확인
    6. 찾아낸 레이어 위치를 반환
    */
    fun isChildExist( now_node : Tree_Node ) : Int{
        // 1. 현재 레이어 위치에 있는 노드가 맞는지 확인한다.
        //println(child_history[this.now_layer])
        if (child_history[this.now_layer].contains(now_node.getId())) {
            // 2. 현재 레이어 위치에 있다면 자식노드가 있는지 확인한다.
            if (now_node.getNumChild() > 0)
            // 3. 자식노드가 있다면 -1을 반환
                return -1
            else
            // 4. 자식노드가 없다면 -2를 반환
                return -2
        }
        else {
            for (idx in 0..child_history.size) {
                // 5. 현재 레이어 위치에 없다면 몇번째 레이어인지 확인
                if (child_history[idx].contains( now_node.getId()))
                // 6. 찾아낸 레이어 위치를 반환
                    return idx
                else
                    continue
            }
            throw ArithmeticException("Could not find now_node")
        }
    }
    // 아래 함수를 실행하기 전에 isChildExist()로 자식을 확인할것
    // 만약
    fun selectNodeFlow(now_node : Tree_Node,  layer : Int = -1) : ArrayList<Tree_Node> {
        // 자식 수가 0이면 null을 반환
        now_node.setNodeStatus(NodeStatus.USING)
        //if (now_node.getNumChild() <= 0) {
        //return null}
        // layer 값이 양수라면 후진
        if (layer >= 0)
            this.__nodeFlowBackword(now_node, layer)

        this.pick_history.add(now_node)
        this.now_layer += 1
        this.__setPickString() // 스트링 생성

        /*
        1. 자식 노드 받아옴
        2. 자식 노드 어레이 리스트에 저장
        3. 2에서 저장한 배열을 한번 더 저장
        */
        val childHistory1d = ArrayList<Int>()

        // 자식 노드 받아오기
        var child_nodes : ArrayList<Tree_Node> = now_node.getChild()
        for (arg in child_nodes)
        {
            childHistory1d.add(arg.getId())
        }
        this.child_history.add(childHistory1d)
        return child_nodes
    }
    // 이전에 존재하던 선택되지 않은 노드가 다시 선택됨
    private fun __nodeFlowBackword(now_node : Tree_Node, layer : Int){
        val temp_child_history : ArrayList<Int> = this.child_history[layer]
        if (layer != -1){
            // 현재 선택된 노드의 레이어 층 아래를 모두 지운다
            for (idx in (layer + 1)..(this.child_history.size - 1)) {
                this.child_history.removeAt(layer + 1)
            }
            // 노드 사용기록들 중 현재 선택한 노드 뒤를 모두 지움
            for (idx in (layer) .. (this.pick_history.size - 1)) {
                this.pick_history[layer].setNodeStatus((NodeStatus.NOT_USING))
                this.pick_history.removeAt(layer)
            }
            this.__setPickString(false) // 스트링 생성
            this.now_layer = layer
        }
        else
            throw ArithmeticException("Invalid Index")
        return
    }
    // 선택된 스트링 생성
    private fun __setPickString(flag : Boolean = true){
        // flag == true 이면 뒤에 추가
        if (flag)
            this.pick_string.add(this.pick_history[this.now_layer - 1].getName())
        // flag == false 이면 다지우고 다시 추가
        else {
            this.pick_string.clear()
            for (arg in this.pick_history)
                this.pick_string.add(arg.getName())
        }
    }
    // 스트링 접근자
    fun getString() : ArrayList<String> = this.pick_string
}


//일상 pass NODE
class MakeNode(context: Context)
{
    val assetManager = context.assets
    val inputStream = assetManager.open("json_data_edit.json")
    val fileContent = inputStream.bufferedReader().use { it.readText() }
    val gson = Gson()
    val datas : AAC = gson.fromJson(fileContent, AAC::class.java)
    val size : Int = datas.AAC.last().id
    val node_list : NodeList = NodeList(this.size + 1)

    // 노드 생성기
    fun make_node_list() : NodeList{
        for (dataObject in this.datas.AAC) {
            val node : Node = Node()
            node.setID(dataObject.id)
            node.setName(dataObject.name)
            node.setChildIndexList(dataObject.node)
            node_list.addNode(node)
        }
        return node_list
    }
}


//긴급 NODE
class MakeUrgencyNode(context: Context)
{
    val assetManager = context.assets
    val inputStream = assetManager.open("json_data_urgency.json")
    val fileContent = inputStream.bufferedReader().use { it.readText() }
    val gson = Gson()
    val datas : AAC = gson.fromJson(fileContent, AAC::class.java)
    val size : Int = datas.AAC.last().id

    val node_list : NodeList = NodeList(this.size + 1)

    // 노드 생성기
    fun make_node_list() : NodeList{
        for (dataObject in this.datas.AAC) {
            val node : Node = Node()
            node.setID(dataObject.id)
            node.setName(dataObject.name)
            node.setChildIndexList(dataObject.node)
            node_list.addNode(node)
        }
        return node_list
    }
}

// Root_Category maker
class Make_Root_Category()
{
    val min_index = 100
    val max_index = 200
    // 루트 카테고리는 Integer형태로, 인덱스만 보관
    var root_category = ArrayList<Int>()
    var size : Int = 0

    // 기본적인 루트 카테고리 세팅
    fun get_default_root_category(node_list : NodeList) : ArrayList<Int>
    {
        // 100부터 200사이에 루트노드를 검색
        for (idx in this.min_index..this.max_index)
        {
            if (node_list.isInvalid(idx))
            {
                this.root_category.add(idx)
                this.size += 1
            }
            // 100 부터 순차적으로 찾아볼때 invalid함 데이터면 더이상 루트노드는 없다
            else
                break
        }
        return this.root_category
    }

    // gps를 통해 카테고리를 추천할 때
    fun get_gps_root_category(node_list : NodeList, gps_data : List<Int>) :ArrayList<Int>
    {
        // 100부터 200사이에 루트노드를 검색
        for (idx in this.min_index..this.max_index)
        {
            if (node_list.isInvalid(idx))
            {
                this.root_category.add(idx)
                this.size += 1
            }
            // 100 부터 순차적으로 찾아볼때 invalid함 데이터면 더이상 루트노드는 없다
            else
                continue
        }
        Log.d("gps_data", gps_data.toString())
        for ( arg in gps_data )
        {
            Log.d("root_category", this.root_category.toString())
            if (this.root_category.isEmpty() || !this.root_category.contains(arg))
                throw ArithmeticException("Invalid Index")
            // 데이터 삭제
            this.root_category.remove(arg)

            // 맨 앞으로 옮기기
            this.root_category.add(0, arg)
        }
        return this.root_category
    }

    fun get_root_category_size() : Int = this.size
}


//fun main(){
//    val application : Application
//    // 노드 생성 ( 앱 실행 초기 상태)
//    val node_maker : MakeNode = MakeNode()
//    val root_maker : Make_Root_Category = Make_Root_Category()
//    val node_list : NodeList = node_maker.make_node_list()
//    val root_category : ArrayList<Int> = root_maker.get_default_root_category(node_list)
//    print("root_category : ")
//    println(root_category)
//    // 루트 노드 지정 ( 여기선 101 == 카페 로 지정)
//    val node : Node = node_list.getNode(root_category[0])
//    // aac tree 생성
//    val aac_tree = AAC_Tree(101, node_list)
//    // tree에서 루트 노드 접근
//    var now_node : Tree_Node = aac_tree.getRootNode()
//    var temp_node : Tree_Node = aac_tree.nodes[2]
//    // 자식 노드 리스트 초기화
//    var child_node_list : ArrayList<Tree_Node> = arrayListOf()
//
//
//    var pick_index : Int = 0
//
//    // 스트링 조합이 되는지 확인
//    var pick_string : ArrayList<String> = arrayListOf()
//    var now_string : String = ""
//
//    while(true){
//        println(" ")
//        print("now_node : ")
//        print(now_node.getId())
//        println(" ")
//
//        // 자식이 존재하는지 확인
//        var flag = aac_tree.isChildExist((now_node))
//        print("flag : ")
//        println(flag)
//        if (flag >= -1) {
//            // 자식이 있다면 선택된 노드의 자식 리스트 접근
//            child_node_list = aac_tree.selectNodeFlow(now_node, flag)
//            // 사이즈 체크
//            // 반환된 노드 리스트가 있는지 확인
//            print("child : ")
//            if (child_node_list != null) {
//                for (child in child_node_list)
//                {
//                    print(child.getId())
//                    print(", ")
//                }
//            }
//
//
//            // 선택한 노드 (임의)
//            // 4021번일때 1번 레이어의 2010번 노드로 재진입 한다고 가정
//            if (pick_index < child_node_list.size) {
//                if (now_node.getId() == 101){
//                    temp_node = child_node_list[1]
//                }
//                if (now_node.getId() == 4021) {
//                    now_node = temp_node
//                }
//                else{
//                    now_node = child_node_list[pick_index]
//                }
//            }
//            else
//                now_node = child_node_list[0]
//        }
//
//        else
//            break
//        println(" ")
//        println("#--------------------------------#")
//    }
//    for (arg in aac_tree.getString())
//    {
//        print(arg)
//    }
//}