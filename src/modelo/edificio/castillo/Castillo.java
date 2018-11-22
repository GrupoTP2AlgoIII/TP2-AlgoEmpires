package modelo.edificio.castillo;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Castillo extends Edificio {
	
	private Ataque ataque;
	private int alcance = 3;

    public Castillo() {
        this.vida = 1000;
        this.tamanio = 16;
        this.velocidadReparacion = 15;
	    this.costo = 50;
        this.vidaFull = vida;
        this.ataque = new Ataque (20, 20, this.alcance);
        
    }

    public Unidad crearArmaAsedio(){
    	return estado.crearArmaAsedio();
    }

    public boolean tieneTamanioCorrecto (int desdeX, int desdeY, int hastaX, int hastaY){

    	boolean tamanioCorrecto = true;

    	// Se pasan coordeanadas de izquierda a derecha y de abajo hacia arriba
    	if ( hastaX != (desdeX + 3) || hastaY != (desdeY + 3)){
    		tamanioCorrecto = false;
    	}

    	return tamanioCorrecto;
    }

    public void atacar(Posicionable posicionable) {
		posicionable.atacado(this.ataque);
	}
    
	public boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {
		
		ArrayList <Posicion> posicionesQueOcupaEdificio = crearListaConPosicionesQueOcupa(this.posicionDesde, this.posicionHasta);
		
		Iterator<Posicion> iterador = posicionesQueOcupaEdificio.iterator();
		while (iterador.hasNext ()) {
			if (iterador.next().perteneceALaCuadricula(posicion, alcanceEnFila, alcanceEnColumna)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	private ArrayList <Posicion> crearListaConPosicionesQueOcupa (Posicion desde, Posicion hasta) {
		ArrayList <Posicion> posicionesQueOcupa = new ArrayList <Posicion> ();
		for (int i = desde.getFila(); i < hasta.getFila(); i++) {
			for (int j = desde.getColumna(); j < hasta.getColumna(); j++) {
				Posicion posicionActual = new Posicion (i, j);
				posicionesQueOcupa.add(posicionActual);
			}
		}
		return posicionesQueOcupa;
	}
	
	public void atacarEnemigosAlAlcance () {
		
		//FALTA RESOLVER ESTO
		Posicion desdeAlcance = new Posicion (this.posicionDesde.getFila() - 3, this.posicionDesde.getColumna() - 3);
		Posicion hastaAlcance = new Posicion (this.posicionHasta.getFila() + 3, this.posicionHasta.getColumna() + 3);
		ArrayList <Posicion> posicionesAlcanzables = crearListaConPosicionesQueOcupa (desdeAlcance, hastaAlcance);
		
		Iterator<Posicion> iterador = posicionesAlcanzables.iterator();
		while (iterador.hasNext()) {
			// if (iterador.hasNext () != vacio) {
			//		atacar(posicionable que se encuentra en la posicion iterador.next());
			//}
		}
		
		//para hacer esto de atacar, el catillo necesita conocer al mapa así puede saber si en las posiciones que estan a su
		//alcance hay algun posicionable o esta vacio. Entonces va a atacar solo a los vacios.
	}
	
}
