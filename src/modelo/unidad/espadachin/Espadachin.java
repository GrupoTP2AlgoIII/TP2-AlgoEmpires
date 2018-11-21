package modelo.unidad.espadachin;

import modelo.ataque.Ataque;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Espadachin extends Unidad {

	public Espadachin() {
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25);
	}
		
	
	public void atacar(Posicionable posicionable) {
		posicionable.atacado(ataque);
	}
	
}
