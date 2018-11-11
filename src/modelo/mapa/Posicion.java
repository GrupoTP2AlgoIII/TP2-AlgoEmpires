package modelo.mapa;

public class Posicion {
	
	private int x;
	private int y;
	
	public Posicion () {
		
		//posiciones invalidas
		this.x = -1;
		this.y = -1;
		
	}
	
	public Posicion (int fila, int columna){
		this.x = fila;
		this.y = columna;
	}

	public void posicionarEnFilaColumna(int fila, int columna) {
		
		this.x = fila;
		this.y = columna;
		
	}

	public void desplazarHaciaLaDerecha(int cantidadDePosiciones) {
		
		this.y += cantidadDePosiciones;
		
	}

	public int getFila() {
		
		return this.x;
	}
	
	public int getColumna() {
		
		return this.y;
	}

	public void desplazarHaciaLaIzquierda(int cantidadDePosiciones) {
		
		this.y -= cantidadDePosiciones;
		
	}

	public void desplazarHaciaArriba(int cantidadDePosiciones) {
		
		this.x -= cantidadDePosiciones;
		
	}

	public void desplazarHaciaAbajo(int cantidadDePosiciones) {

		this.x += cantidadDePosiciones;
		
	}

	public void desplazarHaciaLaDiagonalSuperiorDerecha(int cantidadDePosiciones) {

		this.x -= cantidadDePosiciones;
		this.y += cantidadDePosiciones;
		
	}

	public void desplazarHaciaLaDiagonalSuperiorIzquierda(int cantidadDePosiciones) {
		
		this.x -= cantidadDePosiciones;
		this.y -= cantidadDePosiciones;
		
	}

	public void desplazarHaciaLaDiagonalInferiorDerecha(int cantidadDePosiciones) {

		this.x += cantidadDePosiciones;
		this.y += cantidadDePosiciones;
	}

	public void desplazarHaciaLaDiagonalInferiorIzquierda(int cantidadDePosiciones) {

		this.x += cantidadDePosiciones;
		this.y -= cantidadDePosiciones;
	}

	public boolean noPerteneceAlRango(int filas, int columnas) {
		
		return (x > filas) || (x < 1) || (y > columnas) || (y < 1);
	}

}