# JEE Exam 01/02/2015


## How to package your work : 1 point

To package you work, and send it back, you'll have to :

 * Implement the missing code
 * Update the `pom.xml` file to modify the artifactId following the scheme :


		<artifactId>exam-JEE-2015-NAME-FIRSTNAME</artifactid>

 	Replace all non ASCII characters in then name and fisrtname by a `-`. For instance : `Gérard D'Orimont de Haute Cloque` will give :

	 	<artifactId>exam-JEE-2015-D-ORIMONT-DE-HAUTE-CLOQUE-GERARD</artifactid>

 * Zip the work directory without the `target` folder and rename the file following the scheme :

 		exam-JEE-2015-NAME-FIRSTNAME.zip

 * Send the zip file to `dmetzler@gmail.com` with the subject `Exam JEE 2015 : Name Firstname`



## First part : TDD (12 points)

![Let's play bowling](https://s-media-cache-ak0.pinimg.com/236x/00/f0/57/00f057f62b49076c34d9646a9c09f08a.jpg)

In this first part, you'll developp a java library that will allow to count the points of a bowling game. You'll have to implement the test and then code the library so that it fullfills the tests.

### Bowling rules

The bowling is a game in which a player has to hit some pins places a then end of a lane with the help of a bowl. A game is composed of ten "frames". In each frame, the player has two rolls to knock down 10 pins. The score of a frame is the total number of pins knock down plus bonus for spares and strikes.

The spare : when the player knocks down all 10 pins in two tries. In that case, there is a bonus which vlaue is then number of pins that are knocked down in then next roll.

The strike : when the player knocks down all 10 pins in one try. In that case, there is a bonus which vlaue is then number of pins that are knocked down in then next two rolls.

In the last frame, if a strike or a spare is shot, then the player is allowed to roll one or two additional balls to complete the frame. So there can't be more that three rolls in the last frame.

Consequently, in the case of a perfect game where the player would roll 12 strikes, then the score should be 300.

In the following schema, you'll see the count for a sample bowling game.

<img alt="Sample bowling game " src="https://raw.githubusercontent.com/dmetzler/exam-jee-2015/master/images/samplegame.png" width="800px"/>

### Tests

In the maven project, you got 3 classes :

 * `Game` : The contract that the game should follow. This interface can't be modified.
 * `GameImpl` : The implementation of the previous interface, that you'll have to code.
 * `GameTest` : The test class currently having only empty methods.

One test at a time, implement the body of the test by following the description in the javadoc of each test method.

Then, complete the GameImpl class, in order for the test to pass. After that, step to the next test.

### Clues

The implementation will have to maintain a list (or an array) of rolls. The scoring method will have to iterate thru the frames to compute the score incrementally.

## Second part  (8 points)

Whit the help of a servlet, you will expose the previous libraray in order to show the score a game, and also being able to score.

For that exercise, you get two classes:

 * `BowlingServlet` : this class should be a servelet and answer requestst at  `/score` URL.
 * `BowlingServletTest` : a ready to use test class, that will help you to validate you servlet implementation.

Follow the instructions found in the javadoc of each test. The test harness (`JettyHarness`) already launches the servlet in a micro container during the test.

### Clues

You'll use the we session mecanism (HttpRequest#getSession()) in which you'll be able to store the state of the game (setAttribute()et getAttribute()). Par exemple :

	Game game = (Game) req.getSession().getAttribute("game");




