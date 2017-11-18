import javax.management.RuntimeErrorException;
import java.util.*;

public class AlgorithmsExercises {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>(Arrays.asList(1, 7, 3, 3, 2, 7, 5));
        System.out.println(findTheMaximum(list));

        List<Integer> list1 = new ArrayList<>(Arrays.asList(8, 3, 12, 2, 5));
        System.out.println(minimumDifference(list1));

        Person p1 = new Person("Peter", 20, "NY");
        Person p2 = new Person("Mary", 30, "London");
        Person p3 = new Person("Peter", 20, "BCN");

        List<Person> list2 = new ArrayList<>(Arrays.asList(p1, p2, p3));
        System.out.println(findRepeatedPerson(list2));

    }

    // Finds the maximum number of the List by iterating it and comparing number by number
    // a fast method is sorting the List and picking the last number of the List
    private static int findTheMaximum (List<Integer> list) {

        int max = 0;

        if (list.size() > 0) {

            for (int num : list) {

                if (max < num) {
                    max = num;
                }
            }
        } else {
            throw new RuntimeException();
        }
        return max;
    }

    // Finds the 2 numbers with the minimum difference between them by sorting the List and
    // iterating the List comparing the difference between consecutive couples of numbers
    private static String minimumDifference (List<Integer> list) {

        Collections.sort(list);

        int num = list.get(0);
        int num1 = list.get(1);
        int minDiff = Math.abs(num - num1);

        for (int i = 0; i < list.size() - 1; i++) {

            if (Math.abs(list.get(i) - list.get(i + 1)) < minDiff) {

                num = list.get(i);
                num1 = list.get(i + 1);
                minDiff = Math.abs(num - num1);
            }

        }

        return "(" + num + ", " + num1 + ")";
    }

    static class Person {

        String name;
        int age;
        String city;

        public Person (String name, int age, String city) {

            this.name = name;
            this.age = age;
            this.city = city;
        }
    }


    private static boolean findRepeatedPerson (List<Person> list) {

        for (int i = 0; i < list.size() - 1; i++) {

            for (int j = i + 1; j < list.size(); j++) {

                Person a = list.get(i);
                Person b = list.get(j);

                if (a.name.equals(b.name) && (a.age == b.age)) {
                    return true;
                }
            }
        }
        return false;
    }

}
