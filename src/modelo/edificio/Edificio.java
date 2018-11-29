package modelo.edificio;


import modelo.ataque.Ataque;
import modelo.jugador.JugadorSinOroException;
import modelo.mapa.Posicion;
import modelo.unidad.DesplazarAPosicionOcupadaError;
import modelo.unidad.Posicionable;

public abstract class Edificio extends Posicionable {
    protected int vida;
    protected int costo;
    protected int tamanio;
    protected int velocidadReparacion;
    protected int vidaFull;
    protected EstadoEdificio estado;
    protected Posicion posicionDesde;
    protected Posicion posicionHasta;
	
   

	public Edificio(){
		int turnosEnConstruccionInicial = 3;
		estado = new EstadoEdificioOcupado(turnosEnConstruccionInicial);
		
	}
	
	public Edificio(int desdeX, int desdeY, int hastaX, int hastaY){
		this.posicionDesde = new Posicion (desdeX, desdeY);
		this.posicionHasta = new Posicion (hastaX, hastaY);
		int turnosEnConstruccionInicial = 3;
		estado = new EstadoEdificioOcupado(turnosEnConstruccionInicial);
		
	}

	 // Constructor que reciba 0 por parametro, para inicializar el juego
	 public Edificio(int turnos) {
		if (turnos == 0) {
			estado = new EstadoEdificioDisponible();
		}		
	}
	 
	 public void recibirPosicionable () {
		throw new DesplazarAPosicionOcupadaError ();
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
		
		public void desplazarHasta (Posicion hasta) {
			
			throw new EdificiosNoSePuedenDesplazarError ();
		}
		
		@Override
		public int descontarOro(int oro) {
			if(oro >= this.costo) {
				oro -= this.costo;
				return oro;
		}else {
			throw new JugadorSinOroException();	
		}
		}
		
		@Override
		public int decrementarProduccion(int oro) {
			return oro;
		}
		
		public int getTamanio() {
			return this.tamanio;
		}
		
		@Override
		public int aumentarProduccionDeOro(int produccionDeOro) {
			return produccionDeOro;	
		}
}