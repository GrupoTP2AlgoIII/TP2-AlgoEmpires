package modelo.ataque;

import modelo.edificio.Edificio;
import modelo.unidad.Unidad;

public class Ataque {
	
	private int danioUnidad;
	private int danioEdificio;
	private int distancia;
	
	public Ataque (int danioEdificio, int danioUnidad, int distancia) {
		this.danioEdificio = danioEdificio;
		this.danioUnidad = danioUnidad;
		this.distancia = distancia;
	}
	
	public void atacar (Unidad recibeAtaque) {
		recibeAtaque.recibirDanio (this.danioUnidad);
	}
	
	public void atacar (Edificio recibeAtaque) {
		recibeAtaque.recibirDanio (this.danioEdificio);
		
	}
	
//	public int getAtaqueEdificio() {
//		return this.ataqueEdificio;
//	}
	
//	public int getAtaqueUnidad() {
//		return this.ataqueUnidad;
//	}
	
//	public int getDistancia () {
		
//		return this.distancia;
//	}
	
}
