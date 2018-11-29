package modelo.unidad.espadachin;

import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.unidad.Posicionable;
import modelo.unidad.PosicionableJugador1;
import modelo.unidad.PosicionableJugador2;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.AldeanoNoPuedeAtacarError;

public class Espadachin extends Unidad

		/*implements PosicionableJugador1, PosicionableJugador2*/

{

	private int alcance = 1;
	private int ataquepipo;

	public Espadachin() {
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25, this.alcance);
		this.ataquepipo = 10;
	}

	public Espadachin(int fila, int columna) {

		super (fila, columna);
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25, this.alcance);
	}

	public void atacar(Posicionable posicionable) throws AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		if (!posicionable.estaEnRangoDePosicion (this.posicion, this.alcance, this.alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}

		posicionable.atacado(this.ataque);
	}


	public void recibirDanio(int ataqueDado){
		this.vida -= ataqueDado;
	}

	public int getVida(){
		return this.vida;
	}

/*
	@Override


	public Posicionable vs(Posicionable peleable)
		{return peleable.vs(this);}

	@Override
	public void vs(PosicionableJugador1 posicionable) {

	}

	@Override
	public void vs(PosicionableJugador2 enemigo) {

	}




/*

	@Override
	public void vs(PosicionableJugador2 enemigo) {
		enemigo.recibirDanio(this.ataquepipo);
	}
*/

	@Override
	public int descontarOro(int oro) {
		// TODO Auto-generated method stub
		return 0;
	}

}
