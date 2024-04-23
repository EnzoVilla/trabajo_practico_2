package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Producto>productos =new ArrayList<>();
		int opcionMenu,opcionEnumeradosCategorias,opcionEnumeradosOrigenes,encontrado=0;
		String codigo,codigoModificar;
		String descripcion;
		float precio;
		OrigenFabricacion origen=null;
		Categoria categoria=null;
		
		do {
			System.out.println("----- MENU -----");
			System.out.println("1) Crear producto");
			System.out.println("2) Mostrar productos");
			System.out.println("3) Modificar producto");
			System.out.println("4) Salir");
			System.out.println("Ingrese opcion:");
			opcionMenu = sc.nextInt();
			sc.nextLine();
			switch(opcionMenu) {
				case 1: System.out.println("----- CREANDO PRODUCTO -----");
						System.out.println("codigo del producto:");
						codigo=sc.nextLine();
						System.out.println("descripcion:");
						descripcion=sc.nextLine();
						do {
							try {
								System.out.println("precio:");
								precio=sc.nextFloat();
								if(precio<=0)
									System.out.println("Error en el precio, no puede ser 0 o menos");
							}
							catch(InputMismatchException e) {
								System.out.println("Se pide un dato numerico, intente de nuevo");
								precio=0;
								sc.nextLine();
							}		
						}while(precio<=0);
						do {
							try {
								presentacionCategorias();
								opcionEnumeradosCategorias=sc.nextInt();
								if(opcionEnumeradosCategorias<1 || opcionEnumeradosCategorias>4)
									System.out.println("Se pide una opcion entre 1 y 4");
							}catch(InputMismatchException e) {
								System.out.println("Se pide un dato numerico, intente de nuevo");
								opcionEnumeradosCategorias=0;
								sc.nextLine();
							}
						}while(opcionEnumeradosCategorias<1 || opcionEnumeradosCategorias>4);
						do {
							try {
								presentacionOrigenes();
								opcionEnumeradosOrigenes=sc.nextInt();
								if(opcionEnumeradosOrigenes<1 || opcionEnumeradosOrigenes>4)
									System.out.println("Se pide una opcion entre 1 y 4");
							}catch(InputMismatchException e) {
								System.out.println("Se pide un dato numerico, intente de nuevo");
								opcionEnumeradosOrigenes=0;
								sc.nextLine();
							}
						}while(opcionEnumeradosOrigenes<1 || opcionEnumeradosOrigenes>4);
						switch(opcionEnumeradosOrigenes) {
							case 1: origen = OrigenFabricacion.ARGENTINA;break;
							case 2: origen = OrigenFabricacion.CHINA;break;		
							case 3: origen = OrigenFabricacion.BRASIL;break;
							case 4: origen = OrigenFabricacion.URUGUAY;break;
						}
						switch(opcionEnumeradosCategorias) {
							case 1: categoria = Categoria.TELEFONIA;break;
							case 2: categoria = Categoria.INFORMATICA;break;
							case 3: categoria = Categoria.ELECTROHOGAR;break;
							case 4: categoria = Categoria.HERRAMIENTAS;break;
						}
						productos.add(new Producto(codigo, descripcion, precio, origen, categoria));
						break;
				case 2: System.out.println("----- PRODUCTOS -----");
						if(productos.size()==0)
							System.out.println("No se han registrado productos por el momento");
						else 
							productos.forEach(prod->System.out.println(prod.toString()));
						break;
				case 3: System.out.println("----- MODIFICACION DE PRODUCTO -----");
						System.out.println("Ingrese codigo para asegurar su existencia");
						codigoModificar=sc.nextLine();
						Iterator<Producto>iteratorModificar = productos.iterator();
						while(iteratorModificar.hasNext()) {
							Producto p = iteratorModificar.next();
							if(p.getCodigo().equals(codigoModificar)) {
								System.out.println("Producto existente");
								System.out.println(p.toString());
								encontrado++;
								System.out.println("nueva descripcion:");
								p.setDescripcion(sc.nextLine());
								do {
									try {
										System.out.println("precio:");
										precio=sc.nextFloat();
										if(precio<=0)
											System.out.println("Error en el precio, no puede ser 0 o menos");
									}
									catch(InputMismatchException e) {
										System.out.println("Se pide un dato numerico, intente de nuevo");
										precio=0;
										sc.nextLine();
									}		
								}while(precio<=0);
								p.setPrecioUnitario(precio);
								do {
									try {
										presentacionCategorias();
										opcionEnumeradosCategorias=sc.nextInt();
										if(opcionEnumeradosCategorias<1 || opcionEnumeradosCategorias>4)
											System.out.println("Se pide una opcion entre 1 y 4");
									}catch(InputMismatchException e) {
										System.out.println("Se pide un dato numerico, intente de nuevo");
										opcionEnumeradosCategorias=0;
										sc.nextLine();
									}
								}while(opcionEnumeradosCategorias<1 || opcionEnumeradosCategorias>4);
								do {
									try {
										presentacionOrigenes();
										opcionEnumeradosOrigenes=sc.nextInt();
										if(opcionEnumeradosOrigenes<1 || opcionEnumeradosOrigenes>4)
											System.out.println("Se pide una opcion entre 1 y 4");
									}catch(InputMismatchException e) {
										System.out.println("Se pide un dato numerico, intente de nuevo");
										opcionEnumeradosOrigenes=0;
										sc.nextLine();
									}
								}while(opcionEnumeradosOrigenes<1 || opcionEnumeradosOrigenes>4);
								switch(opcionEnumeradosOrigenes) {
									case 1: p.setOrigenFabricacion(OrigenFabricacion.ARGENTINA);break;
									case 2: p.setOrigenFabricacion(OrigenFabricacion.CHINA);break;		
									case 3: p.setOrigenFabricacion(OrigenFabricacion.BRASIL);break;
									case 4: p.setOrigenFabricacion(OrigenFabricacion.URUGUAY);break;
								}
								switch(opcionEnumeradosCategorias) {
									case 1: p.setCategoria(Categoria.TELEFONIA);break;
									case 2: p.setCategoria(Categoria.INFORMATICA);break;
									case 3: p.setCategoria(Categoria.ELECTROHOGAR);break;
									case 4: p.setCategoria(Categoria.HERRAMIENTAS);break;
								}
							  System.out.println("Datos cambiados correctamente");
							}
						}
						if(encontrado==0)
							System.out.println("No existe un producto con el codigo: "+codigoModificar);
						break;
				case 4:System.out.println("Fin del programa"); ;break;
				default:;
			}
		}while(opcionMenu!=4);
		sc.close();
	}
	public static void presentacionCategorias(){
		System.out.println("----- CATEGORIAS -----");
		System.out.println("1) Telefonia");
		System.out.println("2) Informatica");
		System.out.println("3) Electrohogar");
		System.out.println("4) Herramientas");
		System.out.println("Ingrese opcion:");
	}
	public static void presentacionOrigenes() {
		System.out.println("----- ORIGEN DE FABRICACION -----");
		System.out.println("1) Argentina");
		System.out.println("2) China");
		System.out.println("3) Brasil");
		System.out.println("4) Uruguay");
		System.out.println("Ingrese opcion:");
	}
}
