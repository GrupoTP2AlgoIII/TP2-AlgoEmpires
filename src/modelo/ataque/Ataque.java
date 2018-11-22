package modelo.ataque;

public class Ataque {
	private int ataqueEdificio;
	private int ataqueUnidad;
	private int distancia;
	
	public Ataque(int ataqueEdificio,int ataqueUnidad, int distanciaDeAtaque) {
		this.ataqueEdificio = ataqueEdificio;
		this.ataqueUnidad = ataqueUnidad;
		this.distancia = distanciaDeAtaque;
	}
	
	public int getAtaqueEdificio() {
		return this.ataqueEdificio;
	}
	
	public int getAtaqueUnidad() {
		return this.ataqueUnidad;
	}
	
	public int getDistancia () {
		
		return this.distancia;
	}
}
