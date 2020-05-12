package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

public class user implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String cedula ;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private List<telefono> telefono;
	
	
	public user() {
		super();

	}

	
	public user(String cedula, String nombre, String apellido, String email, String password) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<telefono> getTelefono() {
		return telefono;
	}


	public void setTelefono(List<telefono> telefono) {
		this.telefono = telefono;
	}


	@Override
	public String toString() {
		return "user [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
	

}
