public class DrawRectangle {

    public static void main(String[] args) {


        drawRectangle('*', 5, 3);

    }

    static void drawRectangle (char tile, int width, int height) {

        if ((width == 1 && height == 1) || width == height) {

            System.out.println("Con estos valores no se puede dibujar un rectangulo");
            return;
        }

        String rectangulo = "";

        for (int i = 0; i < width; i++) {

            rectangulo += tile;
        }

        for (int i = 0; i < height; i++) {

            System.out.println(rectangulo);
        }
    }
}
