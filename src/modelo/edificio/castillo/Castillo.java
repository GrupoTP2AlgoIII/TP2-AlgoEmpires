package modelo.edificio.castillo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.edificio.EstadoEdificioDisponible;
import modelo.jugador.Jugador;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Castillo extends Edificio {
	
	private Ataque ataque;
	private int alcance = 3;
	private int danio = 20;
	//private ArrayList<Posicionable> atacables;
	private HashMap <Posicion, Posicionable> atacables;
	
    public Castillo() {
        this.vida = 1000;
        this.tamanio = 16;
        this.velocidadReparacion = 15;
	    this.costo = 50;
        this.vidaFull = vida;
        this.ataque = new Ataque (this.danio, this.danio, this.alcance);
        //this.atacables = new ArrayList<Posicionable>();
        this.atacables = new HashMap<Posicion, Posicionable>();
    }
    
    public Castillo(int turnos) {
        super(turnos);
    	this.vida = 1000;
        this.tamanio = 16;
        this.velocidadReparacion = 15;
	    this.costo = 50;
        this.vidaFull = vida;
        this.ataque = new Ataque (this.danio, this.danio, this.alcance);
        //this.atacables = new ArrayList<Posicionable>();
        this.atacables = new HashMap<Posicion, Posicionable>();
    }

	  public Castillo(int desdeX, int desdeY, int hastaX, int hastaY, Jugador jugador) {
		   
		   this.posicionDesde = new Posicion (desdeX, desdeY);
		   this.posicionHasta = new Posicion (hastaX, hastaY);
	   	   this.vida = 1000;
	   	   this.tamanio = 16;
	   	   this.velocidadReparacion = 15;
		   this.costo = 50;	       
	       this.vidaFull = vida;	       
	       this.ataque = new Ataque (this.danio, this.danio, this.alcance);
	       this.estado = new EstadoEdificioDisponible ();
	       //this.atacables = new ArrayList<Posicionable>();
	       this.atacables = new HashMap<Posicion, Posicionable>();
	       this.propietario = jugador;
	    }
	  
	  @Override
	  public void recibirDanio (int danio) {
		  this.vida -= danio;
		  if (this.vida <= 0) {	  
			  this.propietario.perderLaPartida ();
		  }
		  
	  }
	  
	  @Override
	  public Unidad crearUnidadPropia (char tipo, Jugador jugador) {
		  return estado.crearArmaAsedio();
	  }
	  
	public void atacar (Posicionable posicionable) {

		posicionable.recibirDanioDe(this);
	}
		
	public void atacar (Unidad unidad, Posicion posicionAtacado) {
		if (!posicionAtacado.perteneceALaCuadricula(this.posicion, this.alcance, this.alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		this.ataque.atacar(unidad);
	}
		
	public void atacar (Edificio edificio, Posicion posicionAtacado) {
		if (!posicionAtacado.perteneceALaCuadricula(this.posicion, this.alcance, this.alcance)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		this.ataque.atacar(edificio);
	}
	
	public int calcularLado() {
		
		int lado = (int) Math.sqrt(this.tamanio);
		lado --;
		return lado;
	}
	
	public int calcularRango() {
		return this.alcance;
	}
	
//	public void setAtacables(ArrayList<Posicionable> atacables) {
//		this.atacables = atacables;
//	}
	
	public void setAtacables(HashMap<Posicion, Posicionable> atacables) {
		this.atacables = atacables;
	}
	
	public void atacarEnemigosAlAlcance () {
				
//		Itero los atacables en una lista
//		for (Posicionable posicionableAtacable : atacables) {
//			this.ataque.atacar(posicionableAtacable);
//		}
		
//		Itero los atacables a partir de las claves del hashmap
//		for (Posicion posicionAtacable: atacables.keySet()) {
//		this.ataque.atacar(this.atacables.get(posicionAtacable));
//	}
		
//		Itero los atacables a partir de los valores del hashmap		
		for (Posicionable posicionableAtacable: atacables.values()) {
			this.ataque.atacar(posicionableAtacable);
		}


	}
  
}
