from fastapi import FastAPI
from fastapi.responses import FileResponse
from fastapi import FastAPI, UploadFile, File
import os

#db 입출력도 가능

app = FastAPI()

@app.get("/")
def 작명():
    print("well")
    return 'The Compass Server'

from pydantic import BaseModel
class Model(BaseModel):
    name:str
    phone :int



@app.post("/send")
def send(data : Model):
    print(data)
    return '전송완료'

@app.post("/test")
def test():
    print('well')
    return '전송완료'


@app.post("/upload_wav")
async def upload_wav(file: UploadFile = File(..., required=False)):
    print('welcome')
    if file is None:
        print("not well")
        return {"error": "No file provided"}
    else:
        print('well')
    return {"filename": file.filename }
