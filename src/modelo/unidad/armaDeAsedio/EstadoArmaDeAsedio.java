package modelo.unidad.armaDeAsedio;


import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Unidad;

public interface EstadoArmaDeAsedio{
	
	public abstract EstadoArmaDeAsedio avanzarTurno ();
	public abstract void atacar(Unidad unidad, Posicion posicionAtacado, Posicion posicionAtacante, Ataque ataque);
	public abstract Posicion desplazarPosicionHasta (Posicion hasta, Posicion posicionActual);
	public abstract void atacar(Edificio edificio, Posicion posicionAtacado, Posicion posicionAtacante, Ataque ataque);
		
}
