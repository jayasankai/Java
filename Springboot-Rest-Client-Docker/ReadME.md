### Docker Commands
1. docker build -t spring-rest:1.0 .
2. docker run -p 8085:8085 --name spring-rest-container spring-rest:1.0

### Docker cleanup
1. docker ps
2. docker container stop <process id>
3. docker images
4. docker rmi <image name>

### Minicube start
1. minikube dashboard

### Docker Compose
1. kubectl apply -f deployment.yaml -f service.yaml 
2. minikube service rest-api-service
3. kubectl delete -f deployment.yaml -f service.yaml


## Setup and Deploy to EC2 instances
1. sudo yum install docker
2. sudo service docker start
3. Docker info
4. docker run -p 8085:8085 --name spring-rest-container spring-rest:1.0