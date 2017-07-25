package ejerciciosobjetos;

public class CD {


    private String title;
    private String author;
    private String duration;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String toString() {
        return this.title + " " + "(" + this.author + ")" + " " + duration;
    }
}