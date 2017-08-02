package bookprinter;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HtmlBookPrinter implements BookPrinter {

    @Override
    public String getFormat() {
        return "HTML";
    }

    @Override
    public String BookToString(Book book) throws IOException {

        PrintWriter escritor = new PrintWriter("src/bookprinter/htmlbookprinter.html");

        String title = book.getTitle();
        String author = book.getAuthor();
        List<Chapter> chapters = book.getChapters();
        String html = "";
        String saltoLinea = "\n";

        html = "<h1>" + title + "</h1>" + saltoLinea;
        escritor.println("<h1>" + title + "</h1>");
        html += "<h2>" + author + "</h2>" + saltoLinea;
        escritor.println("<h2>" + author + "</h2>");
        html += "<ol>" + saltoLinea;
        escritor.println("<ol>");

        for (int i = 0; i < chapters.size(); i++) {
            html += "<li>" + chapters.get(i) + "</li>" + saltoLinea;
            escritor.println("<li>" + chapters.get(i) + "</li>");
        }

        html += "</ol>" + saltoLinea;
        escritor.println("</ol>");
        escritor.close();

        return html;
    }
}
