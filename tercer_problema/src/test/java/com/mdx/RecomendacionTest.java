package com.mdx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecomendacionTest {

    @Test
    void testCaso1_Nada() {
        Persona p = new Persona(false, false, false, false, false);
        Espacio e = new Espacio(-20, 10, false, false, false, 10, false);
        assertEquals(Opciones.NADA, App.recomendacion(p, e, 0));
    }

    @Test
    void testCaso2_Casa() {
        Persona p = new Persona(true, false, false, true, true);
        Espacio e = new Espacio(-10, 10, true, false, false, 10, false);
        assertEquals(Opciones.CASA, App.recomendacion(p, e, 0));
    }

    @Test
    void testCaso3_Esquiar() {
        Persona p = new Persona(true, false, false, true, true);
        Espacio e = new Espacio(-5, 10, false, false, false, 10, false);
        assertEquals(Opciones.ESQUIAR, App.recomendacion(p, e, 0));
    }

    @Test
    void testCaso4_Senderismo() {
        Persona p = new Persona(true, false, false, true, true);
        Espacio e = new Espacio(5, 50, false, false, false, 10, false);
        assertEquals(Opciones.SENDERISMO, App.recomendacion(p, e, 0));
    }

    @Test
    void testCaso5_Turismo() {
        Persona p = new Persona(true, false, false, true, true);
        Espacio e = new Espacio(16, 50, false, false, false, 10, false);
        assertEquals(Opciones.TURISMO, App.recomendacion(p, e, 0));
    }

    @Test
    void testCaso6_Canas() {
        Persona p = new Persona(true, false, false, true, true);
        Espacio e = new Espacio(26, 50, false, false, false, 10, false);
        assertEquals(Opciones.CANAS, App.recomendacion(p, e, 0));
    }

    @Test
    void testCaso7_Piscina() {
        Persona p = new Persona(true, false, false, true, true);
        Espacio e = new Espacio(36, 50, false, false, false, 10, false);
        assertEquals(Opciones.PISCINA, App.recomendacion(p, e, 0));
    }

    @Test
    void testCaso8_Playa() {
        Persona p = new Persona(true, false, false, true, true);
        Espacio e = new Espacio(30, 50, false, false, false, 10, false);
        assertEquals(Opciones.PLAYA, App.recomendacion(p, e, 10));
    }
}
