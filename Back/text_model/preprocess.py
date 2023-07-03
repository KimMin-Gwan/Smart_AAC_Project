import os
import pandas as pd
import json
import seaborn as sns
#file_path = './../../../text/data/Training/라벨링데이터/KAKAO(1)'
file_path = './../../../text/data/1.Training/라벨링데이터/KAKAO(1)/'
file_list = os.listdir(file_path)
file_size = len(file_list)

subject_list = []
data_dict = {}

for file_name in file_list[0:500]:
    raw_file = open(file_path + file_name, encoding="utf-8")
    file = json.loads(raw_file.read())
    info = file['info'][0]
    annotations = info['annotations']
    subject = annotations['subject']
    if subject in subject_list:
        data_dict[subject].append(file_name)
    else:
        subject_list.append(subject)
        data_dict[subject] = [file_name]
    raw_file.close()
    file = None
    info = None
    annotations = None
    subject = None

print('subject_list : \n', subject_list)
print('number of subject : ', len(subject_list))
print('data_list : \n', data_dict)
dataframe = pd.DataFrame.from_dict(data_dict, orient="index")
dataframe['length'] = dataframe.apply(lambda row: len(row), axis=1)
print(dataframe.head)

#file = pd.read_json(file_path + file_list[0], orient='split')

#for i in file_list:
#    file = 
