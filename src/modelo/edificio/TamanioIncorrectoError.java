package modelo.edificio;

public class TamanioIncorrectoError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TamanioIncorrectoError() {
		super();
	}
	
	public TamanioIncorrectoError(String mensaje) {
		super(mensaje);
	}
	
}