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
		sePudoVender = coto.venderProducto(masitas, alicia);
		Double dineroEsperado = 900.00;
		Double dineroObtenido = alicia.getDinero();
		
		assertTrue(sePudoVender);
		assertEquals(dineroEsperado, dineroObtenido);
	}

}
