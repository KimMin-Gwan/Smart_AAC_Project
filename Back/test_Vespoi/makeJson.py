import re
import json

file = open('카테고리/category.txt', encoding='UTF8')
#print(file)

data = file.read()
#print(data)


split_data = data.split(',')
#print(split_data[0])

text_data = []
for i in split_data:
    new_str = re.sub(r"[^\uAC00-\uD7A3a-zA-Z\s]", "", i)
    new_str = new_str.replace(" ", "")
    #print(new_str)
    text_data.append(new_str)

#print(text_data)

location = ["카페","병원","식당","학교"]
AAC = ["커피","에이드"]

dict_data = {"AAC": [] }

location_label="10" #장소
aac_label = "100" #기본 AAC
ai_label = "200" #AI 카테고리

index = 0
for i in location:
    index = index + 1
    dict_data["AAC"].append({
        "id": int(location_label + str(index)),
        "parent_node" : [],
        "child_node" : [],
        "name" : i
    })

index = 0
for i in AAC:
    index = index + 1
    dict_data["AAC"].append({
        "id": int(aac_label + str(index)),
        "parent_node" : [],
        "child_node" : [],
        "name" : i
    })

index = 0
for i in text_data:  
    index = index + 1
    dict_data["AAC"].append({
        "id": int(ai_label + str(index)),
        "parent_node" : [],
        "child_node" : [],
        "name" : i
    })
    #print(i)
#print(dict_data)

json_data = json.dumps(dict_data, indent="\t", ensure_ascii=False)
# print(json_data)
# print(type(json_data))
#print(dict_data)

with open('json_data.json', 'w') as f:
   f.write(json_data)
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
