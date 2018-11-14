package modelo.edificio;

import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.arquero.Arquero;

public class EstadoEdificioDisponible implements EstadoEdificio {

	private int	vidaRepararPorTurno = 25;
	
	@Override
	public Unidad crearArquero() {
		Unidad arquero = new Arquero();
		return arquero;
	}

	@Override
	public EstadoEdificio avanzarTurno(Edificio edificio) {
		return this;
	}

	@Override
	public EstadoEdificio reparar(Edificio edificio) {
		int turnosEnReparacion = ((edificio.getVidaFull()-edificio.getVida())/vidaRepararPorTurno);
		return (new EstadoEdificioOcupado(turnosEnReparacion));
		
	}

	@Override
	public Unidad crearAldeano() {
		Unidad aldeano = new Aldeano();
		return aldeano;
	}

	@Override
	public int getTurnosOcupado() {
		return 0;
	}
	
	

}
