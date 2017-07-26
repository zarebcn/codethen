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

        Chapter chapter1 = new Chapter();
        Chapter chapter2 = new Chapter();
        Chapter chapter3 = new Chapter();

        chapter1.setTitle("Breaking the Surface");
        chapter1.setStartPage(1);
        chapter1.setEndPage(26);
        chapter2.setTitle("A Trip to Objectville");
        chapter2.setStartPage(27);
        chapter2.setEndPage(48);
        chapter3.setTitle("Know Your Variables");
        chapter3.setStartPage(49);
        chapter3.setEndPage(65);

        Book book = new Book();

        book.setAuthor("Kathy Sierra");
        book.setTitle("Head First Java");
        book.getChapters().add(chapter1);
        book.getChapters().add(chapter2);
        book.getChapters().add(chapter3);

        System.out.println(book.totalPages());
        System.out.println(book.toString());

    }
}
