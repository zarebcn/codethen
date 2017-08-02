package bookprinter;

import java.util.ArrayList;
import java.util.List;

public class Book {


    private String author;
    private String title;
    private List<Chapter> chapterList = new ArrayList<>();

    public Book (String title, String author) {
        this.title = title;
        this.author = author;
    }

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
        return chapterList;
    }
    public void addChapters(Chapter chapter) {
        chapterList.add(chapter);
    }

    String totalPages() {

        return "Total pages: " + chapterList.get(chapterList.size() - 1).getEndPage();
    }

    public String toString() {

        String info = "";
        info = title + "\n";
        info += "By " + author + "\n";

        for (int i = 0; i < chapterList.size(); i++) {

            info += i + 1 + " - " + chapterList.get(i).toString() + "\n";
        }

        return info;
    }
}
