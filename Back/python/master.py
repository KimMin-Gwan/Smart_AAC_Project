import back_end
from back_end import MainFunction
from WAS import AppServer
import uvicorn 

## Server Setting
HOST = '127.0.0.1'
PORT = 7777

## server
def server():
    mainfunction = MainFunction()
    server = AppServer(mainfunction=mainfunction)
    server.run_server(HOST = HOST, PORT = PORT)

if __name__ == "__main__":
    server()
    


