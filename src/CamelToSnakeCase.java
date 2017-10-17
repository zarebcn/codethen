
public class CamelToSnakeCase {


    public static void main(String[] args) {

        System.out.println(camelToSnakeCase("releaseDate"));
        System.out.println(camelToSnakeCase("numberOfPages"));
        System.out.println(camelToSnakeCase("title"));
    }

    public static String camelToSnakeCase(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            if (Character.isUpperCase(text.charAt(i)) && i > 0) {

                result += "_" + Character.toLowerCase(text.charAt(i));

            } else {

                result += text.charAt(i);
            }
        }

        return result;
    }
}
