package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private String nacionalidad;
	private float estatura;
	private float peso;
	private Posicion posicion;
	private LocalDate fechaNacimiento;
	public Jugador() {
		// TODO Auto-generated constructor stub
	}
	public Jugador(String nombre, String apellido, String nacionalidad, float estatura, float peso, Posicion posicion,
			LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public float getEstatura() {
		return estatura;
	}
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", nacionalidad=" + nacionalidad + ", estatura="
				+ estatura + ", peso=" + peso + ", posicion=" + posicion + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	public int calcularEdad() {
		LocalDate hoy = LocalDate.now();
		Period period = Period.between(fechaNacimiento,hoy);
		return period.getYears();
	}
}
