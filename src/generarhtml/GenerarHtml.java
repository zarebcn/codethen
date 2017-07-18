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


        PrintWriter escritor = new PrintWriter("src/generarhtml/generarhtml.html");
        Scanner scanner = new Scanner(System.in);

        List<String> lineas = lectorArchivo();
        System.out.println("Enter the following values");
        String datos;

        for (int i = 0; i < lineas.size(); i++) {

            int ind = lineas.get(i).indexOf("{{");
            int ind1 = lineas.get(i).indexOf("}}");
            System.out.println(getPlaceholders().get(i) + ": ");
            datos = scanner.nextLine();
            escritor.println(lineas.get(i).substring(0, ind) + datos + lineas.get(i).substring(ind1 + 2, lineas.get(i).length()));
        }

        scanner.close();
        escritor.close();
    }


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

    static List<String> getPlaceholders () throws IOException {

        List<String> lista = lectorArchivo();
        List<String> placeholders = new ArrayList<>();
        String placeholder;

        for (int i = 0; i < lista.size(); i++) {
            int ind = lista.get(i).indexOf("{{");
            int ind1 = lista.get(i).indexOf("}}");
            placeholder = lista.get(i).substring(ind + 2, ind1);
            placeholders.add(placeholder);
        }

        return placeholders;
    }
}
