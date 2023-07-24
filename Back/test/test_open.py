import ast
import json


with open('./label_data.txt', 'r', encoding='UTF-8') as f:
    json_data = json.load(f)
    print(type(json_data))


exit()
with open('./labels.txt', 'r', encoding='UTF-8') as f:
    my_str = f.read()
    my_list = ast.literal_eval(my_str)
    label_data = {}
    for data in my_list:
        label_data.update(data)

