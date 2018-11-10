package modelo.edificio.cuartel;

public class Cuartel {

	private int turnosConstruccion;
	
	   public Cuartel() {
	        this.turnosConstruccion = 3;
	    }
	   
	    public boolean crearArquero() {
	        if(this.turnosConstruccion == 0) {
	        	return true;
	        }
	        return false;
	    }
	    
	    public void avanzarTurno() {
	    	this.turnosConstruccion--;
	    }
	    
	    public int getTurnosConstruccion() {
	    	return this.turnosConstruccion;
	    }
	    
	    
	
}
