package modelo.jugador;

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
	
	public void descontarOro(Unidad unidad) {
		this.oro=unidad.descontarOro(this.oro);
	}
	
	public void aumentarOro(int oroAIncrementar) {
		this.oro += oroAIncrementar;
	}
	
	public void aumentarPoblacion() {
		int topePoblacional =50;
		if(this.poblacion < topePoblacional) {		
			this.poblacion++;
		}else {
			throw new JugadorSuperaTopePoblacionalException();
		}

	}
	
	public void decrementarPoblacion() {
		this.poblacion--;
	}
	
	public void aumentarProduccionDeOro() {
		int produccionOroAldeano = 20;
		this.produccionDeOro += produccionOroAldeano;
	}
	
	public void decrementarProduccionDeOro() {
		int produccionOroAldeano = 20;
		this.produccionDeOro -= produccionOroAldeano;
	}
	
	public int getPoblacion() {
		return this.poblacion;
	}





}
