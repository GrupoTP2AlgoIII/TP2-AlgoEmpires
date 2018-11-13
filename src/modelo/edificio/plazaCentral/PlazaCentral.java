package modelo.edificio.plazaCentral;

import modelo.edificio.Edificio;

public class PlazaCentral extends Edificio {

		   public PlazaCentral()

		   {
		        this.vida = 450;
                this.costo = 100 ;
		        this.turnosConstruccion = 3;
		        this.tamanio = 4;
		        this.velocidadReparacion = 25;
		    }
		   
		    public boolean crearAldeano() {
		        if(this.turnosConstruccion == 0) {
		        	return true;
		        }
		        return false;
		    }


		    public void avanzarTurno() {
		    	this.turnosConstruccion--;
		    }
		    

}
