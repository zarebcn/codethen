import java.util.ArrayList;
import java.util.List;

public class ListaTextos {

    public static void main(String[] args) {


        String texto = "The ability to write good code differentiates good developers from the rest";
        List<String> textoDividido = dividirTexto(texto, 3);

        for (int i = 0; i < textoDividido.size(); i++) {
            System.out.println(textoDividido.get(i));
        }

    }

    static List<String> dividirTexto (String texto, int lineas) {

        int textoLength = texto.length();
        String[] partes = texto.split(" ");
        int longitudFrase = (textoLength - (lineas - 1))/lineas;

        int i = 0;
        int in = 0;
        String frase = "";
        String espacio = " ";

        List<String> lista = new ArrayList<>();

        while (i < lineas) {

            while (frase.length() < longitudFrase) {

                frase = frase + partes[in];
                frase = frase + espacio;
                in++;
            }

            lista.add(frase);
            frase = "";
            i++;
        }

        return lista;
    }
}
