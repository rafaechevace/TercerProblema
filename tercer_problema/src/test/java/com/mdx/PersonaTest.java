package com.mdx;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PersonaTest {

    @Test
    void testSettersAndGetters() {
        Persona persona = new Persona(false, false, false, false, false);

        assertFalse(persona.get_sano());
        assertFalse(persona.get_sintomas());
        assertFalse(persona.get_contacto());
        assertFalse(persona.get_pasado_covid());
        assertFalse(persona.get_cartilla());

        persona.set_sano(true);
        persona.set_sintomas(true);
        persona.set_contacto(true);
        persona.set_pasado_covid(true);
        persona.set_cartilla(true);

        assertTrue(persona.get_sano());
        assertTrue(persona.get_sintomas());
        assertTrue(persona.get_contacto());
        assertTrue(persona.get_pasado_covid());
        assertTrue(persona.get_cartilla());
    }

    @Test
    void testToString() {

        Persona persona = new Persona(true, false, true, true, false);

        String resultadoEsperado = "Sano: true\n"
                                 + "Sintomas: false\n"
                                 + "Contacto: true\n"
                                 + "Pasado Covid: true\n"
                                 + "Cartilla en regla: false";

        assertEquals(resultadoEsperado, persona.to_string());
    }
}
