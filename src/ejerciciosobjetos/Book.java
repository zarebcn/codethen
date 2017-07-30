package ejerciciosobjetos;

import java.util.ArrayList;
import java.util.List;

public class Book {


    private String author;
    private String title;
    private ChapterList chapterList;
   // private List<Chapter> chapterList = new ArrayList<>();

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
    public ChapterList getChapters() {
        return chapterList;
    }
    public void setChapters(ChapterList chapterList) {
        this.chapterList = chapterList;
    }
    /*public List<Chapter> getChapters() {
        return chapterList;
    }
    public void setChapters(List<Chapter> chapterList) {
        this.chapters = chapterList;
    }*/

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
