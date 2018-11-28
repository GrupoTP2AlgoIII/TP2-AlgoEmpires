package modelo.unidad.aldeano;

import modelo.edificio.Edificio;
import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.JugadorSinOroException;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Aldeano extends Unidad {
	
	private EstadoAldeano estado = new EstadoAldeanoDisponible();

	
	   public Aldeano() {
	        this.vida = 50;
	        this.costo = 25;
	    }
	   
	    public Edificio construirCuartel() {
	    	Edificio cuartel = new Cuartel();
	    	estado = estado.construir(cuartel);
	    	return cuartel;
	    }
	    
	    public Edificio construirPlazaCentral() {
	    	Edificio plaza = new PlazaCentral();
	    	estado = estado.construir(plaza);
	    	return plaza;
	    }
	    
	    
	    public int avanzarTurno() {
	    	estado = estado.avanzarTurno();
	    	return estado.obtenerOro();
	    }

		public void reparar(Edificio cuartel) {
			cuartel.reparar();
			estado = estado.reparar(cuartel);

		}
		
		@Override
		public void atacar (Posicionable posicionable) {
			
			throw new AldeanoNoPuedeAtacarError ();
		}

		@Override
		public int descontarOro(int oro) {
			if(oro >= 25) {
				oro -= 25;
				return oro;
		}else {
			throw new JugadorSinOroException();	
		}
			
		}

}
