package org.isen.jee.exam.bowling;

import org.isen.jee.exam.bowling.harness.JettyHarness;
import org.isen.jee.exam.bowling.harness.WebRuntimeException;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BowlingServletTest extends JettyHarness {

    /**
     * En implémentant la méthode `doGet()` faire en sorte que la servlet
     * affiche le score de jeu courant pour la requête suivante :
     * <p/>
     * GET http://localhost:9090/score
     *
     * @throws Exception
     */
    @Test
    public void initialScoreIsNull() throws Exception {
        assertEquals("0", get(getServletUri()));
    }


    /**
     * En implémentant la méthode `doPost()` faire en sorte que la servlet
     * incrémente le score du joueur paramétré pour la requête suivante :
     *
     * POST http://localhost:9090/score pins: 3
     *
     * @throws Exception
     */
    @Test
    public void itCanScore() throws Exception {
        score(3);
        score(5);
        assertEquals("8", get(getServletUri()));
    }


    /**
     * En implémentant la méthode doDelete() faire en sorte que la servlet
     * remette le score à 0 pour la requête suivante :
     *
     * DELETE http://localhost:9090/score
     *
     * @throws Exception
     */
    @Test
    public void gameCanBeResetted() throws Exception {
        score(3);
        score(5);
        assertEquals("8", get(getServletUri()));
        resetScore();
        assertEquals("0", get(getServletUri()));
    }

    @Test
    public void itIsNotPossibleToPlayMoreThan10pins() throws Exception {
        try {
            score(-1);
            fail("On ne devrait pas pouvoir jouer un nombre de quilles négatif");
        } catch (WebRuntimeException e) {
            assertEquals(400, e.getCode());
        }

        try {
            score(12);
            fail("On ne devrait pas pouvoir jouer un nombre de quilles supérieur à 10");
        } catch (WebRuntimeException e) {
            assertEquals(400, e.getCode());
        }

    }



    private String score(Integer pins) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("pins", pins.toString());
        return post(getServletUri(), params);
    }

    private String resetScore() throws IOException {
        return delete(getServletUri());
    }



    private String getServletUri() {
        return getBaseUri() + "/score";
    }
}
