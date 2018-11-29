package modelo.edificio.plazaCentral;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Unidad;

public class PlazaCentral extends Edificio {

		   public PlazaCentral()

		   {
		        this.vida = 450;
                this.costo = 100 ;
		        this.tamanio = 4;
		        this.velocidadReparacion = 25;
		        this.vidaFull = 450;
		    }
		   
		    public PlazaCentral(int desdeX, int desdeY, int hastaX, int hastaY) {
		    	this.posicionDesde = new Posicion (desdeX, desdeY);
		    	this.posicionHasta = new Posicion (hastaX, hastaY);
		        this.vida = 450;
                this.costo = 100 ;
		        this.tamanio = 4;
		        this.velocidadReparacion = 25;
		        this.vidaFull = 450;
		    	
		    }

		   public PlazaCentral(int turnos) {
			   super(turnos);
			   this.vida = 450;
			   this.costo = 100;
			   this.tamanio = 4;
			   this.velocidadReparacion = 25;
			   this.vidaFull = 450;
		   }
		   
		    public Unidad crearAldeano() {
		    	return estado.crearAldeano();
		    }

		    
		    public boolean tieneTamanioCorrecto (int desdeX, int desdeY, int hastaX, int hastaY){

		    	boolean tamanioCorrecto = true;

		    	// Se pasan coordeanadas de izquierda a derecha y de abajo hacia arriba
		    	if ( hastaX != (desdeX + 1) || hastaY != (desdeY + 1)){
		    		tamanioCorrecto = false;
		    	}

		    	return tamanioCorrecto;
		    }  
		    
			public boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {
				
				ArrayList <Posicion> posicionesQueOcupaEdificio = new ArrayList <Posicion> ();
				for (int i = this.posicionDesde.getFila(); i < this.posicionHasta.getFila(); i++) {
					for (int j = this.posicionDesde.getColumna(); j < this.posicionHasta.getColumna(); j++) {
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
