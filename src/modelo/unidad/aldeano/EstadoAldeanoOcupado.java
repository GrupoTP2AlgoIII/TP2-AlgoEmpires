package modelo.unidad.aldeano;

import modelo.edificio.Edificio;

public class EstadoAldeanoOcupado implements EstadoAldeano{

	private int turnosOcupado;
	public EstadoAldeanoOcupado(int turnosOcupado)
	{
		this.turnosOcupado = turnosOcupado;
	}
	@Override
	public EstadoAldeano reparar(Edificio edificio) {
		throw new AldeanoOcupadoException();	
	}

	@Override
	public EstadoAldeano construir(Edificio edificio) {
		throw new AldeanoOcupadoException();
	}

	@Override
	public EstadoAldeano avanzarTurno() {
		this.turnosOcupado--;
		if(this.turnosOcupado == 0) {
			return (new EstadoAldeanoDisponible());
			
		}
		return this;
		
	}
	@Override
	public int obtenerOro() {
		int oroGenerado = 0;
		return oroGenerado;
	}


}
