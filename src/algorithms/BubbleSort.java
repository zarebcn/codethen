package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(9);
        list.add(7);
        list.add(5);
        list.add(8);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(0);

        bubbleSort(list);

        for (int n : list) {

            System.out.println(n);
        }

    }

    private static void bubbleSort (List<Integer> lista) {

        for (int i = 0; i < lista.size(); i++) {

            for (int j = 1; j < lista.size(); j++) {

                int number = lista.get(j - 1);
                int possibleMinNumber = lista.get(j);

                if (possibleMinNumber < number) {

                    lista.set(j - 1, possibleMinNumber);
                    lista.set(j, number);
                }
            }
        }

    }
}
