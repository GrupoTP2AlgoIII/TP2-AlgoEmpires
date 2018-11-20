package modelo.edificio.cuartel;


import modelo.ataque.Ataque;
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
			if(this.vida < this.vidaFull) {
				this.vida += this.velocidadReparacion;
			}
			if(this.vida > this.vidaFull) {
				this.vida = this.vidaFull;
			}
		}
		
		

		@Override
		public int getTurnosConstruccion() {
			return estado.getTurnosOcupado();
		}

		
		@Override
		public int getVelocidadDeReparacion() {
			return this.velocidadReparacion;
		}
		


		@Override
		public void atacado(Ataque ataque) {
			this.vida -= ataque.getAtaqueEdificio();		
		}

	    
	
}
