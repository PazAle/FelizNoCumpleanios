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

	public void obtenerProducto(Producto producto) {
		this.productosComprados.add(producto);
		
	}

	public void actualizarDinero(Double precio) {
		Double dineroActual = this.getDinero();
		dineroActual -=precio;
		this.setDinero(dineroActual);
		
	}

	
}
