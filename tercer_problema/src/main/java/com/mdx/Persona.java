package com.mdx;

public class Persona {
    private boolean sano;
    private boolean sintomas;
    private boolean contacto;
    private boolean pasado_covid;
    private boolean cartilla_en_regla;

    public Persona(boolean sano, boolean sintomas, boolean contacto, boolean pasado_covid, boolean cartilla){
        this.sano = sano;
        this.sintomas = sintomas;
        this.contacto = contacto;
        this.pasado_covid = pasado_covid;
        this.cartilla_en_regla = cartilla;
    }

    public boolean get_sano(){
        return sano;
    }

    public boolean get_sintomas(){
        return sintomas;
    }

    public boolean get_contacto(){
        return contacto;
    }

    public boolean get_pasado_covid(){
        return pasado_covid;
    }

    public boolean get_cartilla(){
        return cartilla_en_regla;
    }

    public void set_sano(boolean sano){
        this.sano = sano;
    }

    public void set_sintomas(boolean sintomas){
        this.sintomas = sintomas;
    }

    public void set_contacto(boolean contacto){
        this.contacto = contacto;
    }

    public void set_pasado_covid(boolean pasado_covid){
        this.pasado_covid = pasado_covid;
    }

    public void set_cartilla(boolean cartilla){
        this.cartilla_en_regla = cartilla;
    }

    public String to_string(){
        return ("Sano: " + sano + "\nSintomas: " + sintomas + "\nContacto: " + contacto + "\nPasado Covid: " + pasado_covid + "\nCartilla en regla: " + cartilla_en_regla);
    }


}
