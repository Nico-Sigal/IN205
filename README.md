# Projet Bataille Navale - IN205

*Commentaires sur le projet numéro 1 d'in205*

### Exercice 1 : Affichage du "board"
Création de la classe Board, début du projet.

Pas de gros problème rencontré lors de cette partie, j'ai essayé de simplifier au maximum mon code avec des noms de fonctions adaptés pour obtenir un affichage assez personnel, la partie esthétique m'ayant amusé en ce début de projet, et me permettant de me familiariser ainsi avec les chaînes et les boucles for.

### Exercice 2 : Création des classes des navires

Cette partie demande surtout de la concentration pour créer la première classe héritant de AbstractShip, la suite est simplement du copier-coller à adapter, je n'y ai pas rencontré de grosses difficultés. J'ai créé un dossier "Boats" pour stocker les fichiers, et ai alors pensé qu'organiser (une fois le travail terminé) le repository en un ensemble de fichiers serait plus pratique.

### Exercice 3 : Placement des navires

J'ai rencontré plus de difficultés dans cette partie. Le fait de commencer avec une ligne initialisée à 1 sur le Board m'a fait considérer que les tableaux commencaient à 1 également en termes d'indices (ce qui m'a valu quelques heures de déboggage pour adapter les codes fournis...). Une fois fait correctement, cet exercice m'a surtout apporté de la rigueur dans les tests, afin d'être efficace lors de l'utilisation de TestBoard, ce qui m'a servi par la suite.

### Exercice 4 : Entrées utilisateur

Pas de problème particulier rencontré, même si les tests ne permettent pas vraiment de voir s'il y a une erreur.
InputHelper permet de ne pas avoir à apprendre de trop longues syntaxes en Java, ce qui s'avère très utile.

### Exercice 5 : Etat des navires et des frappes

Le "Refactoring" est une étape qui a été nécessaire pour pouvoir jouer, mais qui a entraîné de grosses frustrations. Néanmoins, le principe de la bataille navale y force, et l'on comprend l'intérêt de certaines classes telles que ShipState.

### Exercice 6 : Envoyer des frappes

L'utilisation des Hits grâce à un enum est très pertinente, mais les définir puis les localiser m'a demandé bien plus de temps que ce que je n'aurais pensé.
Une fois l'implémentation faite, on peut passer aux choses sérieuses !

### Exercice 7 : Intelligence artificielle

C'est ici que j'ai passé le plus de temps : la compréhension seulement partielle de la boucle do ... while de putShips() m'a induit en erreur un très long moment, et ce n'est qu'à ce moment-là que je me suis rendu compte, avec l'affichage, des difficultés que pose l'indexation à partir de 1. De nombreuses erreurs que j'avais commises ont ensuite été reprises, me permettant de finaliser cette partie.

Créer TestGame ne m'a cependant pas posé de réel problème.

### Exercice 8 : Place au jeu !

Une fois les classes créées et l'énoncé compris, j'ai assez vite réalisé la partie 8. Pouvoir enfin essayer le code avec un joueur était réellement satisfaisant. Cependant, à la suite de cette implémentation, je me suis rendu compte que BattleShipsAI ne fonctionnait plus correctement, et restait bloquée... Je vais essayer de poursuivre mon déboggage, et re déposerai alors le fichier.
