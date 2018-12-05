package modelo.edificio.cuartel;


import java.util.ArrayList;
import java.util.Iterator;

import modelo.edificio.Edificio;
import modelo.jugador.Jugador;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Cuartel extends Edificio{

	   public Cuartel() {
	   	    this.vida = 250;
		    this.costo = 50;
	        this.tamanio = 4;
	        this.velocidadReparacion = 50;
	        this.vidaFull = vida;
	    }

		public Cuartel(Jugador jugador) {
			this.vida = 250;
			this.costo = 50;
			this.tamanio = 4;
			this.velocidadReparacion = 50;
			this.vidaFull = vida;
			this.propietario = jugador;
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
	   
	   public Cuartel(int desdeX, int desdeY, int hastaX, int hastaY, Jugador jugador) {
		   
		   this.posicionDesde = new Posicion (desdeX, desdeY);
		   this.posicionHasta = new Posicion (hastaX, hastaY);
	   	   this.vida = 250;
		   this.costo = 50;
	       this.tamanio = 4;
	       this.velocidadReparacion = 50;
	       this.vidaFull = vida;
	       this.propietario = jugador;
	    }
	   
	   public void atacar (Posicionable posicionable) {
		   throw new CuartelNoPuedeAtacarError ();
	   }
	   
	   public void atacar (Unidad unidad, Posicion posicionAtacado) {
		   throw new CuartelNoPuedeAtacarError ();		   
	   }
	   
	   public void atacar (Edificio edificio, Posicion posicionAtacado) {
		   throw new CuartelNoPuedeAtacarError ();
	   }
	   
	   	@Override
	    public Unidad crearUnidad(char tipo) {
	    	if(tipo == 'A')
	    		return estado.crearArquero();
	    	else
	    		return estado.crearEspadachin();
		}

		@Override
		public Unidad crearUnidadPropia(char tipo, Jugador jugador) {
			if(tipo == 'A')
				return estado.crearArqueroDeJugador(this.propietario);
			else
				return estado.crearEspadachinDeJugador(this.propietario);
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
