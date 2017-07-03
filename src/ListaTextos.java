import java.util.ArrayList;
import java.util.List;

public class ListaTextos {

    public static void main(String[] args) {


        String texto = "The ability to write good code differentiates good developers from the rest";
        List<String> textoDividido = dividirTexto(texto, 3);

        for (String textos : textoDividido) {
            System.out.println("\"" + textos + "\"");
        }

        List<String> textoDividido2 = dividirTexto2(texto, 5);

        for (String textos : textoDividido2) {
            System.out.println("\"" + textos + "\"");
        }

    }

    static List<String> dividirTexto (String texto, int lineas) {

        String[] partes = texto.split(" ");
        int longitudFrase = (texto.length() - (lineas - 1)) / lineas;
        int i = 0;
        String frase = "";

        List<String> lista = new ArrayList<>();

        for (int in = 0; i < lineas; in++) {

            frase += partes[in] + " ";

            if (frase.length() > longitudFrase || in == partes.length - 1) {

                frase = frase.substring(0, frase.length() - 1);
                lista.add(frase);
                frase = "";
                i++;

                if ( partes[in] == partes[partes.length - 1]) {

                    i = lineas;
                    //break;
                }
            }
        }

        return lista;
    }

    static List<String> dividirTexto2 (String texto, int lineas) {

        String[] partes = texto.split(" ");

        //value of 0.5
        String value = "[fijlt]";

        //value of 1
        String value1 = "[^fijltmwA-Z]";

        //value of 1.5
        String value2 = "[mwA-LN-VX-Z]";

        //value of 2
        String value3 = "[MW]";

        double total = 0;
        int j = 0;

        //Este bucle calcula la longitud total del texto midiendo cada palabra por su valor headline
        for (int i = 0; i < partes.length; i++) {

            double longitudPalabra = 0;

            for (int in = 0; in < partes[j].length(); in++) {

                String a = partes[j].substring(in, 1 + in);
                longitudPalabra = longitudPalabra(a, value, value1, value2, longitudPalabra);
            }

            total += longitudPalabra + 1;
            j++;
        }

        total = total - 1;
        double longitudLinea = total / lineas;
        double longitudLineaActual = 0;
        List<String> lista = new ArrayList<>();
        int i = 0;
        String frase = "";

        for (int in = 0; i < lineas; in++) {

            double longitudPalabra = 0;

            for (int e = 0; e < partes[in].length(); e++) {

                String a = partes[in].substring(e, 1 + e);
                longitudPalabra = longitudPalabra(a, value, value1, value2, longitudPalabra);
            }

            frase += partes[in] + " ";
            longitudLineaActual += longitudPalabra + 1;

            if (longitudLineaActual + 3 > longitudLinea || in == partes.length - 1) {

                frase = frase.substring(0, frase.length()-1);
                lista.add(frase);
                frase = "";
                longitudLineaActual = 0;
                i++;
            }
        }

        return lista;
    }

    static double longitudPalabra (String a, String value, String value1, String value2, double longitudPalabra) {

        if (a.matches(value)) {

            longitudPalabra += 0.5;
        }

        if (a.matches(value1)) {

            longitudPalabra += 1;
        }

        if (a.matches(value2)) {

            longitudPalabra += 1.5;
        }

        return longitudPalabra;
    }
}
