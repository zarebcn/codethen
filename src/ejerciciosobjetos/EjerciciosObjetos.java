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

    }
}
