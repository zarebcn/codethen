package labyrinth;

import java.util.List;
import java.util.Scanner;

public class Game {

    private int posicionVertical;
    private int posicionHorizontal;
    private List<String> lista;
    private int keyLocVertical;
    private int keyLocHorizontal;
    private boolean llave;

    Game (Labyrinth labyrinth, Key key) {

        //this.labyrinth = labyrinth;
        posicionVertical = labyrinth.getStartingPointVertical();
        posicionHorizontal = labyrinth.getStartingPointHorizontal();
        keyLocVertical = key.getPosicionVertical();
        keyLocHorizontal = key.getPosicionHorizontal();
        lista = labyrinth.getLabyrinth();
        llave = false;
    }

    public void start() {


        Scanner scanner = new Scanner(System.in);
        String zonaActual = lista.get(posicionVertical);
        boolean exit = false;


        System.out.println("Bienvenido al laberinto, trata de salir de el. Suerte...");

        System.out.println();
        System.out.println(lista.get(lista.size() - 3) + "\n" + (lista.get(lista.size() - 2).substring(0, 4) + "o" + lista.get(lista.size() - 2).substring(5, lista.get(lista.size() - 2).length())) + "\n" + lista.get(lista.size() - 1) + "\n");

        System.out.println("Hacia donde quieres ir (norte, sur, este, oeste) ?");

        String direccion = scanner.next();

        String zonaActualizada = actualizarMapa(direccion, zonaActual);
        System.out.println(mostrarMapa(posicionVertical, zonaActualizada));

        while (!exit) {

            System.out.println("Hacia donde quieres ir (norte, sur, este, oeste) ?");

            direccion = scanner.next();

            zonaActualizada = actualizarMapa(direccion, zonaActualizada);

            System.out.println(mostrarMapa(posicionVertical, zonaActualizada));

            if (posicionVertical == keyLocVertical && posicionHorizontal == keyLocHorizontal && !llave) {

                System.out.println("Has encontrado la llave, ahora dirigete hacia la salida");
                System.out.println();
                llave = true;

            }

            if (posicionVertical == 0 && posicionHorizontal == 1 && llave) {

                System.out.println();
                System.out.println("Bravo!! Has conseguido salir del laberinto");
                exit = true;
                scanner.close();

            } else if (posicionVertical == 0 && posicionHorizontal == 1 && !llave) {

                System.out.println("Necesitas una llave para salir");
                System.out.println();
            }

        }
    }

    public String actualizarMapa(String direccion, String zonaActual) {

        String muroActualizado = "";

        if (direccion.equals("oeste")) {

            String oeste = zonaActual.substring(posicionHorizontal - 1, posicionHorizontal);

            if (!oeste.equals("X")) {

                muroActualizado = zonaActual.substring(0, posicionHorizontal -1) + "o" + " " + zonaActual.substring(posicionHorizontal + 1, zonaActual.length());
                posicionHorizontal--;

            } else {

                System.out.println("No puedes ir al oeste");
                muroActualizado = zonaActual.substring(0, posicionHorizontal) + "o" + zonaActual.substring(posicionHorizontal + 1, zonaActual.length());
            }
        }

        if (direccion.equals("este")) {

            String este = zonaActual.substring(posicionHorizontal + 1, posicionHorizontal + 2);

            if (!este.equals("X")) {

                muroActualizado = zonaActual.substring(0, posicionHorizontal) + " " + "o" + zonaActual.substring(posicionHorizontal + 2, zonaActual.length());
                posicionHorizontal++;

            } else {

                System.out.println("No puedes ir al este");
                muroActualizado = zonaActual.substring(0, posicionHorizontal) + "o" + zonaActual.substring(posicionHorizontal + 1, zonaActual.length());
            }
        }

        if (direccion.equals("norte")) {

            zonaActual = lista.get(posicionVertical);

            if (posicionVertical == 0 && posicionHorizontal== 1 && !llave) {

                return zonaActual.substring(0, posicionHorizontal) + "o" + zonaActual.substring(posicionHorizontal + 1, zonaActual.length());
            }

            String muroArriba = lista.get(posicionVertical - 1);
            String norte = muroArriba.substring(posicionHorizontal, posicionHorizontal + 1);

            if (!norte.equals("X")) {

                muroActualizado = muroArriba.substring(0, posicionHorizontal) + "o" + muroArriba.substring(posicionHorizontal + 1, muroArriba.length());
                posicionVertical--;

            } else {

                System.out.println("No puedes ir al norte");
                muroActualizado = zonaActual.substring(0, posicionHorizontal) + "o" + zonaActual.substring(posicionHorizontal + 1, zonaActual.length());
            }
        }

        if (direccion.equals("sur")) {

            zonaActual = lista.get(posicionVertical);
            String muroAbajo = lista.get(posicionVertical + 1);
            String sur = muroAbajo.substring(posicionHorizontal, posicionHorizontal + 1);

            if (!sur.equals("X")) {

                muroActualizado = muroAbajo.substring(0, posicionHorizontal) + "o" + muroAbajo.substring(posicionHorizontal + 1, muroAbajo.length());
                posicionVertical++;

            } else {

                System.out.println("No puedes ir al sur");
                muroActualizado = zonaActual.substring(0, posicionHorizontal) + "o" + zonaActual.substring(posicionHorizontal + 1, zonaActual.length());
            }
        }

        return muroActualizado;
    }

    public String mostrarMapa(int posicionVertical, String zonaActualizada) {

        if (posicionVertical == 0) {

            //System.out.println();
            //System.out.println(muroActual + "\n" + lista.get(posicionVertical + 1) + "\n");
            return "\n" + zonaActualizada + "\n" + lista.get(posicionVertical + 1) + "\n";

        } else {

            //System.out.println();
            //System.out.println(lista.get(posicionVertical - 1) + "\n" + muroActual + "\n" + lista.get(posicionVertical + 1) + "\n");
            return "\n" + lista.get(posicionVertical - 1) + "\n" + zonaActualizada + "\n" + lista.get(posicionVertical + 1) + "\n";
        }
    }

}
