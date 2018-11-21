package modelo.unidad.armaDeAsedio;

import modelo.ataque.Ataque;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class ArmaDeAsedio extends Unidad {

	
	public ArmaDeAsedio() {
		this.vida = 150;
		this.costo = 200;
		this.ataque = new Ataque(75,0);
		
	}
	
	public void atacar(Posicionable posicionable) {
		posicionable.atacado(ataque);
	}

}
