package modelo.edificio.plazaCentral;

public class PlazaCentral {
	
		private int turnosConstruccion;
		
		   public PlazaCentral() {
		        this.turnosConstruccion = 3;
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
