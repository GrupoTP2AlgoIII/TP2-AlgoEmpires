package modelo.edificio.cuartel;


import java.util.ArrayList;
import java.util.Iterator;

import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Unidad;

public class Cuartel extends Edificio{

	   public Cuartel() {
	   	    this.vida = 250;
		    this.costo = 50;
	        this.tamanio = 4;
	        this.velocidadReparacion = 50;
	        this.vidaFull = vida;
	    }
	   
	   public Cuartel(int desdeX, int desdeY, int hastaX, int hastaY) {
		   
		   this.posicionDesde = new Posicion (desdeX, desdeY);
		   this.posicionHasta = new Posicion (hastaX, hastaY);
	   	   this.vida = 250;
		   this.costo = 50;
	       this.tamanio = 4;
	       this.velocidadReparacion = 50;
	       this.vidaFull = vida;
	    }
	   
	    public Unidad crearArquero() {
	    	return estado.crearArquero();
		}


		public Unidad crearEspadachin() {
			return estado.crearEspadachin();
		}

		@Override
		public boolean tieneTamanioCorrecto(int desdeX, int desdeY, int hastaX, int hastaY) {
			// TODO Auto-generated method stub
			return false;
		}
		
		public boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {
			
			
			ArrayList <Posicion> posicionesQueOcupaEdificio = new ArrayList <Posicion> ();
			for (int i = this.posicionDesde.getFila(); i <= this.posicionHasta.getFila(); i++) {
				for (int j = this.posicionDesde.getColumna(); j <= this.posicionHasta.getColumna(); j++) {
					Posicion posicionActual = new Posicion (i, j);
					posicionesQueOcupaEdificio.add(posicionActual);
				}
			}
			
			
			 Iterator<Posicion> iterador = posicionesQueOcupaEdificio.iterator();
			while (iterador.hasNext ()) {
				if (iterador.next().perteneceALaCuadricula(posicion, alcanceEnFila, alcanceEnColumna)) {
					return true;
				}
			}
			
			return false;
		}

	    
	
}
