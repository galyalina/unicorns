# Getting Started

### Build docker compose
docker-compose up -d    

### Build image and push

* ```docker build .```
* ```docker build -t galyalina/unicorn-rest .```
* ```docker tag galyalina/unicorn-rest galyalina/unicorn-rest:1.0.0```
* ```docker push galyalina/unicorn-rest:1.0.0 ```


### Copy file
docker cp 1875c426a2df:app.jar /Users/glitkin/Code/spring
