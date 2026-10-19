@echo off
echo off

call environment.bat

set BaseWebServerDirectory_Default=WebServer
set PostFixDirectory_Default=AP1

set BaseWebServerDirectory=
set PostFixDirectory=

setlocal enableextensions enabledelayedexpansion

if [%1%]==[] (
	set /p BaseWebServerDirectory="Type Web Server Directory name [%BaseWebServerDirectory_Default%]: "
	if [!BaseWebServerDirectory!]==[] (
		set BaseWebServerDirectory=%BaseWebServerDirectory_Default%
	)
) else (
	set BaseWebServerDirectory=%1%
)

if [%2%]==[] (
	set /p PostFixDirectory="Type Web Server Directory name [%PostFixDirectory_Default%]: "
	if [!PostFixDirectory!]==[] (
		set PostFixDirectory=%PostFixDirectory_Default%
	)
) else (
	set PostFixDirectory=%2%
)

set Directory_WebServer=%BaseWebServerDirectory%-%PostFixDirectory%

echo Python version:
python --version

echo Creating Web Server examples directory...
mkdir %Directory_WebServer%

echo Copying template files...
xcopy _template %Directory_WebServer% /E

echo Changing to Web Server directory...
cd %Directory_WebServer%

echo Creating Python environment...
python -m venv %Directory_PythonEnv%

echo Updating pip...
%Directory_PythonEnv%\Scripts\python.exe -m pip install --upgrade pip

echo Installing Python/Flask modules...
%Directory_PythonEnv%\Scripts\pip install Flask Flask-Session Flask-Mail

pause
