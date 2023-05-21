package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Clientes;
import org.w3c.dom.Document;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ListarCliente {

	@FXML
	private MenuBar BarraMenu;

	@FXML
	private TableView<?> ListarCliente;

	@FXML
	private Button button;

	@FXML
	private TableColumn<Clientes, String> tcNombre;

	@FXML
	private TableColumn<Clientes, String> tcDNI;

	@FXML
	private TableColumn<Clientes, String> tcTelefono;

	@FXML
	private void initialize() {

		tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		tcDNI.setCellValueFactory(new PropertyValueFactory<>("DNI"));
		tcTelefono.setCellValueFactory(new PropertyValueFactory<>("Teléfono"));

		Class<? extends ListarCliente> listaClientes = getClass();
		Clientes.getElemento((Document) FXCollections.observableArrayList(listaClientes), null, null);
	}
}