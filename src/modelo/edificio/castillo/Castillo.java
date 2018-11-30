package modelo.edificio.castillo;

import java.util.ArrayList;
import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.edificio.EstadoEdificioDisponible;
import modelo.jugador.Jugador;
import modelo.mapa.Posicion;
import modelo.unidad.AtacandoAUnAliadoError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Castillo extends Edificio {
	
	private Ataque ataque;
	private int alcance = 3;
	ArrayList<Posicionable> atacables;

    public Castillo() {
        this.vida = 1000;
        this.tamanio = 16;
        this.velocidadReparacion = 15;
	    this.costo = 50;
        this.vidaFull = vida;
        this.ataque = new Ataque (20, 20, this.alcance);
        this.atacables = new ArrayList<Posicionable>();
        
    }
    
    public Castillo(int turnos) {
        super(turnos);
    	this.vida = 1000;
        this.tamanio = 16;
        this.velocidadReparacion = 15;
	    this.costo = 50;
        this.vidaFull = vida;
        this.ataque = new Ataque (20, 20, this.alcance);
        this.atacables = new ArrayList<Posicionable>();
    }
    
	  public Castillo(int desdeX, int desdeY, int hastaX, int hastaY) {
		   
		   this.posicionDesde = new Posicion (desdeX, desdeY);
		   this.posicionHasta = new Posicion (hastaX, hastaY);
	   	   this.vida = 1000;
	   	   this.tamanio = 16;
	   	   this.velocidadReparacion = 15;
		   this.costo = 50;	       
	       this.vidaFull = vida;	       
	       this.ataque = new Ataque (20, 20, this.alcance);
	       this.estado = new EstadoEdificioDisponible ();
	       this.atacables = new ArrayList<Posicionable>();
	    }
	  
	  @Override
	  public Unidad crearUnidad(char tipo) {
		  return estado.crearArmaAsedio();
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
	
	public void setAtacables(ArrayList<Posicionable> atacables) {
		this.atacables = atacables;
	}
	
	public void atacarEnemigosAlAlcance () {
				
		for (Posicionable posicionableAtacable : atacables) {
			this.atacar(posicionableAtacable);
		}

	}
	  
}
