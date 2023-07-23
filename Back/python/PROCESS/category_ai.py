import os
import warnings
from tensorflow.keras.preprocessing.text import Tokenizer
from tensorflow.keras.preprocessing.sequence import pad_sequences
import tensorflow as tf
import json

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'
warnings.simplefilter(action='ignore', category=FutureWarning) # FutureWarning 제거
LABEL_FILE = './label_data.txt'
MODEL_FILE = './model/'
INDEX = 0

class Classifier():
    def __init__(self, text):
        self.real_text = text
        self.text = []
        self.tokenizer = Tokenizer(char_level = True, oov_token='<OOV')
        self.__get_labels()

    # get labels
    def __get_labels(self):
        with open(LABEL_FILE, 'r', encoding='UTF-8') as f:
            self.labels = json.load(f)

    # model
    def __model_predict(self, seq_text):
        model = tf.keras.models.load_model('./model/')
        predict = model.predict(seq_text)

        predict = predict.tolist()
        pred = predict[INDEX]
        return pred
    
    # data preprocess (to seq)
    def __preprocess(self):
        self.text.append(self.real_text)
        self.tokenizer.fit_on_texts(self.real_text)

        # text to number
        seq_text = self.tokenizer.texts_to_sequences(self.text_list)

        seq_text = pad_sequences(seq_text, maxlen = 20)
        seq_text.tolist()
        return seq_text

    def classifier(self):
        seq_text = self.__preprocess()
        pred = self.__model_predict(seq_text)

        for key, value in self.labels.items():
            if value == pred:
                result = key

        return {self.real_text : result}

        

