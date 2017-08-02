package bookprinter;

import java.util.List;

public class MarkdownBookPrinter implements BookPrinter {

    @Override
    public String getFormat() {
        return "MARKDOWN";
    }

    @Override
    public String bookToString(Book book) {

        String title = book.getTitle();
        String author = book.getAuthor();
        List<Chapter> chapters = book.getChapters();
        String markdown = "";
        String saltoLinea = "\n";

        markdown = "# " + title + saltoLinea;
        markdown += "## " + author + saltoLinea;

        for (int i = 0; i < chapters.size(); i++) {
            markdown += (i + 1) + ". " + chapters.get(i) + saltoLinea;
        }

        return markdown;
    }
}
