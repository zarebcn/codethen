package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(7);
        list.add(1);
        list.add(0);
        list.add(3);
        list.add(2);

        selectionSort(list);

        for (int n : list) {

            System.out.println(n);
        }

    }

    static void selectionSort (List<Integer> list) {


        for (int i = 0; i < list.size(); i++) {

            int indexOfTheMinNumber = i;

            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(j) < list.get(indexOfTheMinNumber)) {

                    indexOfTheMinNumber = j;
                }
            }

            if (indexOfTheMinNumber != i) {

                int numberToSwap = list.get(i);
                int minNumber = list.get(indexOfTheMinNumber);

                list.set(i, minNumber);
                list.set(indexOfTheMinNumber, numberToSwap);
            }
        }
    }
}
