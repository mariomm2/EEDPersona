package com.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Persona;

package com.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PersonasTest {

    @Test
    public void testConstructorPorDefecto() {
        Persona persona = new Persona();
        assertEquals("", persona.getNombre());
        assertEquals(0, persona.getEdad());
        assertEquals('H', persona.getSexo()); 
        assertEquals(0, persona.getPeso());
        assertEquals(0, persona.getAltura());
        assertNotNull(persona.getDNI()); 
    }

    @Test
    public void testConstructorConParametros() {
        Persona persona = new Persona("Mario", 20, 'M', 70, 1.75);
        assertEquals("Mario", persona.getNombre());
        assertEquals(20, persona.getEdad());
        assertEquals('M', persona.getSexo());
        assertEquals(70, persona.getPeso());
        assertEquals(1.75, persona.getAltura());
        assertNotNull(persona.getDNI());
    }

    @Test
    public void testComprobarSexo() {
        Persona persona1 = new Persona("Maria", 25, 'M');
        assertEquals('M', persona1.getSexo());

        Persona persona2 = new Persona("Alvaro", 24, 'X'); 
        assertEquals('H', persona2.getSexo()); 
    }

    @Test
    public void testCalcularIMC() {
        Persona persona = new Persona("Luis", 30, 'H', 70, 1.75);
        assertEquals(Persona.PESO_IDEAL, persona.calcularIMC());

        Persona personaBajoPeso = new Persona("Ana", 25, 'M', 45, 1.75);
        assertEquals(Persona.INFRAPESO, personaBajoPeso.calcularIMC());

        Persona personaSobrePeso = new Persona("Jose", 40, 'H', 90, 1.75);
        assertEquals(Persona.SOBREPESO, personaSobrePeso.calcularIMC());
    }

    @Test
    public void testCalcularIMC_AlturaCero() {
        Persona persona = new Persona("Pedro", 35, 'H', 70, 0);
        Exception exception = assertThrows(IllegalArgumentException.class, persona::calcularIMC);
        assertEquals("La altura debe ser mayor que 0.", exception.getMessage());
    }

    @Test
    public void testEsMayorDeEdad() {
        Persona personaMayor = new Persona("Lucía", 20, 'M');
        assertTrue(personaMayor.esMayorDeEdad());

        Persona personaMenor = new Persona("David", 17, 'H');
        assertFalse(personaMenor.esMayorDeEdad());
    }

    @Test
    public void testSetters() {
        Persona persona = new Persona();
        persona.setNombre("Sofía");
        persona.setEdad(22);
        persona.setSexo('M');
        persona.setPeso(60);
        persona.setAltura(1.65);

        assertEquals("Sofía", persona.getNombre());
        assertEquals(22, persona.getEdad());
        assertEquals('M', persona.getSexo());
        assertEquals(60, persona.getPeso());
        assertEquals(1.65, persona.getAltura());
    }

}
