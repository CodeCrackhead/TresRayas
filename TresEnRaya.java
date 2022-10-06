package JuegoCompleto;

import java.util.Scanner;

public class TresEnRaya {
    /*
        solucionar index out of bounds exception.
        probar con a coger la excepcion y volver
    */

    static Scanner lectura = new Scanner(System.in);
    private static Tablero tablero;
    private static boolean isFinished = false;
  
    public static void inicializarTablero() {
        
        System.out.println("¿De que tamaño quieres el NRaya?");

        int tamano = lectura.nextInt();
        tablero = new Tablero(tamano);

    }
    
    public static void jugar() {
        int fila;
        int columna;
        
            do {

                do {

                    System.out.println("Dime la fila");
                    fila = lectura.nextInt() - 1;
                    System.out.println("Dime la columna");
                    columna = lectura.nextInt() - 1;

                    if((fila> tablero.valorTablero) || (columna> tablero.valorTablero))
                    System.out.println("has introducido un valor mas grande de lo permitido vualve a introducirlo");

                } while( (fila> tablero.valorTablero) || (columna> tablero.valorTablero));


                tablero.colocarFicha(fila, columna, JuegoCompleto.jugadorturno() + 1);
                tablero.imprimirTablero();



            } while (tablero.posicion_ocupada == true);
            isFinished = tablero.comprobarTablero();
            if (isFinished)
                JuegoCompleto.jugadores[JuegoCompleto.jugadorturno()].setGanadorTresRaya(true);
    }


    
}