package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;


public class telefono implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String numero;
	private String tipo;
	private String operadora;
	private user user;
	
	
	public telefono() {

	}

	
	
	
	public telefono(String numero, String tipo, String operadora) {
		
		
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


	public user getUser() {
		return user;
	}




	public void setUser(user user) {
		this.user = user;
	}




	@Override
	public String toString() {
		return "telefono [codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora
				+ "]";
	}
	
	
	
	
	
	
	
}
