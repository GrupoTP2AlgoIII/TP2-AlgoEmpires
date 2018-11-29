package modelo.unidad.armaDeAsedio;


import modelo.ataque.Ataque;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;

public interface EstadoArmaDeAsedio {

	public void avanzarTurno ();
	void atacar(Posicionable posicionable, Posicion posicion, int alcance, Ataque ataque) ;
	public void desplazarPosicionHasta (Posicion hasta, Posicion posicionActual);
		
}
