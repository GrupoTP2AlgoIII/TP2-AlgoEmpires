package modelo.jugador;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.edificio.Edificio;

import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.TamanioIncorrectoError;
import modelo.edificio.castillo.Castillo;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.MovimientosPorTurnoExcedidosError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioMontadaNoPuedeDesplazarseError;
import modelo.vacio.Vacio;
import modelo.unidad.PosicionFueraDelMapaError;


import java.util.HashMap;
import java.util.Map;



public class Jugador {
	private Map  <Posicion, Posicionable> posicionables;
	private Mapa mapa;
	private String nombre;
	private int poblacion;
	private int oro;
	private int produccionDeOro;

	public Jugador(Mapa mapa,String nombre) {

		this.posicionables = new HashMap <Posicion, Posicionable> ();
		this.mapa = mapa;
		this.nombre = nombre;
		this.poblacion = 0;
		this.oro = 200;
		this.produccionDeOro = 0;
	}


	public String getNombre(){
		return this.nombre;
	}
	
	public Edificio construirCuartel(int fila,int columna) {
		//se debe pasar el aldeano que construye
		Edificio cuartel = new Cuartel();
		Posicionable posicionable = cuartel;
		this.agregarPosicionableEnFilaColumna(posicionable, fila, columna);
		return cuartel;
		
	}
	
	public Unidad crearAldeano(Posicion plazaCentral) throws PosicionFueraDelMapaError, PosicionOcupadaError {
		int produccionOroAldeano = 20;
		int costoAldeano = 25;
		int topePoblacional = 50;
		Unidad aldeano = null;
		Posicionable plaza = this.posicionables.get(plazaCentral);
		
		if(this.oro >= costoAldeano) {
			if(this.poblacion < topePoblacional) {
				aldeano = plaza.crearAldeano();
				
				this.poblacion++;
				this.produccionDeOro += produccionOroAldeano;
				this.oro -= costoAldeano;
				
				//busco la posicion desocupada para crear el aldeano
				int fila  = plazaCentral.getFila()+3;
				int columna = plazaCentral.getColumna()+3;
				Posicion posicionAux = new Posicion(fila,columna);
				while (this.mapa.estaOcupado(posicionAux)) {
					fila++;
					columna++;
					posicionAux.posicionarEnFilaColumna(fila, columna);
				}
				aldeano.posicionarEnFilaColumna(posicionAux.getFila(), posicionAux.getColumna());
				
				//actualizo mapa y posicionables de jugador
				this.agregarPosicionableEnFilaColumna(aldeano,aldeano.getPosicion().getFila(), aldeano.getPosicion().getColumna());
				this.mapa.posicionarEnFilaColumna(aldeano, aldeano.getPosicion().getFila(),aldeano.getPosicion().getColumna());
				return aldeano;
			}
			throw new JugadorSuperaTopePoblacionalException();
		}	
		throw new JugadorSinOroException();			
	}
	
	public void avanzarTurno() {
		
		posicionables.forEach((k,v) -> {
			this.oro += v.avanzarTurno();
		});
		
		//this.CastilloAtacarEnSuRango();
	}
	
//	public void CastilloAtacarEnSuRango(){
//		
//		
//	}
	
	//elimina a los posicionables con vida cero y lo pone en vacio
	public void actualizarPosicionables() {
		int produccionOroAldeano = 20;
		Posicionable vacio = new Vacio();
		posicionables.forEach((k,v) -> {
			if(v.getVida() <= 0) {
				if(v.avanzarTurno() == produccionOroAldeano) {
					this.produccionDeOro -= produccionOroAldeano;
				}
				posicionables.replace(k,v, vacio);
				this.poblacion--;
			}
		});
	}

	public void agregarPosicionableEnFilaColumna(Posicionable posicionable, int fila, int columna) {
		
		Posicion posicionDelPosicionable = new Posicion (fila, columna);
		
		this.posicionables.put(posicionDelPosicionable, posicionable);
		
	}
	
