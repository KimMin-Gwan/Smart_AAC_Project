def id_finder(name):
    for i in dict_data["AAC"]:
        if(i["name"]==name):
            return i["id"]

def parent_node_updater(id, node):
    for i in dict_data["AAC"]:
        if(i["id"]==id):
            id["parent_node"].append(node)

def child_node_updater(id, node):
    for i in dict_data["AAC"]:
        if(i["id"]==id):
            id["child_node"].append(node)
