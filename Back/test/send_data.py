import requests
import soundfile as sf

url = "http://127.0.0.1:8000/upload_wav"
files = {"file": open("./audio_sample.wav", "rb")}
#response = requests.post(url, files=files)
response = requests.post(url, files=files)
print(response)

print(response.json())
