package modelo.unidad.armaDeAsedio;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.ataque.Ataque;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;

public class ArmaDeAsedioDesmontada implements EstadoArmaDeAsedio {
	
	private int turnosDesmontada;
	
	public ArmaDeAsedioDesmontada (int cantidadDeTurnosParaDesmontar) {
		
		this.turnosDesmontada = cantidadDeTurnosParaDesmontar;
		
	}

	@Override
	public void atacar(Posicionable posicionable, Posicion posicion, int alcance, Ataque ataque)  {
		
		throw new ArmaDeAsedioDesmontadaNoPuedeAtacarError ();

	}

	@Override
	public void avanzarTurno() {
		
		this.turnosDesmontada --;
		
	}
	
	public void desplazarPosicionHasta (Posicion hasta, Posicion posicionActual) {
		
		if (this.turnosDesmontada > 0) {
			throw new ArmaDeAsedioMontadaNoPuedeDesplazarseError ();
		}
		
		posicionActual = hasta;
		
	}

}
