package modelo.edificio.castillo;

import modelo.edificio.Edificio;
import modelo.unidad.Unidad;

public class Castillo extends Edificio {

    public Castillo() {
        this.vida = 1000;
        this.tamanio = 16;
        this.velocidadReparacion = 15;
	    this.costo = 50;
        this.vidaFull = vida;
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

}
