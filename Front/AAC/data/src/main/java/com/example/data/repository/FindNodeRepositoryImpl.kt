package com.example.data.repository

import com.example.data.source.remote.AAC_Tree
import com.example.data.source.remote.Tree_Node
import com.example.domain.repository.FindNodeRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class FindNodeRepositoryImpl @Inject constructor(private val nodeRepositoryImpl: NodeRepositoryImpl) : FindNodeRepository  {
    // 자식 노드 리스트 초기화
    var child_node_list: ArrayList<Tree_Node> = arrayListOf()

    // 스트링 조합이 되는지 확인
    var pick_string: ArrayList<String> = arrayListOf()
    var now_string: String = ""
    var pick_index = 0
    override fun returnIndex(Category: String): Int {
        var index: Int = 0
        if (Category == "카페") {
            index = 101
        }
        if (Category == "라떼") {
            index = 202
        }
        else if (Category =="스무디"){
            index = 203
        }
        else if (Category =="주스"){
            index = 204
        }
        else if (Category =="버블티"){
            index = 205
        }
        else if (Category =="에이드"){
            index = 206
        }
        return index
    }

     override fun MakeTree(index: Int): MutableList<String> {
        val childTree = mutableListOf<String>()
        val node = nodeRepositoryImpl.getNode(index)

//                treeRepositoryImpl.Tree(index)
        // aac tree 생성
        val aac_tree = AAC_Tree(index, nodeRepositoryImpl.getNodeList())
        // tree에서 루트 노드 접근
        var now_node: Tree_Node = aac_tree.getRootNode()


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
                for (child in child_node_list) {
                    print(child.getName())
                    childTree.add(child.getName())

                    print(", ")
                }
            }


//                    // 선택한 노드 (임의)
//                    if (pick_index < child_node_list.size) {
//                        now_node = child_node_list[pick_index]
//                        pick_string.add(child_node_list[pick_index].getName())
//                    }
//                    else {
//                        now_node = child_node_list[0]
//                        pick_string.add(child_node_list[0].getName())
//                    }

        }
        println(" ")
        println("#--------------------------------#")

        for (arg in pick_string) {
            print(arg)
        }

        return childTree
    }
}

