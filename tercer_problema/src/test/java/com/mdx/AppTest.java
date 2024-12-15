package com.mdx;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RecomendacionTest {

    @Test
    void testCaso1_Nada() {
        Persona p1 = new Persona(false, false, false, false, false);
        Espacio e1 = new Espacio(-20, 10, false, false, false, 10, false);
        assertEquals(Opciones.NADA, App.recomendacion(p1, e1, 0));
    }

    @Test
    void testCaso2_Casa() {
        Persona p2 = new Persona(true, false, false, true, true);
        Espacio e2 = new Espacio(-10, 10, true, false, false, 10, false);
        assertEquals(Opciones.CASA, App.recomendacion(p2, e2, 0));
    }

    @Test
    void testCaso3_Esquiar() {
        Persona p3 = new Persona(true, false, false, true, true);
        Espacio e3 = new Espacio(-5, 10, false, false, false, 10, false);
        assertEquals(Opciones.ESQUIAR, App.recomendacion(p3, e3, 0));
    }

    @Test
    void testCaso4_Senderismo() {
        Persona p4 = new Persona(true, false, false, true, true);
        Espacio e4 = new Espacio(5, 50, false, false, false, 10, false);
        assertEquals(Opciones.SENDERISMO, App.recomendacion(p4, e4, 0));
    }

    @Test
    void testCaso5_Turismo() {
        Persona p5 = new Persona(true, false, false, true, true);
        Espacio e5 = new Espacio(20, 50, false, false, false, 10, false);
        assertEquals(Opciones.TURISMO, App.recomendacion(p5, e5, 0));
    }

    @Test
    void testCaso6_Canas() {
        Persona p6 = new Persona(true, false, false, true, true);
        Espacio e6 = new Espacio(27, 50, false, false, false, 10, false);
        assertEquals(Opciones.CANAS, App.recomendacion(p6, e6, 0));
    }

    @Test
    void testCaso7_Piscina() {
        Persona p7 = new Persona(true, false, false, true, true);
        Espacio e7 = new Espacio(36, 50, false, false, false, 10, false);
        assertEquals(Opciones.PISCINA, App.recomendacion(p7, e7, 0));
    }

    @Test
    void testCaso8_Playa() {
        Persona p8 = new Persona(true, false, false, true, true);
        Espacio e8 = new Espacio(37, 50, false, false, false, 10, false);
        assertEquals(Opciones.PLAYA, App.recomendacion(p8, e8, 10));
    }
}
