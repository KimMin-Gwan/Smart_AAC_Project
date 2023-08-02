import back_end

class MainFunction():
    def __init__(self):
        self.status = 0
        self.recognizer = back_end.Recognizer()
    
    def __call__(self):
        if self.status == 0:
            print("Init") 
        elif self.status == 1:
            print("Working")
        else:
            print("Error")

    #wav 분석
    #라벨을 반환
    def recog_wav(self, txt):
        self.status = 1
        self()
        try:
            result = self.recognizer.recognizer(txt)
        except Exception as e:
            print("ERROR_main : ", e)
            result = {'key' : "ERROR" }
            self.status == -1
            self()

        self.status = 0
        self()
        return result

    def recog_gps(self, x, y):
        self.status = 1
        self()

        #---------------
        #분석기 생성
        recognizer = back_end.GPS(x, y)
        # 분석
        result = recognizer.gps_analyzer()
        # 분석기 메모리 반환 
        recognizer = None

        self.status = 0
        self()
        return result


