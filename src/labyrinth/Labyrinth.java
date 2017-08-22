package labyrinth;

import java.util.List;

public class Labyrinth {

    private List<String> labyrinth;
    private int startingPointHorizontal;
    private int startingPointVertical;

    Labyrinth (List<String> labyrinth, int startingPointVertical, int startingPointHorizontal) {

        this.labyrinth = labyrinth;
        this.startingPointHorizontal = startingPointHorizontal;
        this.startingPointVertical = startingPointVertical;
    }

    public List<String> getLabyrinth() {
        return labyrinth;
    }

    public int getStartingPointVertical() {
        return startingPointVertical;
    }

    public int getStartingPointHorizontal() {
        return startingPointHorizontal;
    }
}
