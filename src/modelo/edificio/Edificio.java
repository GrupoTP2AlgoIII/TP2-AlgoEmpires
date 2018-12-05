package modelo.edificio;


import java.util.ArrayList;

import modelo.jugador.Jugador;
import modelo.mapa.Posicion;
import modelo.unidad.DesplazarAPosicionOcupadaError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public abstract class Edificio extends Posicionable {
    protected int tamanio;
    protected int velocidadReparacion;
    protected int vidaFull;
    protected EstadoEdificio estado;
    protected Posicion posicionDesde;
    protected Posicion posicionHasta;
	protected Jugador propietario;



	public Edificio(){
		int turnosEnConstruccionInicial = 3;
		estado = new EstadoEdificioOcupado(turnosEnConstruccionInicial);

	}

	 // Constructor que reciba 0 por parametro, para inicializar el juego
	 public Edificio(int turnos) {
		if (turnos == 0) {
			estado = new EstadoEdificioDisponible();
		}
	}

	public void recibirDanio (int danio) {
		this.vida -= danio;
	}

	public void recibirDanioDe (Posicionable posicionable) {
		posicionable.atacar(this, this.posicion);
	}

	public void recibirDanioDe (Unidad unidad) {
		unidad.atacar(this, this.posicion);
	}

	public void recibirDanioDe (Edificio edificio) {
		edificio.atacar(this, this.posicion);
	}

	 public void recibirPosicionable () {
		throw new DesplazarAPosicionOcupadaError ();
	}

	 public int avanzarTurno() {
		 estado = estado.avanzarTurno(this);
		 return 0;
	 }

	public void reparar() {
		estado = estado.reparar(this);
	}
	

	protected void sumarVida() {
		if(this.vida < this.vidaFull) {
			this.vida += this.velocidadReparacion;
		}
		if(this.vida > this.vidaFull) {
			this.vida = this.vidaFull;
		}
	}


	public void desplazarHasta (Posicion hasta) {

		throw new EdificiosNoSePuedenDesplazarError ();
	}


	public int calcularTurnos() {
		int turnosEnReparacion=((this.vidaFull - this.vida )/this.velocidadReparacion);
		if(turnosEnReparacion < 1) {
			turnosEnReparacion = 1;
		}
		return turnosEnReparacion;
	}

	public ArrayList<Posicion> calcularPosiciones(Posicion posicionDeConstruccion) {

		ArrayList<Posicion> posicionesEdificio = new ArrayList<Posicion>();

		for(int i=0;i< this.calcularLado();i++){
			for(int j=0;j< this.calcularLado() ;j++){
				Posicion posicionAux = new Posicion(posicionDeConstruccion);
				posicionAux.sumarDesplazamiento(i,j);
				posicionesEdificio.add(posicionAux);
			}
		}
		return posicionesEdificio;
	}

	private int calcularLado() {
		return ((int) Math.sqrt(this.tamanio));
	}


	//METODOS DE PRUEBAS
	public int getTurnosConstruccion() {
		return estado.getTurnosOcupado();
	}




}