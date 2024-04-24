package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] provincias = Provincia.values();
		for(Provincia provincia:provincias) {
			System.out.println("Nombre: "+provincia.name());
			System.out.printf("Poblacion: %,d personas%n",provincia.getCantidadPoblacion());
			System.out.printf("Superficie: %,.2f Km²%n",provincia.getSuperficie());
			System.out.printf("Densidad de poblacion: %,.2f personas/Km²%n",provincia.calcularDensidad());
		}
	}

}
