/**
 * 
 */
package com.app.fichaje.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.mapper.ActionMapping;

import com.app.fichaje.model.Empleado;
import com.app.fichaje.model.Fichaje;
import com.opensymphony.xwork2.Action;

/**
 * @author franp
 *
 */
public abstract class FichajeAction implements Action {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private int dni;
	private Date fecha;
	private boolean esEntrada;
	private boolean esSalida;

	List<Empleado> listEmpleados;
	List<Fichaje> listFichaje;

	
	public List<Empleado> getListEmpleados() {
		return listEmpleados;
	}

	public void setListEmpleados(List<Empleado> listEmpleados) {
		this.listEmpleados = listEmpleados;
	}

	public List<Fichaje> getListFichaje() {
		return listFichaje;
	}

	public void setListFichaje(List<Fichaje> listFichaje) {
		this.listFichaje = listFichaje;
	}

	public boolean getEsEntrada() {
		return esEntrada;
	}

	public void setEsEntrada(boolean esEntrada) {
		this.esEntrada = esEntrada;
	}

	public boolean getEsSalida() {
		return esSalida;
	}

	public void setEsSalida(boolean esSalida) {
		this.esSalida = esSalida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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
	

	
	// TODO
	public String listarEmpleados(ActionMapping mapping, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		listEmpleados= new ArrayList<Empleado>();
		Empleado emp= new Empleado();
		emp.setDni(47495861);
		emp.setNombre("Francisco");
		emp.setNombre("Parada");
		emp.setNombre("López");
		
		listEmpleados.add(emp);
		
		return SUCCESS;
	}

	// TODO
	public String listarFichajes(ActionMapping mapping, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return SUCCESS;
	}

	// TODO
	public String altaEmpleado(ActionMapping mapping, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return SUCCESS;
	}

	// TODO
	public String ficharEntrada(ActionMapping mapping, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return SUCCESS;
	}

	// TODO
	public String ficharSalida(ActionMapping mapping, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return SUCCESS;
	}

}