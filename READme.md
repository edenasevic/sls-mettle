# Getting Started

### Prerequisites
* Java 17 installed (that's the one I used)
* Have maven installed, since dependencies will be pulled on first `mvn clean install`
* Have Docker installed (will be needed for Postgre DB)


###Before you start up the application you must do the following:

* Run the `docker-compose up` from terminal.
    * You must be located in root of the project.
    * This will start up Postgre DB inside of a docker container. Connection properties can be found in `applicaiton.properties` file.
    * Once the Postgre is up, run the following maven command for DB migrations: ` mvn clean flyway:migrate -Dflyway.configFile=flyway.properties`.
        * This will create items tables
        * It will insert one ite in `items` table.
    * Once Flyway migrations are finished successfully, you can run the app.
    * The app will be running on port 8080.

Best way to run the app is if you have Intelijj IDEA installed and to run via that IDE.
