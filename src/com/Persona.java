package com;

public class Persona {

    private static final char SEXO_DEF = 'H';
    public static final int INFRAPESO = -1;
    public static final int PESO_IDEAL = 0;
    public static final int SOBREPESO = 1;

    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;

    public Persona() {
        this("", 0, SEXO_DEF, 0, 0);
    }

    public Persona(String nombre, int edad, char sexo) {
        this(nombre, edad, sexo, 0, 0);
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;

        generarDni();
        comprobarSexo();
    }

    private void comprobarSexo() {
        if (sexo != 'H' && sexo != 'M') {
            this.sexo = SEXO_DEF;
        }
    }

    private void generarDni() {
        final int divisor = 23;
        
        // Cambio al calcular el numero aleatorio del DNI al redondear
        int numDNI = (int) (Math.random() * (90000000)) + 10000000;
        
        // Cambio para simplificar el calculo del resto
        int res = numDNI % divisor;
        char letraDNI = generaLetraDNI(res);
        DNI = numDNI + String.valueOf(letraDNI);
    }

    private char generaLetraDNI(int res) {
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
                'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
                'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letras[res];
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Cambio en el setter para que el resultado sea positivo
    public void setSexo(char sexo) {
        this.sexo = sexo;
        comprobarSexo();
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC() {
        // Cambio para evitar la division por 0
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que 0.");
        }
        double pesoActual = peso / (altura * altura);
        if (pesoActual >= 20 && pesoActual <= 25) {
            return PESO_IDEAL;
        } else if (pesoActual < 20) {
            return INFRAPESO;
        } else {
            return SOBREPESO;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        String sexoStr = (sexo == 'H') ? "hombre" : "mujer";
        return "Información de la persona:\n" +
                "Nombre: " + nombre + "\n" +
                "Sexo: " + sexoStr + "\n" +
                "Edad: " + edad + " años\n" +
                "DNI: " + DNI + "\n" +
                "Peso: " + peso + " kg\n" +
                "Altura: " + altura + " metros\n";
    }

	public Integer getEdad() {
		return null;
	}

	public Object getNombre() {
		return null;
	}

	public Integer getSexo() {
		return null;
	}

	public Integer getPeso() {
		return null;
	}

	public Integer getAltura() {
		return null;
	}
}
