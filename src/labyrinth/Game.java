package labyrinth;

import java.util.List;
import java.util.Scanner;

public class Game {

   //private Labyrinth labyrinth;
    private int posicionVertical;
    private int posicionHorizontal;
    private List<String> lista;

    Game (Labyrinth labyrinth) {

        //this.labyrinth = labyrinth;
        posicionVertical = labyrinth.getLabyrinth().size() - 2;
        posicionHorizontal = labyrinth.getStartingPoint();
        lista = labyrinth.getLabyrinth();
    }

    public void start() {


        Scanner scanner = new Scanner(System.in);
        String muroActual = lista.get(posicionVertical);
        boolean exit = false;

        System.out.println("Bienvenido al laberinto, trata de salir de el. Suerte...");

        System.out.println();
        System.out.println(lista.get(lista.size() - 3) + "\n" + (lista.get(lista.size() - 2).substring(0, 4) + "o" + lista.get(lista.size() - 2).substring(5, lista.get(lista.size() - 2).length())) + "\n" + lista.get(lista.size() - 1) + "\n");

        System.out.println("Hacia donde quieres ir (norte, sur, este, oeste) ?");

        String direccion = scanner.next();

        String muroActualizado = actualizarMapa(direccion, muroActual);
        mostrarMapa(posicionVertical, muroActualizado);

        while (!exit) {

            System.out.println();
            System.out.println("Hacia donde quieres ir (norte, sur, este, oeste) ?");

            direccion = scanner.next();

            muroActualizado = actualizarMapa(direccion, muroActualizado);

            mostrarMapa(posicionVertical, muroActualizado);

            if (posicionVertical == 0 && posicionHorizontal == 1) {

                System.out.println();
                System.out.println("Bravo!! Has conseguido salir del laberinto");
                exit = true;
                scanner.close();
            }

        }
    }

    public String actualizarMapa(String direccion, String muroActual) {

        String muroActualizado = "";

        if (direccion.equals("oeste")) {

            String oeste = muroActual.substring(posicionHorizontal - 1, posicionHorizontal);

            if (!oeste.equals("X")) {

                muroActualizado = muroActual.substring(0, posicionHorizontal -1) + "o" + " " + muroActual.substring(posicionHorizontal + 1, muroActual.length());
                posicionHorizontal--;
            } else {

                System.out.println("No puedes ir al oeste");
                muroActualizado = muroActual.substring(0, posicionHorizontal) + "o" + muroActual.substring(posicionHorizontal + 1, muroActual.length());
            }
        }

        if (direccion.equals("este")) {

            String este = muroActual.substring(posicionHorizontal + 1, posicionHorizontal + 2);

            if (!este.equals("X")) {

                muroActualizado = muroActual.substring(0, posicionHorizontal) + " " + "o" + muroActual.substring(posicionHorizontal + 2, muroActual.length());
                posicionHorizontal++;
            } else {

                System.out.println("No puedes ir al este");
                muroActualizado = muroActual.substring(0, posicionHorizontal) + "o" + muroActual.substring(posicionHorizontal + 1, muroActual.length());
            }
        }

        if (direccion.equals("norte")) {

            muroActual = lista.get(posicionVertical);
            String muroArriba = lista.get(posicionVertical - 1);
            String norte = muroArriba.substring(posicionHorizontal, posicionHorizontal + 1);

            if (!norte.equals("X")) {

                muroActualizado = muroArriba.substring(0, posicionHorizontal) + "o" + muroArriba.substring(posicionHorizontal + 1, muroArriba.length());
                posicionVertical--;
            } else {

                System.out.println("No puedes ir al norte");
                muroActualizado = muroActual.substring(0, posicionHorizontal) + "o" + muroActual.substring(posicionHorizontal + 1, muroActual.length());
            }
        }

        if (direccion.equals("sur")) {

            muroActual = lista.get(posicionVertical);
            String muroAbajo = lista.get(posicionVertical + 1);
            String sur = muroAbajo.substring(posicionHorizontal, posicionHorizontal + 1);

            if (!sur.equals("X")) {

                muroActualizado = muroAbajo.substring(0, posicionHorizontal) + "o" + muroAbajo.substring(posicionHorizontal + 1, muroAbajo.length());
                posicionVertical++;
            } else {

                System.out.println("No puedes ir al sur");
                muroActualizado = muroActual.substring(0, posicionHorizontal) + "o" + muroActual.substring(posicionHorizontal + 1, muroActual.length());
            }
        }

        return muroActualizado;
    }

    public void mostrarMapa(int posicionVertical, String muroActual) {

        if (posicionVertical == 0) {

            System.out.println();
            System.out.println(muroActual + "\n" + lista.get(posicionVertical + 1) + "\n");

        } else {

            System.out.println();
            System.out.println(lista.get(posicionVertical - 1) + "\n" + muroActual + "\n" + lista.get(posicionVertical + 1) + "\n");
        }
    }
}
