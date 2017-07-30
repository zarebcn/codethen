package ejerciciosobjetos;

public class EjerciciosObjetos {

    public static void main(String[] args) {


        CDplayer cdplayer = new CDplayer();
        Radio radio = new Radio(cdplayer);

        radio.setBrand("Sony");
        System.out.println(radio.getBrand());
        radio.turnOn();
        radio.increaseVolume(50);
        radio.increaseVolume(30);
        radio.decreaseVolume(10);
        radio.tunerUp();
        radio.tunerUp();
        radio.tunerDown();

        CD cd = new CD();

        cd.setTitle("Dookie");
        cd.setAuthor("Green Day");
        cd.setDuration("39:46");


        cdplayer.play(cd);
        cdplayer.quitCD();
        radio.selectEmisora("Radio teletaxi");
        radio.removeEmisora("radio teletaxi");
        System.out.println(radio.toString());

        Chapter chapter1 = new Chapter("Breaking the Surface", 1, 26 );
        Chapter chapter2 = new Chapter("A Trip to Objectville", 27, 48);
        Chapter chapter3 = new Chapter("Know Your Variables", 49, 65);

        Book book = new Book();
        ChapterList chapterList = new ChapterList();

        book.setAuthor("Kathy Sierra");
        book.setTitle("Head First Java");
        //book.getChapters().add(chapter1);
        //book.getChapters().add(chapter2);
        //book.getChapters().add(chapter3);
        chapterList.add(chapter1);
        chapterList.add(chapter2);
        chapterList.add(chapter3);
        book.setChapters(chapterList);


        System.out.println(book.totalPages());
        System.out.println(book.toString());

    }
}
