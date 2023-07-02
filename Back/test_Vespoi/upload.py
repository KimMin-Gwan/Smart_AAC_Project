import os
from google.cloud import storage

#클라욷 연결
os.environ["GOOGLE_APPLICATION_CREDENTIALS"]="###.json"

#연결 확인
storage_client = storage.Client()
buckets = list(storage_client.list_buckets())
print(buckets)

#파일 업로드
bucket_name = 'speech_sound_test'    # 서비스 계정 생성한 bucket 이름 입력
source_file_name = 'audio/test_audio_KR.flac'  # GCP에 업로드할 파일 절대경로
destination_blob_name = 'test_audio_KR'    # 업로드할 파일을 GCP에 저장할 때의 이름


storage_client = storage.Client()
bucket = storage_client.bucket(bucket_name)
blob = bucket.blob(destination_blob_name)

blob.upload_from_filename(source_file_name)

print(blob.public_url)
print(blob.self_link)
print(blob.media_link)
print(blob.path)