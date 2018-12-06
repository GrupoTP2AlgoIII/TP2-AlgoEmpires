package modelo.edificio;

import modelo.jugador.Jugador;
import modelo.mapa.Posicion;
import modelo.unidad.Unidad;

public interface EstadoEdificio {

	//Los crearArqueroDeJugador o crearAldeadnodeJugador son para el ataque, para darles la instancia de Jugador
	//la cual es su propietaria

	public Unidad crearArquero();
	public Unidad crearArqueroDeJugador(Jugador jugador, Posicion posicionEdificio);



	public EstadoEdificio avanzarTurno(Edificio edificio);

	public EstadoEdificio reparar(Edificio edificio);

	public Unidad crearAldeano();

	public Unidad crearAldeanoDeJugador(Jugador jugador);

	public int getTurnosOcupado();

	public Unidad crearArmaAsedio();


	public Unidad crearEspadachin();

	public Unidad crearEspadachinDeJugador(Jugador jugador);


}