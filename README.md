# shopsync

#build
shopsync -> mvn clean install

shopsync/web-app -> mvn clean spring-boot:run -Plocal

shopsync/web-app -> mvn clean package -Papp

shopsync -> mvn clean install sonar:sonar -Psonar --settings=settings.xml