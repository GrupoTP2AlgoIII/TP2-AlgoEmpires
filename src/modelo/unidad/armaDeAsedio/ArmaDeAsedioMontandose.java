package modelo.unidad.armaDeAsedio;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class ArmaDeAsedioMontandose implements EstadoArmaDeAsedio {

	
	@Override
	public EstadoArmaDeAsedio avanzarTurno() {
		return (new ArmaDeAsedioMontada());
	}

	@Override
	public void atacar(Unidad posicionable, Posicionable atacante, Posicion posicion, int alcance,
			Ataque ataque) {
		throw new ArmaDeAsedioMontandoseException();
		
	}
	
	@Override
	public void atacar(Edificio posicionable, Posicionable atacante, Posicion posicion, int alcance,
			Ataque ataque) {
		throw new ArmaDeAsedioMontandoseException();
		
	}

	@Override
	public Posicion desplazarPosicionHasta(Posicion hasta, Posicion posicionActual) {
		throw new ArmaDeAsedioMontandoseException();	
	}

}
