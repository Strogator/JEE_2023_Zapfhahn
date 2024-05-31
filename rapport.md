# Zapfhahn

## Introduction
Zapfhahn est un microservice conçu pour émuler une commande de bières. Le terme "Zapfhahn" vient de l'allemand et signifie "bec verseur", une référence au bec verseur d'une tireuse à bière, symbolisant la facilité et l'efficacité du service proposé.

## Architecture implémentée
Dans le cadre de ce projet, l'architecture microservices a été imposée. Il a été choisi d'opter pour une structuration modulaire du système. Chaque microservice, tel que les services de commande et de notification, est déployé individuellement grâce à Docker. Spring Boot est utilisé pour le développement de ces microservices, facilitant leur configuration et déploiement. Spring Cloud Gateway fonctionne comme un point d'entrée unique, routant les demandes aux services appropriés en se synchronisant avec Eureka pour la découverte de service, optimisant ainsi la gestion des flux de données et la sécurité du système.

## Problèmes, résolutions, choix
- **Dépendance Maven :** Résolue en consultant la documentation maven et spring.
- **Désérialisation :** Problèmes de désérialisation de l'objet "order" dans le service de notifications, résolus en utilisant une instance de `TextMessage` de Jakarta.
- **Base de données en root :** L'accès à la base de données se fait avec les accès root, car les connexions utilisateur étaient interdites, ce qui constitue une mauvaise pratique dans un contexte réel. Ce problème n'a pas été résolu et représente un point d'amélioration.
- **Swagger :** Le service de notification ne fonctionne pas correctement avec Swagger. Cette erreur, non comprise, reste non résolue.

### Problème induit
A cause des ces divers défis à solutionner la mise en place d'une gestion d'erreur robuste à été mise de coté.

## Flux Asynchrone
Dans l'application Zapfhahn, le flux asynchrone est principalement géré par les messages JMS (Java Message Service), qui permettent une communication entre les microservices sans attendre la réponse de l'autre partie. Cela se manifeste notamment dans la gestion des notifications. Lorsqu'une commande est passée, un message est envoyé de manière asynchrone à un service de notification qui traite la commande indépendamment de l'activité du service de commande principal, améliorant ainsi la réactivité et l'efficacité du système.

## Flux Synchrone
Le flux synchrone dans Zapfhahn est utilisé pour les opérations qui nécessitent une réponse immédiate et sont critiques pour la continuité des transactions. Par exemple, lorsqu'un utilisateur passe une commande, la demande est traitée de manière synchrone à travers les différents services impliqués. L'utilisation d'Eureka pour le service discovery assure que chaque appel entre services localise l'instance appropriée en temps réel, facilitant une interaction rapide et fiable entre les services.

## API Gateway Pattern
Le pattern API Gateway est implémenté dans le projet Zapfhahn pour optimiser les interactions entre les services de commande et de notification. Utilisant Spring Boot et le module Spring Cloud Gateway, il agit comme un intermédiaire unique pour les requêtes entrantes, les routant vers les services internes appropriés. La configuration spécifie les routes et intègre le service de découverte Eureka pour une orchestration efficace des services.

## Envoi de Courriels
L'envoi de courriels dans Zapfhahn est géré par le service de notifications, qui utilise Spring Mail pour envoyer des messages électroniques suite à la confirmation de commandes. Lorsque celle-ci est validée, le système génère un message de confirmation qui est envoyé via le service de messagerie électronique configuré dans `application.properties`. Ce processus utilise des techniques asynchrones pour ne pas retarder les autres opérations du système.

# Guide de Démarrage et d'Utilisation - Zapfhahn

## Prérequis
- Git
- Docker
- Maven
- Adresse email pour les notifications

## Installation et Mise en Service
1. Clonez le répertoire GitHub :
   ```bash
   git clone https://github.com/Strogator/JEE_2023_Zapfhahn.git
   ```
2. Configurez votre email dans `application.properties` du module 'notification-service' pour les notifications.
3. Installez les dépendances :
   ```bash
   mvn clean install
   ```
4. Accédez au dossier Docker et construisez les services :
   ```bash
   cd ./docker/
   docker-compose up --build
   ```

## Utilisation
Accédez à Swagger UI pour passer des commandes de bière :
- **URL :** [Swagger UI pour Zapfhahn](http://localhost:8081/swagger-ui/index.html#/order-controller/getAllOrders)
- **Note :** Après la commande, un email de confirmation sera envoyé.

## Bilan

Le projet Zapfhahn démontre la mise en œuvre d'une architecture microservices pour un système de commande de bières, utilisant les technologies requises telles que Spring Boot, Docker, et Spring Cloud Gateway. Malgré les difficultés rencontrées, le projet permet d'illustrer la compréhension des concepts vus en cours. De plus, ces problèmes ouvrent des pistes pour des améliorations futures, notamment en matière de sécurité et de gestion des erreurs.

## Source 
Le rapport a été corrigé et reformulé par ChatGPT.
