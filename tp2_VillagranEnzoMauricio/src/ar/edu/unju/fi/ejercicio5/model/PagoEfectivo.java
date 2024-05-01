package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago{
	private double montoPagado;
	private LocalDate fechaPago = LocalDate.now();
	@Override
	public void imprimirRecibo() {
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yy");
		System.out.println("----- RECIBO -----");
		System.out.println("Fecha de pago: "+ fechaPago.format(formateador));
		System.out.printf("Monto pagado: $%,.2f \n",montoPagado);
	}
	@Override
	public void realizarPago(double monto) {
		montoPagado = monto-(monto*10/100);
	}

}
