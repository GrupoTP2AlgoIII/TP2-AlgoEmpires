package modelo.unidad.armaDeAsedio;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class ArmaDeAsedioMontada extends EstadoArmaDeAsedio {
	
	private int turnosMontar;
	
	public ArmaDeAsedioMontada (int turnosMontar) {
		
		this.turnosMontar = turnosMontar;
	}
	
	@Override
	public void atacar(Posicionable posicionable, Posicion posicion, int alcance, Ataque ataque)  {
		
		if (this.turnosMontar > 0) {
			throw new ArmaDeAsedioDesmontadaNoPuedeAtacarError ();
		}
		if (!posicionable.estaEnRangoDePosicion (posicion, alcance, alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		
		posicionable.recibirDanioDe (this);
	}
	
	@Override
	public void atacar (Edificio edificio, Posicion posicionAtacado, Posicion posicion, int alcance, Ataque ataque) {
		if (this.turnosMontar > 0) {
			throw new ArmaDeAsedioDesmontadaNoPuedeAtacarError ();
		}
		if (!posicionAtacado.perteneceALaCuadricula(posicion, alcance, alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		
		edificio.recibirDanioDe (this);
	}
	
	@Override
	public void atacar (Unidad unidad, Posicion posicionAtacado, Posicion posicion, int alcance, Ataque ataque) {
		if (this.turnosMontar > 0) {
			throw new ArmaDeAsedioDesmontadaNoPuedeAtacarError ();
		}
		
		if (!posicionAtacado.perteneceALaCuadricula(posicion, alcance, alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		
		unidad.recibirDanioDe (this);
		
	}
	
	@Override
	public int avanzarTurno() {
		
		this.turnosMontar --;
		return 0;
		
	}
	
	@Override
	public void desplazarPosicionHasta (Posicion hasta, Posicion posicionActual) {
		
		throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		
	}
}
