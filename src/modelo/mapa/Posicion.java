package modelo.mapa;

import java.util.ArrayList;

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

	public int getFila() {
		
		return this.x;
	}
	
	public int getColumna() {
		
		return this.y;
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

	public boolean perteneceALaCuadricula(Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {
		
		return ((this.x >= posicion.getFila() - alcanceEnFila) && (this.x <= posicion.getFila() + alcanceEnFila) &&
					(this.y >= posicion.getColumna() - alcanceEnColumna) && (this.y <= posicion.getColumna() + alcanceEnColumna));
	}

	public void comprobarAdyacencia(Posicion otraPosicion) {
		if(this.x > (otraPosicion.getFila())+1 || this.x < (otraPosicion.getFila() -1)) {
			throw new PosicionNoAdyacenteError();
		}
		
		if(this.y > (otraPosicion.getColumna())+1 || this.y < (otraPosicion.getColumna() -1)) {
			throw new PosicionNoAdyacenteError();
		}	
	}

	public ArrayList<Posicion> generarPosicionesDeSpawn() {
		int areaDeSpawn = 64;	//numero con raiz cuadrada
		int tamanioLado = (int) Math.sqrt(areaDeSpawn);
		ArrayList<Posicion> posicionesSpawn = new ArrayList<Posicion>();
		
		int filaAuxiliar = this.x +1;//me posiciono arriba del edificio donde se generan las unidades
		for (int i=0;i<tamanioLado;i++) {
			for (int j=0;j<tamanioLado;j++) {
				Posicion posicionSpawn = new Posicion(filaAuxiliar+i,this.y+j);
				posicionesSpawn.add(posicionSpawn);
			}
		}
		return posicionesSpawn;	
	}



}


