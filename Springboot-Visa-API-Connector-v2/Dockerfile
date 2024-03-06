# Build stage
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /home/app
RUN mkdir -p certs
COPY src src
COPY src/main/resources/certs certs
COPY pom.xml .
RUN mvn -f pom.xml clean package -DskipTests

# Run stage
FROM openjdk:17
RUN mkdir -p /var/local/certs
RUN mkdir -p /var/local/logs
COPY --from=build /home/app/target/visa.api.connector-v2-0.0.1.jar /usr/local/lib/visa.api.connector-v2-0.0.1.jar
COPY --from=build /home/app/certs /var/local/certs
RUN cd /var/local/certs/ && \
	keytool -delete -alias ejbca -keystore visaApiConnector_keyAndCertBundle.jks -storepass k62nN5m7WELp35q88vvAU1fvcX -noprompt && \
	keytool -delete -alias digicert -keystore visaApiConnector_keyAndCertBundle.jks -storepass k62nN5m7WELp35q88vvAU1fvcX -noprompt && \
	keytool -import -alias ejbca -keystore visaApiConnector_keyAndCertBundle.jks -file VDPCA-SBX.pem -storepass k62nN5m7WELp35q88vvAU1fvcX -noprompt && \
	keytool -import -alias digicert -keystore visaApiConnector_keyAndCertBundle.jks -file DigiCertGlobalRootCA.crt -storepass k62nN5m7WELp35q88vvAU1fvcX -noprompt
EXPOSE 8085
USER 10014
ENTRYPOINT ["java","-jar","/usr/local/lib/visa.api.connector-v2-0.0.1.jar"]