package JuegoCompleto;
import java.util.Scanner;

public class JuegoCompleto {

    public static int numero_jugadores;
    public static Jugadores jugadores[];

    public static void main(String args[]) {
        
        int i;

        crear_jugadores();
        TresEnRaya.inicializarTablero();

        do {
            System.out.println(jugadores[jugadorturno()].getNombre() + " te toca jugar");
            TresEnRaya.jugar();
            
            if (jugadores[jugadorturno()].getGanadorTresRaya()) {
                System.out.println("felicidades " + getGanadortresRayasmain() + " has ganado el tres en raya");

            }
            
            JuegoAzar.jugada();
            System.out.println(JuegoAzar.random);;
            JuegoAzar.primera_jugada++;
            if (jugadores[jugadorturno()].getGanadorAzar()) {
                System.out.println("felicidades " + getGanadorAzarmain() + " has ganado el juego de azar");
            }
            i=jugadorturno();
            cambiar_turno();

        } while (jugadores[i].getGanadorAzar() == false && jugadores[i].getGanadorTresRaya() == false);

        if (jugadores[i].getGanadorTresRaya()) {
            int x;
            do {
                System.out.println(jugadores[jugadorturno()].getNombre() + " te toca jugar");
                JuegoAzar.jugada();
                JuegoAzar.primera_jugada++;
                x=jugadorturno();
                cambiar_turno();
            } while (jugadores[x].getGanadorAzar() == false);

        }

        if (jugadores[i].getGanadorAzar() && jugadores[i].getGanadorTresRaya() == false ) {
            int x;
            do {
                
                System.out.println(jugadores[jugadorturno()].getNombre() + " te toca jugar");
                TresEnRaya.jugar();
                x=jugadorturno();
                cambiar_turno();
            } while (jugadores[x].getGanadorTresRaya() == false);
        }

        System.out.println("juego terminado. el juego del azar lo ganó " + getGanadorAzarmain() +
                " y el tres en raya " + getGanadortresRayasmain());

    }
    public static void crear_jugadores() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero de jugadores");

        numero_jugadores = sc.nextInt();
        jugadores = new Jugadores[numero_jugadores];

        for (int i = 0; i < numero_jugadores; i++) {

            System.out.println("Jugador " + (i+1) + " cual es tu nombre:");
            String nombre = sc.next();
            System.out.println("cual es tu asociacion profesional?");
            String Ap = sc.next();
            System.out.println("cuantos anos llevas jugando?");
            int anos = sc.nextInt();
            jugadores[i] = new Jugadores(nombre, anos, Ap);
        }

        System.out.println("¿Quien quiere empezar?:");

        for (int i = 0; i < numero_jugadores; i++) {
            System.out.println("teclea " + (i+1) + " si " + jugadores[i].getNombre());
        }
        int primer_turno = sc.nextInt();
        jugadores[primer_turno-1].setTurno(true);
        /*
            hemos eliminado el sc.close() que era el cierre
            del flujo y hemos resuelto nuestro problema. tendremos
            que intentar entender el porqué ya que pensaba que eran dos objetos
            distintos que no se corelacionaban.

         */
        

    }

    public static void cambiar_turno() {
        int cambio = 0;

        for (int i = 0; i < numero_jugadores; i++) {
            if (jugadores[i].getTurno()) {
                cambio = i;
            }
            jugadores[i].setTurno(false);

        }
        if (cambio == numero_jugadores - 1) {
            jugadores[0].setTurno(true);
        } else {
            jugadores[cambio + 1].setTurno(true);
        }

    }

    public static int jugadorturno() {
        for (int i = 0; i < numero_jugadores; i++) {
            if (jugadores[i].getTurno()) {
                return i;
            }
        }
        return 10000;
    }

    public static String getGanadorAzarmain(){
        for (int i = 0; i < numero_jugadores; i++) {

            if (jugadores[i].getGanadorAzar()) {
                return jugadores[i].getNombre();
            }

        }
        /* no tiene sentido añadir una excepcion ya que podemos utilizar un return
           y nos ahorramos sintexis

         */
        return "errorrr";
    }
    public static String getGanadortresRayasmain() {
        for (int i = 0; i < numero_jugadores; i++) {

            if (jugadores[i].getGanadorTresRaya()) {
                return jugadores[i].getNombre();
            }

        }
        return "excepcion";

    }

}
