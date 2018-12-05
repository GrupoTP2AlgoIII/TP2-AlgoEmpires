package modelo.unidad.armaDeAsedio;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Unidad;

public class ArmaDeAsedioDesmontada implements EstadoArmaDeAsedio {
	


	@Override
	public void atacar(Edificio edificio, Posicion posicionAtacado, Posicion posicionAtacante, Ataque ataque)  {
		
		throw new ArmaDeAsedioDesmontadaException ();

	}
	
	@Override
	public void atacar(Unidad unidad, Posicion posicionAtacado, Posicion posicionAtacante, Ataque ataque)  {
		
		throw new ArmaDeAsedioDesmontadaException ();

	}
	
	@Override
	public EstadoArmaDeAsedio avanzarTurno() {
		return this;
		
	}

	@Override
	public Posicion desplazarPosicionHasta (Posicion hasta, Posicion posicionActual) {
		
		posicionActual = hasta;
		return posicionActual;
		
	}

}
