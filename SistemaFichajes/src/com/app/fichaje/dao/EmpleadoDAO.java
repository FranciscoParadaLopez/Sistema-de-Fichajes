/**
 * 
 */
package com.app.fichaje.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.fichaje.H2service.H2databaseUtil;
import com.app.fichaje.model.Empleado;

/**
 * @author franp
 *
 */
public class EmpleadoDAO {
	
	
		public void insertar(Empleado empleado) throws SQLException {
			
			String SQL_INSERT = "INSERT INTO Empleado (dni,nombre,apellido1,apellido2) VALUES ("
					+ empleado.getDni()+","
					+ "'"+empleado.getNombre()+"',"
					+ "'"+empleado.getApellido1()+"',"
					+ "'"+empleado.getApellido2()+"'"
			+")";
			
			H2databaseUtil.executeUpdateSQL(SQL_INSERT);				
		}
	 
		public void eliminar(Empleado empleado) throws SQLException {

			String SQL_DELETE = "DELETE FROM Empleado WHERE dni= "+empleado.getDni();
			H2databaseUtil.executeUpdateSQL(SQL_DELETE);
		}

		public List<Empleado> listar() throws SQLException {
	 
			String sql = "SELECT * FROM Empleado";
			List<Empleado> listaEmpleado = new ArrayList<Empleado>();
			Empleado emp= new Empleado();
			
			ResultSet resultset;
			resultset = H2databaseUtil.executeSelect(sql);
			
			if (resultset.next()) {
				emp.setDni(resultset.getInt("dni"));
				emp.setNombre(resultset.getString("nombre"));
				emp.setApellido1(resultset.getString("apellido1"));
				emp.setApellido2(resultset.getString("apellido2"));
				listaEmpleado.add(emp);
			}
			resultset.close();
			H2databaseUtil.closeH2();
			
			return listaEmpleado;
		}
	 
		public Empleado findByDni(int dni) throws SQLException {
			
			Empleado emp = new Empleado();
	 
			String sql = "SELECT * FROM Empleado WHERE dni= ? ";
			PreparedStatement statement = H2databaseUtil.executeStatement(sql);
			statement.setInt(1, dni);
	 
			ResultSet res = statement.executeQuery();
			if (res.next()) {
				emp.setDni(res.getInt("dni"));
				emp.setNombre(res.getString("nombre"));
				emp.setApellido1(res.getString("apellido1"));
				emp.setApellido2(res.getString("apellido2"));
			}
			res.close();
			H2databaseUtil.closeH2();
			
			return emp;
		}
	 
		public void actualizar(Empleado emp) throws SQLException {

			String sql = "UPDATE Empleado SET dni=?,nombre=?apellido1=?,apellido2=? WHERE dni=?";
						
			PreparedStatement statement = H2databaseUtil.executeStatement(sql);			
			statement.setInt(1, emp.getDni());
			statement.setString(2, emp.getNombre());
			statement.setString(3, emp.getApellido1());
			statement.setString(4, emp.getApellido2());
			
			statement.executeUpdate();
			statement.close();
			H2databaseUtil.closeH2();			
		}
		
	
	}
