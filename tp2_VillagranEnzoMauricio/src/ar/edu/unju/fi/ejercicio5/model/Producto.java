package ar.edu.unju.fi.ejercicio5.model;
public class Producto {
	private String codigo;
	private String descripcion;
	private float precioUnitario;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	private boolean estado;
	public enum OrigenFabricacion{
		ARGENTINA,CHINA,BRASIL,URUGUAY;
	}
	public enum Categoria{
		TELEFONIA,INFORMATICA,ELECTROHOGAR,HERRAMIENTAS;
	}
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	public Producto(String codigo, String descripcion, float precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria, boolean estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.estado = estado;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}
	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String mostrarProductosPto5() {
		return "----- Producto -----\nCodigo: " + codigo + " - Descripcion: " + descripcion + "\nPrecio: $" + precioUnitario
				+ "\nOrigen: " + origenFabricacion + " - Categoria: " + categoria + " - Stock: "+estado;
	}
	
}
