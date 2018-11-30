package modelo.unidad.armaDeAsedio;


import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public abstract class EstadoArmaDeAsedio extends Unidad {
	
	public abstract int avanzarTurno ();
	public abstract void atacar(Posicionable posicionable, Posicion posicion, int alcance, Ataque ataque);
	public abstract void desplazarPosicionHasta (Posicion hasta, Posicion posicionActual);
	public abstract void atacar (Edificio edificio, Posicion posicionAtacado, Posicion posicion, int alcance, Ataque ataque);
	public abstract void atacar (Unidad unidad, Posicion posicionAtacado, Posicion posicion, int alcance, Ataque ataque);
		
}
