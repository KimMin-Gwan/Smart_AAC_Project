from pydantic import BaseModel

# GPS 데이터 형식
class GPS(BaseModel):
    x:str
    y:str


WAV_SAVE_PATH = "./temp/"

