package modelo.jugador;

import modelo.edificio.cuartel.Cuartel;


public class Jugador {
	private Cuartel jugadores[];
	private boolean jugadorActual;
	
	public Jugador() {
		this.jugadores = new Cuartel[2];
		this.jugadorActual = true;
	}
	
	public Cuartel construirCuartel() {
		Cuartel cuartel = new Cuartel();
		if(this.jugadorActual) {
			this.jugadores[0] = cuartel;
		}else {
			this.jugadores[1] = cuartel;
		}
		return cuartel;
	}
	
	public void avanzarTurno() {
		Cuartel aux;
		if(this.jugadorActual) {
			aux = this.jugadores[0];
			aux.avanzarTurno();
			this.jugadores[0]=aux;
		}else{
			aux = this.jugadores[1];
			aux.avanzarTurno();
			this.jugadores[1]=aux;
		}
	
		this.jugadorActual =!(this.jugadorActual);
	}
}
