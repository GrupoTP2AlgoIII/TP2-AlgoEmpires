package modelo.unidad.arquero;

import modelo.ataque.Ataque;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Arquero extends Unidad {

	
	public Arquero() {
		this.vida = 75;
		this.costo = 75;
		this.ataque = new Ataque(10,15);
	}
	
	
	public void atacar(Posicionable posicionable) {
		posicionable.atacado(ataque);
	}

}
