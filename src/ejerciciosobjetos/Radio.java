package ejerciciosobjetos;

import java.util.ArrayList;
import java.util.List;

public class Radio {


    private String brand;
    private int volume;
    private boolean isOn;
    private List<String> emisoras = new ArrayList<>();
    private String emisora;
    private int i;
    private CDplayer cdplayer;


    Radio (CDplayer cdplayer) {

        this.emisoras.add("RAC1");
        this.emisoras.add("Catalunya Radio");
        this.emisoras.add("SER");
        this.emisoras.add("Cope");
        this.volume = 0;
        this.isOn = false;
        this.emisora = emisoras.get(0);
        this.i = 0;
        this.cdplayer = cdplayer;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String brand) {

        this.brand = brand;
    }

    public int getVolume() {

        return volume;
    }

    public String getEmisora() {

        return emisora;
    }

    public List<String> getEmisoras() {

        return emisoras;
    }

    void turnOn() {

        this.isOn = true;
    }

    void turnOff() {

        this.isOn = false;
    }

    void increaseVolume(int increase) {

        if (this.isOn) {

            this.volume += increase;
        }

        if (this.volume >= 100) {

            this.volume = 100;
        }
    }

    void decreaseVolume(int decrease) {

        if (this.isOn) {

            this.volume -= decrease;
        }

        if (this.volume <= 0) {
            this.volume = 0;
        }
    }

    void tunerUp() {

        i++;

        if (this.isOn) {

            if (i == emisoras.size()) {

                i = 0;
            }
            this.emisora = emisoras.get(i);
        }
    }

    void tunerDown() {

        i--;

        if (this.isOn) {

            if (i < 0) {

                i = emisoras.size() - 1;
            }
            this.emisora = emisoras.get(i);
        }
    }

    void selectEmisora(String favorita) {

        int coincide = 0;
        String emisora = "";

        for (int i = 0; i < this.emisoras.size(); i++) {

            if (favorita.toLowerCase().equals(this.emisoras.get(i).toLowerCase())) {

                coincide++;
                emisora = this.emisoras.get(i);
            }
        }

        if (coincide == 0) {

            System.out.println("Nueva emisora guardada");
            this.emisoras.add(favorita);
            this.emisora = favorita;

        } else {

            System.out.println("Emisora ya guardada");
            this.emisora = emisora;
        }
    }

    void removeEmisora(String emisora) {

        for (int i = 0; i < this.emisoras.size(); i++) {

            if (this.emisoras.get(i).toLowerCase().equals(emisora.toLowerCase())) {

                System.out.println("Emisora borrada");
                this.emisoras.remove(i);
                this.emisora = this.emisoras.get(0);
            }
        }
    }

    public String toString() {

        String mensaje = "";

        if (this.isOn && !this.cdplayer.cdIn) {

            mensaje = this.brand + ", Radio ON, CD Player OFF. Emitiendo: " + this.emisora + ", Volumen: " + this.volume;

        } else if (this.isOn && this.cdplayer.cdIn) {

            mensaje = this.brand + ", Radio OFF, CD Player ON. " + this.cdplayer.toString() + ", Volume: " + this.volume;

        }else if (!this.isOn) {

            mensaje = "...Stand By...";
        }

        return mensaje;
    }
}
