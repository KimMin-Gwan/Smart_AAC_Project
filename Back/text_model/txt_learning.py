import os
import pandas as pd
import numpy as np
import warnings
import json
import re
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'
warnings.simplefilter(action='ignore', category=FutureWarning) # FutureWarning 제거


FILE_PATH = './'
FILE_NAME = 'new_korean_intence.json'

with open(FILE_PATH + FILE_NAME, 'r', encoding='UTF8') as f:
    json_data = json.load(f)

raw_intence = json_data['intence']

# json to dataframe
intence = pd.DataFrame(raw_intence)

# 리스트 분해
intence = intence.explode('patterns')

# 특수문자 제거
intence['patterns'] = intence['patterns'].str.replace('[^ㄱ-ㅎㅏ-ㅣ가-힣0-9 ]', '')

# 중복제거
intence.drop_duplicates( subset=['patterns'], inplace = True)

# ---------------------------------------------
# 라벨 분석기
raw_label = intence['tag'].unique().tolist()
#print(raw_label[0:10])

num_label = len(raw_label)

label_dict = [{x: i+1} for i, x in enumerate(raw_label)]
#print(label_dict)

# 리스트를 딕셔너리로 해체 
label_data = {}
for d in label_dict:
    label_data.update(d)

intence['label'] = ''
intence['label'] = intence['tag'].map(label_data)

#print(intence.head)
# ----------------------------------------------
# 데이터 체크
#print(intence.head())
#print(f'num_labels : {num_label}')

# -----------------------------------------------------------
# bag of words
unique_text = intence['patterns'].tolist()
unique_text = ''.join(unique_text)
unique_text = list(set(unique_text))
unique_text.sort()
#print(unique_text[0:100])

from tensorflow.keras.preprocessing.text import Tokenizer

# 전체 단어에서 1회 출현한 단어는 모두 제거
tokenizer = Tokenizer(char_level = True, oov_token='<OOV')
text_list = intence['patterns'].tolist()
tokenizer.fit_on_texts(text_list)
word_index = tokenizer.word_index
#print(text_list[0:10])

# text to number
train_seq = tokenizer.texts_to_sequences(text_list)

Y = intence['label'].tolist()

# 데이터 길이측정
intence['length'] = ''
intence['length'] = intence['patterns'].str.len()
#print(intence.head())
#print(intence.describe())

# 평균 최대 길이 알아내기 
print(intence['length'][intence['length'] < 20].count())

from tensorflow.keras.preprocessing.sequence import pad_sequences
from sklearn.model_selection import train_test_split

X = pad_sequences(train_seq, maxlen = 20)
X = X.tolist()

trainX, valX, trainY, valY = train_test_split(X, Y, test_size=0.2, random_state=42)
import tensorflow as tf
# ----------------------------------------------------------------
"""

shape = np.array(trainX).shape
#print(shape)
#(2800, 100)

model = tf.keras.Sequential([
    tf.keras.layers.Embedding( len(word_index) + 1, 16),
    tf.keras.layers.LSTM(100 ,input_shape = shape),
    tf.keras.layers.Dense(num_label+1, activation='softmax')
])


model.compile(loss = 'sparse_categorical_crossentropy', optimizer = 'adam', metrics = ['accuracy'])
model.fit(trainX, trainY, batch_size = 64, epochs = 100)

model.save('./model')

"""
#모델 불러오기
model = tf.keras.models.load_model('./model/')
print(valX[150])
predict = model.predict(valX)

#숫자로 된 데이터를 텍스트로 변경
test_sentence = tokenizer.sequences_to_texts(valX)
#print(test_sentence)

test_list = []

#늘려준 크기 줄이고, 공백 줄여서 보기 좋게
for sample in test_sentence:
    temp = sample.replace('<OOV', '')
    test_list.append(temp.replace(' ', ''))
    
#테스트 포인트
index = 150

#조사해본 문자열
print("test")
print('질문 : ',test_list[index])

#실확률
#print("predictions")
#print(predict[index])

result = []
predict = predict.tolist()
pred = predict[index]
max_value = max(pred)
max_index = pred.index(max_value)


for key, value in label_data.items():
    if value == max_index:
        print('정답 : ', key)


#50%를 넘어가면 정상, 아니면 악플

print(result)
        
#끝
