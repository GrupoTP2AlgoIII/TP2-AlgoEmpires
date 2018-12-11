package modelo.edificio;


import java.util.ArrayList;

import modelo.jugador.Jugador;
import modelo.jugador.Poblacion;
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
	protected ArrayList<Posicion> posiciones = new ArrayList<Posicion>();//para edificios
	private boolean avanzoTurno = false;	//es para los edificios ya que tienen mas de 1 posiciones y cuando avanzas el
											//turno aveces se avanza mas de 1 vez
	
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

	 @Override
	 public void actualizar() {
		 this.avanzoTurno = false;
	 }
	 
	@Override
	public void posicionarEnPosicion (Posicion otraPosicion) {
		this.posiciones.add(otraPosicion);
		this.posicion = otraPosicion;
    }
	
	 @Override
	public void posicionarEnFilaColumna(int fila, int columna) {

		this.posiciones.add(new Posicion (fila,columna));
		this.posicion.posicionarEnFilaColumna(fila, columna);

	}
	
	@Override
	public void aceptaReparacion() {
		
	}
	
	public void recibirDanio (int danio) {
		 if(!this.avanzoTurno) {
			 this.vida -= danio;			 
		 }
		 this.avanzoTurno = true;	
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

	@Override
	public void atacar (Unidad unidad, Posicion posicionAtacado) {
		throw new EdificioNoPuedeAtacarException();
	}
	
	@Override
	public void atacar (Edificio edificio, Posicion posicionAtacado) {
		throw new EdificioNoPuedeAtacarException();
	}
	
	@Override
	public void atacar(Posicionable posicionable) {
		throw new EdificioNoPuedeAtacarException();
	}
	
	 public void recibirPosicionable () {
		throw new DesplazarAPosicionOcupadaError ();
	}

	 public int avanzarTurno() {
		 if(!this.avanzoTurno) {
			 estado = estado.avanzarTurno(this);			 
		 }
		 this.avanzoTurno = true;
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
	
	public boolean posicionableEstaEnPropietario(Posicionable posicionable){
		Poblacion poblacionPropietaraio = this.propietario.obtenerPoblacion();
		return poblacionPropietaraio.posicionableEstaEnPoblacion(posicionable);
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

		for(int i = 0; i < this.calcularLado(); i++){
			for(int j = 0; j < this.calcularLado() ; j++){
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
	
	
	public Posicion posicionDesde() {
		return this.posicionDesde;
	}

	//METODOS DE PRUEBAS
	public int getTurnosConstruccion() {
		return estado.getTurnosOcupado();
	}
	
	//METODO DE VISTA
	public String obtenerColor() {
		return this.propietario.obtenerColor();
	}

	public boolean poseeEstaPosicion(Posicion unaPosicion) {
		return (this.posiciones.contains(unaPosicion));
	}

}