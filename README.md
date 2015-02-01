# Examen JEE 01/02/2015


## Modalités de rendu : 1 point

Pour rendre votre travail, vous devrez :

 * Implémenter les différentes méthodes demandées
 * Modifier dans le fichier `pom.xml` le nom de l'artifactId sous la forme suivante :

 		<artifactId>exam-JEE-2015-NOM-PRENOM</artifactid>

 	Remplacer les espaces et tout caractère non alphanumérique dans le nom et prénom par un `-`. Par exemple : `Gérard D'Orimont de Haute Cloque` donnera :

	 	<artifactId>exam-JEE-2015-D-ORIMONT-DE-HAUTE-CLOQUE-GERARD</artifactid>

 * Zipper le répertoire de travail sans le répertoire `target` et renommer le fichier :

 		exam-JEE-2015-NOM-PRENOM.zip

 * Envoyer le fichier zip à `dmetzler@gmail.com` avec comme sujet `Exam JEE 2015 : Nom Prénom`



## Première partie : TDD sur 12 points

![Let's play bowling](https://s-media-cache-ak0.pinimg.com/236x/00/f0/57/00f057f62b49076c34d9646a9c09f08a.jpg)

Dans cette première partie, on développera une librairie permettant de compter les points d'une partie de bowling. Vous devrez implémenter les tests proposés pour ensuite implémenter la librairie elle même.


### Règles du bowling

Le bowling est un jeu dans lequel le joueur doit faire tomber des quilles disposées au bout d'une piste à l'aide d'un boule. Une partie se déroule en dix "frames". A chaque frame, on dispose de deux lancers pour faire tomber un maximum de dix quilles. Le score d'une frame est calculé en additionnant le nombre de quilles tombées. Il existe deux cas dans lesquels on attribue des bonus.

Le spare : c'est le cas où le joueur abat toutes les quilles avec ses deux lancers. Dans ce cas, on ajoute aux 10 points obtenus le nombre de quilles qui tombent au coup suivant.

Le strike : c'est le cas où le joueur abat toutes les quilles en un seul lancer. Dans ce cas, on ajoute aux 10 points obtenus le nombre de quilles qui tombent aux deux coups suivants.

Dans le cas de la dernière frame, si le joueur fait un strike ou un spare, il dispose alors de boules supplémentaires (1 dans le cas d'un spare, 2 dans le cas d'un strike) pour finir la frame. Il ne peut donc pas y avoir plus de 3 lancers de boule dans la dernière frame.

En conséquence, dans le cas d'un jeu parfait où le joueur lancerait 12 strikes, le score du jeu serait 300.

Ci-dessous est représenté une partie exemple avec les comptes intermédiaires de point :

<img alt="Sample bowling game " src="https://raw.githubusercontent.com/dmetzler/exam-jee-2015/master/images/samplegame.png" width="800px"/>

### Tests

Vous disposez dans le projet Maven de trois classes:

 * `Game` : le contrat que doit suivre la partie, cette interface ne doit pas être modifiée.
 * `GameImpl` : l'implémentation de l'interface précédente que vous allez coder.
 * `GameTest` : la classe contenant des méthodes de test vides.

En prenant un test à la fois, implémenter le corps de celui-ci en fonction de la description contenue dans la javadoc des différentes fonctions de test.

Compléter ensuite GameImpl pour que le test passe, puis passer au test suivant.

### Indices

L'implémentation devra maintenir une liste (ou un tableau) des lancers. La méthode de calcul du score devra parcourir les frames pour calculer le score itérativement.


## Deuxième partie : Servlet sur 8 points

A l'aide d'une servlet, on exposera la librairie précédente pour pouvoir afficher le score d'un jeu ainsi qu'enregistrer les points des joueurs.

Pour cet exercice, vous disposez de deux classes :

 * `BowlingServlet` : la classe qui doit être une servlet et répondre à l'URL /score
 * `BowlingServletTest` : une classe de test déjà remplie qui doit vous aider à valider votre servlet.

Suivre les instructions présentes dans la Javadoc de chaque test. Le harnais de test test (`JettyHarness`) lance déjà la servlet dans un micro container pendant le test.

### Indices

On utilisera le mécanisme de la session web (HttpRequest#getSession()) dans lequel on pourra stocker l'état courant du jeu (setAttribute()et getAttribute()). Par exemple :

	Game game = (Game) req.getSession().getAttribute("game");




