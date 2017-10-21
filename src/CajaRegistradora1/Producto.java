package CajaRegistradora1;

public class Producto {
	private String producto;
	private int cantidad;
	private String marca;
	private float peso;
	private float valorUni;
	
	public Producto() {
	}
	
	public Producto(String producto, int cantidad, String marca, float peso, float valorUni) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.marca = marca;
		this.peso = peso;
		this.valorUni = valorUni;
	}



	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getValorUni() {
		return valorUni;
	}
	public void setValorUni(float valorUni) {
		this.valorUni = valorUni;
	}

}
