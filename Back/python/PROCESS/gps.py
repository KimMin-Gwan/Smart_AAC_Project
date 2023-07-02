import requests
from urllib.parse import urlparse
import json

header={"Authorization": "KakaoAK 468b7fd043830d2a5ddb6fff0a000b5b"}  #<<이거 밖으로 뺴는게 좋아보임

#좌표로 주소 변환하기
def notNamed2(x, y):
    url = f"https://dapi.kakao.com/v2/local/geo/coord2address.json?x={x}&y={y}"
    result = requests.get(urlparse(url).geturl(),
        headers=header).json()

   #확인용 출력
    print(json.dumps(notNamed2(128.755739,35.834908),indent=4,ensure_ascii=False))  
       
    return result


