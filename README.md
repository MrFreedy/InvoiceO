<div align="center">
  <a href="https://github.com/MrFreedy/InvoiceO">
    <img src="https://user-images.githubusercontent.com/74242616/198913703-3a76b17c-c5f1-4fe5-b08d-67105f01c0d3.png" alt="Logo" width="761" height="82">
  </a>

<h3 align="center">Un logiciel de gestion de factures pour les entreprises</h3>
</div>

# Présentation du projet :

<p>En juillet 2024, les grandes entreprises auront l’obligation de délaisser les factures papiers pour les factures électroniques. Cette obligation s’étendra aux ETI en 2025 et aux PME et TPE en 2026. C’est pour cela que InvoiceO proposent alors un système de gestion de factures intuitif pour toutes les entreprises ! Le but est d’accompagner les entreprises dans les différentes étapes de la facturation, de la création à la validation des factures.</p>

<h3>Les fonctionnalités proposées par InvoiceO sont les suivantes :</h3>
<ul><li>Création d’une facture avec les différentes informations nécessaires</li></ul>
<ul><li>Edition de facture si le statut de la facture le permet</li></ul>
<ul><li>Suppression de facture si le statut de la facture le permet</li></ul>
<ul><li>Stockage des factures dans une database propre à l’entreprise</li></ul>
<ul><li>Système d’affichage (courbe de tendance, camenbert, …) d’informations élémentaires pour une entreprise sur différentes périodes</li></ul>
<ul><li>Possibilité de générer une facture PDF à partir des informations fournies lors de la création</li></ul>
<br>

# Les langages utilisés :
* Le langage principal du logiciel est le :<br>
  ![Java]<br>
* Le langage utilisé pour le stockage des données de log en local sur l'ordinateur est le:<br>
  ![OCaml]<br>
* Le langage utilisé pour le stockage des factures est :<br>
  ![MySQL]<br>
* Le serveur utilisé est déployé sur le site de :<br>
  ![DigitalOcean]

# 1 - Démarrage
Vous pourrez consulter mon code librement dans un IDE.

Si votre IDE n'arrive pas à lancer les fichiers .java, j'ai build 2 fichiers .jar vous permettant de lancer le logiciel sans problème.

Les fichiers .jar se trouve dans InvoiceO/out/artifacts/InvoiceO_jar

# 2 - Prérequis

Il est important d'avoir d'installer sur son ordinateur Java SDK 17+ et OCaml 4+.<br>
<strong>Si ces prérequis ne sont pas respectés le logiciel peut ne pas fonctionner comme sur la vidéo !</strong>

# 3 - Explications


## 3.a) Partie Java:
Tout le code Java se trouve dans <strong>InvoiceO/src/</strong> comme voulu.
Cependant, il y a quelques différences :
<ul><li> Le package <strong>dao</strong> contient le code permettant d'exécuter le code OCaml</li></ul>
<ul><li> Le dossier <strong>data</strong> contient les données nécessaires à la connection aux database</li></ul>
<ul><li> Dans le package <strong>domain</strong> vous trouverez 2 fichiers java permettant d'intéragir avec la Database</li></ul>
<ul><li> Il y a un dossier <strong>image</strong> contenant toutes les images nécessaires pour l'interface graphiques</li></ul>
<ul><li> Le package <strong>main</strong> contient Main.java permettant qui est le code permettant de démarrer le logiciel</li></ul>
<ul><li> Vous trouverez dans le package <strong>menu</strong> toutes les interfaces ainsi que les codes Java associés</li></ul>

De plus, il y a des dependencies présentes dans <strong>InvoiceO/dependencies</strong> vitales pour le fonctionnement du logiciel.<br><br>


## 3.b) Partie OCaml:
Tout le code OCaml se trouve dans <strong>Invoice/ocaml/</strong> comme voulu.
<ul><li> Le dossier <strong>data</strong> contient le fichier .csv générer grâce au code OCaml</li></ul>
<ul><li> Le dossier <strong>src</strong> contient les différents fichier .ml permettant nécessaires pour générer un fichier .csv. Alors vous allez vous demandez "Pouquoi existe-il un fichier delete.ml ?", pour savoir pourquoi je vous invite à regarde la vidéo à XX:YY, l'explication orale sera plus simple qu'écrite.</li></ul>

# 4 - Roadmap

- [x] Créer une facture
- [x] Editer une facture en fonction de son statut
- [x] Supprimer une facture en fonction de son statut
- [x] Stocker les factures dans une database propre à l’entreprise
- [ ] Affichage d'informations diverses (sera réalisé pour la fin de la license)
- [ ] Génération d'un PDF à partir d'une facture (sera réalisé pour la fin de la license)

[MySQL]: https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white
[OCaml]: https://img.shields.io/badge/-OCaml-black?logo=ocaml&style=for-the-badge
[Java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white
[DigitalOcean]: https://img.shields.io/badge/Digital_Ocean-0080FF?style=for-the-badge&logo=DigitalOcean&logoColor=white