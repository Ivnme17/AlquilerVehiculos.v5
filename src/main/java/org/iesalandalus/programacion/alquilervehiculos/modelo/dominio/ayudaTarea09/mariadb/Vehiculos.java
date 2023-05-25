package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.ayudaTarea09.mariadb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
public class Vehiculos {
	private Vehiculo getVehiculo(ResultSet fila) throws SQLException {
	    String matricula = fila.getString("matricula");
	    String marca = fila.getString("marca");
	    String modelo = fila.getString("modelo");
	    int plazas = fila.getInt("plazas");
	    int pma = fila.getInt("pma");
	    String tipo = fila.getString("tipo");
	    return new Vehiculo(matricula, marca, modelo, plazas, pma, tipo);
	}
	public List<Vehiculo> get() {
	    List<Vehiculo> vehiculos = new ArrayList<>();
	    try (PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM vehiculos")) {
	        ResultSet filas = sentencia.executeQuery();
	        while (filas.next()) {
	            vehiculos.add(getVehiculo(filas));
	        }
	    } catch (SQLException e) {
	        throw new IllegalArgumentException(ERROR + e.getMessage());
	    }
	    return vehiculos;
	}
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
	    if (vehiculo == null) {
	        throw new NullPointerException("ERROR: No se puede insertar un vehículo nulo.");
	    }
	    try (PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO vehiculos VALUES (?, ?, ?, ?, ?, ?)")) {
	        sentencia.setString(1, vehiculo.getMatricula());
	        sentencia.setString(2, vehiculo.getMarca());
	        sentencia.setString(3, vehiculo.getModelo());
	        sentencia.setInt(4, vehiculo.getPlazas());
	        sentencia.setInt(5, vehiculo.getPma());
	        sentencia.setString(6, vehiculo.getTipo());
	        sentencia.execute();
	    } catch (SQLIntegrityConstraintViolationException e) {
	        throw new OperationNotSupportedException("ERROR: Ya existe un vehículo con esa matrícula.");
	    } catch (SQLException e) {
	        throw new IllegalArgumentException(ERROR + e.getMessage());
	    }
	}
}
