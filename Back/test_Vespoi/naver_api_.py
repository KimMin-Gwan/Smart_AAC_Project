import requests
from urllib.parse import urlparse
import json

client_id = '_________________________' 
client_secret = '__________________________'
headers = {'X-Naver-Client-Id':client_id, 'X-Naver-Client-Secret':client_secret}

url_base="https://openapi.naver.com/v1/search/local.json?query="
keyword = "영남대학교"
url_middle="$&start="
number='1'

url = url_base + keyword + url_middle + number

result = requests.get(url,headers = headers).json()
print(json.dumps(result,indent=4,ensure_ascii=False))
print(json.dumps(result['items'][0]["category"],indent=4,ensure_ascii=False))