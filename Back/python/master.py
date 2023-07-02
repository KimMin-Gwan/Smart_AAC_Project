from PROCESS import MainFunction
from WAS import AppServer
import uvicorn 

def server():
    mainfunction = MainFunction()
    server = AppServer(mainfunction=mainfunction)
    app = server.app
    uvicorn.run(app, host = '127.0.0.1', port = 7777)


