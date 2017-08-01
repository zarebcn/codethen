package game.players;

public class Rat extends Player {

    public Rat() {
        setHealth(5);
    }

    @Override
    public int attack() {
        return 1;
    }

}
