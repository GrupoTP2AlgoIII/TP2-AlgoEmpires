package modelo.edificio.cuartel;


import modelo.edificio.Edificio;
import modelo.unidad.Unidad;
import modelo.unidad.espadachin.Espadachin;

public class Cuartel extends Edificio{

	   public Cuartel(int vida) {
	   	    this.vida = vida;
		    this.costo = 50;
	        this.tamanio = 4;
	        this.velocidadReparacion = 50;
	        this.vidaFull = 450;
	    }
	   
	    public Unidad crearArquero() {
			//Arquero arquero = new Arquero();
			//return arquero;
	    	return estado.crearArquero();
		}


		public Espadachin crearEspadachin() {
			Espadachin espadachin = new Espadachin();

			return espadachin;
		}
		
	    
	    public void avanzarTurno() {
	    	estado = estado.avanzarTurno(this);
	    }
	    
		public void reparar() {		
			estado = estado.reparar(this);	
		}
	    
		@Override
		public int getVida() {
			return this.vida;
		}

		@Override
		protected int getVidaFull() {
			return this.vidaFull;
		}

		@Override
		protected void sumarVida() {
			int vidaRepararPorTurno = 25;
			if(this.vida < this.vidaFull) {
				this.vida += vidaRepararPorTurno;
			}
		}

		@Override
		public int getTurnosConstruccion() {
			return estado.getTurnosOcupado();
		}

	    
	
}
