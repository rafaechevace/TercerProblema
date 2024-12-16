package com.mdx;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent)); // Redirigir salida estándar
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut); // Restaurar salida estándar
    }

    // Test de lectura de número válido
    @Test
    void testLecturaNumero_ValidInput() {
        String input = "42\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        int resultado = App.lectura_numero(scanner);
        assertEquals(42, resultado);
    }

    // Test de entrada inválida seguido de entrada válida para número
    @Test
    void testLecturaNumero_InvalidThenValidInput() {
        String input = "abc\n123\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        int resultado = App.lectura_numero(scanner);
        assertEquals(123, resultado);
    }

    // Test de opción válida: "s"
    @Test
    void testLecturaOpcion_ValidInputYes() {
        String input = "s\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        boolean resultado = App.lectura_opcion(scanner);
        assertTrue(resultado);
    }

    // Test de opción válida: "n"
    @Test
    void testLecturaOpcion_ValidInputNo() {
        String input = "n\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        boolean resultado = App.lectura_opcion(scanner);
        assertFalse(resultado);
    }

    // Test de opción inválida seguido de "s"
    @Test
    void testLecturaOpcion_InvalidThenValidInput() {
        String input = "x\ns\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        boolean resultado = App.lectura_opcion(scanner);
        assertTrue(resultado);
    }

    // Test para crear una persona con entrada válida
    @Test
    void testCrearPersona_ValidInput() {
        String input = "s\nn\ns\nn\ns\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Persona persona = App.crear_persona(scanner);

        assertNotNull(persona);
        assertTrue(persona.get_sano());
        assertFalse(persona.get_sintomas());
        assertTrue(persona.get_contacto());
        assertFalse(persona.get_pasado_covid());
        assertTrue(persona.get_cartilla());
    }

    // Test para crear una persona con entradas inválidas seguidas de válidas
    @Test
    void testCrearPersona_InvalidThenValidInput() {
        String input = "x\ns\nx\nn\ns\nn\ns\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Persona persona = App.crear_persona(scanner);

        assertNotNull(persona);
        assertTrue(persona.get_sano());
        assertFalse(persona.get_sintomas());
        assertTrue(persona.get_contacto());
        assertFalse(persona.get_pasado_covid());
        assertTrue(persona.get_cartilla());
    }

    // Test para crear un espacio con entrada válida
    @Test
    void testCrearEspacio_ValidInput() {
        String input = "25\n60\ns\nn\ns\n100\nn\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Espacio espacio = App.crear_espacio(scanner);

        assertNotNull(espacio);
        assertEquals(25, espacio.get_temperatura());
        assertEquals(60, espacio.get_humedad());
        assertTrue(espacio.get_nieva());
        assertFalse(espacio.get_llueve());
        assertTrue(espacio.get_nublado());
        assertEquals(100, espacio.get_aforo_max_actividad());
        assertFalse(espacio.get_confinada());
    }

    // Test para crear un espacio con entradas inválidas seguidas de válidas
    @Test
    void testCrearEspacio_InvalidThenValidInput() {
        String input = "abc\n30\nxyz\n50\ns\nx\nn\ns\n100\nn\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Espacio espacio = App.crear_espacio(scanner);

        assertNotNull(espacio);
        assertEquals(30, espacio.get_temperatura());
        assertEquals(50, espacio.get_humedad());
        assertTrue(espacio.get_nieva());
        assertFalse(espacio.get_llueve());
        assertTrue(espacio.get_nublado());
        assertEquals(100, espacio.get_aforo_max_actividad());
        assertFalse(espacio.get_confinada());
    }

    // Test de setters y getters de Persona
    @Test
    void testSettersAndGettersPersona() {
        Persona persona = new Persona(true, false, true, true, false);

        persona.set_sano(false);
        persona.set_sintomas(true);
        persona.set_contacto(false);
        persona.set_pasado_covid(false);
        persona.set_cartilla(true);

        assertFalse(persona.get_sano());
        assertTrue(persona.get_sintomas());
        assertFalse(persona.get_contacto());
        assertFalse(persona.get_pasado_covid());
        assertTrue(persona.get_cartilla());
    }

    // Test del método toString() de Persona
    @Test
    void testToString() {
        Persona persona = new Persona(true, false, true, true, false);
        String expectedOutput = "Sano: true\nSintomas: false\nContacto: true\nPasado Covid: true\nCartilla en regla: false";

        assertEquals(expectedOutput, persona.to_string());
    }
}
