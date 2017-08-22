package labyrinth;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> labyrinth = new ArrayList<>();
        String muro1 = "X XXXXX";
        String muro2 = "X XX XX";
        String muro3 = "X    XX";
        String muro4 = "XX XX X";
        String muro5 = "XX    X";
        String muro6 = "XXXXXXX";

        labyrinth.add(muro1);
        labyrinth.add(muro2);
        labyrinth.add(muro3);
        labyrinth.add(muro4);
        labyrinth.add(muro5);
        labyrinth.add(muro6);

        Labyrinth laberinto = new Labyrinth(labyrinth, 4);
        Game game = new Game(laberinto);

        game.start();

    }
}
