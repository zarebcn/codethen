package game.players;

import java.util.Random;

public class Giant extends Player {

    private Random random;
    private boolean hasAttacked;

    public Giant() {
        random = new Random();
        hasAttacked = false;
    }

    @Override
    public void receiveHit(double hit) {
        super.receiveHit(hit / 2);
    }

    @Override
    public int attack() {

        int probabilidad = random.nextInt(2);
        int hit = random.nextInt(3) + 4;
        hasAttacked = false;

        if (probabilidad == 0) {
            return 0;
        } else if (probabilidad == 1) {
            hasAttacked = true;
            return hit;
        } else {
            hasAttacked = true;
            return hit;
        }
    }

   @Override
    public boolean giantHasAttacked() {
        return hasAttacked;
    }
}
