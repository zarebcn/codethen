import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MapAndFilterExercise {

    public static void main(String[] args) throws Exception {


        List<String> dates = Arrays.asList("21-01-2016", "08-04-2015", "01-10-2017");
        System.out.println("fechas: " + dates);

        List<String> modifiedDates = stringMap(dates, new StringFunction() {
            @Override
            public String apply(String date) throws ParseException {

                return addMonths(date, 1);
            }
        });
        System.out.println("fechas (modificadas): " + modifiedDates);

        List<String> modifiedDates2 = stringMap(dates, date -> addMonths(date, 1));

        System.out.println("fechas (modificadas): " + modifiedDates2);


        List<String> text = Arrays.asList("barca", "casa", "perro", "bolsa", "burro", "agua", "coche");

        System.out.println("palabras: " + text);

        List<String> filteredText = stringFilter(text, new filterFunction() {
            @Override
            public boolean apply(String word) {

                return word.toLowerCase().startsWith("b");
            }
        });

        System.out.println("palabras (filtradas): " + filteredText);

        List<String> filteredText2 = stringFilter(text, word -> word.toLowerCase().startsWith("b"));

        System.out.println("palabras (filtradas): " + filteredText2);

        List<String> filteredText3 = filter(text, new genericFilterFunction<String>() {
            @Override
            public boolean apply(String word) {
                return word.toLowerCase().startsWith("b");
            }
        });

        System.out.println(filteredText3);

        List<Integer> numbers = Arrays.asList(12, 5, 7, 10, 15, 2);

        List<Integer> numbers2 = filter(numbers, new genericFilterFunction<Integer>() {
            @Override
            public boolean apply(Integer number) {

                if (number % 2 == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        System.out.println("numeros: " + numbers);
        System.out.println("numeros (pares): " + numbers2);

    }

    @FunctionalInterface
    interface StringFunction {
        String apply(String arg) throws ParseException;
    }

    @FunctionalInterface
    interface genericStringFunction<Arg, Return> {
        Return apply(Arg arg);
    }

    @FunctionalInterface
    interface filterFunction {
        boolean apply(String arg);
    }

    @FunctionalInterface
    interface genericFilterFunction<Arg> {
        boolean apply(Arg arg);
    }

    static List<String> stringMap(List<String> list, StringFunction f) throws ParseException {

        List<String> result = new ArrayList<>();

        for (String elem : list) {
            String modified = f.apply(elem);
            result.add(modified);
        }

        return result;
    }

    static List<String> stringFilter(List<String> list, filterFunction f) {

        List<String> result = new ArrayList<>();

        for (String elem : list) {
            if (f.apply(elem)) {
                result.add(elem);
            }
        }

        return result;
    }

    static <In> List<In> filter(List<In> list, genericFilterFunction<In> f) {

        List<In> result = new ArrayList<>();

        for (In elem : list) {
            if (f.apply(elem)) {
                result.add(elem);
            }
        }

        return result;

    }

    static String addMonths(String date, int amount) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = dateFormat.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.MONTH, amount);
        Date fechaModificada = calendar.getTime();

        return dateFormat.format(fechaModificada);
    }
}
