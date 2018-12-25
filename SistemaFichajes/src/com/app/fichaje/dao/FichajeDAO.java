/**
 * 
 */
package com.app.fichaje.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.app.fichaje.H2service.H2databaseUtil;
import com.app.fichaje.model.Fichaje;
import com.app.fichaje.util.FichajeUtil;

/**
 * @author franp
 *
 */
public class FichajeDAO {


	public void insertar(Fichaje Fichaje) throws SQLException {

		String SQL_INSERT = "INSERT INTO Fichaje (dni,fecha,esEntrada,esSalida) VALUES (" + Fichaje.getDni() + "," + "'"
				+ Fichaje.getFecha() + "'," + "'" + Fichaje.isEntrada() + "'," + "'" + Fichaje.isSalida() + "'" + ")";

		H2databaseUtil.executeUpdateSQL(SQL_INSERT);
	}

	public void eliminar(Fichaje Fichaje) throws SQLException {

		String SQL_DELETE = "DELETE FROM Fichaje WHERE dni= " + Fichaje.getDni();
		H2databaseUtil.executeUpdateSQL(SQL_DELETE);
	}

	public List<Fichaje> listar() throws SQLException {

		String sql = "SELECT * FROM Fichaje";
		List<Fichaje> listaFichaje = new ArrayList<Fichaje>();
		Fichaje fich = new Fichaje();

		ResultSet res;
		res = H2databaseUtil.executeSelect(sql);

		if (res.next()) {
			fich.setDni(res.getInt("dni"));
			try {
				fich.setFecha(FichajeUtil.FORMATO_FECHA.parse(res.getString("fecha")));
			} catch (ParseException e) {
				System.out.println("Error al intentar formatear la fecha " + res.getString("fecha") + " al formato "
						+ FichajeUtil.FORMATO_FECHA);
				e.printStackTrace();
			}
			fich.setEntrada(res.getBoolean("esEntrada"));
			fich.setSalida(res.getBoolean("esSalida"));
			listaFichaje.add(fich);
		}
		res.close();
		H2databaseUtil.closeH2();

		return listaFichaje;
	}

	public Fichaje findByDni(int dni) throws SQLException {

		String sql = "SELECT * FROM Fichaje WHERE dni= ? ";
		PreparedStatement statement = H2databaseUtil.executeStatement(sql);
		statement.setInt(1, dni);
		return rellenarFichaje(statement);
	}

	public Fichaje findByNombreApellidos(String nombre, String apellido1, String apellido2) throws SQLException {

		String sql = "SELECT * FROM Fichaje WHERE nombre=? and apellido1=? and apellido2=? ";
		PreparedStatement statement = H2databaseUtil.executeStatement(sql);
		statement.setString(1, nombre);
		statement.setString(2, apellido1);
		statement.setString(3, apellido2);
		
		return rellenarFichaje(statement);
	}

	//TODO
	//personas presentes en la oficina, 
	//personas que han salido ya de la oficina
		

	private Fichaje rellenarFichaje(PreparedStatement statement) throws SQLException {

		Fichaje fich = new Fichaje();

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			fich.setDni(res.getInt("dni"));
			try {
				fich.setFecha(FichajeUtil.FORMATO_FECHA.parse(res.getString("fecha")));
			} catch (ParseException e) {
				System.out.println("Error al intentar formatear la fecha " + res.getString("fecha") + " al formato "
						+ FichajeUtil.FORMATO_FECHA);
				e.printStackTrace();
			}
			fich.setEntrada(res.getBoolean("esEntrada"));
			fich.setSalida(res.getBoolean("esSalida"));
		}
		res.close();
		H2databaseUtil.closeH2();
		return fich;
	}

}
