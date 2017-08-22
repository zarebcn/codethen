package labyrinth;

public class Key {

    private int posicionHorizontal;
    private int posicionVertical;

    Key(int posicionVertical, int posicionHorizontal) {

        this.posicionVertical = posicionVertical;
        this.posicionHorizontal = posicionHorizontal;
    }

    public int getPosicionVertical() {
        return posicionVertical;
    }

    public int getPosicionHorizontal() {
        return posicionHorizontal;
    }
}
