FROM maven:3.6-jdk-8

COPY src /home/SapGuiTst/src

COPY pom.xml /home/SapGuiTst

RUN mvn -f /home/CC_BDD_TNG/pom.xml clean test -DskipTests=true