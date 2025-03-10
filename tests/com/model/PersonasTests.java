package com.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Persona;

class PersonasTests {

	private Persona persona;
	
	@BeforeEach
    void setUp() {
        persona = new Persona("Mario", 25, 'H', 70, 1.70);
    }

	@Test
    void testConstructorPorDefecto() {
        Persona p = new Persona();
        assertEquals("", p.getNombre());
        assertEquals(0, p.getEdad());
        assertEquals('H', p.getSexo());
        assertEquals(0, p.getPeso());
        assertEquals(0, p.getAltura());
    }

    @Test
    void testConstructorConParametros() {
        assertEquals("Mario", persona.getNombre());
        assertEquals(25, persona.getEdad());
        assertEquals('H', persona.getSexo());
        assertEquals(70, persona.getPeso());
     }

    @Test
    void testCalcularIMC_PesoIdeal() {
        assertEquals(Persona.PESO_IDEAL, persona.calcularIMC());
    }

    @Test
    void testCalcularIMC_Sobrepeso() {
        persona.setPeso(90);
        assertEquals(Persona.SOBREPESO, persona.calcularIMC());
    }

    @Test
    void testCalcularIMC_Infrapeso() {
        persona.setPeso(45);
        assertEquals(Persona.INFRAPESO, persona.calcularIMC());
    }
}
