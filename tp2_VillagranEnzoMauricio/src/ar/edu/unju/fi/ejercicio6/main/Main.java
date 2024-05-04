package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;
public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		System.out.println(gato.toString());
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),x.getEdad(),x.getPeso());
		FelinoSalvaje felino1 = converter.convert(gato);
		converter.mostrarObjeto(felino1);
		System.out.println("Convirtiendo felino salvaje a felino domestico");
		FelinoSalvaje gatitoSalvaje = new FelinoSalvaje("Tanner",(byte)20,186f);
		System.out.println(gatitoSalvaje.toString());
		Converter<FelinoSalvaje,FelinoDomestico> converterDomestico = s -> new FelinoDomestico(s.getNombre(),s.getEdad(),s.getPeso());
		System.out.println("Objeto a convertir no es nulo: "+Converter.isNotNull(gatitoSalvaje));
		FelinoDomestico felino2 = converterDomestico.convert(gatitoSalvaje);
		converterDomestico.mostrarObjeto(felino2);
	}

}