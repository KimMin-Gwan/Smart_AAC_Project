import requests
import soundfile as sf
#url = "http://13.125.205.99/get_string"
url = "http://127.0.0.1:7777/get_string"
#files = {"file": open("./audio_sample.wav", "rb")}
data = {"key" : "현금영수증 해드릴까요?"}
#response = requests.post(url, files=files)
response = requests.post(url, json=data)
print(response)

print(response.json())
