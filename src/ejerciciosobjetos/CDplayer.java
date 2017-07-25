package ejerciciosobjetos;

public class CDplayer {


    public boolean cdIn;
    private CD cd;

    CDplayer() {

        this.cdIn = false;
    }

    void quitCD() {

        this.cdIn = false;
    }

    void play(CD cd) {

        if (!this.cdIn) {

            this.cd = cd;
            this.cdIn = true;
        }
    }

    public String toString() {

        String mensaje = "";

        if (this.cdIn) {

            mensaje = "Playing: " + this.cd.toString();

        } else {

            mensaje = "No disc";
        }

        return mensaje;
    }

}