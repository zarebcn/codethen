package bookprinter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Book book = new Book("Head First Java", "Kathy Sierra");
        HtmlBookPrinter htmlBookPrinter = new HtmlBookPrinter();

        Chapter chapter1 = new Chapter("Breaking the Surface", 1, 26 );
        Chapter chapter2 = new Chapter("A Trip to Objectville", 27, 48);
        Chapter chapter3 = new Chapter("Know Your Variables", 49, 65);

        book.addChapters(chapter1);
        book.addChapters(chapter2);
        book.addChapters(chapter3);

        System.out.println(htmlBookPrinter.BookToString(book));
        System.out.println(htmlBookPrinter.getFormat());

    }
}
