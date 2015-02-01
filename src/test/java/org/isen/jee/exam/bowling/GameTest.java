package org.isen.jee.exam.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

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
    }
}
