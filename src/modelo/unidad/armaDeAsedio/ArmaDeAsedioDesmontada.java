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
	public void atacar(Posicionable posicionable, Posicion posicion, int alcance, Ataque ataque) throws ArmaDeAsedioDesmontadaNoPuedeAtacarError {
		
		throw new ArmaDeAsedioDesmontadaNoPuedeAtacarError ();

	}

	@Override
	public void avanzarTurno() {
		
		this.turnosDesmontada --;
		
	}
	
	//tengo que reescribir los metodos de desplazamiento porque sólo de puede desplazar si turnosDesmontada == 0.

}
