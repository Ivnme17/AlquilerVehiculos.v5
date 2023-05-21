package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.OperationNotSupportedException;
import javax.swing.text.html.ImageView;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.recursos.VistaGráfica;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Dialogos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.recursos.*;

public class VentanaPrincipal<Parent> extends Controlador {

	@FXML
	private Button btAgregarClient;

	@FXML
	private Button btAñadirAlq;

	@FXML
	private Button btAñadirVeh;

	@FXML
	private ImageView btBuscaClient;

	@FXML
	private ImageView btBuscarAlq;

	@FXML
	private Button btBuscarVeh;

	@FXML
	private Button btDevolverAlq;

	@FXML
	private Button btDevolverCliente;

	@FXML
	private Button btDevolverVeh;

	@FXML
	private Button btEliminarAlq;

	@FXML
	private Button btEliminarClient;

	@FXML
	private Button btEliminarVeh;

	@FXML
	private Button btGestionarAlq;

	@FXML
	private Button btGestionarClient;

	@FXML
	private MenuItem cerrar;
	private Stage AcercaDe;

	@FXML
	void Cerrar(ActionEvent event) {

	}

	@FXML
	void AccionBoton() {
		System.out.println("Botón pulsado");
	}

	private void leerCliente() {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/AlquilerVehiculos-v3/src/main/resources/vistas/LeerCliente.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(new Scene((javafx.scene.Parent) root));
			stage.showAndWait();
		} catch (IOException e) {
			Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private void gestionarCliente() {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/AlquilerVehiculos-v3/src/main/resources/vistas/ListarCliente.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(new Scene((javafx.scene.Parent) root));
			stage.showAndWait();
		} catch (IOException e) {
			Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private void leerVehiculo() {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/AlquilerVehiculos-v3/src/main/resources/vistas/LeerVehiculo.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(new Scene((javafx.scene.Parent) root));
			stage.showAndWait();
		} catch (IOException e) {
			Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private void leerAlquiler() {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/AlquilerVehiculos-v3/src/main/resources/vistas/LeerAlquiler.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(new Scene((javafx.scene.Parent) root));
			stage.showAndWait();
		} catch (IOException e) {
			Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private void listarAlquileres() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/ruta/del/archivo/ListarAlquiler.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(new Scene((javafx.scene.Parent) root));
			stage.showAndWait();
		} catch (IOException e) {
			Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private void listarVehiculos() {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/AlquilerVehiculos-v3/src/main/resources/vistas/ListarVehiculo.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(new Scene((javafx.scene.Parent) root));
			stage.showAndWait();
		} catch (IOException e) {
			Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	@FXML
	private void initialize() {
		System.out.println("Método initialize de VentanaPrincipal");
		((MenuItem) btAgregarClient).setOnAction(event -> leerCliente());
		((MenuItem) btGestionarClient).setOnAction(event -> gestionarCliente());
		((MenuItem) btAñadirVeh).setOnAction(event -> leerVehiculo());
		((MenuItem) btAñadirAlq).setOnAction(event -> leerAlquiler());
		((MenuItem) btGestionarAlq).setOnAction(event -> listarAlquileres());
		((MenuItem) btBuscarVeh).setOnAction(event -> listarVehiculos());

	}

}