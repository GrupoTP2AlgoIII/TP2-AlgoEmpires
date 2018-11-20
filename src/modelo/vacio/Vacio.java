package modelo.vacio;

import modelo.unidad.Posicionable;

public class Vacio extends Posicionable{

	public Vacio(int i, int j) {
		super(i, j);
	}

	@Override
	public int avanzarTurno() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVida() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void restarVida(int vidaARestar) {
		
	}

}
