import re
import json


def preprocessing_text_data(file_path):
    file = open(ai_file_path, encoding='UTF8')

    data = file.read()

    split_data = data.split(',')

    text_data = []
    for i in split_data:
        new_str = re.sub(r"[^\uAC00-\uD7A3a-zA-Z\s]", "", i)
        new_str = new_str.replace(" ", "")
        #print(new_str)
        text_data.append(new_str)
    
    return text_data

def make_dict_location(dict_aac,aac_data): 
    location_label="10" #장소
    index = 0
    for i in aac_data:
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(location_label + str(index)),
            "parent_node" : [],
            "child_node" : [],
            "name" : i
        })

def make_dict_AAC(dict_aac,aac_data):
    aac_label = "100" #기본 AAC
    index = 0
    for i in aac_data:
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(aac_label + str(index)),
            "parent_node" : [],
            "child_node" : [],
            "name" : i
        })

def make_dict_ai(dict_aac,aac_data):
    ai_label = "200" #AI 카테고리
    index = 0
    for i in aac_data:  
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(ai_label + str(index)),
            "parent_node" : [],
            "child_node" : [],
            "name" : i
        })
        #print(i)
    #print(dict_data)

def make_json(dict_data):
    json_data = json.dumps(dict_data, indent="\t", ensure_ascii=False)
    with open('json_data.json', 'w') as f:
        f.write(json_data)

# print(json_data)
# print(type(json_data))
#print(dict_data)

ai_file_path = '카테고리/category.txt'

ai_data = preprocessing_text_data(ai_file_path)
location = ["카페","병원","식당","학교"]
AAC = ["커피","에이드"]
dict_aac = {"AAC": [] }

make_dict_location(dict_aac,location)
make_dict_AAC(dict_aac,AAC)
make_dict_ai(dict_aac,ai_data)
make_json(dict_aac)
