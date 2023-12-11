package alumno.unlam.edu.ar;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {

	private String nombre;
	private List<Producto> productos;
	
	public Supermercado(String nombre) {
		this.nombre = nombre;
		this.productos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void registrarProducto(Producto producto) {
		this.productos.add(producto);
		
	}

	public Boolean venderProducto(Producto producto, Personaje personaje) {
		Boolean existeProducto = productoRegistrado(producto);
		Boolean sePudoVender = false;
		if(existeProducto) {
			if(personaje.getDinero() >= producto.getPrecio()) {
				personaje.obtenerProducto(producto);
				personaje.actualizarDinero(producto.getPrecio());
				sePudoVender = true;
			}
		}
		return sePudoVender;
	}

	private Boolean productoRegistrado(Producto producto) {
		Boolean existe = false;
		if(this.productos.contains(producto)) {
			existe = true;
		}
		return existe;
	}

	
}
