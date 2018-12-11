package modelo.jugador;

public class JuegoFinalizadoException extends RuntimeException {

	private String nombreJugadorGanador;
	
	public JuegoFinalizadoException (String mensaje) {
		this.nombreJugadorGanador = mensaje;
	}
	
	public String getNombreGanador() {
		return this.nombreJugadorGanador;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
