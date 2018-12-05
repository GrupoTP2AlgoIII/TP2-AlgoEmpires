package modelo.unidad.armaDeAsedio;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Unidad;

public class ArmaDeAsedioDesmontandose implements EstadoArmaDeAsedio{

	
	@Override
	public EstadoArmaDeAsedio avanzarTurno() {
		return (new ArmaDeAsedioDesmontada());
	}

	@Override
	public void atacar(Unidad unidad, Posicion posicionAtacado, Posicion posicionAtacante, Ataque ataque) {
		throw new ArmaDeAsedioDesmontandoseException ();
		
	}
	
	@Override
	public void atacar(Edificio edificio, Posicion posicionAtacado, Posicion posicionAtacante, Ataque ataque) {
		throw new ArmaDeAsedioDesmontandoseException ();
		
	}

	@Override
	public Posicion desplazarPosicionHasta(Posicion hasta, Posicion posicionActual) {
		throw new ArmaDeAsedioDesmontandoseException ();
		
	}

}
