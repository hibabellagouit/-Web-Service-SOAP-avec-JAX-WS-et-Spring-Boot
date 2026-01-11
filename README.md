# TP13 - Service Web SOAP avec JAX-WS et Spring Boot

Ce projet est une démonstration de la création d'un service web SOAP avec JAX-WS et Spring Boot, utilisant Apache CXF comme implémentation.

## 📋 Description

Ce projet implémente un service web SOAP simple pour la gestion de comptes bancaires avec les opérations suivantes :
- Récupérer la liste de tous les comptes
- Récupérer un compte par son ID
- Créer un nouveau compte
- Supprimer un compte

## 🚀 Technologies utilisées

- **Java 17**
- **Spring Boot 3.3.4**
- **Apache CXF 4.1.4** (pour les services web SOAP)
- **Spring Data JPA** (pour la persistance des données)
- **H2 Database** (base de données en mémoire)
- **Lombok** (pour réduire le code boilerplate)

## 🛠 Configuration

Le projet utilise la configuration par défaut de Spring Boot avec les propriétés suivantes :
- Port du serveur : 8080
- Base de données H2 en mémoire
- Console H2 accessible à l'URL : http://localhost:8080/h2-console
  - JDBC URL: jdbc:h2:mem:testdb
  - Username: sa
  - Password: (vide)

## 📡 Points d'accès SOAP

Le service web est exposé à l'URL : `http://localhost:8080/ws`

### WSDL

Le WSDL du service est disponible à l'URL : `http://localhost:8080/ws/BanqueWS?wsdl`

## 📝 Opérations disponibles

1. **getComptes**
   - Description : Récupère la liste de tous les comptes
   - Paramètres : Aucun
   - Retour : Liste des comptes

2. **getCompte**
   - Description : Récupère un compte par son ID
   - Paramètres :
     - id (Long) : L'identifiant du compte
   - Retour : Le compte correspondant ou null si non trouvé

3. **createCompte**
   - Description : Crée un nouveau compte
   - Paramètres :
     - solde (double) : Le solde initial du compte
     - type (TypeCompte) : Le type de compte (COURANT ou EPARGNE)
   - Retour : Le compte créé avec son ID généré

4. **deleteCompte**
   - Description : Supprime un compte par son ID
   - Paramètres :
     - id (Long) : L'identifiant du compte à supprimer
   - Retour : true si le compte a été supprimé, false sinon

## 🏃‍♂️ Exécution

1. Cloner le dépôt
2. Exécuter la commande : `mvn spring-boot:run`
3. Le serveur démarrera sur http://localhost:8080

## 📚 Documentation supplémentaire

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Apache CXF Documentation](https://cxf.apache.org/)
- [JAX-WS Documentation](https://docs.oracle.com/javaee/6/tutorial/doc/bnayl.html)

**Réalisé par : Ayyoub**  
**Date : 25 novembre 2025**

## Captures d’écran du TP (tout fonctionne parfaitement)

| N° | Description                        | Capture                     |
|----|------------------------------------|-----------------------------|
| 1  | XML file                           | ![1](captures/1.png)        |
| 2  | Console H2 connectée               | ![2](captures/2.png)        |
| 3  | SoapUI – Projet chargé proprement  | ![3](captures/3.png)        |