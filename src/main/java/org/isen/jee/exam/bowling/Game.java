package org.isen.jee.exam.bowling;


public interface Game {

    /**
     * Cette méthode permet de renseigner le nombre de quilles tombées
     * lors d'un lancer.
     * @param pins
     */
    public void hit(int pins);

    /**
     * Cette méthode renvoie le score actuel.
     * @return
     */
    public int getScore();

}
