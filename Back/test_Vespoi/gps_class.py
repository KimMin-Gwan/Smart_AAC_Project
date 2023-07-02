import requests
from urllib.parse import urlparse
import json
import constant

#좌표로 주소 변환하기
def gps_data(lon, lat):
    url = f"https://dapi.kakao.com/v2/local/geo/coord2address.json?x={lon}&y={lat}"
    result = requests.get(urlparse(url).geturl(),
        headers=header).json()

    return result

#확인용 출력
print(json.dumps(gps_data(128.755739,35.834908),indent=4,ensure_ascii=False))  
print(json.dumps(gps_data(128.755739,35.834908)['documents'][0]["road_address"]["building_name"],indent=4,ensure_ascii=False))


#인증키 constant
#gps 정보 받아오기
#건물 ㅔㄷ이터 보내주기
#try except < 건물 데이터 없으며 데이턱 ㅏ없으니 사용
class gps():   
    def __init__():
        self.lat = lon
        self.lon = lon

    def __gps_location():
        #안드로이드 애플리케이션에서 gps 데이틀 받아옴
        return 0

    def __where_am_i():
        #gps 경도 위도로 현재 위치의 정보 받기
        lon = self.__gps_location() #gps 위치 받은거 경도 위도 잘라서 넣어주기
        lat = 0
        url = f"https://dapi.kakao.com/v2/local/geo/coord2address.json?x={lon}&y={lat}"
        result = requests.get(urlparse(url).geturl(), headers=constant.header).json()        
        return result

    def __you_are_here():
        try:
            data = json.dumps(self.__where_am_i()['documents'][0]["road_address"]["building_name"],indent=4,ensure_ascii=False)
            return 
        
        except:
            all_data = print("건물 데이터 못찾음 대신 다 보여드림", json.dumps(self.__where_am_i(),indent=4,ensure_ascii=False))
            return 


    def need_great_name_4_this_func():
        #건물 이름으로 얻은 데이터 분석해서 장소 라벨 보내주기 ex)식당, 병원, 약국, 학교
        return 0
