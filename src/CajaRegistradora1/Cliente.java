package CajaRegistradora1;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String apellido;
	private int edad;
	private int cedula;
	private String empresa;
	private float sueldo;
	private ArrayList productos;
	
	public Cliente(String _nombre, String _apellido, int _edad, int _cedula, String _empresa, float _sueldo) {
		nombre = _nombre;
		apellido = _apellido;
		edad = _edad;
		cedula = _cedula;
		empresa = _empresa;
		sueldo = _sueldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public ArrayList getProductos() {
		return productos;
	}

	public void setProductos(ArrayList productos) {
		this.productos = productos;
	}

}
