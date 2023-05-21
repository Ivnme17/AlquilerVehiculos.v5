package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import javafx.event.ActionEvent;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Dialogos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DevolverCliente {
	private List<Cliente> coleccionClientes;
	@FXML
	private MenuBar BarraMenu;

	@FXML
	private TableView<?> ListarCliente;

	@FXML
	private TableColumn<Clientes, String> tcNombre;

	@FXML
	private TableColumn<Clientes, String> tcDNI;

	@FXML
	private TableColumn<Clientes, String> tcTelefono;
	
	@FXML
	private Button btDevolver;



	@FXML
	void Devolver(ActionEvent event) {
	    Cliente clienteSeleccionado = (Cliente) ListarCliente.getSelectionModel().getSelectedItem();
	    if (clienteSeleccionado != null) {
	        try {
	            realizarDevoluciones(clienteSeleccionado);
	            Dialogos.mostrarDialogoInformacion("Devoluciones realizadas", "Se han realizado las devoluciones para el cliente.", null);
	        } catch (OperationNotSupportedException e) {
	            Dialogos.mostrarDialogoError("Error al realizar las devoluciones", e.getMessage(), null);
	        }
	    } else {
	        Dialogos.mostrarDialogoAdvertencia("Realizar devoluciones", "Debe seleccionar un cliente para realizar las devoluciones.", null);
	    }
	}

	private void realizarDevoluciones(Cliente cliente) throws OperationNotSupportedException {
		   if (cliente != null) {
		        List<Alquiler> alquileres = cliente.getAlquileres();
		        for (Alquiler alquiler : alquileres) {
		            alquiler.setDevuelto(true);
		        }
		    }
		}
}
