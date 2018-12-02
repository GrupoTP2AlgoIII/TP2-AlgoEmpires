package modelo.unidad.armaDeAsedio;

import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class ArmaDeAsedioMontada implements EstadoArmaDeAsedio {
	
	
	public void atacar(Unidad atacado,Posicionable atacante, Posicion posicion, int alcance, Ataque ataque)  {
		
		if (!atacado.estaEnRangoDePosicion (posicion, alcance, alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError();
		}
		ataque.atacar(atacado);	
	}
	
	public void atacar(Edificio atacado,Posicionable atacante, Posicion posicion, int alcance, Ataque ataque)  {
		
		if (!atacado.estaEnRangoDePosicion (posicion, alcance, alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError();
		}
		ataque.atacar(atacado);	
	}
	
	
	@Override
	public EstadoArmaDeAsedio avanzarTurno() {
		return this;
		
	}
	
	@Override
	public Posicion desplazarPosicionHasta (Posicion hasta, Posicion posicionActual) {		
		throw new ArmaDeAsedioMontadaException();
		
	}
	
}
