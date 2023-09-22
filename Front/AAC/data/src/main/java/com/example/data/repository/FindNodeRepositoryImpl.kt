package com.example.data.repository

import android.content.Context
import android.util.Log
import com.example.data.source.remote.AAC_Tree
import com.example.data.source.remote.MakeNode
import com.example.data.source.remote.Make_Root_Category
import com.example.data.source.remote.Tree_Node
import com.example.json.NodeList
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class FindNodeRepositoryImpl @Inject constructor(@ApplicationContext private val context:Context) :
    FindNodeRepository {

    val node_list = MakeNode()

     override fun MakeNode(): NodeList {
         val node_maker = MakeNode(context)
         val node_list : NodeList = node_maker.make_node_list()

         return node_list
    }

    override fun MakeRootCategory(node_list : NodeList): ArrayList<Int> {
        val root_maker: Make_Root_Category = Make_Root_Category()
        val root_category: ArrayList<Int> = root_maker.get_default_root_category(node_list)

        Log.d("root_category", root_category.toString())
        return root_category

    }

    override fun MakeRootGpsCategory(node_list : NodeList, categoryId : List<Int>): ArrayList<Int> {
        val root_maker: Make_Root_Category = Make_Root_Category()
        val root_category: ArrayList<Int> = root_maker.get_gps_root_category(node_list, categoryId)

        Log.d("root_category", root_category.toString())
        return root_category

    }

    override fun RootNode(selectedId: Int) {
        node_list.getNode(selectedId)
    }

    override fun getAAC_Tree(selectedId: Int) : ArrayList<Tree_Node>{
        node_list.getNode(selectedId)
        val aactree = AAC_Tree(selectedId, node_list)
        Log.d("AAC_Tree", aactree.getRootNode().getId().toString())
        var now_node: Tree_Node = aactree.getRootNode()
        Log.d("AAC_Tree", now_node.getId().toString())

        // 자식 노드 리스트 초기화
        var child_node_list: ArrayList<Tree_Node> = arrayListOf()
        val child_node_string : ArrayList<String> = arrayListOf()

        var pick_index: Int = 0

        // 스트링 조합이 되는지 확인
        var pick_string: ArrayList<String> = arrayListOf()
        var now_string: String = ""

        println(" ")
        print("now_node : ")
        print(now_node.getId())
        println(" ")


        fun makeChild(): ArrayList<Tree_Node> {

            // 자식이 존재하는지 확인
            var flag = aactree.isChildExist((now_node))
            print("flag : ")
            println(flag)
            if (flag >= -1) {
                // 자식이 있다면 선택된 노드의 자식 리스트 접근
                child_node_list = aactree.selectNodeFlow(now_node, flag)
                // 사이즈 체크
                // 반환된 노드 리스트가 있는지 확인
                print("child : ")
                for (child in child_node_list) {
                    print(child.getId())
                    child_node_string.add(child.getName())
                    print(", ")
                }

            }
            else{
                Log.d("선택된 단어", aactree.getString().toString())
//                for (arg in aactree.getString()) {
//                    print(arg)
//                }

            }

            println(" ")
            println("#--------------------------------#")


            return child_node_list
        }

        makeChild()


        return child_node_list
    }

}

