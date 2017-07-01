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
        int longitudFrase = texto.length() / lineas;
        int in = 0;

        List<String> lista = new ArrayList<>();

        for (int i = 0; i < lineas; i++) {

            String frase = "";

            while (frase.length() < longitudFrase && in < partes.length) {

                frase += partes[in] + " ";
                in++;
            }

            frase = frase.substring(0, frase.length() - 1);
            lista.add(frase);
        }

        return lista;
    }
}
