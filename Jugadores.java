package JuegoCompleto;


public class Jugadores {
    private String nombre;
    private String Asociacion_profesional;
    private int años;
    private boolean turno=false;
    private boolean ganadorAzar = false;
    private boolean ganadorTresRaya = false;
  
    public Jugadores(String nombre, int años, String asociacion_profesional) {
        this.nombre = nombre;
        this.años = años;
        this.Asociacion_profesional = asociacion_profesional;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAsociacion_profesional() {
        return Asociacion_profesional;
    }

    public int getAños() {
        return años;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAsociacion_profesional(String Asociacion_profesional) {
        this.Asociacion_profesional = Asociacion_profesional;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;

    }

    public boolean getTurno() {
        return turno;

    }

    public void setGanadorAzar(boolean GanadorAzar) {
        this.ganadorAzar = GanadorAzar;
    }

    public boolean getGanadorAzar() {
        return ganadorAzar;

    }

    public void setGanadorTresRaya(boolean GanadorTresRaya) {
        this.ganadorTresRaya = GanadorTresRaya;
    }

    public boolean getGanadorTresRaya() {
        return ganadorTresRaya;
    }





}
