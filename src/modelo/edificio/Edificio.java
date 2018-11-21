package modelo.edificio;

import modelo.ataque.Ataque;
import modelo.unidad.Posicionable;

public abstract class Edificio extends Posicionable{
    protected int vida;
    protected int costo;
    protected int tamanio;
    protected int velocidadReparacion;
    protected int vidaFull;
    protected EstadoEdificio estado;
	
   
	public abstract boolean tieneTamanioCorrecto (int desdeX, int desdeY, int hastaX, int hastaY);
	
	public Edificio(){
		int turnosEnConstruccionInicial = 3;
		estado = new EstadoEdificioOcupado(turnosEnConstruccionInicial);
	}
	

	   public boolean estaOcupado() {
		   return true;		
	   }
	
	   public int avanzarTurno() {
	    	estado = estado.avanzarTurno(this);
	    	return 0;
	    }
	    
		public void reparar() {		
			estado = estado.reparar(this);	
		}
	    
		public int getVida() {
			return this.vida;
		}

		protected int getVidaFull() {
			return this.vidaFull;
		}

		protected void sumarVida() {
			if(this.vida < this.vidaFull) {
				this.vida += this.velocidadReparacion;
			}
			if(this.vida > this.vidaFull) {
				this.vida = this.vidaFull;
			}
		}
		
		
		public int getTurnosConstruccion() {
			return estado.getTurnosOcupado();
		}


		public int getVelocidadDeReparacion() {
			return this.velocidadReparacion;
		}

		public void atacado(Ataque ataque) {
			this.vida -= ataque.getAtaqueEdificio();
			
		}

}