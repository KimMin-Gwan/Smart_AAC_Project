import os
import warnings
from tensorflow.keras.preprocessing.text import Tokenizer
from tensorflow.keras.preprocessing.sequence import pad_sequences
import tensorflow as tf
import json
import pandas as pd
#from back_end import MODEL_FILE, LABEL_FILE, AAC_FILE
FILE_PATH = './'
FILE_NAME = 'new_korean_intence.json'

LABEL_FILE = './label_data.txt'
MODEL_FILE = './model/'
AAC_FILE = './json_data_test.json'

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'
warnings.simplefilter(action='ignore', category=FutureWarning) # FutureWarning 제거
INDEX = 0

class Classifier():
    def __init__(self):
        self.text = []
        self.tokenizer = Tokenizer(char_level = True, oov_token='<OOV')
        self.__set_intent()
        self.__get_aac_category()
        self.__get_labels()


    def __set_intent(self):
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

        text_list = intence['patterns'].tolist()
        self.tokenizer.fit_on_texts(text_list)

        # text to number



    # get labels
    def __get_labels(self):
        with open(LABEL_FILE, 'r', encoding='UTF-8') as f:
            self.labels = json.load(f)

    # model
    def __model_predict(self, seq_text):
        model = tf.keras.models.load_model(MODEL_FILE)
        try:
            pred_model = model.predict(seq_text)
        except Exception as e:
            print("Error : ", str(e))


        pred_model = pred_model.tolist()
        pred = pred_model[INDEX]
        return pred
    
    # data preprocess (to seq)
    def __preprocess(self, real_text):
        self.text.append(real_text)
        # text to number
        seq_text = self.tokenizer.texts_to_sequences(self.text)

        seq_text = pad_sequences(seq_text, maxlen = 20)
        seq_text = seq_text.tolist()
        print(seq_text)
        return seq_text
    
    # load aac_category
    def __get_aac_category(self):
        with open(AAC_FILE, 'r', encoding='euc-kr') as f:
            raw_aac = json.load(f)

        self.aac_category = raw_aac['AAC']
        #aac_name = raw_aac['AAC']
        """
        for AAC_NAME in raw_aac['AAC']:
            self.aac_category.append(AAC_NAME['name'])
        """

    # 현재 제공하는 AAC에 포함되어있는지 확인
    def __check_category(self, txt):
        #print(self.aac_category)
        print('here')
        for arg in self.aac_category:
            if arg['name'] == txt:
                return {'key' : arg['id']}

        return {'key' : 'default'}
        """
        if txt in self.aac_category:
            return {'key' : txt}
        else:
            return {'key' : 'default'}
        """

    # 카테고리 분석기
    def classifier(self, text):
        seq_text = self.__preprocess(text)
        pred = self.__model_predict(seq_text)
        max_index = pred.index(max(pred))
        result = None
        for key, value in self.labels.items():
            if value == max_index:
                result = key
        result = result.replace(" ", "")
        print(result)
        return_data = self.__check_category(result)
        self.text.clear()
        return return_data



        
