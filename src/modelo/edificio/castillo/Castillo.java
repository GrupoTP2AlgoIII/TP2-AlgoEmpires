package modelo.edificio.castillo;

import modelo.edificio.Edificio;
import modelo.unidad.Unidad;

public class Castillo extends Edificio {

    public Castillo() {
        this.vida = 1000;
        this.tamanio = 16;
        this.velocidadReparacion = 15;
	    this.costo = 50;
        this.vidaFull = vida;
    }

    public Unidad crearArmaAsedio(){
    	return estado.crearArmaAsedio();
    }

    public boolean tieneTamanioCorrecto (int desdeX, int desdeY, int hastaX, int hastaY){

    	boolean tamanioCorrecto = true;

    	// Se pasan coordeanadas de izquierda a derecha y de abajo hacia arriba
    	if ( hastaX != (desdeX + 3) || hastaY != (desdeY + 3)){
    		tamanioCorrecto = false;
    	}

    	return tamanioCorrecto;
    }
	
    
    public int avanzarTurno() {
    	estado = estado.avanzarTurno(this);
    	return 0;
    }
    
	public void reparar() {		
		estado = estado.reparar(this);	
	}
    
	@Override
	public int getVida() {
		return this.vida;
	}

	@Override
	protected int getVidaFull() {
		return this.vidaFull;
	}

	@Override
	protected void sumarVida() {
		if(this.vida < this.vidaFull) {
			this.vida += this.velocidadReparacion;
		}
		if(this.vida > this.vidaFull) {
			this.vida = this.vidaFull;
		}
	}
	
	

	@Override
	public int getTurnosConstruccion() {
		return estado.getTurnosOcupado();
	}

	@Override
	public void restarVida(int vidaARestar) {
		this.vida -= vidaARestar;
	}


}
