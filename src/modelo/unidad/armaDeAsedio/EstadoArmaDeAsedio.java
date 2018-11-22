package modelo.unidad.armaDeAsedio;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;

public interface EstadoArmaDeAsedio {

	public void avanzarTurno ();
	void atacar(Posicionable posicionable, Posicion posicion, int alcance, Ataque ataque) throws ArmaDeAsedioDesmontadaNoPuedeAtacarError, AtacandoEnPosicionFueraDelAlcanceError;
}
