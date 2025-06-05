# 📧 Application Java de Gestion des Courriers Électroniques

## 📝 Description

Ce projet est une mini-application Java permettant de gérer des courriers électroniques via une base de données MySQL.  
Chaque **message** est défini par :
- L'adresse de l'expéditeur
- Le sujet
- La date d'envoi
- Le contenu
- L'état de lecture (0 pour non lu par défaut)

La base de données utilisée est nommée **gestion_courriers** et contient une table **message**.

---

## 🛠️ Fonctionnalités principales

L'application permet les opérations suivantes :

| Méthode                | Description                                        |
|------------------------|----------------------------------------------------|
| `Envoyer_MSG()`        | Envoyer un message                                 |
| `Modifier_MSG()`       | Modifier un message existant                       |
| `Supprimer_MSG()`      | Supprimer un message                               |
| `Lister()`             | Lister tous les messages                           |
| `Msg_lus()`            | Lister uniquement les messages lus                 |
| `Modifier_Etat()`      | Modifier l’état de lecture d’un message            |
| `Lister_Mois()`        | Lister les messages envoyés dans un mois donné     |
| `Annee_Envoi()`        | Fournir l’année d’envoi d’un message               |
| `Supprimer_Msg_Lus()`  | Supprimer tous les messages lus                    |

---

## 🧱 Structure du projet

Le projet est composé de trois classes Java principales :

1. **ConnexionBD.java**  
   Contient la méthode pour établir une connexion JDBC avec la base de données MySQL.

2. **Message.java**  
   Classe représentant un message avec ses propriétés (expéditeur, sujet, date, contenu, état).

3. **GestionMessage.java**  
   Contient toutes les méthodes de gestion (CRUD et requêtes spécifiques).

---

## 🗃️ Base de données

### Nom : `gestion_courriers`

### Table : `message`

| Champ        | Type        | Description                      |
|--------------|-------------|----------------------------------|
| id           | INT         | Identifiant unique (clé primaire) |
| expediteur   | VARCHAR     | Adresse e-mail de l'expéditeur   |
| sujet        | VARCHAR     | Sujet du message                 |
| date_envoi   | DATE        | Date d’envoi                     |
| contenu      | TEXT        | Contenu du message               |
| etat         | INT(1)      | 0 = Non lu, 1 = Lu               |

---

## 💻 Prérequis

- JDK 8 ou version supérieure
- MySQL Server
- JDBC Driver pour MySQL (mysql-connector-java)
- IDE (Eclipse, IntelliJ, NetBeans, etc.)

---

## 🚀 Instructions d'exécution

1. **Cloner le dépôt ou télécharger les fichiers source.**

2. **Créer la base de données et la table :**
   ```sql
   CREATE DATABASE gestion_courriers;

   USE gestion_courriers;

   CREATE TABLE message (
       id INT PRIMARY KEY AUTO_INCREMENT,
       expediteur VARCHAR(255),
       sujet VARCHAR(255),
       date_envoi DATE,
       contenu TEXT,
       etat INT DEFAULT 0
   );
