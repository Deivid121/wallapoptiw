package es.uc3m.tiw.wallapop.dominios;

import static javax.persistence.GenerationType.AUTO;

import java.awt.Image;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {
	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	@Column(length = 30, nullable = false,unique = true)
	private String titulo;
	@Column(length = 30, nullable = false)
	private String categoria;
	@Column(length = 255, nullable = true)
	private String descripcion;
	@Column()
	private String imagen;
	@Column(nullable = false)
	private int precio;
	
	public Producto(String titulo, String categoria, String descripcion, String imagen, int precio) {
		super();
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
	}
	
	public Producto() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
}
