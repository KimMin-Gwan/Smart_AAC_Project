package com.example.data.repository

import com.example.data.source.remote.AAC_Tree
import com.example.data.source.remote.Tree_Node
import javax.inject.Inject

class TreeRepositoryImpl @Inject constructor(private val nodeRepositoryImpl: NodeRepositoryImpl) {

    fun Tree(rootIndex : Int){
//        // aac tree 생성
//        val aac_tree = AAC_Tree(rootIndex, nodeRepositoryImpl.getNodeList())
//        // tree에서 루트 노드 접근
//        var now_node: Tree_Node = aac_tree.getRootNode()
//        // 자식 노드 리스트 초기화
//        var child_node_list: ArrayList<Tree_Node> = arrayListOf()
//
//        var pick_index = 0
//
//        // 스트링 조합이 되는지 확인
//        var pick_string: ArrayList<String> = arrayListOf()
//        var now_string: String = ""
//
//
//        while (true) {
//            println(" ")
//            print("now_node : ")
//            print(now_node.getId())
//            println(" ")
//
//            // 자식이 존재하는지 확인
//            if (aac_tree.isChildExist(now_node)) {
//                // 자식이 있다면 선택된 노드의 자식 리스트 접근
//                child_node_list = aac_tree.selectNodeFlow(now_node)
//                // 사이즈 체크
//                print("now_node size : ")
//                print(child_node_list.size)
//                println(" ")
//                print("childe : ")
//                // 반환된 노드 리스트가 있는지 확인
//                if (child_node_list != null) {
//                    for (child in child_node_list) {
//                        print(child.getName())
//                        print(", ")
//                    }
//                }
//
//
//                // 선택한 노드 (임의)
//                if (pick_index < child_node_list.size) {
//                    now_node = child_node_list[pick_index]
//                    pick_string.add(child_node_list[pick_index].getName())
//                }
//                else {
//                    now_node = child_node_list[0]
//                    pick_string.add(child_node_list[0].getName())
//                }
//
//            } else
//                break
//            println(" ")
//            println("#--------------------------------#")
//        }
//
//        for (arg in pick_string) {
//            print(arg)
//        }
    }
}

