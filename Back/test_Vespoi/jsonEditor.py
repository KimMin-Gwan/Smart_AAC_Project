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

def node_adder_single(dict_data, id, node):
    for i in dict_data["AAC"]:
        if(i["id"]==id):
            i["node"].append(node)

def node_adder_multi(dict_data, id, node):
    for i in dict_data["AAC"]:
        if(i["id"]==id):
            for j in node:
                i["node"].append(j)

def save_json(dict_data):
    json_data = json.dumps(dict_data, indent="\t", ensure_ascii=False)
    with open('json_data.json', 'w') as f:
        f.write(json_data)



with open ("json_data.json", "r") as f:
    dict_data = json.load(f)

name_single = id_finder(dict_data,"재건축아파트정보세대수층연식위치등") #추가할거 하나 이름

name_list = ["임대기간", "재건축아파트정보세대수층연식위치등"] #추가할거 여러개 이름
node_list = id_finder_multi(dict_data, name_list)

id = id_finder(dict_data,"재건축아파트정보세대수층연식위치등") #어디에 추가할지 이름

#print(id_finder(dict_data,"재건축아파트정보세대수층연식위치등"))
#print(id_finder_multi(dict_data, name_list))

node_adder_single(dict_data, id, name_single) #1개 추가
node_adder_multi(dict_data, id, node_list) #여러개 추가

save_json(dict_data)

#만들어야 하는거: 삭제