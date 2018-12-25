/**
 * 
 */
package com.app.fichaje.model;

import java.util.Date;

/**
 * @author franp
 *
 */
public class Fichaje {

	private int dni;
	private Date fecha;
	private boolean entrada;
	private boolean salida;
		
	public Fichaje() {
		super();
	}
	
	public Fichaje(int dni, Date fecha, boolean entrada, boolean salida) {
		super();
		this.dni = dni;
		this.fecha = fecha;
		this.entrada = entrada;
		this.salida = salida;
	}
	
	@Override
	public String toString() {
		return "Fichaje [dni=" + dni + ", fecha=" + fecha + ", entrada=" + entrada + ", salida=" + salida + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		result = prime * result + (entrada ? 1231 : 1237);
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (salida ? 1231 : 1237);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fichaje other = (Fichaje) obj;
		if (dni != other.dni)
			return false;
		if (entrada != other.entrada)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (salida != other.salida)
			return false;
		return true;
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public boolean isEntrada() {
		return entrada;
	}
	
	public void setEntrada(boolean entrada) {
		this.entrada = entrada;
	}
	
	public boolean isSalida() {
		return salida;
	}
	
	public void setSalida(boolean salida) {
		this.salida = salida;
	}

	
}
