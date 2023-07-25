import json

def id_finder(dict_data, name):
    for i in dict_data["AAC"]:
        if(i["name"]==name):
            return i["id"]

def id_finder_multi(dict_data, name_list):
    id_list = []

    for i in dict_data["AAC"]:
        for j in name_list:
            if(i["name"]==j):
                id_list.append(i["id"])
    return id_list

def node_add_single(dict_data, id, node):
    for i in dict_data["AAC"]:
        if(i["id"]==id):
            i["node"].append(node)

def node_add_multi(dict_data, id, node):
    for i in dict_data["AAC"]:
        if(i["id"]==id):
            for j in node:
                i["node"].append(j)

def save_json(dict_data):
    json_data = json.dumps(dict_data, indent="\t", ensure_ascii=False)
    with open('json_data_edit.json', 'w') as f:
        f.write(json_data)

def add_multi_to_multi(dict_data, list_where):
    for i in list_where:
        id = id_finder(dict_data, i)
        node_add_multi(dict_data, id, node_list)

def add_single_to_multi(dict_data, list_where, name_single):
    for i in list_where:
        id = id_finder(dict_data, i)
        node_add_single(dict_data, id, name_single)


with open ("json_data_edit.json", "r") as f:
    dict_data = json.load(f)


id = id_finder(dict_data,"") #어디에 추가할지 이름
list_where = ["", "", ""] #여러개에 한번에 추가 할 때 추가하는 곳 이름


name_single = id_finder(dict_data,"") #추가할거 하나 이름
name_list = ["", "", ""] #추가할거 여러개 이름


#print(id_finder(dict_data,"재건축아파트정보세대수층연식위치등"))
#print(id_finder_multi(dict_data, name_list))

node_add_single(dict_data, id, name_single) #1개 추가


node_list = id_finder_multi(dict_data, name_list)
node_add_multi(dict_data, id, node_list) #여러개 추가


add_single_to_multi(dict_data, list_where, name_single) #여러개에 하나 추가
add_multi_to_multi(dict_data, list_where) #여러개에 여러개 추가


save_json(dict_data)

#만들어야 하는거: 삭제 , 수정(초기화)