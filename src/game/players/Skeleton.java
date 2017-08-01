package game.players;

import java.util.Random;

public class Skeleton extends Player {

    private Random random;

    public Skeleton() {
        this.random = new Random();
        setHealth(8);
    }

    @Override
    public int attack() {
        return random.nextInt(3) + 2;
    }

    @Override
    public void receiveHit(double hit) {
        if (hit > 2) {
            super.receiveHit(hit);
        }
    }

}
