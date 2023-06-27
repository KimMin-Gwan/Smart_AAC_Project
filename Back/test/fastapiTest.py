from fastapi import FastAPI
from fastapi.responses import FileResponse

#db 입출력도 가능

app = FastAPI()

@app.get("/")
def 작명():
    return FileResponse('./template/index.html')

from pydantic import BaseModel
class Model(BaseModel):
    name:str
    phone :int



@app.post("/send")
def send(data : Model):
    #await
    print(data)
    return '전송완료'
