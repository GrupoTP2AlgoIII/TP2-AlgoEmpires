package modelo.unidad.armaDeAsedio;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;

public class ArmaDeAsedioMontada implements EstadoArmaDeAsedio {
	
	private int turnosMontar;
	
	public ArmaDeAsedioMontada (int turnosMontar) {
		
		this.turnosMontar = turnosMontar;
	}

	@Override
	public void atacar(Posicionable posicionable, Posicion posicion, int alcance, Ataque ataque) throws AtacandoEnPosicionFueraDelAlcanceError, ArmaDeAsedioDesmontadaNoPuedeAtacarError {
		
		if (this.turnosMontar > 0) {
			throw new ArmaDeAsedioDesmontadaNoPuedeAtacarError ();
		}
		if (!posicionable.estaEnRangoDePosicion (posicion, alcance, alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		
		posicionable.atacado(ataque);
	}

	@Override
	public void avanzarTurno() {
		
		this.turnosMontar --;
		
	}
	
	public void desplazarPosicionHasta (Posicion hasta, Posicion posicionActual) {
		
		throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		
	}
}
