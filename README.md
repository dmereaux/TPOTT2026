# Example JSP project with Tomcat and Maven

A simple JSP project to introduce working with Maven.
The project is packaged as a war file and deployed onto a dockerized Tomcat server.

## Building

The below command removes the target folder, compiles the code, runs the tests and creates a WAR file.

`mvn clean install`

## Running locally

The below command compiles the code, runs the tests, creates a WAR file and deploys it onto an in-memory Jetty web server.

`mvn install jetty:run`

You can now access the app with a brower at http://localhost:8080. You can also send HTTP requests to the REST API at
http://localhost:8080/rest/hello.

### Deploying to Tomcat

To deploy the code onto a dockerized Tomcat server, use the following commands:

```shell
mvn clean install
docker run \
-it --rm \
-v $PWD/target/tomcatjspexample-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/ROOT.war \
-p 8080:8080 \
tomcat:9.0
```

### Using a Docker container for the database

To setup a dockerized MySQL db and initialize it with schemas, run the following:
```shell
# create a MySQL docker container with a root user and db
docker run \
--name some-mysql \
-e MYSQL_ROOT_PASSWORD=my-secret-pw \
-e MYSQL_DATABASE=testdb \
-p 3306:3306 \
-d mysql:8.0
# test the connection to the db
mysql -h localhost -P 3306 --protocol=tcp -u root -p
# run a flyway migration
flyway \
-user=root \
-password=my-secret-pw \
-url=jdbc:mysql://localhost:3306/testdb \
-locations=filesystem:/$PWD/src/main/resources/db/migration \
migrate
```
# TPOTT2026
