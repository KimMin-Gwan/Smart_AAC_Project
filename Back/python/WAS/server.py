from fastapi import FastAPI
#from fastapi.responses import FileResponse
from fastapi import UploadFile, File
import WAS
import uvicorn
#from constant import WAV_SAVE_PATH

class AppServer():
    def __init__(self, mainfunction):
        self.app = FastAPI()
        self.mainfunction = mainfunction
        self.register_routes()

    def register_routes(self):
        #wav 데이터 받기
        @self.app.post('/get_string')
        async def recog_voice(data : dict):
            if data is None:
                print('data did not uploaded')
                return {"key": "ERROR"} 
            else:
                print('json loaded')
            try:
                result = self.mainfunction.recog_wav(data['key'])
            except Exception as e:
                print("Error : ", str(e))

            if result['key'] == 'ERROR':
                return {"key" : "Recognize Fail"}

            return result # {'key' : data}


        #GPS 데이터 보내기
        @self.app.post('/get_gps')
        async def recog_GPS(data : WAS.GPS):
            if data is None:
                print('gps not uploaded')
                return {"error": "data did not usable"}

            x = int(data.x)
            y = int(data.y)
            # result:str
            try:
                result = self.mainfunction.recog_gps(x, y)
            except Exception as e:
                print("Erro : ", str(e))

            return {"Category": result}
        
    def run_server(self, HOST, PORT):
        uvicorn.run(self.app, host=HOST, port= PORT)



        
    
