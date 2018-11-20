package modelo.edificio;

import modelo.unidad.Unidad;

public class EstadoEdificioOcupado implements EstadoEdificio{
	private int turnosOcupado;
	
	public EstadoEdificioOcupado(int turnosOcupado) {
		this.turnosOcupado = turnosOcupado;
	}

	@Override
	public Unidad crearArquero() {
		throw new EdificioOcupadoException();
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
		throw new EdificioOcupadoException();
	}

	@Override
	public Unidad crearAldeano() {
		throw new EdificioOcupadoException();
	}

	@Override
	public int getTurnosOcupado() {
		return this.turnosOcupado;
	}

	@Override
	public Unidad crearArmaAsedio() {
		throw new EdificioOcupadoException();
	}

	@Override
	public Unidad crearEspadachin() {
		throw new EdificioOcupadoException();
	}
}
