package ejerciciosobjetos;

public class Radio {


    private String brand;
    private int volume;
    private boolean isOn;
    private String[] emisoras = {"RAC 1", "Cadena Dial", "Maxima FM", "La Cope", "Radio Marca", "Cadena 100", "Catalunya Radio", "Radio Teletaxi"};
    private String emisora;
    private int i;
    private CDplayer cdplayer;

    Radio (CDplayer cdplayer) {

        this.volume = 0;
        this.isOn = false;
        this.emisora = emisoras[0];
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

            if (i == emisoras.length) {

                i = 0;
            }
            this.emisora = emisoras[i];
        }
    }

    void tunerDown() {

        i--;

        if (this.isOn) {

            if (i < 0) {

                i = emisoras.length - 1;
            }
            this.emisora = emisoras[i];
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
