package ejerciciosobjetos;

public class CDplayer {


    private CD cd;

    CDplayer() {

        this.cd = null;
    }

    public CD getCd() {

        return this.cd;
    }

    Boolean getIsIn() {

        Boolean isIn = false;

        if (this.cd != null) {

            isIn = true;

        } else {

            isIn = false;
        }

        return isIn;
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