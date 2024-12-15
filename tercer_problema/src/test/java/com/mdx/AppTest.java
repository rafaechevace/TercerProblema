package com.mdx;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

class AppTest {

    // Test para lectura_número() con número válido
    @Test
    void testLecturaNumero_Valido() {
        String input = "42\n"; // Entrada válida
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int resultado = App.lectura_número();
        assertEquals(42, resultado);
    }

    // Test para lectura_número() con entrada inválida seguida de válida
    @Test
    void testLecturaNumero_InvalidoLuegoValido() {
        String input = "abc\n15\n"; // Entrada inválida seguida de válida
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int resultado = App.lectura_número();
        assertEquals(15, resultado);
    }

    // Test para lectura_opcion() con "s" (Sí)
    @Test
    void testLecturaOpcion_Si() {
        String input = "s\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        boolean resultado = App.lectura_opcion();
        assertTrue(resultado);
    }

    // Test para lectura_opcion() con "n" (No)
    @Test
    void testLecturaOpcion_No() {
        String input = "n\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        boolean resultado = App.lectura_opcion();
        assertFalse(resultado);
    }

    // Test para lectura_opcion() con entrada inválida seguida de "s" (Sí)
    @Test
    void testLecturaOpcion_InvalidaLuegoSi() {
        String input = "x\ns\n"; // Entrada inválida seguida de válida
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        boolean resultado = App.lectura_opcion();
        assertTrue(resultado);
    }

    // Test para crear_persona() simulando respuestas por teclado
    @Test
    void testCrearPersona() {
        String input = "s\nn\nn\ns\ns\n"; // Respuestas simuladas para cada pregunta
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Persona persona = App.crear_persona();
        assertTrue(persona.get_sano());
        assertFalse(persona.get_sintomas());
        assertFalse(persona.get_contacto());
        assertTrue(persona.get_pasado_covid());
        assertTrue(persona.get_cartilla());
    }

    // Test para crear_espacio() simulando respuestas por teclado
    @Test
    void testCrearEspacio() {
        String input = "25\n30\nn\nn\nn\n100\nn\n"; // Respuestas simuladas para cada pregunta
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Espacio espacio = App.crear_espacio();
        assertEquals(25, espacio.get_temperatura());
        assertEquals(30, espacio.get_humedad());
        assertFalse(espacio.get_nieva());
        assertFalse(espacio.get_llueve());
        assertFalse(espacio.get_nublado());
        assertEquals(100, espacio.get_aforo_max_actividad());
        assertFalse(espacio.get_confinada());
    }
}
