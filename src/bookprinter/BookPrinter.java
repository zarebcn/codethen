package bookprinter;

import java.io.IOException;

public interface BookPrinter {

    String BookToString(Book book) throws IOException;

    String getFormat();
}
