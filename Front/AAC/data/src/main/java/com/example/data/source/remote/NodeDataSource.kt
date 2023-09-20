package com.example.json

import android.util.Log
import com.example.data.source.remote.NodeStatus

// node
class Node(){
    var _id : Int = -1
    var name : String = "name"
    var node_status : NodeStatus = NodeStatus.NOT_USING
    var child_index_list = ArrayList<Int>()
    var level: Int = 0
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
class NodeList(private var size : Int){
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
            Log.d("index", index.toString())
            node_Array[index] = node
            this.num_node++
        }
        else
            println("NodeList is FULL !!!")
    }

    // valid 한 index인지 검사
    fun isInvalid(index : Int) : Boolean{
        if (index >= 0 && index < this.size && node_Array[index].getID() != -1) return true else return false
    }
}