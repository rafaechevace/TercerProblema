package com.mdx;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class OpcionNoValidaExceptionTest {

    @Test
    void testConstructorWithMessage() {
        String mensajeEsperado = "Error, opción no válida";
        
        OpcionNoValidaException exception = new OpcionNoValidaException(mensajeEsperado);
        
        assertEquals(mensajeEsperado, exception.getMessage());
    }

    @Test
    void testExceptionInheritance() {
        OpcionNoValidaException exception = new OpcionNoValidaException("Test");
        assertTrue(exception instanceof Exception);
    }
}
