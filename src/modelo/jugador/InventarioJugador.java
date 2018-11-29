package modelo.jugador;

import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class InventarioJugador {
	private int oro;
	private int poblacion;
	private int produccionDeOro;
	
	public InventarioJugador(int oroInicial,int poblacionInicial,int produccionOroInicial) {
		this.oro = oroInicial;
		this.poblacion = poblacionInicial;
		this.produccionDeOro = produccionOroInicial;
	}
	
	public void descontarOro(Posicionable unidad) {
		this.oro=unidad.descontarOro(this.oro);
	}
	
	public void aumentarOro(int oroAIncrementar) {
		this.oro += oroAIncrementar;
	}
	
	public void aumentarPoblacion(Unidad unidad) {
		int topePoblacional =50;
		if(this.poblacion < topePoblacional) {		
			this.poblacion++;
			this.produccionDeOro = unidad.aumentarProduccionDeOro(this.produccionDeOro);
		}else {
			throw new JugadorSuperaTopePoblacionalException();
		}

	}
	
	public void decrementarPoblacion() {
		this.poblacion--;
	}
	
	public void decrementarProduccionDeOro(Posicionable unidad) {
		unidad.decrementarProduccion(this.produccionDeOro);
	}
	
	public int getPoblacion() {
		return this.poblacion;
	}





}
