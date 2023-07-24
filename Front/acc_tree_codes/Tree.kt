//package com.example.new_test

import java.lang.ArithmeticException
import java.security.KeyStore.TrustedCertificateEntry

enum class NodeStatus {
    USING,
    NOT_USING,
    Disable
}

// node
class Node(){
    var _id : Int = -1
    var name : String = ""
    var node_status : NodeStatus = NodeStatus.NOT_USING
    var child_index_list = ArrayList<Int>()
    // --------------------------------------------------
    fun setID(id : Int){this._id = id}
    fun getID() : Int  = this._id
    fun setName(name : String) {this.name = name}
    fun getName() : String = this.name
    fun setNodeStatus( status : NodeStatus) { this.node_status = status}
    fun getNodeStatus() : NodeStatus = this.node_status
    // 자식 노드 인덱스 세팅 (만약 자식이 없다면 0번째 데이터가 -1)
    fun setChildIndexList(index_list : Array<Int>) {
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
        if ( other !is Vertex ) return false
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
    fun getSize() : Int = this.num_node
    // 노드 인덱스에 맞춰서 배열에 삽입
    fun addNode(node : Node){
        if (this.num_node < this.size){
            var index = node.getID()
            node_Array[index] = node
            this.num_node++
        }
        else
            println("NodeList is FULL !!!")
    }
    // valid 한 index인지 검사
    fun isInvalid(index : Int) : Boolean{
        if (index >= 0 && index < this.num_node) return true else return false
    }
}

// 트리 구조에서 생성될 실제 노드와 포인터
/// 자신 : self_node, 자식 : child_node
class Tree_Node(val self_node : Node) {
    var child_node = ArrayList<Node>()
    // 자식 노드 설정
    fun setChildNode(node_list : NodeList) {
        var child_list : ArrayList<Int> = this.self_node.getChildIndexList()
        var num_child : Int = child_list.size
        // child_node는 각각의 노드에 대한 포인터
        for (arg in child_list) {
            child_node.add(node_list.getNode(arg))
        }
    }
    // 현재 노드의 이름 접근
    fun getName() : String = this.self_node.getName()
    fun getChild() : ArrayList<Node> = this.child_node
}

// 트리 알고리즘
class ACC_Tree(var root_index :Int, var node_list : NodeList)
{
    // nodes[0] == root
    var nodes = ArrayList<Tree_Node>()
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
        this.makeChild(root_node)
    }

    fun makeChild(now_node : Tree_Node){
        var child_list : ArrayList<Node> = now_node.getChild()
        var now_node_list = ArrayList<Tree_Node>()
        // 재귀 탈출 (자식이 더 없을 때)
        if (child_list[0].getID() == -1)
            return
        for (node in child_list)
        {
            now_node_list.add(Tree_Node(node))
            this.nodes.add(Tree_Node(node))
        }
        // 재귀
        for (node in now_node_list) {
            this.makeChild(node)
        }
        // 재귀 탈출 (같은 층에 노드가 더 없을 때)
        return
    }
}







