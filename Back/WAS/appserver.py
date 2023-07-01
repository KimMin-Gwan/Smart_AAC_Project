from fastapi import FastAPI
from fastapi.responses import FileResponse
#from pydantic import BaseModel
from fastapi import UploadFile, File
import soundfile as sf
#import Mainfucntion as mainfunction

def get_audio_header_info(filename):
    # 오디오 파일의 헤더 정보를 읽어옴
    info = sf.info(filename)

    # 헤더 정보 출력
    print("Sample Rate:", info.samplerate)
    print("Channels:", info.channels)
    print("Duration:", info.duration)
    print("Format:", info.format)
    print("Subtype:", info.subtype)

app = FastAPI()

@app.get('/')
def main():
    return 'The Compass Server'

#class Model(BaseModel):
    #name : str

#wav 데이터 받기
@app.post('/get_wav')
async def recog_voice(file: UploadFile = File(..., required = False)):
    contents = await file.read()
    return {"filename": 'hi'}

#GPS 데이터 보내기
@app.post('/get/id')
async def recog_GPS():
    contents = 10
    return {"filename": contents}


"""
1. 메인 ( /)
2. 음성 데이터 보내기( /post/wav)
3. 음성 분석 데이터 받기(/get/wav)
4. GPS 데이터 보내기( /post/gps)
5. GPS 데이터 받기(/get/gps)
6. 사용자 정보 보내기( /post/id)
7. 사용자 정보 받기 (/get/id)
"""

