package JuegoCompleto;

public class Tablero {
    int[][] tablero;
    int valorTablero;


    boolean posicion_ocupada = false;

    public Tablero(int tamano) {
        tablero = new int[tamano][tamano];
        valorTablero=tamano;
    }

    public boolean comprobarTablero() {
        if (comprobarFilas() || comprobarColumnas() || comprobarDiagonalPrincipal() || 
            comprobarDiagonalInversa() || comprobarempate()) {
            return true;
        }
        return false;
    }

    public boolean comprobarempate() {
        boolean empate = false;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {

                if (tablero[i][j] == 0) {
                    empate = false;
                }
            }
        }
        if (empate == true) {
            return true;
        } else {
            return false;
        }
    }

    private boolean comprobarFilas() {

        int suma_break = 0;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == JuegoCompleto.jugadorturno() + 1) {
                    suma_break++;
                }

            }
            if (suma_break == tablero[i].length) {
                JuegoCompleto.jugadores[JuegoCompleto.jugadorturno()].setGanadorTresRaya(true);
                return true;
            }
            suma_break = 0;
        }

        return false;
    }

    private boolean comprobarColumnas() {
        int suma_break = 0;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[j][i] == JuegoCompleto.jugadorturno() + 1) {
                    suma_break++;
                }
            }

            if (suma_break == tablero.length) {
                JuegoCompleto.jugadores[JuegoCompleto.jugadorturno()].setGanadorTresRaya(true);
                return true;
            }

            suma_break = 0;

        }

        return false;
    }

    private boolean comprobarDiagonalPrincipal() {
        int ij;
        int suma_break = 0;
        for (ij = 0; ij < tablero.length; ij++) {

            if (tablero[ij][ij] == JuegoCompleto.jugadorturno() + 1) {
                suma_break++;

            }
            if (suma_break == tablero.length) {
                JuegoCompleto.jugadores[JuegoCompleto.jugadorturno()].setGanadorTresRaya(true);
                return true;
            }

        }
        return false;

    }

    private boolean comprobarDiagonalInversa() {
        int i;
        int j;
        int suma_break = 0;

        for (i = 0; i < tablero.length; i++) {
            j = tablero.length - 1 - i;

            if (tablero[i][j] == JuegoCompleto.jugadorturno() + 1) {
                suma_break++;

            } 
            if (suma_break == tablero.length) {
                JuegoCompleto.jugadores[JuegoCompleto.jugadorturno()].setGanadorTresRaya(true);
                return true;
            } 

        }

        return false;

    }
     
    public void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {

                System.out.print(tablero[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    public void colocarFicha(int fila, int columna, int ficha) {

        if (tablero[fila][columna] == 0) {
            tablero[fila][columna] = ficha;
            posicion_ocupada = false;
        } else {
            posicion_ocupada = true;
            System.out.println("psoicion ocupada, selecciona otra posicion ");

        }

    }

    //metodo para comprobar si fila y columna introducida estan out of bounds.

}
