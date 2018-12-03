package modelo.unidad.armaDeAsedio;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class ArmaDeAsedioDesmontada implements EstadoArmaDeAsedio {
	


	@Override
	public void atacar(Edificio atacado,Posicionable atacante, Posicion posicion, int alcance, Ataque ataque)  {
		
		throw new ArmaDeAsedioDesmontadaException ();

	}
	
	@Override
	public void atacar(Unidad atacado,Posicionable atacante, Posicion posicion, int alcance, Ataque ataque)  {
		
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
