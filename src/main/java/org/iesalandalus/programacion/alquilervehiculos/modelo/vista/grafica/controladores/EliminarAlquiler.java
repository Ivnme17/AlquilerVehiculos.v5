package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Alquileres;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EliminarAlquiler {

	@FXML
	private TableView<?> TablaBorrarAlquiler;

	@FXML
	private Button btBorrar;

	@FXML
	private TableColumn<Alquileres, String> tcClienteAlquiler;

	@FXML
	private TableColumn<Alquileres, String> tcFechaAlquiler;

	@FXML
	private TableColumn<Alquileres, String> tcFechaDevolucion;

	@FXML
	private TableColumn<Alquileres, String> tcVehiculoAlquiler;

	@FXML
	void Borrar(ActionEvent event) {
		Object alquilerSeleccionado = TablaBorrarAlquiler.getSelectionModel().getSelectedItem();
		if (alquilerSeleccionado != null) {
			try {
				Alquileres.getInstancia().borrar(alquilerSeleccionado);
				TablaBorrarAlquiler.getItems().remove(alquilerSeleccionado);
			} catch (OperationNotSupportedException e) {
				throw new OperationNotSupportedException("Error al borrar el alquiler: " + e.getMessage());

			}
		}
	}

}
