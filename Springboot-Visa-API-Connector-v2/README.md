### How to use application
  Run application:
  1. java -jar ./dist/visa.api.connector-0.0.1-SNAPSHOT.jar
  2. test via postman 
  	 url : https://localhost:8085/vdp/helloworld

### Assumptions:
This spring-boot application implemented as a REST client where anyone can call API to retrieve data. <br>
Which means application has less security and less validations.<br>
Here I assumed this application is hosted in de-militarized zone where APIs can access by other services within the same private subnet.

### Improvements:
Application level improvements:
  1. Url authentication filters to be added.
  2. Security features like rate limiters to be implemented or handle via Saas level.
  3. Rest Application authentication layer is minimal as of now.
    
Controller layer improvements:
  1. pending to add request layer validations
 
Service level improvements:
  1. pending to add Validations as per the business logics
  2. User IDs and passwords should be retrieved from DB layer
  3. Files (Private key and other security files) should be stored in secure repository or byte stream in DB

### Generate a Key Store:
commands:
- openssl pkcs12 -export -in cert.pem -inkey privateKey.pem -certfile cert.pem -out visaApiConnector_keyAndCertBundle.p12
- keytool -importkeystore -srckeystore visaApiConnector_keyAndCertBundle.p12 -srcstoretype PKCS12 -destkeystore visaApiConnector_keyAndCertBundle.jks
- keytool -list -v -keystore visaApiConnector_keyAndCertBundle.jks
- keytool -import -alias ejbca -keystore visaApiConnector_keyAndCertBundle.jks -file VDPCA-SBX.pem -storepass k62nN5m7WELp35q88vvAU1fvcX
- keytool -import -alias digicert -keystore visaApiConnector_keyAndCertBundle.jks -file DigiCertGlobalRootCA.crt -storepass k62nN5m7WELp35q88vvAU1fvcX
	
### Dockerization
commands:
- mvn clean install -DskipTests
- docker build -t jayasanka/visa-api-connector-v2:1.0 .
- docker push jayasanka/visa-api-connector-v2:1.0
- docker-compose up

### minikube
commands:
- minikube status
- minikube start
- minikube dashboard
- minikube ssh
- minikube stop
- minikube mount /Users/jayasanka/Projects/Java/Springboot-Visa-API-Connector-v2/src/main/resources/certs:/var/data/certs

### Kubernetes with minikube
commands:
- kubectl apply -f credentials.yml -f persistent-volume.yaml -f persistent-volume-claim.yaml -f service.yaml -f deployment.yaml
- kubectl delete -f credentials.yml -f persistent-volume.yaml -f persistent-volume-claim.yaml -f service.yaml -f deployment.yaml
- kubectl apply -f service.yaml -f deployment.yaml
- kubectl delete -f service.yaml -f deployment.yaml 
- kubectl describe pod {POD Name}
- kubectl logs -p {POD Name}

### SCP file
- scp ./src/main/resources/certs/visaApiConnector_keyAndCertBundle.jks docker@minikube:/var/data/certs
	
### Note: 20240224
Client Application was able get the "helloworld" response from API after re-generating new set of keys in new API project.<br>
See bellow link for more details.<br>
Link : https://community.developer.visa.com/t5/Two-way-SSL-X-Pay-Token/9611-Error-Hello-World-Example/m-p/23771

 
### Note: 20240222
as of now this application is getting bellow response from the service.
<pre>
 {
    "responseStatus": {
        "status": 403,
        "code": "9611",
        "severity": "ERROR",
        "message": "Authorization Failed for the URL.",
        "info": ""
    }
 }
</pre>

I've tested this service via Postman and also SOAP UI. Both clients are getting same error.
So I assumed, Visa service is having some issue while responding to client.
 
** However I am checking this further to check the issue.
