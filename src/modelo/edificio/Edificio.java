package modelo.edificio;

import modelo.unidad.Posicionable;

public abstract class Edificio extends Posicionable{
    protected int vida;
    protected int costo;
    protected int tamanio;
    protected int velocidadReparacion;
    protected int vidaFull;
    protected EstadoEdificio estado;
	
    
    public abstract int getVelocidadDeReparacion();
	public abstract void reparar();
	public abstract int getVida();
	protected abstract int getVidaFull();
	protected abstract void sumarVida();
	public abstract int getTurnosConstruccion();
	public abstract int avanzarTurno();
	public abstract boolean tieneTamanioCorrecto (int desdeX, int desdeY, int hastaX, int hastaY);
	
	public Edificio(){
		int turnosEnConstruccionInicial = 3;
		estado = new EstadoEdificioOcupado(turnosEnConstruccionInicial);
	}
	
	@Override
	public boolean estaOcupado() {
		return true;		
	}

}