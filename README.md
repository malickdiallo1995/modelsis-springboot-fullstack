# Modelsis-springboot-fullstack
## 1- Introduction : 
Ce projet a ete crée pour repondre aux besoins du test technique de Modelsis Sénégal.
Il s'agit ici d'une application Springboot de gestion de Produit qui permet de faire les operations suivantes : 
* Creer un type de Produit
* Creer un Produit en lui associant un Type de produit
* Modifier un Produit
* Lister les produits 
## 2- Stack utilisée : 
* Springboot : 2.7.0
* Java : 1.8
* Spring data JPA
* Spring Web
* H2 Database
* Postgresql
* Lombok
* spring-boot-starter-test
* jasypt-spring-boot : 3.0.4
* Github pour versionnement fichier   
## 3- Excecuter le projet : 
* Installer les dependances en se placant sur la racine du projet </br>
  `mvn install`
* Builder le projet  </br>
  `mvn clean package`
* tester en local :
  - se placer dans le dossier target et excuter
    `java -jar app-products-0.0.1-SNAPSHOT.jar` </br>
## 4- Lien de test Heroku 
      https://app-product-backend.herokuapp.com/api/v1 </br>
* Liste des Endpoints : 
  - /productType (GET) : recuperer tous les types de produit </br>
  - /productType (POST) : ajouter un produit </br>
     Input : `{"name":""}`
  - /productType/:id (GET) : recuperer un type Produit via son ID
  - /products (GET) : Recuperer l'ensemble des Produits
  - /products/:idType (POST) : ajouter un Produit et lui affectant un Type
      Input : `{"name":""}`
  - /products/:idType (PUT) : Modifier un Produit 
      Input : `{"name":""}`
  - /products/:idType (GET) : Recuperer un produit via son ID 
 
