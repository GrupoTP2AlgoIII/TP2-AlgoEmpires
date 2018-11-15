package modelo.edificio.castillo;

import modelo.edificio.Edificio;
import modelo.unidad.armaDeAsedio.ArmaDeAsedio;

public class Castillo extends Edificio {

    public Castillo() {
        this.vida = 1000;
        this.tamanio = 16;
        this.velocidadReparacion = 15;
    }

    public ArmaDeAsedio crearArmaAsedio(){
        ArmaDeAsedio nuevaArmaAsedio = new ArmaDeAsedio();
            return nuevaArmaAsedio;
    }

    public boolean tieneTamanioCorrecto (int desdeX, int desdeY, int hastaX, int hastaY){

    	boolean tamanioCorrecto = true;

    	// Se pasan coordeanadas de izquierda a derecha y de abajo hacia arriba
    	if ( hastaX != (desdeX + 3) || hastaY != (desdeY + 3)){
    		tamanioCorrecto = false;
    	}

    	return tamanioCorrecto;
    }

	@Override
	public void reparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getVida() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getVidaFull() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void sumarVida() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTurnosConstruccion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int avanzarTurno() {
		// TODO Auto-generated method stub
		return 0;
		
	}

	@Override
	public void restarVida(int vidaARestar) {
		// TODO Auto-generated method stub
		
	}

}
