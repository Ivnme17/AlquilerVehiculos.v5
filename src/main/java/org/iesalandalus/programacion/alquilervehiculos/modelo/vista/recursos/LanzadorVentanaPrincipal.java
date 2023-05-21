package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.recursos;

import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Controladores;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Dialogos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LanzadorVentanaPrincipal extends Application {

	private static final String TITULO = null;

	@Override
	public void start(Stage escenarioPrincipal) throws Exception {
		String nombreFxml = "/vistas/VentanaPrincipal.fxml";
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(nombreFxml));
		Parent nodo = loader.load();

		Scene escena = new Scene(nodo, 600, 400);
		escenarioPrincipal.setScene(escena);
		escenarioPrincipal.show();
	}

	public static void comenzar() {
		launch(LanzadorVentanaPrincipal.class);

	}

}
