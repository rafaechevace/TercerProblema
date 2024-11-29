package com.mdx;
public class Espacio {
    private double temperatura;
    private double humedad;
    private boolean nieva;
    private boolean llueve;
    private boolean nublado;
    private int aforo_max;
    private boolean confinada;

    public Espacio (double temperatura,double humedad,boolean nieve,boolean llueve,boolean nubes,int aforo_max,boolean confinada){
        this.temperatura=temperatura;
        this.humedad=humedad;
        this.nieva=nieve;
        this.llueve=llueve;
        this.nublado=nubes;
        this.aforo_max=aforo_max;
        this.confinada=confinada;
    }

    public double get_temperatura(){
        return temperatura;
    }

    public double get_humedad(){
        return humedad;
    }

    public boolean get_nieva(){
        return  nieva;
    }

    public boolean get_llueve(){
        return  llueve;
    }

    public boolean get_nublado(){
        return  nublado;
    }

    public int aforo_max_actividad(){
        return aforo_max;
    }

    public boolean get_confinada(){
        return  confinada;
    }
}
