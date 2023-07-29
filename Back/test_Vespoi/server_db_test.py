from flask import *
from pymongo import MongoClient
import certifi
from bson.json_util import dumps
import json

app = Flask(__name__)

mongo_connect = "mongodb+srv://admin:_____________@cluster0.pmbm4ny.mongodb.net/?retryWrites=true&w=majority"
#client = MongoClient(mongo_connect)
client = MongoClient(mongo_connect, tlsCAFile=certifi.where())
db = client.temp

@app.route('/') #계정 아이디는 전화번호 비밀번호는 비밀번호
def test(): #데이터 확인 실험용 root
    phone = "010-0000-0001"
    temp = db.account.find_one({"phone": phone})
    result = json.dumps(temp["name"], ensure_ascii=False)
    data = make_response(result)
    return data



@app.route('/login', methods=["POST"]) #계정 아이디는 전화번호 비밀번호는 비밀번호
def login():
    params = request.get_json() #로그인 정보를 json으로 받음
    phone = params["phone"]
    password = params["password"]
    try:
        temp = db.account.find_one({"phone": phone})
        result = json.dumps(temp["pw"], ensure_ascii=False)
        password_db = make_response(result)

        if(password == password_db):
            return jsonify({"message":"성공","status": HTTPStatus.OK})
        else:
            return jsonify({"message":"pw 실패","status": HTTPStatus.OK})

    except:
        return jsonify({"message":"phone 실패","status": HTTPStatus.OK})

@app.route('/register', methods=["POST"])
def register():
    params = request.get_json()
    data={
        'name':params["name"],
        'phone':params["phone"],
        'pw':params["pw"]
    }
    if(params["name"]==""):
        return jsonify({"message":"name 실패","status": HTTPStatus.OK})
    elif(params["phone"]==""):
        return jsonify({"message":"phone 실패","status": HTTPStatus.OK})
    elif(params["pw "]==""):
        return jsonify({"message":"pw 실패","status": HTTPStatus.OK})
    db.account.insert_one(data)
    return jsonify({"message":"성공","status": HTTPStatus.OK})
   
if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)





    
# doc = {'key':'value','key':value}
# db.users.insert_one(doc)

# # 한 개 찾기(조건 추가)
# user = db.users.find_one({'key':'value'})

# # 여러개 찾기( _id 값은 제외하고 출력)
# all_users = list(db.users.find({},{'_id':False}))

# # 바꾸기
# db.users.update_one({'where_key':'where_value'},{'$set':{'key':set_value}})

# # 지우기
# db.users.delete_one({'key':'value'})
