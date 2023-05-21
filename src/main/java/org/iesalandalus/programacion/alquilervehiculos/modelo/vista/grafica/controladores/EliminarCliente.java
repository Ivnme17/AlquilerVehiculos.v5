package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EliminarCliente {
	private List<Cliente> coleccionClientes;
	@FXML
	private MenuBar BarraMenu;

	@FXML
	private TableView<?> ListarCliente;

	@FXML
	private Button btEliminar;

	@FXML
	private TableColumn<Clientes, String> tcNombre;

	@FXML
	private TableColumn<Clientes, String> tcDNI;

	@FXML
	private TableColumn<Clientes, String> tcTelefono;

	@FXML
	void Eliminar(ActionEvent event) {
		Cliente clienteSeleccionado = (Cliente) ListarCliente.getSelectionModel().getSelectedItem();
		if (ListarCliente != null) {
			try {
				borrar();
				ListarCliente.getItems().remove(ListarCliente);
			} catch (OperationNotSupportedException e) {
				Dialogos.mostrarDialogoError("Error al eliminar el cliente", e.getMessage(), null);
			}
		} else {
			Dialogos.mostrarDialogoAdvertencia("Eliminar cliente", "Debe seleccionar un cliente para eliminarlo.",
					null);
		}
	}

	private void borrar() throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		if (ListarCliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if (!coleccionClientes.remove(ListarCliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
	}
}
