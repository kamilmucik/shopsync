# shopsync

#build
shopsync -> mvn clean install

shopsync/web-app -> mvn clean spring-boot:run -Plocal

shopsync/web-app -> mvn clean package -Papp

shopsync -> mvn clean install sonar:sonar -Psonar --settings=settings.xml

shopsync -> mvn -B -DdevelopmentVersion="0.0.2-SNAPSHOT" -DrleaseVersion="0.0.1" -Dresume=false release:prepare release:perform -DdryRun=true

shopsync -> git reset HEAD~1

#TODO
## - mock dla serwisów zewnetrznych
## + testy spock rest, service, DB
## + sonarqube
## + profile z bazami danych
## + pokrycie kody >80
## + spring-security
## + skrypty flyway
## - jmeter
## - postman
## - Api dla mobilki
## + panel web
## - kolejka z zadaniami do wykonania
## + Podłączenie JMXa prometheus
## + BDD- spock + cucumber


Pomocne:
https://blog.allegro.tech/2018/04/Spring-WebMvcTest-with-Spock.html
https://blog.j-labs.pl/2019/05/Test-your-REST-API-with-Spock-Introduction-to-Spock-Framework
https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/