package gamewithdice;

/** The real game */
public class Main {

    public static void main(String[] args) {

        Dice dice = new RealDice();
        Game game = new Game(dice);
        game.start();
    }
}