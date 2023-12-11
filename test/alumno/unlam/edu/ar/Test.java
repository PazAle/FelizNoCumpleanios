package alumno.unlam.edu.ar;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	@org.junit.Test
	public void queAlComprarUnAlimentoSeDescuenteElDineroDisponible() {
		String nombreSuper = "Coto", nombrePersonaje = "Alicia", nombreProducto = "Masitas Finas";
		Integer edad = 20;
		Double altura = 1.80, dinero = 1000.00, precio = 100.00;
		Boolean sePudoVender = false;
		
		Supermercado coto = new Supermercado(nombreSuper);
		Personaje alicia = new Personaje(nombrePersonaje, altura, edad, dinero);
		Producto masitas = new Achicador(nombreProducto, precio);
		
		coto.registrarProducto(masitas);
		try {
			sePudoVender = coto.venderProducto(masitas, alicia);
		} catch (DineroInsuficienteException | ProductoNoRegistradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double dineroEsperado = 900.00;
		Double dineroObtenido = alicia.getDinero();
		
		assertTrue(sePudoVender);
		assertEquals(dineroEsperado, dineroObtenido);
	}
	
	@org.junit.Test(expected = DineroInsuficienteException.class)
	public void queNoSePuedaExcederElDineroDeCompraDisponible() throws DineroInsuficienteException {
		String nombreSuper = "Coto", nombrePersonaje = "Alicia", nombreProducto = "Masitas Finas";
		Integer edad = 20;
		Double altura = 1.80, dinero = 10.00, precio = 100.00;
		Boolean sePudoVender = false;
		
		Supermercado coto = new Supermercado(nombreSuper);
		Personaje alicia = new Personaje(nombrePersonaje, altura, edad, dinero);
		Producto masitas = new Achicador(nombreProducto, precio);
		
		coto.registrarProducto(masitas);
		try {
			sePudoVender = coto.venderProducto(masitas, alicia);;
		} catch (ProductoNoRegistradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@org.junit.Test
	public void queAlConsumirUnAlimentoAchicadorElPersonajeSeEncoja() {
		String nombreSuper = "Coto", nombrePersonaje = "Alicia", nombreProducto = "Masitas Finas";
		Integer edad = 20;
		Double altura = 1.80, dinero = 1000.00, precio = 100.00;
		Boolean sePudoVender = false;
		
		Supermercado coto = new Supermercado(nombreSuper);
		Personaje alicia = new Personaje(nombrePersonaje, altura, edad, dinero);
		Producto masitas = new Achicador(nombreProducto, precio);
		
		coto.registrarProducto(masitas);
		try {
			sePudoVender = coto.venderProducto(masitas, alicia);
			alicia.consumirAlimento(masitas);
		} catch (DineroInsuficienteException | ProductoNoRegistradoException | AlimentoNoCompradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double alturaEsperada = 1.30;
		Double alturaObtenida = alicia.getAltura();
		
		assertTrue(sePudoVender);
		assertEquals(alturaEsperada, alturaObtenida);
	}
	
	@org.junit.Test
	public void queAlConsumirUnAlimentoAgrandadorElPersonajeSeEncoja() {
		String nombreSuper = "Coto", nombrePersonaje = "Alicia", nombreProducto = "Gomitas";
		Integer edad = 20;
		Double altura = 1.80, dinero = 1000.00, precio = 200.00;
		Boolean sePudoVender = false;
		
		Supermercado coto = new Supermercado(nombreSuper);
		Personaje alicia = new Personaje(nombrePersonaje, altura, edad, dinero);
		Producto masitas = new Agrandador(nombreProducto, precio);
		
		coto.registrarProducto(masitas);
		try {
			sePudoVender = coto.venderProducto(masitas, alicia);
			alicia.consumirAlimento(masitas);
		} catch (DineroInsuficienteException | ProductoNoRegistradoException | AlimentoNoCompradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double alturaEsperada = 2.20;
		Double alturaObtenida = alicia.getAltura();
		
		assertTrue(sePudoVender);
		assertEquals(alturaEsperada, alturaObtenida);
	}
	
	@org.junit.Test
	public void queAlConsumirUnAlimentoAgrandadorNoSePuedaAgrandarMasDe280cmElPersonaje() {
		String nombreSuper = "Coto", nombrePersonaje = "Alicia", nombreProducto = "Gomitas", nombreProducto2="Caramelos";
		Integer edad = 20;
		Double altura = 1.80, dinero = 1000.00, precio = 100.00;
		Boolean sePudoVender = false;
		
		Supermercado coto = new Supermercado(nombreSuper);
		Personaje alicia = new Personaje(nombrePersonaje, altura, edad, dinero);
		Producto gomitas = new Agrandador(nombreProducto, precio);
		Producto caramelos = new Agrandador(nombreProducto2, precio);
		Producto caramelos2 = new Agrandador(nombreProducto2, precio);
		
		coto.registrarProducto(gomitas);
		coto.registrarProducto(caramelos);
		coto.registrarProducto(caramelos2);
		try {
			sePudoVender = coto.venderProducto(gomitas, alicia);
			sePudoVender = coto.venderProducto(caramelos, alicia);
			sePudoVender = coto.venderProducto(caramelos2, alicia);
			alicia.consumirAlimento(gomitas);
			alicia.consumirAlimento(caramelos);
			alicia.consumirAlimento(caramelos2);
		} catch (DineroInsuficienteException | ProductoNoRegistradoException | AlimentoNoCompradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double alturaEsperada = 2.80;
		Double alturaObtenida = alicia.getAltura();
		
		assertTrue(sePudoVender);
		assertEquals(alturaEsperada, alturaObtenida);
	}
	
	@org.junit.Test
	public void queAlConsumirUnAlimentoAchicadorNoSePuedaAchicarMasDe50cmElPersonaje() {
		String nombreSuper = "Coto", nombrePersonaje = "Alicia", nombreProducto = "Masitas", nombreProducto2="Alfajor";
		Integer edad = 20;
		Double altura = 1.80, dinero = 1000.00, precio = 100.00;
		Boolean sePudoVender = false;
		
		Supermercado coto = new Supermercado(nombreSuper);
		Personaje alicia = new Personaje(nombrePersonaje, altura, edad, dinero);
		Producto masitas = new Achicador(nombreProducto, precio);
		Producto jorgito = new Achicador(nombreProducto2, precio);
		Producto capitanDelEspacio = new Achicador(nombreProducto2, precio);
		
		coto.registrarProducto(masitas);
		coto.registrarProducto(jorgito);
		coto.registrarProducto(capitanDelEspacio);
		try {
			sePudoVender = coto.venderProducto(masitas, alicia);
			sePudoVender = coto.venderProducto(jorgito, alicia);
			sePudoVender = coto.venderProducto(capitanDelEspacio, alicia);
			alicia.consumirAlimento(masitas);
			alicia.consumirAlimento(jorgito);
			alicia.consumirAlimento(capitanDelEspacio);
		} catch (DineroInsuficienteException | ProductoNoRegistradoException | AlimentoNoCompradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double alturaEsperada = 0.50;
		Double alturaObtenida = alicia.getAltura();
		
		assertTrue(sePudoVender);
		assertEquals(alturaEsperada, alturaObtenida);
	}
	
	@org.junit.Test
	public void queSePuedaOrdenarLaColeccionDeAlimentosPorNombre() {
		String nombreSuper = "Coto", nombrePersonaje = "Alicia", nombreProducto = "Masitas", nombreProducto2="Jorgito",
				nombreProducto3="Capitan del Espacio";
		Integer edad = 20;
		Double altura = 1.80, dinero = 1000.00, precio = 100.00;
		Boolean sePudoVender = false;
		
		Supermercado coto = new Supermercado(nombreSuper);
		Personaje alicia = new Personaje(nombrePersonaje, altura, edad, dinero);
		Producto masitas = new Achicador(nombreProducto, precio);
		Producto jorgito = new Achicador(nombreProducto2, precio);
		Producto capitanDelEspacio = new Achicador(nombreProducto3, precio);
		
		coto.registrarProducto(masitas);
		coto.registrarProducto(jorgito);
		coto.registrarProducto(capitanDelEspacio);
		try {
			sePudoVender = coto.venderProducto(masitas, alicia);
			sePudoVender = coto.venderProducto(jorgito, alicia);
			sePudoVender = coto.venderProducto(capitanDelEspacio, alicia);
			alicia.consumirAlimento(masitas);
			alicia.consumirAlimento(jorgito);
			alicia.consumirAlimento(capitanDelEspacio);
		} catch (DineroInsuficienteException | ProductoNoRegistradoException | AlimentoNoCompradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double alturaEsperada = 0.50;
		Double alturaObtenida = alicia.getAltura();
		
		List<Producto> listaDeProductos = new ArrayList<>(coto.getProductos());
		
		Collections.sort(listaDeProductos);
		
		assertEquals(listaDeProductos.get(0), capitanDelEspacio);
		assertEquals(listaDeProductos.get(1), jorgito);
		assertEquals(listaDeProductos.get(2), masitas);
	}

}
