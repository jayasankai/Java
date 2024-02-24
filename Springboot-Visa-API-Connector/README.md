<pre>
<b>How to use application</b>
  Run application:
  > java -jar ./dist/visa.api.connector-0.0.1-SNAPSHOT.jar
  > test via postman 
  	url : https://localhost:8085/vdp/helloworld

<b>Assumptions:</b>
  This spring-boot application implemented as a REST client where anyone can call API to retrieve data. 
  Which means application has less security and less validations.
  Here I assumed this application is hosted in de-militarized zone where APIs can access by other services within the same private subnet.

<b>Improvements:</b>
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
	
	
<b>Note: 20240224</b>
Client Application was able get the "helloworld" response from API after re-generating new set of keys in new API project.
See bellow link for more details.
Link : https://community.developer.visa.com/t5/Two-way-SSL-X-Pay-Token/9611-Error-Hello-World-Example/m-p/23771

 
<b>Note: 20240222</b>
 as of now this application is getting bellow response from the service.
 {
    "responseStatus": {
        "status": 403,
        "code": "9611",
        "severity": "ERROR",
        "message": "Authorization Failed for the URL.",
        "info": ""
    }
 }
 
 I've tested this service via Postman and also SOAP UI. Both clients are getting same error.
 So I assumed, Visa service is having some issue while responding to client.
 
 ** However I am checking this further to check the issue.
 
 </pre>