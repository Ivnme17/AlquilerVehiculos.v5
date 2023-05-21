package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;
import javax.lang.model.element.Element;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Vehiculos;
import org.w3c.dom.Document;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarVehiculo {
	@FXML
	private MenuBar BarraMenu;

	@FXML
	private static TableView<?> ListarCliente;

	@FXML
	private Button button;

	@FXML
	private TableColumn<Vehiculos, String> tcMarca;

	@FXML
	private TableColumn<Vehiculos, String> tcMatricula;

	@FXML
	private TableColumn<Vehiculos, String> tcModelo;
	 @FXML void initialize() {
	        // Configurar las propiedades de las columnas
	        tcMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));
	        tcMatricula.setCellValueFactory(new PropertyValueFactory<>("Matricula"));
	        tcModelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));

	        // Obtener los datos de los clientes y asignarlos a la tabla
	        Class<? extends ListarVehiculo> listaClientes = getClass();
	        Vehiculos.getElemento((Element) FXCollections.observableArrayList(listaClientes), null, null);
	    }
	public static Object getVehiculo() {
		  return ListarCliente.getSelectionModel().getSelectedItem();
	}
}
