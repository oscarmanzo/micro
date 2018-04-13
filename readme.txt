
docker build -t micro-services-test .

docker images

docker run -p 4000:8080 micro-services-test

docker container ls

docker rmi container_id

docker stop container_id