package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;



public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombre,apellido,nacionalidad;
		int opcion,posicionAuxiliar;
		float estatura,peso;
		LocalDate anioActual = LocalDate.now();
		Posicion posicion=null;
		List<Jugador>jugadores = new ArrayList<>();
		do {
			System.out.println("------- MENU -------");
			System.out.println("1) Alta de un jugador");
			System.out.println("2) Mostrar todos los jugadores");
			System.out.println("3) Modificar datos de un jugador");
			System.out.println("4) Eliminar un jugador");
			System.out.println("5) Salir");
			System.out.println("Ingrese opcion: ");
			try{
				opcion = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Las opciones solo aceptan dato de tipo numerico del 1 al 5");
				opcion = 6;
			}
			sc.nextLine();
			switch(opcion) {
			 case 1: System.out.println("------- NUEVO JUGADOR -------");
				 	 System.out.println("Ingrese nombre:"); 
				 	 nombre = sc.nextLine();
				 	 System.out.println("Ingrese apellido:"); 
				 	 apellido = sc.nextLine();
				 	 System.out.println("Ingrese nacionalidad:"); 
				 	 nacionalidad = sc.nextLine();
				 	 do {
				 		 try {
				 			 posiciones();
				 			 posicionAuxiliar = sc.nextInt();
				 			 if(posicionAuxiliar<1 || posicionAuxiliar>4)
				 				 System.out.println("Solo hay opciones validas entre 1 y 4");
				 		 }
				 		 catch(InputMismatchException e) {
				 			System.out.println("Se pide un dato numerico, intente de nuevo");
				 			posicionAuxiliar=0;
				 			sc.nextLine();
				 		 }
				 	 }while(posicionAuxiliar<1 || posicionAuxiliar>4);
				 	 switch(posicionAuxiliar) {
					 	 case 1:posicion=Posicion.DELANTERO;break;
					 	 case 2:posicion=Posicion.MEDIO;break;
					 	 case 3:posicion=Posicion.DEFENSA;break;
					 	 case 4:posicion=Posicion.ARQUERO;break;
				 	 } 	 
				 	 do {
				 		 try {
				 			 System.out.println("Ingrese estatura:"); 
						 	 estatura = sc.nextFloat(); 
						 	 if(estatura<=0)
						 		 System.out.println("Error en la estatura, no puede medir 0 o menos");
				 		 }catch(InputMismatchException e) {
				 			System.out.println("Se pide un dato numerico, intente de nuevo");
							estatura=0;
							sc.nextLine();
				 		 }
				 	 }while(estatura<=0); 
				 	do {
				 		 try {
				 			 System.out.println("Ingrese peso:"); 
						 	 peso = sc.nextFloat(); 
						 	 if(peso<=0)
						 		 System.out.println("Error en el peso, no puede pesar 0 o menos");
				 		 }catch(InputMismatchException e) {
				 			System.out.println("Se pide un dato numerico, intente de nuevo");
							peso=0;
							sc.nextLine();
				 		 }
				 	 }while(peso<=0);
				 	int anio; 
				 	System.out.println("Fecha de Nacimiento");
				 	do {
					 	 try {
					 		 System.out.println("Ingrese año:");
					 		 anio = sc.nextInt();
					 		 if(anio<=1900 || anio>anioActual.getYear())
					 			 System.out.println("Los años validos estan entre el 1900 y "+anioActual.getYear());
					 	 }catch(InputMismatchException e) {
					 		 System.out.println("Error en la fecha, se introdujo una cadena, se pide el numero de año");
					 		 anio=0;
					 		 sc.nextLine();
					 	 }
				 	}while(anio<=1900 || anio>anioActual.getYear());
				 	 int mes;
				 	 do {
				 		try {
					 		System.out.println("Ingrese mes:");
						 	mes = sc.nextInt();
						 	if(mes<=0 || mes>12)
						 		System.out.println("Los meses son validos unicamente si estan entre 1 y 12");
					 	 }catch(InputMismatchException e) {
					 		 System.out.println("Error en la fecha, se introdujo una cadena, se pide el numero del mes");
					 		 mes=0;
					 		 sc.nextLine();
					 	 }
				 	 }while(mes<=0 || mes>12);
				 	 int dia ;
				 	 int diasMes=diasSegunMes(mes,anio);
				 	 do {
				 		 try {
				 			 System.out.println("Ingrese dia:"); 
						 	 dia = sc.nextInt();
						 	 if(dia<=0 || dia>diasMes) {
						 		if(anio%4==0) {
							 		 System.out.println(anio+" es año bisiesto");
							     }
						 		 System.out.println("Para el mes:"+mes+"\nLos dias son validos unicamente si estan entre 1 y "+diasMes);
						 	 }
				 		 }catch(InputMismatchException e) {
					 		 System.out.println("Error en la fecha, se introdujo una cadena, se pide el numero de dia");
					 		 dia=0;
					 		 sc.nextLine();
					 	 }
				 	 }while(dia<=0 || dia>diasMes); 	 
				 	 LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
				 	 jugadores.add(new Jugador(nombre, apellido, nacionalidad, estatura, peso, posicion, fechaNacimiento));
				 	 break;
			 case 2: System.out.println("------- JUGADORES -------");
				 	 if(jugadores.size()==0)
				 		 System.out.println("No hay jugadores registrados por el momento");
				 	 else
				 		 jugadores.forEach(jug->System.out.println(jug.toString()));
				 	 break;
			 case 3: System.out.println("------- MODIFICAR JUGADOR -------");
				 	 System.out.println("Ingrese nombre:"); 
				 	 String nombreModificar = sc.nextLine();
				 	 System.out.println("Ingrese apellido:");
				 	 String apellidoModificar = sc.nextLine();
				 	 Iterator<Jugador>iteratorModificar = jugadores.iterator();
				 	 int encontradoModificar = 0;
					 while(iteratorModificar.hasNext()) {
						Jugador j = iteratorModificar.next();
						if(j.getNombre().equals(nombreModificar) && j.getApellido().equals(apellidoModificar)) {
							do {
						 		 try {
						 			 posiciones();
						 			 posicionAuxiliar = sc.nextInt();
						 			 if(posicionAuxiliar<1 || posicionAuxiliar>4)
						 				 System.out.println("Solo hay opciones validas entre 1 y 4");
						 		 }
						 		 catch(InputMismatchException e) {
						 			System.out.println("Se pide un dato numerico, intente de nuevo");
						 			posicionAuxiliar=0;
						 			sc.nextLine();
						 		 }
						 	 }while(posicionAuxiliar<1 || posicionAuxiliar>4);
						 	 switch(posicionAuxiliar) {
							 	 case 1:j.setPosicion(Posicion.DELANTERO);break;
							 	 case 2:j.setPosicion(Posicion.MEDIO);break;
							 	 case 3:j.setPosicion(Posicion.DEFENSA);break;
							 	 case 4:j.setPosicion(Posicion.ARQUERO);break;
						 	 } 	 
							System.out.println("------- CAMBIOS REALIZADOS -------");
							System.out.println("Nuevos datos: ");
							System.out.println(j.toString());
							encontradoModificar++;
						}
					 }
					 if(encontradoModificar == 0)
							System.out.println("No hay nigun jugador registrado como: "+nombreModificar+" "+apellidoModificar);
				 	 break;
			 case 4: System.out.println("------- ELIMINAR JUGADOR -------");
				     System.out.println("Ingrese nombre:"); 
				 	 String nombreEliminar = sc.nextLine();
				 	 System.out.println("Ingrese apellido:");
				 	 String apellidoEliminar = sc.nextLine();
				 	 Iterator<Jugador>iteratorEliminar = jugadores.iterator();
				 	 int encontradoEliminar = 0;
					 while(iteratorEliminar.hasNext()) {
						Jugador j = iteratorEliminar.next();
						if(j.getNombre().equals(nombreEliminar) && j.getApellido().equals(apellidoEliminar)) {
							System.out.println("Jugador a eliminar:\n"+j.toString());
							iteratorEliminar.remove();
							System.out.println("Jugador eliminado con exito");
							encontradoEliminar++;
						}
					 }
					 if(encontradoEliminar == 0)
						 System.out.println("No hay nigun jugador registrado como: "+nombreEliminar+" "+apellidoEliminar);
				     break;
			 case 5: System.out.println("------- FIN DEL PROGRAMA -------");
			 		 break;
			 default: System.out.println("Opcion invalida, vuelva a elegir :)");
			}
		} while(opcion != 5);
		sc.close();
	}
	public static int diasSegunMes(int mes,int anio) {
		int dias=0;
		switch(mes) {
			case 2: dias= anio%4 == 0? 29:28 ; //para saber si es bisiesto o no
					break;
			
			case 1,3,5,7,8,10,12: dias=31;
							  	  break;
			case 4,6,9,11: dias=30;
							break;
		
		}
		return dias;
	}
	public static void posiciones() {
		System.out.println("SELECCIONE POSICION: "); 
		System.out.println("1) DELANTERO");
		System.out.println("2) MEDIO");
		System.out.println("3) DEFENSA");
		System.out.println("4) ARQUERO");
		System.out.println("Ingrese una opcion");
	}
}
