package modelo.edificio;

import modelo.unidad.Unidad;

public interface EstadoEdificio {

	public Unidad crearArquero();

	public EstadoEdificio avanzarTurno(Edificio edificio);

	public EstadoEdificio reparar(Edificio edificio);

	public Unidad crearAldeano();

	public int getTurnosOcupado();

}
