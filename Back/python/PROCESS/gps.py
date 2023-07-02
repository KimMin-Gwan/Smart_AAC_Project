import requests
from urllib.parse import urlparse
import json

header={"Authorization": "KakaoAK 468b7fd043830d2a5ddb6fff0a000b5b"}  #<<이거 밖으로 뺴는게 좋아보임

#좌표로 주소 변환하기
def gps_data(lon, lat):
    url = f"https://dapi.kakao.com/v2/local/geo/coord2address.json?x={lon}&y={lat}"
    result = requests.get(urlparse(url).geturl(),
        headers=header).json()

    return result

#확인용 출력
print(json.dumps(gps_data(128.755739,35.834908),indent=4,ensure_ascii=False))  
print(json.dumps(gps_data(128.755739,35.834908)['documents'][0]["road_address"]["building_name"],indent=4,ensure_ascii=False))