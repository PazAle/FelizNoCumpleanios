package alumno.unlam.edu.ar;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Personaje {

	private String nombre;
	private Double altura;
	private Integer edad;
	private Double dinero;
	private List<Producto> productosComprados;
	
	public Personaje(String nombre, Double altura, Integer edad, Double dinero) {
		this.nombre = nombre;
		this.altura = altura;
		this.edad = edad;
		this.dinero = dinero;
		this.productosComprados = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}
	

	public List<Producto> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosComprados(List<Producto> productosComprados) {
		this.productosComprados = productosComprados;
	}

	public void obtenerProducto(Producto producto) {
		this.productosComprados.add(producto);
		
	}

	public void actualizarDinero(Double precio) {
		Double dineroActual = this.getDinero();
		dineroActual -=precio;
		this.setDinero(dineroActual);
		
	}

	public void consumirAlimento(Producto producto) throws AlimentoNoCompradoException {
		Boolean tieneAlimento = tieneElAlimento(producto);
		Integer tipoDeAlimento = tipoDeAlimento(producto);
		if(tieneAlimento) {
			comer(tipoDeAlimento, producto);
			actualizarListaDeProductosComprados(producto);
		}
	}


	private void actualizarListaDeProductosComprados(Producto producto) {
		this.getProductosComprados().remove(producto);
		
	}

	private void comer(Integer tipoDeAlimento, Producto producto) {
		final int achicador = 1, agrandador = 2;
		
		switch(tipoDeAlimento){
		case achicador:
			encogerse();
			break;
		case agrandador:
			agrandarse();
			break;
		}
		
	}

	private void agrandarse() {
		Double alturaActual = this.getAltura();
		alturaActual += 0.40;
		this.setAltura(alturaActual);
		
	}

	private void encogerse() {
		Double alturaActual = this.getAltura();
		alturaActual -= 0.50;
		this.setAltura(alturaActual);
	}

	private Integer tipoDeAlimento(Producto producto) {
		Integer tipo = 0;
		if(producto instanceof Achicador) {
			tipo = 1;
		} else if(producto instanceof Agrandador) {
			tipo = 2;
		}
		return tipo;
	}

	private Boolean tieneElAlimento(Producto masitas) throws AlimentoNoCompradoException {
		Boolean tiene = false;
		if(this.productosComprados.contains(masitas)) {
			tiene = true;
		} else {
			throw new AlimentoNoCompradoException("El alimento que intenta consumir, no se encuentra en la lista de alimentos comprados");
		}
		return tiene;
	}

	
}
