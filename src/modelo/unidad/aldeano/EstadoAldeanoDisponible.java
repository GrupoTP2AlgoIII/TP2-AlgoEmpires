package modelo.unidad.aldeano;

import modelo.edificio.Edificio;

public class EstadoAldeanoDisponible implements EstadoAldeano {

	@Override
	public EstadoAldeano reparar(Edificio edificio) {
		int turnosOcupado = 2;
		return (new EstadoAldeanoOcupado(turnosOcupado));
		
	}

	@Override
	public EstadoAldeano construir(Edificio edificio) {
		int turnosOcupado = 3;
		return (new EstadoAldeanoOcupado(turnosOcupado));
		
	}

	@Override
	public EstadoAldeano avanzarTurno() {
		return this;
	}

	@Override
	public int obtenerOro() {
		int oroGenerado = 20;
		return oroGenerado;
	}

}
