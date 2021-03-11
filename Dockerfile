FROM maven:3.6-jdk-8

COPY src /home/SapGuiTst/src

COPY pom.xml /home/SapGuiTst

RUN mvn -f /home/SapGuiTst/pom.xml clean test -DskipTests=true