package modelo.ataque;

public class Ataque {
	private int ataqueEdificio;
	private int ataqueUnidad;
	
	public Ataque(int ataqueEdificio,int ataqueUnidad) {
		this.ataqueEdificio = ataqueEdificio;
		this.ataqueUnidad = ataqueUnidad;
	}
	
	public int getAtaqueEdificio() {
		return this.ataqueEdificio;
	}
	
	public int getAtaqueUnidad() {
		return this.ataqueUnidad;
	}
}
