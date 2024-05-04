package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Producto>productos = new ArrayList<>();
		int opcionMenu;
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
		do {
			System.out.println("----- MENU -----");
			System.out.println("1) Mostrar productos (con stock)");
			System.out.println("2) Mostrar productos (sin stock)");
			System.out.println("3) Incrementar precios de los productos");
			System.out.println("4) Productos de ELECTROHOGAR con stock");
			System.out.println("5) Ordenar productos por precio descendente");
			System.out.println("6) Todos los productos en mayuscula");
			System.out.println("7) Salir");
			try {
				System.out.println("Ingrese una opcion");
				opcionMenu = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Se pide un dato numerico!!!");
				opcionMenu = 0;
				sc.nextLine();
			}
			switch(opcionMenu) {
			case 1:	Consumer<Producto> stock = p-> {
						if(p.isEstado())
							System.out.println(p.mostrarProductosPto5());
					};
					productos.forEach(stock);
					break;
			case 2:	Predicate<Producto> noStock = n -> n.isEstado()==false;
					List<Producto> sinStock = productos.stream().filter(noStock).collect(Collectors.toList());
					sinStock.forEach(st->System.out.println(st.mostrarProductosPto5()));
					break;
			case 3: Function<Producto,Producto> incremento = (i) -> {
							i.setPrecioUnitario(i.getPrecioUnitario()+(i.getPrecioUnitario()*20/100));
							return i;
					};
					List<Producto> productosIncrementados = productos.stream().map(incremento).collect(Collectors.toList());
					productosIncrementados.forEach(pi->System.out.println(pi.mostrarProductosPto5()));
					break;
			case 4:	Predicate<Producto> categoriaStock = c -> c.getCategoria() == Categoria.ELECTROHOGAR && c.isEstado()==true;
					List<Producto> segunCategoriaStock = productos.stream().filter(categoriaStock).collect(Collectors.toList());
					segunCategoriaStock.forEach(se -> System.out.println(se.mostrarProductosPto5()));
					break;
			case 5: productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
					productos.forEach(pr->System.out.println(pr.mostrarProductosPto5()));
					break;
			case 6: Function<Producto,Producto> mayusculas = m-> {
						m.setDescripcion(m.getDescripcion().toUpperCase());
						return m;
					};
					List<Producto> productosMayuscula = productos.stream().map(mayusculas).collect(Collectors.toList());
					productosMayuscula.forEach(pm->System.out.println(pm.mostrarProductosPto5()));
					break;
			case 7:System.out.println("Fin del programa");break;
			default: System.out.println("Opcion incorrecta");
			}
		}while(opcionMenu!=7);
		sc.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
