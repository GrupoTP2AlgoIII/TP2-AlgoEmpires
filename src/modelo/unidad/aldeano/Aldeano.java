package modelo.unidad.aldeano;

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

		public Edificio construirPropio(char tipo, Jugador jugador) {
			if(tipo == 'C') {
				Edificio cuartel = new Cuartel(jugador);
				estado = estado.construir(cuartel);
				return cuartel;
			}

			Edificio plaza = new PlazaCentral(0, jugador);
			estado = estado.construir(plaza);
			return plaza;
		}

	    @Override
	    public int avanzarTurno() {
	    	estado = estado.avanzarTurno();
	    	this.cantidadDeMovimientos=0;
	    	return estado.obtenerOro();
	    }




	public void reparar(Edificio edificio) {
		edificio.reparar();
		estado = estado.reparar(edificio);
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
		public int decrementarProduccion(int oro) {
			oro -= this.produccionOro;
			return oro;
		}

		@Override
		public int aumentarProduccionDeOro(int produccionDeOro) {
			produccionDeOro += estado.obtenerOro();
			return produccionDeOro;

		}


}
