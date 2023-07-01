import requests
import soundfile as sf

def get_audio_header_info(filename):
    # 오디오 파일의 헤더 정보를 읽어옴
    info = sf.info(filename)

    # 헤더 정보 출력
    print("Sample Rate:", info.samplerate)
    print("Channels:", info.channels)
    print("Duration:", info.duration)
    print("Format:", info.format)
    print("Subtype:", info.subtype)

url = "http://127.0.0.1:8000/get/wav"
files = {"audio": open("sample_text.txt", "rb")}
#get_audio_header_info("audio_sample.wav")
response = requests.post(url, files=files)
print(response)

print(response.json())
