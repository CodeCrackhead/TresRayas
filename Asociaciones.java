package JuegoCompleto;
public class Asociaciones {

    String Asociacion="";
    private static Jugadores Jugadores[]=new Jugadores[JuegoCompleto.numero_jugadores];

    public Asociaciones() {

    }

    public Asociaciones(String Asociacion) {

        this.Asociacion=Asociacion;
        //this.Jugadores=new Jugadores[JuegoCompleto.numero_jugadores]; // aqui deberiamos meter el numero de asociaciones que hemos introducido.

    }

    public static void copiar() {
        for (int i = 0; i < JuegoCompleto.numero_jugadores; i++) {
            Jugadores[i] = new Jugadores(JuegoCompleto.jugadores[i].getNombre(), JuegoCompleto.jugadores[i].getAños(), JuegoCompleto.jugadores[i].getAsociacion_profesional());
        }
    }

}
