import WavRecognizer

class MainFunction():
    def __init__(self):
        self.status = 0
    
    def __call__(self):
        if self.status == 0:
            print("Init") 
        elif self.status == 1:
            print("Working")
        else:
            print("Error")

    #wav 분석
    def recog_wav(file):
        recognizer = WavRecognizer(file)
        result = recognizer.recognizer(file)
        return result




    def recog_gps(x, y):
        pass

