package com.example.data.repository

import com.example.data.source.remote.MakeUrgencyNode
import com.example.data.source.remote.Tree_Node
import com.example.json.NodeList


interface FindNodeRepository {


      fun MakeNode() : NodeList

      fun MakeUrgencyNode() : NodeList

      fun MakeRootCategory(node_list : NodeList) : ArrayList<Int>

      fun MakeRootGpsCategory(node_list : NodeList, categoryId : List<Int>) : ArrayList<Int>

      fun RootNode(selectedId : Int)

      fun RootUrgencyNode(selectedId: Int)

      fun getAAC_Tree(selectedId: Int): ArrayList<Tree_Node>

      fun getAAC_Urgency_Tree(selectedId: Int): ArrayList<Tree_Node>
//      fun getChildNode(treeNode: Tree_Node) : ArrayList<Tree_Node>


}