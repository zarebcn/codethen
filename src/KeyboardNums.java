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

        scanner.close();

        if (numeros.size() == 0) {
            return;
        }

        MayorMenor mayorMenor = mayorMenor(numeros);
        System.out.println("El número mayor es: " + mayorMenor.mayor);
        System.out.println("El número menor es: " + mayorMenor.menor);
        System.out.println("La suma de los números es: " + suma(numeros));
        System.out.println("La media aritmética es: " + formato.format(suma(numeros)/numeros.size()));
        System.out.println("La mediana es: " + mediana(numeros));
        System.out.println("La moda es: " + moda(numeros));

    }

    static MayorMenor mayorMenor (List<Double> numeros) {

        double mayor = numeros.get(0);
        double menor = numeros.get(0);
        MayorMenor mayorMenor = new MayorMenor(mayor, menor);

        for (int i = 0; i < numeros.size(); i++) {

            double num = numeros.get(i);

            if (num > mayor) {

                mayor = num;
            }

            if (num < menor) {

                menor = num;
            }
        }

        mayorMenor.mayor = mayor;
        mayorMenor.menor = menor;
        return mayorMenor;
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

        } else {

            mediana = numeros2[(int)(numeros2.length / 2)];
        }

        return mediana;
    }

    static Result moda (List<Double> numeros) {

        Collections.sort(numeros);
        int repeticionModa = 0;
        double moda = 0;
        String error = null;
        Result resultado = new Result(moda, error);

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
                resultado.value = moda;

            } else if (repeticionModaActual == repeticionModa && repeticionModa > 1) {

                moda = Math.min(moda, modaActual);
                resultado.value = moda;

            } else if (repeticionModa == 1) {

                resultado.error = "No hay numeros repetidos";
            }
        }

        return resultado;
    }
}

class MayorMenor {

    double mayor;
    double menor;

    MayorMenor (double mayor, double menor) {

        this.mayor = mayor;
        this.menor = menor;
    }
}

class Result {

    double value;
    String error;

    Result (double value, String error) {

        this.value = value;
        this.error = error;
    }

   public String toString() {

        //String resultado = "";

        if (this.error == null) {

            return "" + this.value;
        } else {

            return this.error;
        }
    }
}