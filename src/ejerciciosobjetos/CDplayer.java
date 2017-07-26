package ejerciciosobjetos;

public class CDplayer {


    private CD cd;

    CDplayer() {

        this.cd = null;
    }

    public CD getIsIn() {

        return this.cd;
    }

    void quitCD() {

        this.cd = null;
    }

    void play(CD cd) {

        if (this.cd == null) {

            this.cd = cd;
        }
    }

    public String toString() {

        String mensaje = "";

        if (this.cd != null) {

            mensaje = "Playing: " + this.cd.toString();

        } else {

            mensaje = "No disc";
        }

        return mensaje;
    }

}