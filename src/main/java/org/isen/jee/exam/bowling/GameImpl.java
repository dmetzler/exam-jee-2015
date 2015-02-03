package org.isen.jee.exam.bowling;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {

    private List<Integer> hits = new ArrayList<>();

    @Override
    public void hit(int pins) {
        hits.add(new Integer(pins));

    }

    @Override
    public int getScore() {
        int score = 0;

        //Variable pour maintenir l'index de la frame. Effectivement
        //dans le cas d'un strike, il n'y a qu'un lancer dans la frame.
        int hitsIndex = 0;
        for(int frame = 0; frame < 10; frame++) {
            if(hits.size() > hitsIndex) {
                if (isStrike(hitsIndex)) {
                    score += 10 + strikeBonus(hitsIndex);
                    hitsIndex += 1;
                } else if (isSpare(hitsIndex)) {
                    score += 10 + spareBonus(hitsIndex);
                    hitsIndex += 2;
                } else {
                    score += sumOfFrameBall(hitsIndex);
                    hitsIndex += 2;
                }
            }

        }
        return score;
    }

    private Integer spareBonus(int hitsIndex) {
        return hits.get(hitsIndex + 2);
    }

    private boolean isSpare(int hitsIndex) {
        return sumOfFrameBall(hitsIndex) == 10;
    }

    private int strikeBonus(int hitsIndex) {
        return hits.get(hitsIndex + 1) + spareBonus(hitsIndex);
    }

    private boolean isStrike(int hitsIndex) {
        return hits.get(hitsIndex) == 10;
    }

    private int sumOfFrameBall(int hitsIndex) {
        return hits.get(hitsIndex) + hits.get(hitsIndex+1);
    }

}
