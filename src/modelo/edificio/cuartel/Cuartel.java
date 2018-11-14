package modelo.edificio.cuartel;


import modelo.edificio.Edificio;
import modelo.unidad.Unidad;
import modelo.unidad.espadachin.Espadachin;

public class Cuartel extends Edificio{

	   public Cuartel() {
	   	    this.vida = 450;
		    this.costo = 50;
	        this.tamanio = 4;
	        this.velocidadReparacion = 50;
	        this.vidaFull = vida;
	    }
	   
	    public Unidad crearArquero() {
	    	return estado.crearArquero();
		}


		public Espadachin crearEspadachin() {
			Espadachin espadachin = new Espadachin();

			return espadachin;
		}
		
	    
	    public int avanzarTurno() {
	    	estado = estado.avanzarTurno(this);
	    	return 0;
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

		@Override
		public void restarVida(int vidaARestar) {
			this.vida -= vidaARestar;
		}

	    
	
}
