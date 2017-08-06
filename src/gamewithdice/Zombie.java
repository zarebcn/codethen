package gamewithdice;

public class Zombie extends Player {

    @Override
    public int attack(Dice dice) {
        return dice.nextInt(3) + 2;
    }
}
