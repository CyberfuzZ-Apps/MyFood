FROM openjdk
WORKDIR MY_food
ADD target/MyFood-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar app.jar
