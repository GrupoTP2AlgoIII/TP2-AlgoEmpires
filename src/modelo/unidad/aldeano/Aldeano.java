package modelo.unidad.aldeano;

import modelo.edificio.cuartel.Cuartel;

public class Aldeano {
	
	private int oroGenerado;
	private boolean construyendo;
	
	   public Aldeano() {
	        this.oroGenerado = 20;
	        this.construyendo = false;
	    }
	   
	    public Cuartel construirCuartel() {
	    	this.construyendo = true;
	    	Cuartel cuartel = new Cuartel();
	    	return cuartel;
	    }
	    
	    public int avanzarTurno() {
	    	if (this.construyendo) {
	    		return 0;
	    	}
	    	return this.oroGenerado;
	    }
}
