import os
os.environ["GOOGLE_APPLICATION_CREDENTIALS"]="clever-oasis-391111-6b11bee44796.json"

### Sample Code ###

# Imports the Google Cloud client library
from google.cloud import speech

# Instantiates a client
client = speech.SpeechClient()

# The name of the audio file to transcribe
gcs_uri = "gs://speech_sound_test/test_audio_KR"
#gs://버킷이름/파일이름

audio = speech.RecognitionAudio(uri=gcs_uri)

config = speech.RecognitionConfig(
    encoding=speech.RecognitionConfig.AudioEncoding.FLAC,
    audio_channel_count=2,
    sample_rate_hertz=44100,
    language_code="ko-KR",
)

# Detects speech in the audio file
response = client.recognize(config=config, audio=audio)

for result in response.results:
    print("Transcript: {}".format(result.alternatives[0].transcript))

### Sample Code ###