package com.mdx;

public class Actividad {
    private String recomendar;

    public Actividad(String recomendar){
        this.recomendar = recomendar;
    }

    public String get_recomendar(){
        return recomendar;
    }

    public void set_recomendar(String recomendar){
        this.recomendar = recomendar;
    }

    public void to_string(){
        System.out.println("Recomendación: " + recomendar);
    }

}
