package org.iesalandalus.programacion.alquilervehiculos.modelo.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BuscarAlquiler {

	@FXML
	private TableView<?> TablaBuscarAlquiler;

	@FXML
	private TableColumn<?, ?> tcClienteAlquiler;

	@FXML
	private TableColumn<?, ?> tcFechaAlquiler;

	@FXML
	private TableColumn<?, ?> tcFechaDevolucion;

	@FXML
	private TableColumn<?, ?> tcVehiculoAlquiler;

	@FXML
	private TextField tfBuscar;

	  private Alquileres alquileres;

	    public void setAlquileres(Alquileres alquileres) {
	        this.alquileres = alquileres;
	    }

	    @FXML
	    void Buscar(ActionEvent event) {
	        Cliente cliente = tfBuscar.getText();

	        if (((CharSequence) cliente).isEmpty()) {
	            return;
	        }

	        // Realizar la búsqueda utilizando el método buscar() de Alquileres
	        // Puedes adaptar el código según la estructura de tus objetos Alquiler

	        // Ejemplo de búsqueda ficticia
	        Alquiler alquiler = new Alquiler();
	        alquiler.setCliente(cliente);

	        Alquiler alquilerEncontrado = alquileres.buscar(alquiler);

	        if (alquilerEncontrado != null) {
	             TablaBuscarAlquiler.getItems().add(alquilerEncontrado);
	        } else {
	        	Dialogos.mostrarDialogoError("No se encontró ningún alquiler que cumpla con el criterio de búsqueda", null, null);
	        }
	    }
}


