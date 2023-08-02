import re
import json


def preprocessing_text_data(file_path): #txt 파일 텍스트 정리
    file = open(file_path, encoding='UTF8')

    data = file.read()

    split_data = data.split(',')

    text_data = []
    for i in split_data:
        new_str = re.sub(r"[^\uAC00-\uD7A3a-zA-Z\s0-9]", "", i)
        new_str = new_str.replace(" ", "")
        #print(new_str)
        text_data.append(new_str)
    
    return list(set(text_data))

def init_dict(dict_aac, path):
    location_label="10" #장소
    index = 0
    for i in preprocessing_text_data(path):
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(location_label + str(index)),
            "node" : [],
            "name" : i
        })

def add_txt_dict_location(dict_aac,PATH): #텍스트 파일로 딕셔너리 만들기 - 장소
    location_label="10" #장소
    index = 0
    for i in dict_aac["AAC"]:
        if str(i["id"])[:2] == "10":
            #print(str(i["id"])[:2])
            index = int(str(i["id"])[2:])
            #print(index)

    aac_data = preprocessing_text_data(PATH)
    for i in aac_data:
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(location_label + str(index)),
            "node" : [],
            "name" : i
        })

def add_txt_dict_category(dict_aac,PATH): #텍스트 파일로 딕셔너리 만들기 - 장소 아래 카테고리
    location_label="20" #카테고리
    index = 0
    for i in dict_aac["AAC"]:
        if str(i["id"])[:2] == "20":
            index = int(str(i["id"])[2:])

    aac_data = preprocessing_text_data(PATH)
    for i in aac_data:
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(location_label + str(index)),
            "node" : [],
            "name" : i
        })

def add_txt_dict_flow(dict_aac,PATH): #텍스트 파일로 딕셔너리 만들기 - 장소 아래 대화형
    location_label="30" #순서형
    index = 0
    for i in dict_aac["AAC"]:
        if str(i["id"])[:2] == "30":
            index = int(str(i["id"])[2:])

    aac_data = preprocessing_text_data(PATH)
    for i in aac_data:
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(location_label + str(index)),
            "node" : [],
            "name" : i
        })

def add_txt_dict_AAC(dict_aac,PATH): #텍스트 파일로 딕셔너리 만들기 - 카테고리 아래 AAC
    aac_label = "40" #기본 AAC
    index = 0
    for i in dict_aac["AAC"]:
        if str(i["id"])[:2] == "40":
            index = int(str(i["id"])[2:])

    aac_data = preprocessing_text_data(PATH)
    for i in aac_data:
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(aac_label + str(index)),
            "node" : [],
            "name" : i
        })

def add_txt_dict_ai(dict_aac,PATH): #텍스트 파일로 딕셔너리 만들기 - AI 카테고리
    ai_label = "90" #AI 카테고리
    index = 0
    for i in dict_aac["AAC"]:
        if str(i["id"])[:2] == "90":
            index = int(str(i["id"])[2:])

    aac_data = preprocessing_text_data(PATH)
    for i in aac_data:  
        index = index + 1
        dict_aac["AAC"].append({
            "id": int(ai_label + str(index)),
            "node" : [],
            "name" : i
        })
        #print(i)
    #print(dict_data)

def add_single_dict_location(dict_aac,name): #장소 추가
    location_label="10" #장소
    index = 0
    for i in dict_aac["AAC"]:
        if str(i["id"])[:2] == "10":
            index = int(str(i["id"])[2:])

    index = index + 1
    dict_aac["AAC"].append({
        "id": int(location_label + str(index)),
        "name" : name
    })

def add_single_dict_category(dict_aac,name): #카테고리 추가
    location_label="20" 
    index = 0
    for i in dict_aac["AAC"]:
        if str(i["id"])[:2] == "20":
            index = int(str(i["id"])[2:])

    index = index + 1
    dict_aac["AAC"].append({
        "id": int(location_label + str(index)),
        "name" : name
    })

