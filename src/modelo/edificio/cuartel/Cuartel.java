package modelo.edificio.cuartel;


import modelo.edificio.Edificio;
import modelo.unidad.Unidad;

public class Cuartel extends Edificio{

	   public Cuartel() {
	   	    this.vida = 250;
		    this.costo = 50;
	        this.tamanio = 4;
	        this.velocidadReparacion = 50;
	        this.vidaFull = vida;
	    }
	   
	    public Unidad crearArquero() {
	    	return estado.crearArquero();
		}


		public Unidad crearEspadachin() {
			return estado.crearEspadachin();
		}

		@Override
		public boolean tieneTamanioCorrecto(int desdeX, int desdeY, int hastaX, int hastaY) {
			// TODO Auto-generated method stub
			return false;
		}

	    
	
}
