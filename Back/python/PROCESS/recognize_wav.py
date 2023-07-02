import os
import shutil
import speech_recognition as sr

# 유저 별로 꼬이지 않도록 설계해야함


class WavRecognizer():
    def __init__(self, file):
        self.path = __file__ + file.filename
    
    def __call__(self):
        now_loc = __file__
        os.system(f'cd {now_loc}')
        os.system('ls')

    def __save_real_file(self, object_file):
        try:
            with open(self.path, "wb") as f:
                shutil.copyfileobj(self.object_file, f)
            print(f"WAV file saved to {self.path}")
            return 1
        except Exception as e:
            print("Error : ", str(e))
            return -1
    
    def __speech_to_text(self):
        try:
            r = sr.Recognizer()
            with sr.AudioFile(self.file_path) as source:
                audio = r.record(source, duration = 120)
            text = r.recognize_google(audio_data=audio, language='ko-KR')
            return text
        except Exception as e:
            print("Error : ", str(e))
            return " "
    
    def __recognizing(self):
        # 군집화나 RNN으로 분석해서 리턴시켜야됨
        pass

    def recognizer(self, file):
        flag = self.__save_real_file(object_file = file.file)
        if flag == -1:
            return "default"
        
        #음성 데이터에서 text을 읽을 수 없으면 " " 으로 받음
        text = self.__speech_to_text()
        if text == " ":
            return "default"
        
        result = self.__recognizing()

        return result

        




