# word-counter
To run the microservice locally you'll need to have the following software installed:
- Java 8
- Maven

To run it locally:
- clone the repository
- open the terminal in the word-counter-lib root folder and run 'mvn clean install' (this will create a snapshot of the library in your local .m2 folder)
- when that finishes, open word-counter-api with:
    - IntelliJ and run 'mvn clean install' and then run the app using the play button
    - the terminal and run 'mvn clean install', when that finishes position yourself in the target folder in the root of the app and run "java -jar word-counter-api-0.0.1-SNAPSHOT.jar"
