import re
import json


def preprocessing_text_data(file_path):
    file = open(file_path, encoding='UTF8')

    data = file.read()

    split_data = data.split(',')

    text_data = []
    for i in split_data:
        new_str = re.sub(r"[^\uAC00-\uD7A3a-zA-Z\s0-9]", "", i)
        new_str = new_str.replace(" ", "")
        #print(new_str)
        text_data.append(new_str)
    
    return text_data

def make_dict_location(dict_aac,aac_data): #딕셔너리 만들기 장소
    location_label="10" #장소
    index = 0
    for i in aac_data:
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(location_label + str(index)),
            "node" : [],
            "name" : i
        })

def make_dict_category(dict_aac,aac_data): #딕셔너리 만들기 장소 아래 카테고리
    location_label="20" #카테고리
    index = 0
    for i in aac_data:
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(location_label + str(index)),
            "node" : [],
            "name" : i
        })

def make_dict_AAC(dict_aac,aac_data): #딕셔너리 만들기 카테고리 아래 AAC
    aac_label = "30" #기본 AAC
    index = 0
    for i in aac_data:
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(aac_label + str(index)),
            "node" : [],
            "name" : i
        })

def make_dict_ai(dict_aac,aac_data): #딕셔너리 만들기 AI 카테고리
    ai_label = "90" #AI 카테고리
    index = 0
    for i in aac_data:  
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(ai_label + str(index)),
            "node" : [],
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

location_file_path = '카테고리/test_location.txt'
AAC_file_path = '카테고리/test_AAC.txt'
ai_file_path = '카테고리/category.txt'

location = preprocessing_text_data(location_file_path)
AAC = preprocessing_text_data(AAC_file_path)
ai_data = preprocessing_text_data(ai_file_path)

dict_aac = {"AAC": [] }

make_dict_location(dict_aac,location)
make_dict_AAC(dict_aac,AAC)
make_dict_ai(dict_aac,ai_data)

make_json(dict_aac)
