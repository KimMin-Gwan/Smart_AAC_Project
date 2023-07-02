from fastapi import FastAPI
#from fastapi.responses import FileResponse
from fastapi import UploadFile, File
from constant import GPS
import uvicorn

class AppServer():
    def __init__(self, mainfunction):
        self.app = FastAPI()
        self.mainfunction = mainfunction
        self.register_routes()

    def register_routes(self):
        #wav 데이터 받기
        @self.app.post('/get_wav')
        async def recog_voice(file: UploadFile = File(..., required = False)):
            if file is None:
                print('wav file did not uploaded')
                return {"error": "No file provided"}
            else:
                print('wav file upload complete')

            result = self.mainfunction.recog_wav(file)

            if result == 'default':
                return {"error" : "Recognize Fail"}

            return {"result" : result}


        #GPS 데이터 보내기
        @self.app.post('/get_gps')
        async def recog_GPS(data : GPS):
            if data is None:
                print('gps not uploaded')
                return {"error": "data did not usable"}

            x = int(data.x)
            y = int(data.y)
            # result:str
            result = self.mainfunction.recog_gps(x, y)

            return {"Category": result}
        
    def run_server(self, HOST, PORT):
        uvicorn.run(self.app, host=HOST, port= PORT)



        
    