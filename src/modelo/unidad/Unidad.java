package modelo.unidad;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.jugador.Jugador;
import modelo.jugador.Poblacion;
import modelo.mapa.Posicion;

public abstract class Unidad extends Posicionable {
	
	protected int cantidadDeMovimientos;
	protected int movimientosPermitidos;
	protected Ataque ataque;
	protected int alcance;
	protected Jugador propietario;
	
	public Unidad () {
		
		this.cantidadDeMovimientos = 0;
		this.movimientosPermitidos = 1;
	}

	public Unidad(int x, int y) {
		super (x, y);
		this.cantidadDeMovimientos = 0;
		this.movimientosPermitidos = 1;
	}
	
	@Override
	public int decrementarPoblacion() {
		return 1;
	}

    @Override
    public int avanzarTurno() {
	    this.cantidadDeMovimientos=0;
	    return 0;
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
	
	public void atacar (Unidad unidad, Posicion posicionAtacado) {
		
	}
	
	public void atacar (Edificio edificio, Posicion posicionAtacado) {

	}

	public boolean posicionableEstaEnPropietario(Posicionable posicionable){
		Poblacion poblacionPropietaraio = this.propietario.obtenerPoblacion();
		return poblacionPropietaraio.posicionableEstaEnPoblacion(posicionable);
	}
	

	public void atacar(Posicionable posicionable) {
		if  (posicionableEstaEnPropietario(posicionable)) {
			throw new AtacandoAUnAliadoError ();
		}

		posicionable.recibirDanioDe (this);
	}

	public void desplazarHasta (Posicion hasta) {
		
		this.mover();
		
		if (this.cantidadDeMovimientos >= this.movimientosPermitidos) {
			
			throw new MovimientosPorTurnoExcedidosError ();
			
		}
		//this.posicion.comprobarAdyacencia(hasta); //Atencion con este metodo
		this.cantidadDeMovimientos ++;//Se puede comentar esta linea para avanzar unidades mas rapido al probarlo
		this.posicionarEnPosicion(hasta);
		
	}
	
	protected void mover() {
		
	}
	
	public void recibirPosicionable () {
		throw new DesplazarAPosicionOcupadaError ();
	}
	
	/*
     * devuelve si el posicionable se encuentra dentro de la cuadricula formada por el alcanceEnFila y alcanceEnColumna
     * a partir de la posicion.
     */
/*
	public boolean estaEnRangoDePosicion (Posicion posicion, int alcanceEnFila, int alcanceEnColumna) {
		
		return this.posicion.perteneceALaCuadricula(posicion, alcanceEnFila, alcanceEnColumna);
	}
*/
	
//metodos para pruebas
	public int getVida() {
		return this.vida;
	}
	
	//METODO DE VISTA
	public String obtenerColor() {
		return this.propietario.obtenerColor();
	}
	







}
