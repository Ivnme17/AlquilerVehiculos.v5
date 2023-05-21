package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Alquileres;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListarAlquiler {

	@FXML
	private TableView<?> TablaBuscarAlquiler;

	@FXML
	private TableColumn<Alquileres, String> tcClienteAlquiler;

	@FXML
	private TableColumn<Alquileres, String> tcFechaAlquiler;

	@FXML
	private TableColumn<Alquileres, String> tcFechaDevolucion;

	@FXML
	private TableColumn<Alquileres, String> tcVehiculoAlquiler;

}
