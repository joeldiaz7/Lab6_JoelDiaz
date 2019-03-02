package lab.pkg6_joeldiaz;

import java.util.ArrayList;

class criatura {
    private String nombre;
    private int energia;
    private int años;
    private String region;
    private int vivas;
    private ArrayList<String> objetos_magicos = new ArrayList();

    public criatura() {
    }

    public criatura(String nombre, int energia, int años, String region, int vivas) {
        this.nombre = nombre;
        this.energia = energia;
        this.años = años;
        this.region = region;
        this.vivas = vivas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getVivas() {
        return vivas;
    }

    public void setVivas(int vivas) {
        this.vivas = vivas;
    }

    public ArrayList<String> getObjetos_magicos() {
        return objetos_magicos;
    }

    public void setObjetos_magicos(ArrayList<String> objetos_magicos) {
        this.objetos_magicos = objetos_magicos;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
