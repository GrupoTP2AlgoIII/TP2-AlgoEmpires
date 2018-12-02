package modelo.unidad.armaDeAsedio;


import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public interface EstadoArmaDeAsedio{
	
	public abstract EstadoArmaDeAsedio avanzarTurno ();
	public abstract void atacar(Unidad atacado,Posicionable atacante, Posicion posicion, int alcance, Ataque ataque);
	public abstract void atacar(Edificio atacado,Posicionable atacante, Posicion posicion, int alcance, Ataque ataque);
	public abstract Posicion desplazarPosicionHasta (Posicion hasta, Posicion posicionActual);
		
}
