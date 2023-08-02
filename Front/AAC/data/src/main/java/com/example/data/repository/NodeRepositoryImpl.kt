package com.example.data.repository

import android.content.Context
import com.example.data.source.remote.MakeNode
import com.example.data.source.remote.Node
import com.example.data.source.remote.NodeList
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class NodeRepositoryImpl @Inject constructor(@ApplicationContext private val context: Context){
    // NodeRepository는 앱의 생명 주기와 동기화됩니다.
    // 이 클래스는 node_list를 만들고 관리하는 메소드를 제공합니다.
    private var node_list: NodeList? = null

     fun getNodeList(): NodeList {
        if (node_list == null) {
            var make = MakeNode(context)
            node_list = make.make_node_list()
        }
        return node_list!!
    }

     fun getNode(index: Int): Node {
        return getNodeList().getNode(index)
    }
}