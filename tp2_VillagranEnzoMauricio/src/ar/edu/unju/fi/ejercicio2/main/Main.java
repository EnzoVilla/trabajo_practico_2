package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		List<Efemeride>efemerides = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int opcionMenu = 0,dia=0,mesAuxiliar,diaAuxiliar;
		String codigo,detalle,codigoAuxiliar;
		Mes mes=null;
		do {
			do {
				try {
					menu();
					opcionMenu = sc.nextInt();
					if(opcionMenu < 1 || opcionMenu > 5)
						System.out.println("solo hay opciones validas entre 1 y 5");
				}catch(InputMismatchException e) {
					System.out.println("Se esperaba un dato númerico");
					opcionMenu=0;
					sc.nextLine();
				}
			}while(opcionMenu < 1 || opcionMenu > 5);
			sc.nextLine();
			switch(opcionMenu) {
				case 1: System.out.println("----- CREACION DE EFEMERIDES -----");
				        System.out.println("Codigo: ");
				        codigo=sc.nextLine();
				        System.out.println("Detalles:");
				        detalle=sc.nextLine();
				        do {
				        	 try {
						        System.out.println("Indique NUMERO del mes");
							    mesAuxiliar=sc.nextInt();
							    if(mesAuxiliar < 1 || mesAuxiliar > 12)
							    	System.out.println("Los meses van unicamente entre 1 y 12");
						     }catch(InputMismatchException e) {
						        System.out.println("Se esperaba un dato númerico");
								mesAuxiliar=0;
								sc.nextLine();
						     }
				        }while(mesAuxiliar < 1 || mesAuxiliar > 12);
				        switch(mesAuxiliar) {
					        case 1:mes = Mes.ENERO;break;
					        case 2:mes = Mes.FEBRERO;break;
					        case 3:mes = Mes.MARZO;break;
					        case 4:mes = Mes.ABRIL;break;
					        case 5:mes = Mes.MAYO;break;
					        case 6:mes = Mes.JUNIO;break;
					        case 7:mes = Mes.JULIO;break;
					        case 8:mes = Mes.AGOSTO;break;
					        case 9:mes = Mes.SEPTIEMBRE;break;
					        case 10:mes = Mes.OCTUBRE;break;
					        case 11:mes = Mes.NOVIEMBRE;break;
					        case 12:mes = Mes.DICIEMBRE;break;
				        }
				        diaAuxiliar= diasSegunMes(mesAuxiliar);
				        do {
				        	try {
				        		System.out.println("Ingrese numero del dia");
				        		dia=sc.nextInt();
				        		if(dia<1 || dia>diaAuxiliar)
				        			System.out.println("Los dias solo son entre 1 y "+diaAuxiliar);
				        	}catch(InputMismatchException e) {
				        		System.out.println("Se esperaba un dato númerico");
								dia=0;
								sc.nextLine();
				        	}
				        }while(dia<1|| dia>diaAuxiliar);
				        efemerides.add(new Efemeride(codigo, mes, dia, detalle));
				        System.out.println("Añadido correctamente");
						break;
				case 2: if(efemerides.size()==0)
							System.out.println("No se creo ninguna efeméride por el momento");
						else
							efemerides.forEach(ef->System.out.println(ef.toString()));
						break;
				case 3: System.out.println("----- ELIMINAR EFEMERIDE -----");
						System.out.println("Ingrese codigo de la efeméride:");
						codigoAuxiliar=sc.nextLine();
						Iterator<Efemeride>iteratorEliminar = efemerides.iterator();
					 	int encontradoEliminar = 0;
						while(iteratorEliminar.hasNext()) {
							Efemeride e = iteratorEliminar.next();
							if(e.getCodigo().equals(codigoAuxiliar)) {
								System.out.println("Efeméride a eliminar:\n"+e.toString());
								iteratorEliminar.remove();
								System.out.println("Fecha eliminada con exito");
								encontradoEliminar++;
							}
						}
						if(encontradoEliminar == 0)
							System.out.println("No hay niguna fecha registrado con el codigo: "+codigoAuxiliar);
					    break;
				case 4: System.out.println("----- MODIFICAR EFEMERIDE -----");
						System.out.println("Ingrese codigo de la efeméride:");
						codigoAuxiliar=sc.nextLine();
						Iterator<Efemeride>iteratorModificar = efemerides.iterator();
					 	int encontradoModificar = 0;
						while(iteratorModificar.hasNext()) {
							Efemeride e = iteratorModificar.next();
							if(e.getCodigo().equals(codigoAuxiliar)) {
								System.out.println("Efeméride a modificar:\n"+e.toString());
								System.out.println("Nuevo código: ");
							    e.setCodigo(sc.nextLine());  
							    System.out.println("Detalles:");
							    e.setDetalle(sc.nextLine()); 
							    do {
							       	 try {
								        System.out.println("Indique NUMERO del mes");
									    mesAuxiliar=sc.nextInt();
									    if(mesAuxiliar < 1 || mesAuxiliar > 12)
									    	System.out.println("Los meses van unicamente entre 1 y 12");
								     }catch(InputMismatchException x) {
								        System.out.println("Se esperaba un dato númerico");
										mesAuxiliar=0;
										sc.nextLine();
								     }
							    }while(mesAuxiliar < 1 || mesAuxiliar > 12);
							    switch(mesAuxiliar) {
								    case 1:e.setMes(Mes.ENERO);break;
								    case 2:e.setMes(Mes.FEBRERO);break;
								    case 3:e.setMes(Mes.MARZO);break;
								    case 4:e.setMes(Mes.ABRIL);break;
								    case 5:e.setMes(Mes.MAYO);break;
								    case 6:e.setMes(Mes.JUNIO);break;
								    case 7:e.setMes(Mes.JULIO);break;
								    case 8:e.setMes(Mes.AGOSTO);break;
								    case 9:e.setMes(Mes.SEPTIEMBRE);break;
								    case 10:e.setMes(Mes.OCTUBRE);break;
								    case 11:e.setMes(Mes.NOVIEMBRE);break;
								    case 12:e.setMes(Mes.DICIEMBRE);break;
							    }
							    diaAuxiliar= diasSegunMes(mesAuxiliar);
							    do {
							        	try {
							        		System.out.println("Ingrese numero del dia");
							        		dia=sc.nextInt();
							        		if(dia<1 || dia>diaAuxiliar)
							        			System.out.println("Los dias solo son entre 1 y "+diaAuxiliar);
							        	}catch(InputMismatchException x) {
							        		System.out.println("Se esperaba un dato númerico");
											dia=0;
											sc.nextLine();
							        	}
							    }while(dia<1|| dia>diaAuxiliar);
							    e.setDia(dia);
								System.out.println("Fecha modificada con éxito");
								e.toString();
								encontradoModificar++;
							}
						}
						if(encontradoModificar == 0)
							System.out.println("No hay niguna fecha registrado con el codigo: "+codigoAuxiliar);
					    break;
				case 5: System.out.println("Fin del programa");;break;
				default: System.out.println("Opción incorrecta");
			}
		}while(opcionMenu!= 5 );
		sc.close();
	}
	public static void menu() {
		System.out.println("----- MENU -----");
		System.out.println("1) Crear efémeride");
		System.out.println("2) Mostrar efemérides");
		System.out.println("3) Eliminar efeméride");
		System.out.println("4) Modificar efeméride");
		System.out.println("5) Salir");
		System.out.println("Ingrese una opcion:");
	}
	public static int diasSegunMes(int mes) {
		int dias=0;
		switch(mes) {
			case 2: dias= 28 ;break;
			case 1,3,5,7,8,10,12: dias=31; break;
			case 4,6,9,11: dias=30;break;
		}
		return dias;
	}
}
