package org.iesalandalus.programacion.alquilervehiculos.modelo.vista;

import org.iesalandalus.programacion.alquilervehiculos.modelo.vista.recursos.LanzadorVentanaPrincipal;

import javafx.application.Application;

public enum FactoriaVista {
	TEXTO {
		@Override
		public Application crear() {
			// TODO Auto-generated method stub
			return null;
		}
	},
	GRAFICA {
		@Override
		public Application crear() {
			return new LanzadorVentanaPrincipal();
		}
	};

	public abstract Application crear();
}
