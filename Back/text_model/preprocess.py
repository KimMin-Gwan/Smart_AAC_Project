# 데이터 셋 변경으로 인해 코드 변화

import os
import pandas as pd
import json
import seaborn as sns
from numba import jit  
#file_path = './../../../text/data/Training/라벨링데이터/KAKAO(1)'


"""
1. 만약 점원인데 질문을 한다면
2. 뭘 질문하고, 카테고리가 뭔가
3. 거기에 대한 대답은 뭐고, 카테고리가 뭔가

1. 

"""
#data = df.loc[1]
#print(data['SPEAKER'])
def process(df, intence, l_tag):
    temp = type(0.1)
    tag = 'NAN'
    flag = 0

    for i in range (1, len(df)-1):
        if i%1000 == 0:
            print(f'{i}번째 Processing')
        
        data = df.loc[i]

        #1. 만약 점원인데 질문을 한다면
        #if data['SPEAKER'] == '점원' and data['QA'] == 'Q':
        if data['QA'] == 'Q':
            # 2. 뭘 질문하고, 카테고리가 뭔가
            q_data = df.loc[i+1]
            if q_data['QA'] == 'Q':
                continue
            patterns = data['SENTENCE']
            # 3. 거기에 대한 대답은 뭐고, 카테고리가 뭔가
            response = q_data['SENTENCE']
            #tag = q_data['지식베이스']
            tag = q_data['MAIN']
            if type(tag) == temp:
                continue

            if '/' in tag:
                tag = tag.split('/')
            if ',' in tag:
                tag = tag.split(',')

        else:
            continue
            
        arg = tag

        """
        tag를 하나의 프레임 단위로 생성해야됨
        data_one = {"tag" : tag,
                    "patterns" : patterns,
                    "response" : response
        }
        1. intents들 중 'tag'가 이미 존재하는지 확인
        2. 없다면 tag를 새로 생성해서 저장
        3. 있다면 해당 tag에 sentence와 response를 append 
        """

        #print(f'{i} 번째 데이터, tag = {tag}')

        #for arg in tag:
            #print(arg)
        #data_one = dict()
        #for arg in tag:
        flag = 0
        # 첫번째 데이터
        if len(intence) == 0:
            data_one = {"tag" : arg,
                        "patterns" : [patterns],
                        "response" : [response]
            }
            intence.append(data_one)
            #print('intence : \n', intence)
            #print()
            # 다음 루프로
            l_tag.append(arg)
            continue
        
        # 검색후 있으면 거기다가 추가
        for a_intence in intence:
            if a_intence['tag'] == arg:
                #print('if', arg)
                #print('patterns : ', patterns)
                #print('response : ', response)
                a_intence['patterns'].append(patterns)
                a_intence['response'].append(response)
                # 추가하고 나서 다음 루프로
                #print()
                flag = 1
                break
        if flag == 1:
            continue
        # 검색해도 없으면 새로 추가
        #print('patterns : ', patterns)
        #print('response : ', response)
        data_one = {"tag" : arg,
                    "patterns" : [patterns],
                    "response" : [response]
        }
        intence.append(data_one)
        #print('intence : \n', intence)
        #print()
        l_tag.append(arg)

    return intence, l_tag
    #intence = pd.Series(intence)
    #print(intence)

import time

def main():
    file_path = './../../../text/한국어_대화/대화데이터/'
    file_list = os.listdir(file_path)
    file_size = len(file_list)
    print(file_list)
    intence = []
    l_tag = []
    for i in range(file_size):
        print(file_list[i])
        if file_list[i] == 'J 민원':
            print('OVER')
            break
        df = pd.read_excel(file_path + file_list[i])
        intence, l_tag = process(df, intence, l_tag)
        print(df.head())
        print('complete')
    """
    time.sleep(1)
    for arg in intence:
        param = arg['patterns']
        if len(param) < 4:
            temp_tag = arg['tag']
            #print(f'tag : {temp_tag}, length : {len(param)} ')
            intence.remove(arg)
        count += 1
        if arg['tag'] == "메뉴, 돼지고기":
            print("이게맞나 ")
    time.sleep(1)
    """

    
    json_data = {'intence' : intence}
    #print(json_data)

    with open(file_path + 'korean_intence.json', 'w', encoding='utf-8') as f : 
        json.dump(json_data, f, indent=4, ensure_ascii=False)

    print(l_tag)

if __name__ == "__main__":
    main()

