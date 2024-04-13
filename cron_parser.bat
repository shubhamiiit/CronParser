@echo off

REM Set directory paths
set SRC_DIR=src
set BUILD_DIR=build
set MAIN_CLASS=assignment.CronParser

mkdir %BUILD_DIR% 2>nul

REM Compile Java files
javac -d %BUILD_DIR% %SRC_DIR%\assignment\*.java %SRC_DIR%\assignment\CronFieldParser\*.java

REM Check for compilation errors
if %ERRORLEVEL% NEQ 0 (
    echo Compilation failed.
    exit /b 1
)

REM Run the main class
java -cp %BUILD_DIR% %MAIN_CLASS% %*
