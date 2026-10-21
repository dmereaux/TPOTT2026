# Utiliser une image de base avec Tomcat 9.0
FROM tomcat:9.0-jdk11

# Installer SQLite
RUN apt-get update && apt-get install -y sqlite3 libsqlite3-dev

# Copier le fichier WAR dans le conteneur
COPY target/TPOTT2026-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

# Copier le script SQL pour initialiser la base de données
COPY init.sql /docker-entrypoint-initdb.d/init.sql

# Exposer le port Tomcat
EXPOSE 8080

# Commande pour démarrer Tomcat après l'initialisation de la base de données
#CMD ["sh", "-c", "sqlite3 /usr/local/tomcat/db/clothing.db < /docker-entrypoint-initdb.d/init.sql && catalina.sh run"]
