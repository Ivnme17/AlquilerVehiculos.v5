package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.fichero;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.naming.OperationNotSupportedException;
import javax.naming.spi.DirStateFactory.Result;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public abstract class Vehiculos implements IVehiculos {
	private String FICHEROS_VEHICULOS;
	private String RAIZ;
	private String VEHICULO;
	private String MARCA;
	private String MODELO;
	private String MATRICULA;
	private String CILINDRADA;
	private String PLAZAS;
	private String PMA;
	private String TIPO;
	private String TURISMO;
	private String AUTOBUS;
	private String FURGONETA;

	private List<Vehiculo> coleccionVehiculos;

	public Vehiculos() {
		this.coleccionVehiculos = new ArrayList<>();
	}

	@Override
	public List<Vehiculo> get() {
		return new ArrayList<>(coleccionVehiculos);
	}

	public void comenzar() {
		leerDom();
	}

	private void leerDom() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.parse(new File(FICHEROS_VEHICULOS));
			Element raiz = documento.getDocumentElement();
			NodeList vehiculos = raiz.getElementsByTagName(TURISMO);
			for (int i = 0; i < vehiculos.getLength(); i++) {
				Node nodoVehiculo = vehiculos.item(i);
				if (nodoVehiculo.getNodeType() == Node.ELEMENT_NODE) {
					Element elementoVehiculo = (Element) nodoVehiculo;
					Vehiculo vehiculo = getVehiculo(elementoVehiculo);
					coleccionVehiculos.add(vehiculo);
				}
			}
		} catch (Exception e) {
			System.out.println("No se pudo leer el fichero de vehículos.");
		}
	}

	private Vehiculo getVehiculo(Element elementoVehiculo) throws OperationNotSupportedException {
		String marca = elementoVehiculo.getAttribute(MARCA);
		String modelo = elementoVehiculo.getAttribute(MODELO);
		String matricula = elementoVehiculo.getAttribute(MATRICULA);
		String cilindrada = elementoVehiculo.getAttribute(CILINDRADA);
		String plazas = elementoVehiculo.getAttribute(PLAZAS);
		String pma = elementoVehiculo.getAttribute(PMA);
		String tipo = elementoVehiculo.getAttribute(TIPO);
		if (tipo.equalsIgnoreCase(TURISMO)) {
			return new Turismo(marca, modelo, matricula, Integer.parseInt(cilindrada), Integer.parseInt(plazas));
		} else if (tipo.equalsIgnoreCase(AUTOBUS)) {
			return new Autobus(marca, modelo, matricula, Integer.parseInt(cilindrada), Integer.parseInt(plazas),
					Integer.parseInt(pma));
		} else if (tipo.equalsIgnoreCase(FURGONETA)) {
			return new Furgoneta(marca, modelo, matricula, Integer.parseInt(cilindrada), Integer.parseInt(plazas),
					Integer.parseInt(pma));
		} else {
			throw new OperationNotSupportedException("Tipo de vehículo no válido.");
		}
	}

	public void terminar() {
		crearDom();
	}

	private void crearDom() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.newDocument();

			Element raiz = documento.createElement(RAIZ);
			documento.appendChild(raiz);

			for (Vehiculo vehiculo : coleccionVehiculos) {
				Element elementoVehiculo = null;
				if (vehiculo instanceof Turismo) {
					elementoVehiculo = documento.createElement(TURISMO);
				} else if (vehiculo instanceof Autobus) {
					elementoVehiculo = documento.createElement(AUTOBUS);
				} else if (vehiculo instanceof Furgoneta) {
					elementoVehiculo = documento.createElement(FURGONETA);
				}

				elementoVehiculo.setAttribute(MARCA, vehiculo.getMarca());
				elementoVehiculo.setAttribute(MODELO, vehiculo.getModelo());
				elementoVehiculo.setAttribute(MATRICULA, vehiculo.getMatricula());
				elementoVehiculo.setAttribute(CILINDRADA, String.valueOf(vehiculo.getCilindrada()));
				elementoVehiculo.setAttribute(PLAZAS, String.valueOf(vehiculo.getPlazas()));
				if (vehiculo instanceof Autobus || vehiculo instanceof Furgoneta) {
					elementoVehiculo.setAttribute(PMA, String.valueOf(((Vehiculo) vehiculo).getMarca()));
				}

				raiz.appendChild(elementoVehiculo);
			}

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			StreamResult output = new StreamResult(new File(FICHEROS_VEHICULOS));
			Source input = new DOMSource(documento);
			transformer.transform(input, (javax.xml.transform.Result) output);
		} catch (Exception e) {
			System.out.println("No se pudo crear el archivo de vehículos.");
		}
	}

	private Element getElemento(Vehiculo vehiculo) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File(FICHEROS_VEHICULOS));
            Element raiz = documento.getDocumentElement();
            NodeList vehiculos = raiz.getElementsByTagName(TURISMO);
            for (int i = 0; i < vehiculos.getLength(); i++) {
                Node nodoVehiculo = vehiculos.item(i);
                if (nodoVehiculo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoVehiculo = (Element) nodoVehiculo;
                    if (elementoVehiculo.getAttribute(MATRICULA).equals(vehiculo.getMatricula())) {
                        return elementoVehiculo;
                    }
                }
            }
        }
    }

	@Override
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		if (vehiculo != null && !coleccionVehiculos.contains(vehiculo)) {
			coleccionVehiculos.add(vehiculo);
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}
	}

	@Override
	public Vehiculo buscar(Vehiculos vehiculo) {
		int index = coleccionVehiculos.indexOf(vehiculo);
		if (index >= 0) {
			return coleccionVehiculos.get(index);
		} else if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		return null;
	}

	@Override
	public void borrar(Vehiculos vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}

		if (!coleccionVehiculos.remove(vehiculo)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		}
	}

}