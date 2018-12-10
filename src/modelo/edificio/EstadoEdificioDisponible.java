package modelo.edificio;

import modelo.jugador.Jugador;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.armaDeAsedio.ArmaDeAsedio;
import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;

public class EstadoEdificioDisponible implements EstadoEdificio {

	@Override
	public Unidad crearArqueroDeJugador(Jugador jugador) {
		Unidad arquero = new Arquero(jugador);
		return arquero;
	}

	@Override
	public EstadoEdificio avanzarTurno(Edificio edificio) {
		return this;
	}

	@Override
	public EstadoEdificio reparar(Edificio edificio) {

		int turnosEnReparacion = edificio.calcularTurnos();
		return (new EstadoEdificioOcupado(turnosEnReparacion));

	}


	@Override
	public Unidad crearAldeanoDeJugador(Jugador jugador) {
		Unidad aldeano = new Aldeano(jugador);
		return aldeano;
	}

	@Override
	public int getTurnosOcupado() {
		return 0;
	}

	
	@Override
	public Unidad crearArmaDeAsedioDeJugador (Jugador jugador) {
		Unidad armaDeAsedio = new ArmaDeAsedio (jugador);
		return armaDeAsedio;
	}

	@Override
	public Unidad crearEspadachinDeJugador(Jugador jugador) {
		Unidad espadachin = new Espadachin(jugador);
		return espadachin;
	}

}