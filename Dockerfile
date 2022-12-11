FROM openjdk:11
EXPOSE 8083
ADD target/ExamThourayaS2-0.0.1-SNAPSHOT.jar ExamThourayaS2-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ExamThourayaS2-0.0.1-SNAPSHOT.jar"]