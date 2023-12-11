package alumno.unlam.edu.ar;

import static org.junit.Assert.*;

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

}
