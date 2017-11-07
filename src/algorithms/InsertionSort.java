package algorithms;

public class InsertionSort {

    public static void main(String[] args) {

        int[] lista = {4,7,1,0,3,2};

        insertionSort(lista);

        for (int n : lista) {

            System.out.println(n);
        }
    }

    static void insertionSort (int[] lista) {


        for (int i = 1; i < lista.length; i++) {

            for (int j = i; j > 0; j--) {

                int numberToSwap;

                if (lista[j] < lista[j - 1]) {

                    numberToSwap = lista[j];
                    lista[j] = lista[j - 1];
                    lista[j - 1] = numberToSwap;
                }
            }
        }
    }
}
