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


        FileReader fr = new FileReader("src/generarhtml/generarhtml.txt");
        BufferedReader lector = new BufferedReader(fr);
        PrintWriter escritor = new PrintWriter("src/generarhtml/generarhtml.html");
        Scanner scanner = new Scanner(System.in);


        String linea = lector.readLine();
        System.out.println("Enter the following values");
        String datos;

        for (int i = 0; linea != null; i++) {

            int ind = linea.indexOf("{{");
            int ind1 = linea.indexOf("}}");
            System.out.println(getPlaceholder().get(i) + ": ");
            datos = scanner.nextLine();
            escritor.println(linea.substring(0, ind) + datos + linea.substring(ind1 + 2, linea.length()));
            linea = lector.readLine();
        }

        lector.close();
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

    static List<String> getPlaceholder () throws IOException {

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
