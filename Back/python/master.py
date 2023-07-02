from PROCESS import MainFunction
from WAS import AppServer
import uvicorn 
HOST = '127.0.0.1'
PORT = 7777

def server():
    mainfunction = MainFunction()
    server = AppServer(mainfunction=mainfunction)
    server.run_server(HOST = HOST, PORT = PORT)
    