def add_single_dict_flow(dict_aac,name): #순서형 추가
    location_label="30" #순서형
    index = 0
    for i in dict_aac["AAC"]:
        if str(i["id"])[:2] == "30":
            index = int(str(i["id"])[2:])

        index = index + 1
        dict_aac["AAC"].append({
            "id": int(location_label + str(index)),
            "name" : name
        })

def add_single_dict_AAC(dict_aac,name): #AAC 추가
    location_label="40" 
    index = 0
    for i in dict_aac["AAC"]:
        if str(i["id"])[:2] == "40":
            index = int(str(i["id"])[2:])

    index = index + 1
    dict_aac["AAC"].append({
        "id": int(location_label + str(index)),
        "name" : name
    })

def add_single_dict_ai(dict_aac,name): #AI 카테고리 추가
    location_label="90" 
    index = 0
    for i in dict_aac["AAC"]:
        if str(i["id"])[:2] == "90":
            index = int(str(i["id"])[2:])

    index = index + 1
    dict_aac["AAC"].append({
        "id": int(location_label + str(index)),
        "name" : name
    })

def id_finder(dict_data, name): #이름(name)으로 id 찾기
    for i in dict_data["AAC"]:
        if(i["name"]==name):
            return i["id"]

def id_finder_multi(dict_data, name_list): #이름(name) 목록(list) 으로 id 찾기
    id_list = []

    for i in dict_data["AAC"]:
        for j in name_list:
            if(i["name"]==j):
                id_list.append(i["id"])
    return id_list

def node_add_single(dict_data, id, node): #node에 숫자(id) 하나(node <- int) 추가
    for i in dict_data["AAC"]:
        if(i["id"]==id):
            i["node"].append(node)

def node_add_multi(dict_data, id, node_list): #node 에 숫자(id) 여러개(node <- list(int)) 추가
    for i in dict_data["AAC"]:
        if(i["id"]==id):
            for j in node_list:
                i["node"].append(j)

def add_multi_to_multi(dict_data, list_where, node_list): #list_where: 추가 할 곳(ex 이것, 저것) , node_list 추가할 노드(ex 있습니다, 없습니다 )
    for i in list_where:
        id = id_finder(dict_data, i)
        node_add_multi(dict_data, id, node_list)

def add_single_to_multi(dict_data, list_where, name_single): #list_where: 추가 할 곳(ex 이것, 저것) , node_list 추가할 노드(ex 주세요 )
    for i in list_where:
        id = id_finder(dict_data, i)
        node_add_single(dict_data, id, name_single)

def open_json(PATH): #json 불러오기
    with open (PATH, "r") as f:
        dict_data = json.load(f)
    return dict_data

def make_json(dict_data): #json 저장
    json_data = json.dumps(dict_data, indent="\t", ensure_ascii=False)
    with open('json_data_test.json', 'w') as f:
        f.write(json_data)




