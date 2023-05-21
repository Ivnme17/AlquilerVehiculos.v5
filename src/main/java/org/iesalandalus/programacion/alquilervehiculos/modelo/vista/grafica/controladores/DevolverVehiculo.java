package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Vehiculos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DevolverVehiculo {
	@FXML
	private MenuBar BarraMenu;

	@FXML
	private static TableView<?> ListarVehiculo;

	@FXML
	private TableColumn<Vehiculos, String> tcMarca;

	@FXML
	private TableColumn<Vehiculos, String> tcMatricula;

	@FXML
	private TableColumn<Vehiculos, String> tcModelo;
	@FXML
	private Button btDevolver;

	@FXML
	void Devolver(ActionEvent event) {
		Object vehiculoSeleccionado = ListarCliente.getSelectionModel().getSelectedItem();
		if (vehiculoSeleccionado != null) {
			try {
				alquilerVehiculos.devolverVehiculo(vehiculoSeleccionado);
				ListarCliente.getItems().remove(vehiculoSeleccionado);
				Dialogos.mostrarDialogoInformacion("Devolución de vehículo",
						"Se ha realizado la devolución del vehículo.", null);
			} catch (OperationNotSupportedException e) {
				Dialogos.mostrarDialogoError("Error al realizar la devolución", e.getMessage(), null);
			}
		} else {
			Dialogos.mostrarDialogoAdvertencia("Realizar devolución",
					"Debe seleccionar un vehículo para realizar la devolución.", null);
		}
	}

	public void setAlquilerVehiculos(Alquileres alquilerVehiculos) {
		this.alquilerVehiculos = alquilerVehiculos;
		ListarCliente.setItems(((Object) alquilerVehiculos).getVehiculos());
	}
}
