package game.players;

import java.util.Random;

public class Zombie extends Player {

    private Random random;

    public Zombie() {
        this.random = new Random();
        setHealth(7);
    }

    @Override
    public int attack() {
        return random.nextInt(3) + 2;
    }

}
