import java.util.ArrayList;
import java.util.List;

public class ListaTextos {

    public static void main(String[] args) {


        String texto = "The ability to write good code differentiates good developers from the rest";
        List<String> textoDividido = dividirTexto(texto, 3);

        for (String textos : textoDividido) {
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
}
