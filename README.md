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
3. Le serveur démarrera sur http://localhost:8082



## Captures d’écran du TP (tout fonctionne parfaitement)

<img width="1366" height="705" alt="SoapUI 5 9 1  11_01_2026 16_00_50" src="https://github.com/user-attachments/assets/f6911aa7-2558-41a2-b8a4-130de3dedb33" />
<img width="1366" height="705" alt="SoapUI 5 9 1  11_01_2026 16_01_41" src="https://github.com/user-attachments/assets/3d010940-24f5-4253-962b-73492e321189" />
<img width="1366" height="705" alt="SoapUI 5 9 1  11_01_2026 16_02_23" src="https://github.com/user-attachments/assets/8934ad45-4fb8-451b-af94-0a00c5978298" />
<img width="1366" height="705" alt="SoapUI 5 9 1  11_01_2026 16_02_39" src="https://github.com/user-attachments/assets/500de6a6-d1b4-42c5-8515-b3a0a9378287" />
