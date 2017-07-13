import java.util.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class KeyboardNums {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Double> numeros = new ArrayList<>();
        DecimalFormatSymbols punto = new DecimalFormatSymbols();
        punto.setDecimalSeparator('.');
        DecimalFormat formato = new DecimalFormat("#.00", punto);


        System.out.println("Introduce un número o escribe 'exit' para salir: ");
        String input = scanner.next();

        while (!input.equals("exit")) {

            numeros.add(Double.parseDouble(input));
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
        moda(numeros);

    }

    static double mayor (List<Double> numeros) {

        double mayor = numeros.get(0);

        for (int i = 0; i < numeros.size(); i++) {

            double num = numeros.get(i);

            if (num > mayor) {

                mayor = num;
            }
        }

        return mayor;
    }

    static double menor (List<Double> numeros) {

        double menor = numeros.get(0);

        for (int i = 0; i < numeros.size(); i++) {

            double num = numeros.get(i);

            if (num < menor) {

                menor = num;
            }
        }

        return menor;
    }

    static double suma (List<Double> numeros) {

        double suma = 0;

        for (int i = 0; i < numeros.size(); i++) {

            suma += numeros.get(i);
        }

        return suma;
    }

    static double mediana (List<Double> numeros) {

        double[] numeros2 = new double[numeros.size()];
        double mediana = 0;

        for (int i = 0; i < numeros.size(); i++) {

            numeros2[i] = numeros.get(i);
        }

        Arrays.sort(numeros2);

        if ((numeros2.length % 2) == 0) {

            mediana = (numeros2[(numeros2.length / 2)] + numeros2[(numeros2.length / 2) - 1]) / 2;
        }

        if ((numeros2.length % 2) != 0) {

            mediana = numeros2[(int)(numeros2.length / 2)];
        }

        return mediana;
    }

    static void moda (List<Double> numeros) {

        Collections.sort(numeros);
        int repeticionModa = 0;
        double moda = 0;

        for (int i = 0; i < numeros.size(); i++) {

            double modaActual = numeros.get(i);
            int repeticionModaActual = 1;

            for (int j = i + 1; j < numeros.size(); j++) {

                if (modaActual == numeros.get(j)) {

                    repeticionModaActual++;
                }
            }

            if (repeticionModaActual > repeticionModa) {

                moda = modaActual;
                repeticionModa = repeticionModaActual;

            } else if (repeticionModaActual == repeticionModa && repeticionModa > 1) {

                moda = Math.min(moda, modaActual);

            } else if (repeticionModa == 1) {

                System.out.println("Moda: No hay números que se repitan");
                return;
            }
        }

        System.out.println("La moda es: " + moda);
    }
}