package modelo.unidad.espadachin;

import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.jugador.Poblacion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.jugador.Jugador;

import modelo.unidad.aldeano.AldeanoNoPuedeAtacarError;

public class Espadachin extends Unidad {

	private int alcance = 1;

	public Espadachin(Jugador jugadorDado) {
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25, this.alcance);
		this.propietario = jugadorDado;
	}


	public Espadachin() {
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25, this.alcance);

	}

		
	public Espadachin(int fila, int columna) {
		
		super (fila, columna);
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25, this.alcance);
	}
	

	@Override
	public int descontarOro(int oro) {
		// TODO Auto-generated method stub
		return 0;
	}

}
