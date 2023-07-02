
import requests

url = "https://maps.googleapis.com/maps/api/place/details/json?place_id=ChIJe3hOIsXjZTURA07Md8yGGxY&key=#####"

payload={}
headers = {}

response = requests.request("GET", url, headers=headers, data=payload)

print(response.text)