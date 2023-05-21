package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Vehiculos;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BuscarVehiculo {

	@FXML
	private TableView<?> TablaBuscarVehiculo;

	@FXML
	private TableColumn<Vehiculos, String> tcMarcaVehiculo;

	@FXML
	private TableColumn<Vehiculos, String> tcMatriculaVehiculo;

	@FXML
	private TableColumn<Vehiculos, String> tcModeloVehiculo;

	@FXML
	private TextField tfBuscar;

	  @FXML
	    void initialize() {
	        vehiculos = FXCollections.observableArrayList();
	        TablaBuscarVehiculo.setItems(vehiculos);
	    }

	    @FXML
	    void Buscar(ActionEvent event) {
	        String textoBusqueda = tfBuscar.getText();
	        Vehiculos.clear();
	        for (Vehiculo vehiculo : Vehiculos.getVehiculo(null)) {
	            if (Vehiculo.getMarca().equalsIgnoreCase(textoBusqueda) || Vehiculos.getModelo().equalsIgnoreCase(textoBusqueda)) {
	                Vehiculos.insertar(vehiculo);
	            }
	        }
	    }
	}