package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611,53219), SALTA(1441351,155488), 
	TUCUMAN(1731820,22524), CATAMARCA(429562,102602), 
	LA_RIOJA(383865,89680), SANTIAGO_DEL_ESTERO(1060906,136351);
	private long cantidadPoblacion;
	private float superficie;
	private Provincia() {
		// TODO Auto-generated constructor stub
	}
	private Provincia(long cantidadPoblacion, float superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}
	public long getCantidadPoblacion() {
		return cantidadPoblacion;
	}
	public void setCantidadPoblacion(long cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}
	public float getSuperficie() {
		return superficie;
	}
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}
	public float calcularDensidad() {
		return cantidadPoblacion/superficie;
	}
	
}
