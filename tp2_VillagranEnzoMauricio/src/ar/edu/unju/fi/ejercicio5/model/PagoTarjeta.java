package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroTarjeta;
	private LocalDate fechaPago = LocalDate.now();
	private double montoPagado;
	@Override
	public void imprimirRecibo() {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yy");
		System.out.println("----- RECIBO -----");
		System.out.println("Numero de tarjeta: "+numeroTarjeta);
		System.out.println("Fecha de pago: "+ fechaPago.format(formateador));
		System.out.printf("Monto pagado: $%,.2f \n",montoPagado);
		
	}
	@Override
	public void realizarPago(double monto) {
		montoPagado = monto+(monto*15/100);
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
}
