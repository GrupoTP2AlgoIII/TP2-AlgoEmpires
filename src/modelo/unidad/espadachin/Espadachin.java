package modelo.unidad.espadachin;

import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.jugador.Jugador;
import modelo.mapa.Posicion;
import modelo.unidad.Unidad;

public class Espadachin extends Unidad {

	private int alcance = 1;
	
	public Espadachin() {
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25, this.alcance);
	}

	public Espadachin(Jugador jugadorDado) {
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25, this.alcance);
		this.propietario = jugadorDado;
	}


	public Espadachin(int fila, int columna) {
		
		super (fila, columna);
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25, this.alcance);
	}
	
	@Override
	public void atacar (Unidad unidad, Posicion posicionAtacado) {
		if (!posicionAtacado.perteneceALaCuadricula(this.posicion, this.alcance, this.alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		this.ataque.atacar(unidad);
	}
	
	@Override
	public void atacar (Edificio edificio, Posicion posicionAtacado) {
		if (!posicionAtacado.perteneceALaCuadricula(this.posicion, this.alcance, this.alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		this.ataque.atacar(edificio);
	}
	
	@Override
	public int descontarOro(int oro) {
		// TODO Auto-generated method stub
		return 0;
	}

}
