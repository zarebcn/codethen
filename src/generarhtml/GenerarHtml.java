package generarhtml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerarHtml {

    public static void main(String[] args) throws IOException {


        //PrintWriter escritor = new PrintWriter("src/generarhtml/generarhtml.html");
        //Scanner scanner = new Scanner(System.in);

        List<String> lista = lectorArchivo();
        List<String> sinCorchetes = quitarCorchetes();
        System.out.println("Enter the following values");
        generarHtml(lista, sinCorchetes);
    }

    /**
     * lee de un archivo de texto y guarda el contenido en una List<String> y la retorna
     */
    static List<String> lectorArchivo () throws IOException {

        FileReader fr = new FileReader("src/generarhtml/generarhtml.txt");
        BufferedReader lector = new BufferedReader(fr);
        List<String> texto = new ArrayList<>();
        String linea;
        linea = lector.readLine();

        while (linea != null) {
            texto.add(linea);
            linea = lector.readLine();
        }

        lector.close();
        return texto;
    }

    /**
     * sustituye por "#" los corchetes a cada elemento de la lista que crea lectorArchivo
     * y guarda en una List<String> el contenido con los corchetes sustituidos y la retorna
     */
    static List<String> quitarCorchetes () throws IOException {

        List<String> lista = lectorArchivo();
        List<String> sinCorchetes = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {

            String linea = lista.get(i);
            String a = linea.replace("}}{{", "#");
            String b = a.replace("}}", "#");
            String c = b.replace("{{", "#");
            sinCorchetes.add(c);
        }

        return sinCorchetes;
    }

    static void generarHtml (List<String> lista, List<String> sinCorchetes) throws IOException  {

        PrintWriter escritor = new PrintWriter("src/generarhtml/generarhtml.html");
        Scanner scanner = new Scanner(System.in);

        String datos;
        String html = "";

        for (int i = 0; i < lista.size(); i++) {

            String[] partes = sinCorchetes.get(i).split("#");

            for (int in = 1; in < partes.length - 1; in++) {

                System.out.println(partes[in] + ": ");
                datos = scanner.nextLine();
                html += datos + " ";
            }

            escritor.println(partes[0] + html.substring(0, html.length() - 1) + partes[partes.length - 1]);
            html = "";
        }

        scanner.close();
        escritor.close();
    }
}