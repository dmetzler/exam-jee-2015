package org.isen.jee.exam.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void doBefore() {
        game = new GameImpl();
    }

    /**
     * Dans ce test, on vérifiera que le jeu dans lequel le joueur lancer toutes
     * ses boules dans la goutière (c'est à dire qu'il ne fait tomber aucune
     * quille) rapporte un score nul.
     *
     * In that test, you'll verigy that a game in which the player rolls all of
     * its balls in the gutter is null.
     *
     * @throws Exception
     */
    @Test
    public void testJeuGoutiere() throws Exception {
        rollMany(0,20);

        assertThat(game.getScore()).isEqualTo(0);
    }

    private void rollMany(int pins , int times) {
        for(int i = 0; i< times; i++) {
            game.hit(pins);
        }
    }

    /**
     * Dans ce test, on vérifiera que le jeu dans lequel le joueur fait tomber
     * une seule quille à chaque lancer donne un score de 20.
     *
     * In that test, you'll verfiy that the game in which the player knock down
     * on pin at each roll give a score of 20
     *
     * @throws Exception
     */
    @Test
    public void testJeuSimple() throws Exception {
        rollMany(1,20);
        assertThat(game.getScore()).isEqualTo(20);
    }



    /**
     * Dans ce test, on vérifiera un jeu, où il n'y a qu'un spare et une quille
     * suivant le spare pour vérifier que le score prend bien en compte la règle
     * du spare.
     *
     * In that test, you'll verify, that in a game where there is only a spare
     * and a pin down after the spare, will allow you to verify the spare rule.
     *
     * @throws Exception
     */
    @Test
    public void testSpare() throws Exception {
        game.hit(8);
        game.hit(2);
        game.hit(3);
        rollMany(0, 17);
        assertThat(game.getScore()).isEqualTo(16);

    }

    /**
     * Dans ce test, on vérifiera un jeu où il n'y a qu'un strike avec deux
     * quilles suivant le strike pour vérifier que le score prend bien en compte
     * la règle du strike
     *
     * In that test, you'll verify a game, where there is only on strike with
     * two rolls after, that will allow you to verify the stike rule.
     *
     * @throws Exception
     */
    @Test
    public void testStrike() throws Exception {
        game.hit(10);
        game.hit(2);
        game.hit(3);
        rollMany(0,17);
        assertThat(game.getScore()).isEqualTo(20);
    }

    /**
     * Dans ce test, on vérifiera que le score du jeu donné en exemple dans
     * l'énoncé est bien de 132.
     *
     * In that test, you'll verify that the sample game given has a score
     * of 132.
     * @throws Exception
     */
    @Test
    public void testJeuExemple() throws Exception {
        game.hit(2);
        game.hit(6);
        game.hit(3);
        game.hit(5);
        game.hit(8);
        game.hit(2);
        game.hit(7);
        game.hit(3);
        game.hit(10);
        game.hit(1);
        game.hit(6);
        game.hit(2);
        game.hit(7);
        game.hit(5);
        game.hit(5);
        game.hit(10);
        game.hit(5);
        game.hit(3);
        assertThat(game.getScore()).isEqualTo(132);
    }

    /**
     * Dans ce test, on vérifiera que le score du jeu parfait (lancer de 12
     * strikes) est de 300.
     *
     * In that test you'll verify that the score of the perfect game is 300.
     * (12 strike rolls)
     *
     * @throws Exception
     */
    @Test
    public void testJeuParfait() throws Exception {
        rollMany(10,12);
        assertThat(game.getScore()).isEqualTo(300);
    }
}
