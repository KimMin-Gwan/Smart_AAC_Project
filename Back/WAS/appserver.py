from fastapi import FastAPI
from fastapi.responses import FileResponse
from pydantic import BaseModel
from fastapi import UploadFile, File
import soundfile as sf
import Mainfucntion as mainfunction

app = FastAPI()

@app.get('/')
def main():
    return 'The Compass Server'

#wav 데이터 받기
@app.post('/get_wav')
async def recog_voice(file: UploadFile = File(..., required = False)):
    if file is None:
        print('wav file did not uploaded')
        return {"error": "No file provided"}
    else:
        print('wav file upload complete')

    result = mainfunction.recog_wav()

    if result == 'default':
        return {"error" : "Recognize Fail"}

    return {"result" : result}


#GPS 데이터 보내기
@app.post('/get/id')
async def recog_GPS():
    contents = 10
    return {"filename": contents}


"""
1. 메인 ( /)
2. 음성 데이터 보내기( /post/wav)
3. GPS 데이터 보내기( /post/gps)
4. 사용자 정보 보내기( /post/id)
5. 사용자 정보 받기 (/get/id)
"""

