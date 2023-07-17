import json

#FILE_PATH = './../../../text/한국어_대화/대화데이터/'
FILE_NAME = 'korean_intence.json'

FILE_PATH = './'
FILE_NAME = 'new_korean_intence.json'

with open(FILE_PATH + FILE_NAME, 'r', encoding='UTF8') as f:
    json_data = json.load(f)
patterns_len_list = []
tag_list = []
intence = json_data['intence']

for data in intence:
    count_patterns = len(data['patterns'])
    patterns_len_list.append(count_patterns)
    if count_patterns >= 10:
        tag = data['tag']
        tag_list.append(tag)
    
print(f'number of tag list : ',len(tag_list) )
print(tag_list)

delete_tag_list = []
for data in intence:
    if data['tag'] not in tag_list:
        now_tag = data['tag']
        delete_tag_list.append(now_tag)
        print(f' tag : {now_tag}')
        intence.remove(data)

print(f'number of delete tag list : ',len(delete_tag_list) )
print(delete_tag_list)

new_json_data = {'intence' : intence}

#print(json.dumps(json_data, indent="\t"))

with open( './new_korean_intence.json', 'w', encoding='utf-8') as f : 
    json.dump(json_data, f, indent=4, ensure_ascii=False)

        

    