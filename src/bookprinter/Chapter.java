package bookprinter;

public class Chapter {


    private String title;
    private int startPage;
    private int endPage;
    private Chapter next;

    Chapter (String title, int startPage, int endPage) {
        this.title = title;
        this.startPage = startPage;
        this.endPage = endPage;
    }
    public String getTitle() {
        return title;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setNext(Chapter next) {
        this.next = next;
    }

    public Chapter getNext() {
        return next;
    }

    public String toString() {

        return title + ": page " + startPage;
    }
}
