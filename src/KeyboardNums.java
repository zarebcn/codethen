import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class KeyboardNums {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> numeros = new ArrayList<>();
        DecimalFormatSymbols punto = new DecimalFormatSymbols();
        punto.setDecimalSeparator('.');
        DecimalFormat formato = new DecimalFormat("#.00", punto);


        System.out.println("Introduce un número o escribe 'exit' para salir: ");
        String input = scanner.next();

        while (!input.equals("exit")) {

            numeros.add(input);
            System.out.println("Introduce un número o escribe 'exit' para salir: ");
            input = scanner.next();
        }

        if (numeros.size() == 0) {
            return;
        }

        System.out.println("El número mayor es: " + mayor(numeros));
        System.out.println("El número menor es: " + menor(numeros));
        System.out.println("La suma de los números es: " + suma(numeros));
        System.out.println("La media aritmética es: " + formato.format(suma(numeros)/numeros.size()));
        System.out.println("La mediana es: " + mediana(numeros));

    }

    static double mayor (List<String> numeros) {

        double mayor = Double.parseDouble(numeros.get(0));

        for (int i = 0; i < numeros.size(); i++) {

            double num = Double.parseDouble(numeros.get(i));

            if (num > mayor) {

                mayor = num;
            }
        }

        return mayor;
    }

    static double menor (List<String> numeros) {

        double menor = Double.parseDouble(numeros.get(0));

        for (int i = 0; i < numeros.size(); i++) {

            double num = Double.parseDouble(numeros.get(i));

            if (num < menor) {

                menor = num;
            }
        }

        return menor;
    }

    static double suma (List<String> numeros) {

        double suma = 0;

        for (int i = 0; i < numeros.size(); i++) {

            suma += Double.parseDouble(numeros.get(i));
        }

        return suma;
    }

    static double mediana (List<String> numeros) {

        double[] numeros2 = new double[numeros.size()];
        double mediana = 0;

        for (int i = 0; i < numeros.size(); i++) {

            numeros2[i] = Double.parseDouble(numeros.get(i));
        }

        Arrays.sort(numeros2);

        if ((numeros2.length % 2) == 0) {

            mediana = (numeros2[(numeros2.length / 2)] + numeros2[(numeros2.length / 2) + 1]) / 2;
        }

        if ((numeros2.length % 2) != 0) {

            mediana = numeros2[(int)((numeros2.length / 2) + 0.5)];
        }

        return mediana;
    }
}