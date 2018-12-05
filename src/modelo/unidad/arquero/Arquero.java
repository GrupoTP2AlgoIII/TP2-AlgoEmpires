package modelo.unidad.arquero;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.jugador.Jugador;
import modelo.mapa.Posicion;
import modelo.unidad.AtacandoAUnAliadoError;
import modelo.unidad.Unidad;

public class Arquero extends Unidad {

	private int alcance = 3;
	
	public Arquero() {
		this.vida = 75;
		this.costo = 75;
		this.ataque = new Ataque(10,15, this.alcance);
	}

	public Arquero(int fila, int columna, Jugador jugadorDado) {
		super (fila, columna);
		this.vida = 75;
		this.costo = 75;
		this.ataque = new Ataque(10,15, this.alcance);
		this.propietario = jugadorDado;
	}
	
	public Arquero(Jugador jugadorDado) {
		this.vida = 75;
		this.costo = 75;
		this.ataque = new Ataque(10,15, this.alcance);
		this.propietario = jugadorDado;
	}	
	
	public Arquero (int fila, int columna) {
		
		super (fila, columna);
		this.vida = 75;
		this.costo = 75;
		this.ataque = new Ataque(10,15, this.alcance);
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
