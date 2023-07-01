from fastapi import FastAPI
from fastapi.responses import FileResponse
from pydantic import BaseModel

app = FastAPI()

@app.get('/')
def main():
    return 'The Compass Server'

class Model(BaseModel):
    name : str



"""
1. 메인 ( /)
2. 음성 데이터 보내기( /post/wav)
3. 음성 분석 데이터 받기(/get/wav)
4. GPS 데이터 보내기( /post/gps)
5. GPS 데이터 받기(/get/gps)
6. 사용자 정보 보내기( /post/id)
7. 사용자 정보 받기 (/get/id)
"""

