package modelo.unidad.arquero;

import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Arquero extends Unidad {

	private int alcance = 3;
	
	public Arquero() {
		this.vida = 75;
		this.costo = 75;
		this.ataque = new Ataque(10,15, this.alcance);
	}
	
	public Arquero (int fila, int columna) {
		
		super (fila, columna);
		this.vida = 75;
		this.costo = 75;
		this.ataque = new Ataque(10,15, this.alcance);
	}
	
	@Override
	public void atacar(Posicionable posicionable)  {
		if (!posicionable.estaEnRangoDePosicion (this.posicion, this.alcance, this.alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		
		posicionable.recibirDanioDe(this);
	}


	



}
