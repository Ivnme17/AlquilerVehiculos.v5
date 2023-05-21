package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Dialogos;

public class BuscarCliente {
	private List<Cliente> coleccionClientes;
	@FXML
	private TableView<?> TablaBuscarCliente;

	@FXML
	private TableColumn<Clientes, String> tcDNICliente;

	@FXML
	private TableColumn<Clientes, String> tcNombreCliente;

	@FXML
	private TableColumn<Clientes, String> tcTelefonoCliente;

	@FXML
	private TextField tfBuscar;

	@FXML
	void Buscar(ActionEvent event) {

		String nombre = tcNombreCliente.getText();
		String DNI = tcDNICliente.getText();
		String telefono = tcTelefonoCliente.getText();

		Cliente clienteEncontrado = buscarCliente(nombre, DNI, telefono);
		if (clienteEncontrado != null) {
			mostrar(clienteEncontrado);
		} else {

			Dialogos.mostrarDialogoError("No se ha encontrado el cliente buscado por el nombre", nombre, null);
			Dialogos.mostrarDialogoError("No se ha encontrado el cliente buscado por Dni", DNI, null);
			Dialogos.mostrarDialogoError("No se ha encontrado el cliente buscado por teléfono", telefono, null);
		}
	}

	private void mostrar(Cliente clienteEncontrado) {

		TablaBuscarCliente.getItems().clear();
		TablaBuscarCliente.getItems().add(clienteEncontrado);
	}

	private Cliente buscarCliente(String nombre, String Dni, String telefono) {
		for (Cliente cliente : coleccionClientes) {
			if (cliente.getNombre().equals(nombre) && cliente.getDni().equals(Dni)
					&& cliente.getTelefono().equals(telefono)) {
				return cliente;
			}
		}
		return null;
	}
}