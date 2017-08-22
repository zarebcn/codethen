package labyrinth;

import java.util.List;

public class Labyrinth {

    private List<String> labyrinth;
    private int startingPoint;

    Labyrinth (List<String> labyrinth, int startingPoint) {

        this.labyrinth = labyrinth;
        this.startingPoint = startingPoint;
    }

    public List<String> getLabyrinth() {
        return labyrinth;
    }

    public int getStartingPoint() {

        //String muroInicio = labyrinth.get(labyrinth.size() - 2);
        //startingPoint = muroInicio.indexOf("o");

        return startingPoint;
    }

}
