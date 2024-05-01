package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

public class Main {

	public static void main(String[] args) {
		List<Producto>productos = new ArrayList<>();
		List<Producto>carrito = new ArrayList<>();
		productos.add(new Producto("AA01", "Iphone 15 Pro max", 1750.75f , OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true));
		productos.add(new Producto("AA02", "Cortadora de cesped Daewoo", 1125.50f , OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto("AA03", "Monitor LG 32 pulgadas", 1600 , OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, false));
		productos.add(new Producto("AA04", "Freidora de aire Huawei", 1100.25f , OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("AA05", "Samsung s24 Ultra", 1850 , OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
		productos.add(new Producto("AA06", "Set de desarmadores Phillips", 800 , OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto("AA07", "Pava electrica Philco", 1210.25f , OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, false));
		productos.add(new Producto("AA08", "Notebook Hp ryzen 9", 2750.50f , OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, false));
		productos.add(new Producto("AA09", "Tira led Phillips 5 metros", 524 , OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("AA10", "Martillo punta de goma", 150.50f , OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto("AA11", "Soldadora Yamaha", 2330.60f , OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto("AA12", "Mouse Red Dragon", 450.50f , OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
		productos.add(new Producto("AA13", "Parlante Jbl", 950.35f , OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("AA14", "Placa de video Nvidia", 3540 , OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		productos.add(new Producto("AA15", "Poco phone f5", 2150.25f , OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true));
		Scanner sc = new Scanner(System.in);
		int opMenu = 0, opFormaPago=0,encontrado=0,totalProductos=0;
		String codigoModificar,masProductos;
		boolean opcionErronea;
		do {
			System.out.println("----- MENU -----");
			System.out.println("1) Mostrar productos");
			System.out.println("2) Realizar compra");
			System.out.println("3) Salir");
			try {
				System.out.println("Ingrese una opcion");
				opMenu=sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Se pide un dato numerico, intente de nuevo");
				opMenu=0;
				sc.nextLine();
			}
			switch(opMenu) {
				case 1: productos.forEach(prod -> System.out.println(prod.mostrarProductosPto5()));break;
				case 2: System.out.println("----- ARMANDO CARRITO -----");
						sc.nextLine();
						do{
							System.out.println("Ingrese codigo del producto para añadir al carrito");
							codigoModificar=sc.nextLine();
							Iterator<Producto>iteratorBuscar = productos.iterator();
							while(iteratorBuscar.hasNext()) {
								Producto p = iteratorBuscar.next();
								if(p.getCodigo().equals(codigoModificar) && p.isEstado() == true) {
									carrito.add(p);
									encontrado++;
									totalProductos++;
									System.out.println("Producto añadido al carrito ("+totalProductos+" productos añadidos)");
									System.out.println("Añadido: "+p.getDescripcion());
								}
								if(p.getCodigo().equals(codigoModificar) && p.isEstado()==false) {
									encontrado++;
									System.out.println("No hay stock del producto: "+p.getDescripcion());
								}
							}
							if(encontrado==0) {
								System.out.println("No existe un producto con el codigo: "+codigoModificar);
							}
							System.out.println("Desea agregar mas productos: s/n");
							masProductos=sc.nextLine();
							opcionErronea=(masProductos.toUpperCase().equals("S")==false && masProductos.toUpperCase().equals("N")==false) ;
							encontrado=0;
							if(opcionErronea)
								System.out.println("Se esta ingresando una opcion incorrecta, responder s/n");
						}while(masProductos.toUpperCase().equals("S") || opcionErronea);
						if(totalProductos==0)
							System.out.println("No hay ningun producto en el carrito");
						else {
							do {
								System.out.println("----- OPCIONES DE PAGO -----");
								System.out.println("1) Pago en efectivo");
								System.out.println("2) Pago con tarjeta");
								try {
									System.out.println("Ingrese una opcion");
									opFormaPago=sc.nextInt();
								}catch(InputMismatchException e) {
									System.out.println("Se pide un dato numerico");
									opFormaPago=0;
									sc.nextLine();
								}
								double sumaCarrito=0;
								Iterator<Producto> carritoTotal = carrito.iterator();
								while(carritoTotal.hasNext()) {
									Producto p = carritoTotal.next();
									sumaCarrito = sumaCarrito + p.getPrecioUnitario();
								}
								switch(opFormaPago) {
									case 1: PagoEfectivo efectivo = new PagoEfectivo();
											efectivo.realizarPago(sumaCarrito);
											efectivo.imprimirRecibo();
											break;
									case 2: PagoTarjeta tarjeta = new PagoTarjeta();
											sc.nextLine();
											System.out.println("Ingrese numero de tarjeta:");
											tarjeta.setNumeroTarjeta(sc.nextLine());
											tarjeta.realizarPago(sumaCarrito);
											tarjeta.imprimirRecibo();
								}
							}while(opFormaPago!=1 && opFormaPago!=2);
						}
						carrito.clear();
						totalProductos=0;
						break;
				case 3: System.out.println("Fin del programa");break;
				default: System.out.println("Opcion incorrecta");
			}	
		}while(opMenu!=3);
		sc.close();
	}

}
