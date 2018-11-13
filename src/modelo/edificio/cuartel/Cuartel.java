package modelo.edificio.cuartel;


import modelo.edificio.Edificio;
import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;

public class Cuartel extends Edificio{

	   public Cuartel() {
	   	    this.vida = 250;
		    this.costo = 50;
	        this.turnosConstruccion = 3;
	        this.tamanio = 4;
	        this.velocidadReparacion = 50;
	    }
	   
	    public Arquero crearArquero() {
			if (this.turnosConstruccion == 0) {
				Arquero arquero = new Arquero();
				return arquero;
			}
			return null;
		}


		public Espadachin crearEspadachin() {
			Espadachin espadachin = new Espadachin();
			if (this.turnosConstruccion == 0) {
				return espadachin;
			}
			return null;
		}
	    
	    public void avanzarTurno() {
	    	this.turnosConstruccion--;
	    }
	    
	    public int getTurnosConstruccion() {
	    	return this.turnosConstruccion;
	    }

	    
	
}
