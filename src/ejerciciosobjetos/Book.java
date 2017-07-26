package ejerciciosobjetos;

import java.util.ArrayList;
import java.util.List;

public class Book {


    private String author;
    private String title;
    private List<Chapter> chapters = new ArrayList<>();

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Chapter> getChapters() {
        return chapters;
    }
    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    String totalPages() {

        return "Total pages: " + this.chapters.get(this.chapters.size() - 1).getEndPage();
    }

    public String toString() {

        String info = "";
        info = this.title + "\n";
        info += "By " + this.author + "\n";

        for (int i = 0; i < this.chapters.size(); i++) {

            info += i + 1 + " - " + this.chapters.get(i).toString() + "\n";
        }

        return info;
    }
}
