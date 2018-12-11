package modelo.unidad.aldeano;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Aldeano extends Unidad {

	private EstadoAldeano estado = new EstadoAldeanoDisponible();

	private int produccionOro;

	   public Aldeano() {
	        this.vida = 50;
	        this.costo = 25;
	        this.produccionOro = 20;
	    }

		public Aldeano(Jugador jugadorDado) {
			this.vida = 50;
			this.costo = 25;
			this.produccionOro = 20;
			this.propietario = jugadorDado;
		}
		
		public Aldeano(Jugador jugadorDado,Posicion posicion) {
			this.vida = 50;
			this.costo = 25;
			this.produccionOro = 20;
			this.propietario = jugadorDado;
			this.posicion = posicion;
	    }
		
		public Aldeano (int fila, int columna, Jugador jugador) {
			
			super (fila, columna);
			this.vida = 50;
			this.costo = 25;
			this.produccionOro = 20;
			this.propietario = jugador;
		}

		@Override
	    public Edificio construir(char tipo) {
	    	if(tipo == 'C') {
	    		Edificio cuartel = new Cuartel();
	    		estado = estado.construir(cuartel);
	    		return cuartel;
	    	}

		    Edificio plaza = new PlazaCentral();
		    estado = estado.construir(plaza);
		    return plaza;
	    }
		
		@Override
		public Edificio construirPropio(char tipo, Jugador jugador) {
			if(tipo == 'C') {
				Edificio cuartel = new Cuartel (jugador);
				estado = estado.construir(cuartel);
				return cuartel;
			}

			Edificio plaza = new PlazaCentral(jugador);
			estado = estado.construir(plaza);
			return plaza;
		}

	    @Override
	    public int avanzarTurno() {
	    	estado = estado.avanzarTurno();
	    	this.cantidadDeMovimientos=0;
	    	return estado.obtenerOro();
	    }
	    
		@Override
		protected void mover() {
			if(!(this.estado.obtenerOro() == this.produccionOro)) {
				throw new AldeanoOcupadoException();
			}			
		}
		
	    public void reparar(Posicionable edificio) {
	    	edificio.aceptaReparacion();
	    	Edificio edificioAReparar = (Edificio) edificio;
	    	edificioAReparar.reparar();
	    	estado = estado.reparar(edificioAReparar);
		}

		@Override
		public void atacar (Posicionable posicionable) {

			throw new AldeanoNoPuedeAtacarError ();
		}
		
		@Override
		public void atacar (Unidad unidad, Posicion posicionAtacado) {
			throw new AldeanoNoPuedeAtacarError ();
		}
		
		@Override
		public void atacar (Edificio edificio, Posicion posicionAtacado) {
			throw new AldeanoNoPuedeAtacarError ();
		}

		@Override
		public int produccionDeOro() {
			return this.estado.obtenerOro();
		}
		
		//VISTA
		@Override
		protected Ataque getAtaque() {
			return new Ataque (0,0,0);
		}
		
}
