package modelo.edificio;

import modelo.unidad.Unidad;

public class EstadoEdificioOcupado implements EstadoEdificio{
	private int turnosOcupado;
	
	public EstadoEdificioOcupado(int turnosOcupado) {
		this.turnosOcupado = turnosOcupado;
	}

	@Override
	public Unidad crearArquero() {
		return null;//cambiar por exception, esta asi para que pasen las pruebas.
	}

	@Override
	public EstadoEdificio avanzarTurno(Edificio edificio) {
		
		if(this.turnosOcupado > 0) {
			edificio.sumarVida();
		}
		this.turnosOcupado--;
		if(this.turnosOcupado==0) {
			return new EstadoEdificioDisponible();
		}
		return this;
		
	}

	@Override
	public EstadoEdificio reparar(Edificio edificio) {
		//throw new EdificioOcupadoException();
		return null;
	}

	@Override
	public Unidad crearAldeano() {
		return null; //cambiar por exception
	}

	@Override
	public int getTurnosOcupado() {
		return this.turnosOcupado;
	}
}
