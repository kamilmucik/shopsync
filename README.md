# shopsync

#build
shopsync -> mvn clean install

shopsync/web-app -> mvn clean spring-boot:run -Plocal

shopsync/web-app -> mvn clean package -Papp

shopsync -> mvn clean install sonar:sonar -Psonar --settings=settings.xml

shopsync -> mvn -B -DdevelopmentVersion="0.0.2-SNAPSHOT" -DrleaseVersion="0.0.1" -Dresume=false release:prepare release:perform -DdryRun=true

shopsync -> git reset HEAD~1