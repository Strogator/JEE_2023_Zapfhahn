# Zapfhahn - Microservice de Commande de Bières

## Développeur
Alessio Comi

## Introduction
Ce projet scolaire, développé dans le cadre du programme d'ingénierie de la HE-Arc à Neuchâtel, Suisse, est un microservice en Spring destiné à la commande de bières. Le projet utilise Docker pour faciliter la mise en service et le déploiement.

## Installation
Pour installer et lancer le projet Zapfhahn, suivez ces étapes :

1. Téléchargez le répertoire GitHub :
```bash
git clone https://github.com/Strogator/JEE_2023_Zapfhahn.git 
```
2. Mettez à jour l'adresse email dans le fichier `application.properties` du service de notification avec votre email privé.
3. Construisez le projet avec Maven :
```bash
mvn clean install 
```
4, Naviguer depuis la racine du projet dans le dossier docker :
```bash
cd ./docker/
```

4. Lancez les services via Docker :
```bash
docker-compose up --build
```

## Utilisation
Pour passer une commande de bière, utilisez l'interface Swagger accessible via le lien suivant : [Swagger UI pour Zapfhahn](http://localhost:8081/swagger-ui/index.html#/order-controller/getAllOrders). Cette interface vous permet de visualiser le déroulement d'une commande de bière. Une fois celle-ci effectué un email de confirmation vous sera envoyé.



