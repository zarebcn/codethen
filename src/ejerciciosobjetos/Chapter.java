package ejerciciosobjetos;

public class Chapter {


    private String title;
    private int startPage;
    private int endPage;
    private Chapter next;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
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
