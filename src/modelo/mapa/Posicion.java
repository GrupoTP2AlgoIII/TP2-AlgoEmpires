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

	// Agrego este metodo	
	public boolean esAdyacenteA(Posicion otraPosicion) {
		
		boolean esAdyacente = true;
		
		if (this.x > (otraPosicion.getFila() + 1) || this.x < (otraPosicion.getFila() - 1)){
			esAdyacente = false;
		}
		
		if (this.y > (otraPosicion.getColumna() + 1) || this.y < (otraPosicion.getColumna() - 1)){
			esAdyacente = false;
		}
		
		return esAdyacente;
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
	

    // Fuente para redefinir los metodos equals y hashcode:
	// https://www.geeksforgeeks.org/override-equalsobject-hashcode-method/
	@Override
	public boolean equals(Object objeto)
	{

	// si las dos referencias
	// se refieren al mismo objeto.
	if(this == objeto) {
		return true;
	}

	// chequea si el argumento es de tipo
	// Posicion comparando entre las clases
	// del argumento y de este objeto.
	// if(!(objeto instanceof Posicion)) return false; > evitar hacer esto.
	if(objeto == null || objeto.getClass()!= this.getClass()) {
		return false;
	}

	// casteo del tipo de dato del argumento.
	Posicion posicion = (Posicion) objeto;

	// comparacion entre el estado del argumento
	// y el estado del objeto 'this'.
	return (posicion.x == this.x && posicion.y == this.y);
	}
	
	@Override
	public int hashCode(){
		
		int resultado = 50;
		resultado = resultado * (this.x) + (this.y);
		return resultado;		
	}



}


