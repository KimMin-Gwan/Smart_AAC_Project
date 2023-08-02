package com.example.new_test

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
    // �ڽ� ��� �ε��� ���� (���� �ڽ��� ���ٸ� 0��° �����Ͱ� -1)
    fun setChildIndexList(index_list : List<Int>) {
        for (arg in index_list)
            child_index_list.add(arg)
    }
    fun getChildIndexList() : ArrayList<Int> = this.child_index_list
    // ��� ������ (�ε���, �̸�, �ڽ� ���)
    fun node_init(id : Int, name : String, index_list : ArrayList<Int>) {
        this._id = id; this.name = name; this.child_index_list = index_list
    }
    // == �������̵�
    override fun equals(other : Any?) : Boolean {
        if ( this === other ) return true
        if ( other !is Node ) return false
        return this._id == other._id && this.name == other.name
    }
    // print �������̵�
    override fun toString() : String{
        return "Vertex id : $this._id, Vertex name : $this.name, Status : ${this.node_status}"
    }
}

// ��带 ������ �ִ� ����Ʈ
class NodeList(var size : Int){
    var node_Array = Array(size) { Node() }
    // ��Ʈ ��带 �̸� ����
    //var root_node : Array<Int> = emptyArray()
    var num_node : Int = 0
    init{
        println("Create Node  List | ( $this.num_nodes ) size) ")
    }

    // ��� ������
    fun getNode(index : Int) : Node {
        if (this.isInvalid(index))
            return this.node_Array[index]
        else
            throw ArithmeticException("Invalid Execss !")
        //return Node()
    }
    @JvmName("callFromInt")
    fun getSize() : Int = this.num_node
    // ��� �ε����� ���缭 �迭�� ����
    fun addNode(node : Node){
        if (this.num_node < this.size){
            val index = node.getID()
            node_Array[index] = node
            this.num_node++
        }
        else
            println("NodeList is FULL !!!")
    }

    // valid �� index���� �˻�
    fun isInvalid(index : Int) : Boolean{
        if (index >= 0 && index < this.size && node_Array[index].getID() != -1) return true else return false
    }
}

