package modelo.unidad.aldeano;

import modelo.edificio.Edificio;
import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
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
	    
	    public int avanzarTurno() {
	    	estado = estado.avanzarTurno();
	    	return estado.obtenerOro();
	    }


	@Override
	public void recibirDanio(int ataque) {

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
