package modelo.unidad.espadachin;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.jugador.Jugador;
import modelo.mapa.Posicion;
import modelo.unidad.AtacandoAUnAliadoError;
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
	
	public Espadachin (int fila, int columna) {
		super (fila, columna);
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25, this.alcance);	
		
	}

	public Espadachin(int fila, int columna, Jugador jugadorDado) {
		
		super (fila, columna);
		this.vida = 100;
		this.costo = 50;
		this.ataque = new Ataque(15,25, this.alcance);
		this.propietario = jugadorDado;
	}
	
	@Override
	public void atacar (Unidad unidad, Posicion posicionAtacado) {
		if  (posicionableEstaEnPropietario(unidad)) {
			throw new AtacandoAUnAliadoError ();
		}
		this.ataque.atacar(unidad, posicionAtacado, this.posicion);
	}

	@Override
	public void atacar (Edificio edificio, Posicion posicionAtacado) {
		if  (posicionableEstaEnPropietario(edificio)) {
			throw new AtacandoAUnAliadoError ();
		}
		this.ataque.atacar(edificio, posicionAtacado, this.posicion);
	}	

}
