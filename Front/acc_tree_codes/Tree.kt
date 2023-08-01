package com.example.new_test

import com.example.new_test.ui.theme.AAC
import com.example.new_test.ui.theme.AACX
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

// node
class Node(){
    var _id : Int = -1
    var name : String = "name"
    var node_status : NodeStatus = NodeStatus.NOT_USING
    var child_index_list = ArrayList<Int>()
    // --------------------------------------------------
    fun setID(id : Int){this._id = id}
    fun getID() : Int  = this._id
    @JvmName("callFromString")
    fun setName(name : String) {this.name = name}
    @JvmName("callFromString")
    fun getName() : String = this.name
    fun setNodeStatus( status : NodeStatus) { this.node_status = status}
    fun getNodeStatus() : NodeStatus = this.node_status
    // 자식 노드 인덱스 세팅 (만약 자식이 없다면 0번째 데이터가 -1)
    fun setChildIndexList(index_list : List<Int>) {
        for (arg in index_list)
            child_index_list.add(arg)
    }
    fun getChildIndexList() : ArrayList<Int> = this.child_index_list
    // 노드 생성자 (인덱스, 이름, 자식 노드)
    fun node_init(id : Int, name : String, index_list : ArrayList<Int>) {
        this._id = id; this.name = name; this.child_index_list = index_list
    }
    // == 오버라이딩
    override fun equals(other : Any?) : Boolean {
        if ( this === other ) return true
        if ( other !is Node ) return false
        return this._id == other._id && this.name == other.name
    }
    // print 오버라이딩
    override fun toString() : String{
        return "Vertex id : $this._id, Vertex name : $this.name, Status : ${this.node_status}"
    }
}

// 노드를 가지고 있는 리스트
class NodeList(var size : Int){
    var node_Array = Array(size) { Node() }
    // 루트 노드를 미리 저장
    //var root_node : Array<Int> = emptyArray()
    var num_node : Int = 0
    init{
        println("Create Node  List | ( $this.num_nodes ) size) ")
    }

    // 노드 접근자
    fun getNode(index : Int) : Node {
        if (this.isInvalid(index))
            return this.node_Array[index]
        else
            throw ArithmeticException("Invalid Execss !")
            //return Node()
    }
    @JvmName("callFromInt")
    fun getSize() : Int = this.num_node
    // 노드 인덱스에 맞춰서 배열에 삽입
    fun addNode(node : Node){
        if (this.num_node < this.size){
            val index = node.getID()
            node_Array[index] = node
            this.num_node++
        }
        else
            println("NodeList is FULL !!!")
    }
    // valid 한 index인지 검사
    fun isInvalid(index : Int) : Boolean{
        if (index >= 0 && index < this.size) return true else return false
    }
}

// 트리 구조에서 생성될 실제 노드와 포인터
/// 자신 : self_node, 자식 : child_node
class Tree_Node(val self_node : Node) {
    var child_tree_node = ArrayList<Tree_Node>()
    var num_child : Int = 0
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
        if (this == other) return true
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
    fun _makeChild(now_node : Tree_Node){
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
            // Tree node 자식 배열 포인터로 세팅
            now_node_list.add(temp_node)
            // Tree 자체 보관용 포인터
            this.nodes.add(temp_node)
        }
        // 노드 포인터 저장
        now_node.setChildNodePointer(now_node_list)

        // 재귀
        for (node in now_node_list) {
            this._makeChild(node)
        }

        // 재귀 탈출 (같은 층에 노드가 더 없을 때)
        return
    }

    //var latest_pick : Tree_Node = this.nodes[0]
    var num_pick : Int = 0
    var pick_history = ArrayList<Tree_Node>()

    // ***** 트리 생성후 바로 루트 노드 받아갈 것  ********
    fun getRootNode() : Tree_Node {
        this.num_pick ++
        pick_history.add(this.nodes[0])
        return this.nodes[0]
    }
    // 자식 노드가 있는지 확인해준다. 없다면 false 반환
    fun isChildExist( now_node : Tree_Node ) : Boolean {
        return now_node.getNumChild() > 0
    }
    // 아래 함수를 실행하기 전에 isChildExist()로 자식을 확인할것
    fun selectNodeFlow(now_node : Tree_Node) : ArrayList<Tree_Node> {
        // 자식 수가 0이면 null을 반환
        now_node.setNodeStatus(NodeStatus.USING)
        //if (now_node.getNumChild() <= 0) {
            //return null}
        // 후진인지 확인, 후진이라면 히스토리에서 마지막 제거
        // 정상동작 하지않음
        /*
        if (pick_history.contains(now_node)){
            var remove_node : Tree_Node = this.pick_history.removeLast()
            remove_node.setNodeStatus(NodeStatus.NOT_USING)
        }
        else
        */
            this.pick_history.add(now_node)

        var child_nodes : ArrayList<Tree_Node> = now_node.getChild()
        return child_nodes
    }

    // 사용 내역을 지우고, 노드 스테이터스를 제거
    fun clearTree(){
        for (i in 0..num_pick)
        {
            var remove_node : Tree_Node = this.pick_history.removeLast()
            remove_node.setNodeStatus(NodeStatus.NOT_USING)
        }
    }
}


class MakeNode()
{
    val gson = Gson()
    val JSON_PATH = "D:\\kotlin\\app\\src\\main\\assets\\json_data_edit.json"
    val fileContent = File(JSON_PATH).readText()
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

fun main(){
    // 노드 생성 ( 앱 실행 초기 상태)
    var make : MakeNode = MakeNode()
    val node_list : NodeList = make.make_node_list()

    // 루트 노드 지정 ( 여기선 101 == 카페 로 지정)
    val node : Node = node_list.getNode(101)

    // aac tree 생성
    val aac_tree = AAC_Tree(101, node_list)
    // tree에서 루트 노드 접근
    var now_node : Tree_Node = aac_tree.getRootNode()
    // 자식 노드 리스트 초기화
    var child_node_list : ArrayList<Tree_Node> = arrayListOf()

    var pick_index : Int = 0

    // 스트링 조합이 되는지 확인
    var pick_string : ArrayList<String> = arrayListOf()
    var now_string : String = ""

    while(true){
        println(" ")
        print("now_node : ")
        print(now_node.getId())
        println(" ")

        // 자식이 존재하는지 확인
        if (aac_tree.isChildExist(now_node)) {
            // 자식이 있다면 선택된 노드의 자식 리스트 접근
            child_node_list = aac_tree.selectNodeFlow(now_node)
            // 사이즈 체크
            print("now_node size : ")
            print(child_node_list.size)
            println(" ")
            print("childe : ")
            // 반환된 노드 리스트가 있는지 확인
            if (child_node_list != null) {
                for (child in child_node_list)
                {
                    print(child.getId())
                    print(", ")
                }
            }
            // 선택한 노드 (임의)
            if (pick_index < child_node_list.size) {
                now_node = child_node_list[pick_index]
                pick_string.add(child_node_list[pick_index].getName())
            }
            else {
                now_node = child_node_list[0]
                pick_string.add(child_node_list[0].getName())
            }
        }
        else
            break
        println(" ")
        println("#--------------------------------#")
    }
    for (arg in pick_string)
    {
        print(arg)
    }
}



