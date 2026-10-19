@echo off
echo off

call environment.bat

echo Python version inside environment
%Directory_PythonEnv%\Scripts\python --version

set FLASK_APP=Server.py

set FLASK_BIN=%Directory_PythonEnv%\Scripts\flask

start %FLASK_BIN% run --port %Port% --host="0.0.0.0"

timeout 3

start http://localhost:%Port%/
