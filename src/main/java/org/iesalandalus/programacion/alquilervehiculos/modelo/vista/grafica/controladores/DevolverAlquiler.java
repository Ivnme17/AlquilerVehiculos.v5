package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DevolverAlquiler {

	@FXML
	private TableView<?> TablaBuscarAlquiler;

	@FXML
	private Button btDevolverAlquiler;
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
	void Devolver(ActionEvent event) {
		Alquiler alquilerSeleccionado = (Alquiler) TablaBuscarAlquiler.getSelectionModel().getSelectedItem();
		if (alquilerSeleccionado != null) {
			try {
				alquilerVehiculos.devolverVehiculo(alquilerSeleccionado);
				TablaBuscarAlquiler.getItems().remove(alquilerSeleccionado);
				Dialogos.mostrarDialogoInformacion("Devolución de vehículo",
						"Se ha realizado la devolución del vehículo.", null);
			} catch (OperationNotSupportedException e) {
				Dialogos.mostrarDialogoError("Error al realizar la devolución", e.getMessage(), null);
			}
		} else {
			Dialogos.mostrarDialogoAdvertencia("Realizar devolución",
					"Debe seleccionar un alquiler para realizar la devolución.", null);
		}
	}

	public void setAlquilerVehiculos(Alquileres alquilerVehiculos) {
		this.alquilerVehiculos = alquilerVehiculos;
		TablaBuscarAlquiler.setId(alquilerVehiculos.getAlquiler());
	}
}
