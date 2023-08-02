import requests
from urllib.parse import urlparse
import json
import back_end

class GPS():   
    def __init__(self, lat, lon):
        self.lat = lat
        self.lon = lon

    def __gps_location(self):
        #안드로이드 애플리케이션에서 gps 데이틀 받아옴
        return 0

    def __get_location(self):
        #gps 경도 위도로 현재 위치의 정보 받기
        lon = self.__gps_location() #gps 위치 받은거 경도 위도 잘라서 넣어주기
        lat = 0
        url = f"https://dapi.kakao.com/v2/local/geo/coord2address.json?x={lon}&y={lat}"
        result = requests.get(urlparse(url).geturl(), headers=back_end.constant.kakao_headers).json()        
        return result

    def __location_name(self): #받아온 json 데이터에서 건물 이름을 뽑아냄
        try:
            data = json.dumps(self.__where_am_i()['documents'][0]["road_address"]["building_name"],
                              indent=4,ensure_ascii=False)
            return data
        
        except:
            err = "error not found"
            return err #나중에 수정 해야됨  ex) 건물 이름 정보를 찾을 수 없습니다.


    def gps_analyzer(self):
        #건물 이름으로 얻은 데이터 분석해서 장소 라벨 보내주기 ex)식당, 병원, 약국, 학교
        headers = {'X-Naver-Client-Id':client_id, 'X-Naver-Client-Secret':client_secret}

        url_base="https://openapi.naver.com/v1/search/local.json?query="
        keyword = self.__location_name()
        url_middle="$&start="
        number='1'

        url = url_base + keyword + url_middle + number
        if(name == "error not found"):
            err = "failled to find bd use"
            return err

        
        result = requests.get(url,headers = naver_headers).json()
        try:
            #BdUse = json.dumps(result['items'][0]["category"],indent=4,ensure_ascii=False)
            BdUse = result['items'][0].pop('category', None)
            data = BdUse.split('>')
            result_json = {'category': data[1]}

            return result_json
        except:
            err = "data not found"
            return err
        
