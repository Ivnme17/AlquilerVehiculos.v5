package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.ayudaTarea09.mongodb;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;
import javax.swing.text.Document;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class Vehiculos {
	private Vehiculo getVehiculo(Document documento) {
	    String matricula = documento.getString("matricula");
	    String marca = documento.getString("marca");
	    String modelo = documento.getString("modelo");
	    int plazas = documento.getInteger("plazas");
	    int pma = documento.getInteger("pma");
	    String tipo = documento.getString("tipo");
	    return new Vehiculo(matricula, marca, modelo, plazas, pma, tipo);
	}
	public List<Vehiculo> get() {
	    List<Vehiculo> vehiculos = new ArrayList<>();
	    for (Document documento : coleccionVehiculos.find()) {
	        vehiculos.add(getVehiculo(documento));
	    }
	    return vehiculos;
	}
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
	    if (vehiculo == null) {
	        throw new NullPointerException("ERROR: No se puede insertar un vehículo nulo.");
	    }
	    Document documentoVehiculo = new Document()
	            .append("matricula", vehiculo.getMatricula())
	            .append("marca", vehiculo.getMarca())
	            .append("modelo", vehiculo.getModelo())
	            .append("plazas", vehiculo.getPlazas())
	            .append("pma", vehiculo.getPma())
	            .append("tipo", vehiculo.getTipo());

	    coleccionVehiculos.insertOne(documentoVehiculo);
	}
	






}
