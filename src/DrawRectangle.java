import java.util.Arrays;

public class DrawRectangle {

    public static void main(String[] args) {

        assertEquals(drawRectangle("*",5,3), "*****\n*****\n*****\n");
        assertEquals(drawRectangle("*",4,2), "****\n****\n");
        assertEquals(drawRectangle("*",6,4), "******\n******\n******\n******\n");
    }


    /**
     * esta funcion recibe un caracter, un valor de anchura y un valor de altura
     * y retorna un String de una linea de tantos caracteres como el valor de anchura
     * y tantas lineas como el valor de altura
     */
    static String drawRectangle (String tile, int width, int height) {

        String rectangulo;

        if (width < 1 || height < 1) {

            rectangulo = "Con estos valores no se puede dibujar un rectangulo";
            return rectangulo;
        }

        String linea = repeat("*", width) + "\n";
        rectangulo = repeat(linea, height);

        return rectangulo;
    }

    static String repeat (String datos, int repeticiones) {

        String resultado = "";

        for (int i = 0; i < repeticiones; i++) {

            resultado += datos;
        }

        return resultado;
    }

    /**
     * funcion para hacer tests
     */
    static void assertEquals(Object actual, Object expected) {
        if ( ! actual.equals(expected) ) {
            throw new RuntimeException("the actual value " + actual
                    + " is not equal to the expected " + expected);
        }
    }
}
