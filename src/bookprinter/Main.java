package bookprinter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Book book = new Book("Head First Java", "Kathy Sierra");
        HtmlBookPrinter htmlBookPrinter = new HtmlBookPrinter();
        MarkdownBookPrinter markdownBookPrinter = new MarkdownBookPrinter();

        Chapter chapter1 = new Chapter("Breaking the Surface", 1, 26 );
        Chapter chapter2 = new Chapter("A Trip to Objectville", 27, 48);
        Chapter chapter3 = new Chapter("Know Your Variables", 49, 65);

        book.addChapters(chapter1);
        book.addChapters(chapter2);
        book.addChapters(chapter3);

        System.out.println(htmlBookPrinter.getFormat());
        System.out.println(htmlBookPrinter.bookToString(book));
        escritorHtml(book.getTitle(), book.getAuthor(), book.getChapters());

        System.out.println(markdownBookPrinter.getFormat());
        System.out.println(markdownBookPrinter.bookToString(book));

    }

    static void escritorHtml(String title, String author, List<Chapter> chapterList) throws IOException{

        PrintWriter escritor = new PrintWriter("src/bookprinter/htmlbookprinter.html");

        escritor.println("<h1>" + title + "</h1>");
        escritor.println("<h2>" + author + "</h2>");
        escritor.println("<ol>");

        for (int i = 0; i < chapterList.size(); i++) {
            escritor.println("<li>" + chapterList.get(i) + "</li>");
        }

        escritor.println("</ol>");
        escritor.close();
    }
}
