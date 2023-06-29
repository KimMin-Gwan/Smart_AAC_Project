from gtts import gTTS

text="테스트"

tts = gTTS(
    text = text,
    lang ='ko'
)
tts.save("audio/tts_test.flac")