def main():
    dict_aac = {"AAC": [] }
    init_dict(dict_aac, "카테고리/test_location.txt")
    add_txt_dict_category(dict_aac,"카테고리/test_category.txt")
    add_txt_dict_flow(dict_aac, "카테고리/test_flow.txt")   
    add_txt_dict_AAC(dict_aac, "카테고리/test_aac.txt")

    node_list=["주문", "요청카페", "계산요청"]
    node_add_multi(dict_aac, id_finder(dict_aac,"카페"), id_finder_multi(dict_aac,node_list))
    node_add_single(dict_aac, id_finder(dict_aac,"주문"), id_finder(dict_aac,"종류"))
    node_list=["커피","티","스무디"]
    node_add_multi(dict_aac, id_finder(dict_aac,"종류"), id_finder_multi(dict_aac,node_list))
    node_list = ["에스프레소","아메리카노","카페라떼","카페모카","카라멜마끼야또","바닐라라떼"]
    node_add_multi(dict_aac, id_finder(dict_aac,"커피"), id_finder_multi(dict_aac,node_list))
    add_single_to_multi(dict_aac, node_list, id_finder(dict_aac,"HOTCOLD"))
    node_list = ["녹차","얼그레이티","히비스커스티","캐모마일티","패션후르츠티","밀크티"]
    node_add_multi(dict_aac, id_finder(dict_aac,"티"), id_finder_multi(dict_aac,node_list))
    add_single_to_multi(dict_aac, node_list, id_finder(dict_aac,"HOTCOLD"))
    node_list = ["수박스무디","망고스무디","딸기스무디","커피스무디","초콜릿스무디","민트스무디"]
    node_add_multi(dict_aac, id_finder(dict_aac,"스무디"), id_finder_multi(dict_aac,node_list))
    add_single_to_multi(dict_aac, node_list, id_finder(dict_aac,"잔"))
    node_list = ["따뜻하게","차갑게"]
    node_add_multi(dict_aac, id_finder(dict_aac,"HOTCOLD"), id_finder_multi(dict_aac,node_list))
    add_single_to_multi(dict_aac, node_list, id_finder(dict_aac,"잔"))
    node_list = ["포장","매장","텀블러"]
    node_add_multi(dict_aac, id_finder(dict_aac,"잔"), id_finder_multi(dict_aac,node_list))
    add_single_to_multi(dict_aac, node_list, id_finder(dict_aac,"결제방식"))
    node_list = ["카드","현금","기프티콘"]
    node_add_multi(dict_aac, id_finder(dict_aac,"결제방식"), id_finder_multi(dict_aac,node_list))

    node_list = ["빨대","물티슈","휴지","시럽","와이파이","화장실","흡연실","메뉴판"]
    node_add_multi(dict_aac, id_finder(dict_aac,"요청카페"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ["주세요","어디있어요","버려주세요","필요해요"]
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list = ["영수증","봉투","계산","가격","현금영수증"]
    node_add_multi(dict_aac, id_finder(dict_aac,"계산요청"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ["해주세요","주세요","필요해요","필요없어요","얼마에요"]
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list=["주문식당", "추가요청", "계산요청"]
    node_add_multi(dict_aac, id_finder(dict_aac,"식당"), id_finder_multi(dict_aac,node_list))

    node_list=["수량", "인원", "맵기"]
    node_add_multi(dict_aac, id_finder(dict_aac,"주문식당"), id_finder_multi(dict_aac,node_list))
    node_list=["1개" , "2개" , "3개", "4개"]
    node_add_multi(dict_aac, id_finder(dict_aac,"수량"), id_finder_multi(dict_aac,node_list))
    node_list=["1인분","2인분","3인분","4인분"]
    node_add_multi(dict_aac, id_finder(dict_aac,"인원"), id_finder_multi(dict_aac,node_list))
    node_list=["맵게" , "덜맵게" , "맵지않게"]
    node_add_multi(dict_aac, id_finder(dict_aac,"맵기"), id_finder_multi(dict_aac,node_list))

    node_list = ["휴지","물티슈","수저","젓가락","포크","나이프","소스","공기밥","반찬","메뉴판","물"]
    node_add_multi(dict_aac, id_finder(dict_aac,"추가요청"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ["주세요","더주세요","추가할게요"]
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list=["찾기마트", "장소마트", "계산요청"]
    node_add_multi(dict_aac, id_finder(dict_aac,"마트"), id_finder_multi(dict_aac,node_list))

    node_list = ["가지","감자","강낭콩","계란","고구마","고추","호박","버섯","부추","우유","과자","젤리","음료수"]
    node_add_multi(dict_aac, id_finder(dict_aac,"찾기마트"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ["어디있어요","주세요","필요해요"]
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list = ["화장실","계산대","시식코너","행사장","바구니카트","푸드코트"]
    node_add_multi(dict_aac, id_finder(dict_aac,"장소마트"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ["어디에요","가고싶어요","필요해요","원해요"]
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list=["찾기편의점", "계산요청"]
    node_add_multi(dict_aac, id_finder(dict_aac,"편의점"), id_finder_multi(dict_aac,node_list))

    node_list = ["과자","라면","삼각김밥","빵","젤리","생필품","음료수","술","복권","담배"]
    node_add_multi(dict_aac, id_finder(dict_aac,"찾기편의점"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ["어디있어요","주세요","필요해요"]
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list=["찾기문구점", "계산요청","요청문구점"]
    node_add_multi(dict_aac, id_finder(dict_aac,"문구점"), id_finder_multi(dict_aac,node_list))

    node_list = ["가위","볼펜","연필",'샤프','지우개','테이프','도화지','물감','붓','딱풀','색종이','수첩','스케치북','실내화']
    node_add_multi(dict_aac, id_finder(dict_aac,"찾기문구점"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ["어디있어요","주세요","필요해요"]
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list = ['컬러인쇄','흑백인쇄','제본','코팅','스캔','선물포장','복사']
    node_add_multi(dict_aac, id_finder(dict_aac,"요청문구점"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ['고장났어요','필요해요','해주세요','교환해주세요','보내주세요','원해요']
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list=["찾기서점도서관", "계산요청","요청서점"]
    node_add_multi(dict_aac, id_finder(dict_aac,"서점"), id_finder_multi(dict_aac,node_list))

    node_list = ['베스트셀러','국내소설','해외소설','만화책','도서검색대','문제집','수필','시집','신간도서','전공서적','잡지']
    node_add_multi(dict_aac, id_finder(dict_aac,"찾기서점도서관"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ['어디있어요','주세요','필요해요']
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list = ['환불해주세요','교환해주세요']
    node_add_multi(dict_aac, id_finder(dict_aac,"요청서점"), id_finder_multi(dict_aac,node_list))

    node_list=["찾기서점도서관", "장소도서관","요청도서관"]
    node_add_multi(dict_aac, id_finder(dict_aac,"도서관"), id_finder_multi(dict_aac,node_list))
    
    node_list = ['화장실','열람실','구내식당','정수기','컴퓨터실','장애인보조도구']
    node_add_multi(dict_aac, id_finder(dict_aac,"장소도서관"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ['어디에요','가고싶어요','필요해요','원해요']
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))
    
    node_list = ['대여','반납']
    node_add_multi(dict_aac, id_finder(dict_aac,"요청도서관"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ['원해요','해주세요']
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list=["계산요청","요청미용실"]
    node_add_multi(dict_aac, id_finder(dict_aac,"미용실"), id_finder_multi(dict_aac,node_list))

    node_list = ['두피마사지','파마','커트','염색','앞머리','스포츠머리','짧게','짧지않게']
    node_add_multi(dict_aac, id_finder(dict_aac,"요청미용실"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ['깎아주세요','잘라주세요','원해요','해주세요','할래요']
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list=["계산요청","티켓","먹거리","요청영화관"]
    node_add_multi(dict_aac, id_finder(dict_aac,"영화관"), id_finder_multi(dict_aac,node_list))

    node_list = ['애니메이션','액션영화','코미디','스릴러','로맨스','조조영화','심야영화','가장빠른거']
    node_add_multi(dict_aac, id_finder(dict_aac,"티켓"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ['추천해주세요','예매해주세요','원해요',]
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list = ['팝콘','음료수','츄러스','핫도그','나쵸']
    node_add_multi(dict_aac, id_finder(dict_aac,"먹거리"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ['원해요','구매할게요','주세요']
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    node_list = ['좌석변경','예매취소','장애인석']
    node_add_multi(dict_aac, id_finder(dict_aac,"요청영화관"), id_finder_multi(dict_aac,node_list))
    list_where = node_list
    node_list = ['해주세요','원해요','가능해요']
    add_multi_to_multi(dict_aac, list_where, id_finder_multi(dict_aac,node_list))

    make_json(dict_aac)
    

if __name__ == "__main__":
    main()


#만들어야 하는거: 삭제 , 수정(초기화)

