package gamewithdice;

public class Skeleton extends Player {

    @Override
    public int attack(Dice dice) {
        return dice.nextInt(3) + 2;
    }

    @Override
    public void receiveHit(int hit, Dice dice) {
        if (hit > 2) {
            super.receiveHit(hit, dice);
        }
    }
}
