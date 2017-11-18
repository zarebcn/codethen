import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgorithmsExercises {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>(Arrays.asList(1, 7, 3, 3, 2, 7, 5));
        System.out.println(findTheMaximum(list));

        List<Integer> list1 = new ArrayList<>(Arrays.asList(8, 3, 12, 2, 5));
        System.out.println(minimumDifference(list1));

    }

    private static int findTheMaximum (List<Integer> list) {

        int max = 0;

        if (list.size() > 0) {

            for (int i = 0; i < list.size(); i++) {

                if (max < list.get(i)) {
                    max = list.get(i);
                }
            }
        } else {
            throw new RuntimeException();
        }
        return max;
    }

    private static String minimumDifference (List<Integer> list) {

        int num = list.get(0);
        int num1 = list.get(1);
        int minDiff = Math.abs(num - num1);

        for (int i = 0; i < list.size() - 1; i++) {

            for (int j = i + 1; j < list.size(); j++) {

                if ((list.get(0) - list.get(j)) < minDiff) {

                    num = list.get(i);
                    num1 = list.get(j);
                    minDiff = Math.abs(num - num1);
                }
            }
        }

        return "(" + Math.min(num, num1) + ", " + Math.max(num, num1) + ")";
    }
}
