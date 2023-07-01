import numpy as np
import wave, math
import sounddevice as sd
import soundfile as sf
import keyboard
import threading
import librosa

#Overrun 검출기
#Overrun이 발생하면 True를 반환 
def check_overrun(data, sample_rate, runtime):
    overrun_size = sample_rate * runtime
    target = np.zeros(overrun_size)
    #snapshot = list()
    window = len(target)
    possibility = np.where(data = target[0])[0]
    for case in possibility:
        check = data[case:case+window]
        if np.all(check == target):
            return True
        else:
            return False
        

def check_interupt():
    global stop_recording
    if keyboard.is_pressed('q'):
        stop_recording = True

        
def recording(file, duration):
    print("Recording start")
    def callback(indata, frames, time, status):
        if status:
            print("Error : ", status)
        else:
            print("recording...")
        sf.write(file, indata, samplerate)

    # 콜백 함수와 샘플링 속도를 설정하여 오디오 입력 시작
    samplerate = sd.query_devices(None, 'input')['default_samplerate']
    samplerate = int(samplerate)
    stream = sd.InputStream(callback= callback, channels = 1, 
                            samplerate=samplerate, 
                            blocksize=int(samplerate * duration))
    stream.start()

    while True:
        if keyboard.is_pressed('q'):
            print('stop_recording')
            break


    #sd.sleep(int(duration * 1000))

    stream.stop()
    stream.close()
    print("Recording Finishied")

def get_audio_header_info(filename):
    # 오디오 파일의 헤더 정보를 읽어옴
    info = sf.info(filename)

    # 헤더 정보 출력
    print("Sample Rate:", info.samplerate)
    print("Channels:", info.channels)
    print("Duration:", info.duration)
    print("Format:", info.format)
    print("Subtype:", info.subtype)

        
def audio_test():
    recording("sample.wav", 5)
    #get_audio_header_info('sample.wav')


if __name__ == "__main__":
    audio_test()




