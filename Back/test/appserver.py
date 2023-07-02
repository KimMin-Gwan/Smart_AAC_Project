from fastapi import FastAPI
from fastapi.responses import FileResponse
from pydantic import BaseModel
from fastapi import UploadFile, File
import soundfile as sf
import speech_recognition as sr
import asyncio
import shutil
import time

def recog_wav(file):
    r = sr.Recognizer()
    with sr.AudioFile(file) as source:
        audio = r.record(source, duration = 120)
    text = r.recognize_google(audio_data=audio, language='ko-KR')
    print(text)


app = FastAPI()

#wav 데이터 받기
@app.post('/get_wav')
async def recog_voice(file: UploadFile = File(..., required = False)):
    if file is None:
        print('wav file did not uploaded')
        return {"error": "No file provided"}
    else:
        print('wav file upload complete')
    try:
        save_path = f"./temp/{file.filename}"
        with open(save_path, "wb") as f:
            shutil.copyfileobj(file.file, f)
        print(f"WAV file saved to {save_path}")
        time.sleep(0.5)
        recog_wav(save_path)
    except Exception as e:
        print("Error : ", str(e))


    #if result == 'default':
    #    return {"error" : "Recognize Fail"}

    #return {"result" : result}
    return {"file": file.filename}

# GPS 데이터 형식
class GPS(BaseModel):
    x:str
    y:str

#GPS 데이터 보내기
@app.post('/get_gps')
async def recog_GPS(data : GPS):
    if data is None:
        print('gps not uploaded')
        return {"error": "data did not usable"}

    x = int(data.x)
    y = int(data.y)
    # result:str
    #result = recog_gps(x, y)
    result = 10
    return {"Category": result}


"""
1. 메인 ( /)
2. 음성 데이터 보내기( /post/wav)
3. GPS 데이터 보내기( /post/gps)
4. 사용자 정보 보내기( /post/id)
5. 사용자 정보 받기 (/get/id)
"""

