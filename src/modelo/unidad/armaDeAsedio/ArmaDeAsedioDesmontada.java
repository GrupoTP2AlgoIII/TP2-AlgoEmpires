package modelo.unidad.armaDeAsedio;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class ArmaDeAsedioDesmontada extends EstadoArmaDeAsedio {
	
	private int turnosDesmontada;
	
	public ArmaDeAsedioDesmontada (int cantidadDeTurnosParaDesmontar) {
		
		this.turnosDesmontada = cantidadDeTurnosParaDesmontar;
		
	}

	@Override
	public void atacar(Posicionable posicionable, Posicion posicion, int alcance, Ataque ataque)  {
		
		throw new ArmaDeAsedioDesmontadaNoPuedeAtacarError ();

	}
	
	@Override
	public void atacar (Edificio edificio, Posicion posicion, int alcance, Ataque ataque) {
		throw new ArmaDeAsedioDesmontadaNoPuedeAtacarError ();

	}
	
	@Override
	public void atacar (Unidad unidad, Posicion posicion, int alcance, Ataque ataque) {
		throw new ArmaDeAsedioDesmontadaNoPuedeAtacarError ();
	}

	@Override
	public int avanzarTurno() {
		
		this.turnosDesmontada --;
		return 0;
		
	}
	
	@Override
	public void desplazarPosicionHasta (Posicion hasta, Posicion posicionActual) {
		
		if (this.turnosDesmontada > 0) {
			throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		}
		
		posicionActual = hasta;
		
	}

}
