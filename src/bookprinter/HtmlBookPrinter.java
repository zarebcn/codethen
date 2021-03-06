package bookprinter;


import java.util.List;

public class HtmlBookPrinter implements BookPrinter {

    @Override
    public String getFormat() {
        return "HTML";
    }

    @Override
    public String bookToString(Book book) {


        String title = book.getTitle();
        String author = book.getAuthor();
        List<Chapter> chapters = book.getChapters();
        String html = "";
        String saltoLinea = "\n";

        html = "<h1>" + title + "</h1>" + saltoLinea;
        html += "<h2>" + author + "</h2>" + saltoLinea;
        html += "<ol>" + saltoLinea;

        for (int i = 0; i < chapters.size(); i++) {
            html += "<li>" + chapters.get(i) + "</li>" + saltoLinea;
        }

        html += "</ol>" + saltoLinea;

        return html;
    }
}
