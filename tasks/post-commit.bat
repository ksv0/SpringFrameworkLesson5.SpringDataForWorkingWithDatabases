@echo on

echo MAVEN_PROJECT_PATH: %MAVEN_PROJECT_PATH%
echo DOCKER_IMAGE_NAME: %DOCKER_IMAGE_NAME%

cd %MAVEN_PROJECT_PATH%

echo Current directory: %CD%

:: Build Maven project
call mvn clean install

if %ERRORLEVEL% EQU 0 (
    :: Build Docker image
    docker build -t %DOCKER_IMAGE_NAME%.

    :: Push Docker image to Docker Hub
    docker push %DOCKER_IMAGE_NAME%
)