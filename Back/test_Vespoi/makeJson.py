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
    #print(new_str)
    text_data.append(new_str)

#print(text_data)

dict_data = {}

label = "20"
index = 0
for i in text_data:  
    index = index + 1
    dict_data[i] =  {
        "id": int(label + str(index))
    }    
    #print(i)
#print(dict_data)

json_data = json.dumps(dict_data, indent="\t", ensure_ascii=False)
print(json_data)
print(type(json_data))


with open('AI_json_data.json', 'w') as f:
    f.write(json_data)
