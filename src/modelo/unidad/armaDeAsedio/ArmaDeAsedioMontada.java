package modelo.unidad.armaDeAsedio;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Unidad;

public class ArmaDeAsedioMontada implements EstadoArmaDeAsedio {
	
	
	public void atacar(Unidad unidad, Posicion posicionAtacado, Posicion posicionAtacante, Ataque ataque)  {
	
		ataque.atacar(unidad, posicionAtacado, posicionAtacante);	
	}
	
	public void atacar(Edificio edificio, Posicion posicionAtacado, Posicion posicionAtacante, Ataque ataque)  {
		
		ataque.atacar(edificio, posicionAtacado, posicionAtacante);	
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
