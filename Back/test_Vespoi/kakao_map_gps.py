import requests
from urllib.parse import urlparse
import json

"""
x,y 좌표
input_coord ="WGS84"  좌표계
CategoryGroupCode 하단 참조
radius 검색 범위
"""
header={"Authorization": "KakaoAK 468b7fd043830d2a5ddb6fff0a000b5b"} #나중에 초기화 파일로 빼낼거(인증키)
param={"query=이마트"}
#좌표로 행정구역정보 받기
def notNamed1(x, y):
    url = f"https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x={x}&y={y}"
    result = requests.get(urlparse(url).geturl(),
        headers=header).json()
    return result

#좌표로 주소 변환하기
def notNamed2(x, y):
    url = f"https://dapi.kakao.com/v2/local/geo/coord2address.json?x={x}&y={y}"
    result = requests.get(urlparse(url).geturl(),
        headers=header).json()
    return result

#키워드로 장소 검색하기 (수정중)
def notNamed3(x, y, radius):
    url = f"https://dapi.kakao.com/v2/local/search/keyword.json?y={y}&x={x}&radius={radius}"
    result = requests.get(urlparse(url).geturl(),
        headers=header, params=param).json()
    return result

#카테고리로 장소 검색하기
def notNamed4(CategoryGroupCode, radius):
    url = f"https://dapi.kakao.com/v2/local/search/category.json?category\_group\_code={CategoryGroupCode}&radius={radius}"
    result = requests.get(urlparse(url).geturl(),
        headers=header).json()
    return result


print(json.dumps(notNamed2(128.755739,35.834908),indent=4,ensure_ascii=False))

"""
CategoryGroupCode
이름	설명
MT1	대형마트
CS2	편의점
PS3	어린이집, 유치원
SC4	학교
AC5	학원
PK6	주차장
OL7	주유소, 충전소
SW8	지하철역
BK9	은행
CT1	문화시설
AG2	중개업소
PO3	공공기관
AT4	관광명소
AD5	숙박
FD6	음식점
CE7	카페
HP8	병원
PM9	약국
"""