# Utiliser l'image OpenJDK 11 comme base
FROM openjdk:8

# Exposer le port 8987
EXPOSE 8987

# Installer wget pour récupérer l'artefact depuis Nexus
RUN apt-get update && apt-get install -y wget

# Récupérer l'artefact depuis Nexus et le copier dans l'image Docker
RUN wget -O /achat-1.0.jar http://192.168.50.4:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar

# Commande d'entrée pour exécuter l'application Java
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
