package modelo.edificio.plazaCentral;

import modelo.edificio.Edificio;
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

}
