package modelo.unidad.aldeano;

import modelo.edificio.Edificio;

public interface EstadoAldeano {
	
	public EstadoAldeano reparar(Edificio edificio);
	public EstadoAldeano construir(Edificio edificio);
	public EstadoAldeano avanzarTurno();
	public int obtenerOro();
}
