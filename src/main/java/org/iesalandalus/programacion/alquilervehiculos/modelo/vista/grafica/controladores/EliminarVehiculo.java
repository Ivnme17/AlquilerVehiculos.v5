package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Vehiculos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EliminarVehiculo {

	@FXML
	private MenuBar BarraMenu;

	@FXML
	private TableView<?> ListarCliente;

	@FXML
	private Button btEliminarVehiculo;

	@FXML
	private TableColumn<Vehiculos, String> tcMarca;

	@FXML
	private TableColumn<Vehiculos, String> tcMatricula;

	@FXML
	private TableColumn<Vehiculos, String> tcModelo;

	@FXML
	void Eliminar(ActionEvent event) {
		Vehiculos vehiculoSeleccionado = ListarVehiculo.getVehiculo().getSelectedItem();
		if (vehiculoSeleccionado != null) {
			try {
				borrar(vehiculoSeleccionado);

				ListarVehiculo.initialize().remove(getVehiculo);
			} catch (OperationNotSupportedException e) {

				Dialogos.mostrarDialogoError("Error al eliminar el vehículo", e.getMessage(), null);
			}
		} else {

			Dialogos.mostrarDialogoAdvertencia("Eliminar vehículo", "Debe seleccionar un vehículo para eliminarlo.",
					null);
		}
	}

	@FXML
	void eliminarVehiculoSeleccionado(ActionEvent event) {
		Vehiculos vehiculoSeleccionado = ListarVehiculo.getVehiculo().getSelectedItem();
		if (vehiculoSeleccionado != null) {
			try {
				borrar(vehiculoSeleccionado);

				ListarVehiculo.initialize().remove(getVehiculo);
			} catch (OperationNotSupportedException e) {

				Dialogos.mostrarDialogoError("Error al eliminar el vehículo", e.getMessage(), null);
			}
		} else {

			Dialogos.mostrarDialogoAdvertencia("Eliminar vehículo", "Debe seleccionar un vehículo para eliminarlo.",
					null);
		}
	}

	@Override
	public void borrar(Vehiculos vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}

		if (!coleccionVehiculos.remove(vehiculo)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		}
	}
}
