import requests
import soundfile as sf
url = "http://127.0.0.1:7777/get_string"
#files = {"file": open("./audio_sample.wav", "rb")}
data = {"key" : "카드 결제로 하고 싶어요."}
#response = requests.post(url, files=files)
response = requests.post(url, json=data)
print(response)

print(response.json())