	// Borrar el metodo agregar edificio a posicionables y agregarle la linea del mapa al metodo de arriba
	public void agregarEdificioDesdeHasta (Edificio edificio, int desdeX, int desdeY, int hastaX, int hastaY) throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		for (int i = desdeX; i <= hastaX; i++) {
			for (int j = desdeY; j <= hastaY; j++) {
				Posicion posicion = new Posicion (i,j);
				this.posicionables.put(posicion, edificio);
				this.mapa.posicionarEnFilaColumna(edificio, i, j);
			}
		}
		
	}
	

	public void desplazarFilaColumnaHaciaArriba(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionDesocupadaError, PosicionOcupadaError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaArriba (1);
		posicionDesplazable.desplazarHaciaArriba (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaAbajo(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaAbajo (1);
		posicionDesplazable.desplazarHaciaAbajo (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaDerecha(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaDerecha (1);
		posicionDesplazable.desplazarHaciaLaDerecha (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaIzquierda(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaIzquierda (1);
		posicionDesplazable.desplazarHaciaLaIzquierda (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaDiagonalSuperiorDerecha(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaDiagonalSuperiorDerecha (1);
		posicionDesplazable.desplazarHaciaLaDiagonalSuperiorDerecha (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaDiagonalSuperiorIzquierda(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaDiagonalSuperiorIzquierda(1);
		posicionDesplazable.desplazarHaciaLaDiagonalSuperiorIzquierda (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaDiagonalInferiorIzquierda(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaDiagonalInferiorIzquierda (1);
		posicionDesplazable.desplazarHaciaLaDiagonalInferiorIzquierda (1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}
	
	public void desplazarFilaColumnaHaciaLaDiagonalInferiorDerecha(int fila, int columna, int cantidadDePosiciones) throws MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {
		
		Posicion posicionDesplazable = new Posicion (fila, columna);
		
		if (!this.mapa.estaOcupado (posicionDesplazable)) {
			
			throw new PosicionDesocupadaError ();
			
		}
		
		Posicionable posicionableEnPosicion = this.posicionables.get(posicionDesplazable);
		posicionableEnPosicion.desplazarHaciaLaDiagonalInferiorIzquierda (1);
		posicionDesplazable.desplazarHaciaLaDiagonalInferiorIzquierda(1);
		this.mapa.posicionarPosicionableEnPosicion (posicionableEnPosicion, posicionDesplazable);
		
		
	}

	public void iniciarAldeanosDesde(int x, int y) throws PosicionFueraDelMapaError, PosicionOcupadaError {
	
		for (int i = y; i <= (y + 2); i++ ) {
		    Posicionable aldeano = new Aldeano();
		    this.agregarPosicionableEnFilaColumna(aldeano, x, i);
		    this.mapa.posicionarEnFilaColumna(aldeano, x, i);
        }
		
	}


	public void crearCastilloDesdeHasta(int desdeX, int desdeY, int hastaX, int hastaY) throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Edificio castillo = new Castillo(0);
		
		if (! castillo.tieneTamanioCorrecto(desdeX, desdeY, hastaX, hastaY)){
			throw new TamanioIncorrectoError();
		}

		Posicion posicionDesde = new Posicion (desdeX, desdeY);
		Posicion posicionHasta = new Posicion (hastaX, hastaY);

		if (posicionDesde.noPerteneceAlRango(this.mapa.getFilas(), this.mapa.getColumnas())){
			throw new PosicionFueraDelMapaError ();
		}

		if (posicionHasta.noPerteneceAlRango(this.mapa.getFilas(), this.mapa.getColumnas())){
			throw new PosicionFueraDelMapaError ();
		}

		this.mapa.ponerEdificioDesdeHasta(castillo, desdeX, desdeY, hastaX, hastaY);
		this.agregarEdificioAPosicionables(castillo, desdeX, desdeY, hastaX, hastaY);

	}
	
	public void crearPlazaCentralDesdeHasta(int desdeX, int desdeY, int hastaX, int hastaY) throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{
		
		Edificio plazaCentral = new PlazaCentral(0);

		if (! plazaCentral.tieneTamanioCorrecto(desdeX, desdeY, hastaX, hastaY)){
			throw new TamanioIncorrectoError();
		}

		Posicion posicionDesde = new Posicion (desdeX, desdeY);
		Posicion posicionHasta = new Posicion (hastaX, hastaY);

		if (posicionDesde.noPerteneceAlRango(this.mapa.getFilas(), this.mapa.getColumnas())){
			throw new PosicionFueraDelMapaError ();
		}

		if (posicionHasta.noPerteneceAlRango(this.mapa.getFilas(), this.mapa.getColumnas())){
			throw new PosicionFueraDelMapaError ();
		}

		this.mapa.ponerEdificioDesdeHasta(plazaCentral, desdeX, desdeY, hastaX, hastaY);
		this.agregarEdificioAPosicionables(plazaCentral, desdeX, desdeY, hastaX, hastaY);
	}

	private void agregarEdificioAPosicionables(Posicionable edificio, int desdeX, int desdeY, int hastaX, int hastaY) throws PosicionFueraDelMapaError, PosicionOcupadaError{

		for (int i = desdeX; i <= hastaX; i++){
			for (int j = desdeY; j <= hastaY; j++){
				this.agregarPosicionableEnFilaColumna(edificio, i, j);
			}
		}

	}


	public Object getPoblacion() {
		return this.poblacion;
	}


	public Object getOro() {
		return this.oro;
	}


	public Object getProduccionOro() {
		return this.produccionDeOro;
	}


	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
		
	}


	public void setOro(int oro) {
		this.oro = oro;
		
	}
	
	public Map <Posicion, Posicionable> getPosicionables() {
		return this.posicionables;
	}
}
