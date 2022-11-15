package JuegoCompleto;
import JuegoCompleto.JuegoCompleto;
import java.util.*;

public class JuegoAzar {

    /*
    ahora lo que vamos a intentar hacer es guardar las asocioaciones en xml y rescatarlas
    y luego vamos a intentar guardar las partidas!!.

    */
    
     static int x;
     static Scanner sc = new Scanner(System.in);
    static int numeroazar;
    public static int primera_jugada=0;
    public static int random;

    public static  void randomodromizador() {

        double randomodromo = Math.random() * 10;
        int randomodromoentero = (int) randomodromo;
        if(primera_jugada==0)
        random=randomodromoentero;

    }

    public static void jugada() {

        randomodromizador();
        System.out.println( JuegoCompleto.jugadores[JuegoCompleto.jugadorturno()].getNombre() + " introduce numero al azar:");
        numeroazar = sc.nextInt();

         if (numeroazar==random)
              JuegoCompleto.jugadores[JuegoCompleto.jugadorturno()].setGanadorAzar(true);

    }
    
    
}