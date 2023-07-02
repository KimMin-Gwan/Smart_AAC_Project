import speech_recognition as sr


def main():
    r = sr.Recognizer()
    with sr.AudioFile('audio_sample.wav') as source:
        audio = r.record(source, duration = 120)
    text = r.recognize_google(audio_data=audio, language='ko-KR')

    print(text)

if __name__ == "__main__":
    main()