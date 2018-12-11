package modelo.edificio.castillo;


import java.util.HashMap;
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
	private int danio = 20;
	
    public Castillo() {
        this.vida = 1000;
        this.tamanio = 16;
        this.velocidadReparacion = 15;
	    this.costo = 50;
        this.vidaFull = vida;
        this.ataque = new Ataque (this.danio, this.danio, this.alcance);
    }
    
    public Castillo(int turnos,Jugador jugadorDado,Posicion posicionInicio) {
        super(turnos);
    	this.vida = 1000;
        this.tamanio = 16;
        this.velocidadReparacion = 15;
	    this.costo = 50;
        this.vidaFull = vida;
        this.posicionDesde = posicionInicio;
        this.ataque = new Ataque (this.danio, this.danio, this.alcance);
        this.propietario = jugadorDado;
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
		  return estado.crearArmaDeAsedioDeJugador(this.propietario);
	  }
		
	
	public int calcularLado() {
		
		int lado = (int) Math.sqrt(this.tamanio);
		lado --;
		return lado;
	}
	
	public int calcularRango() {
		return this.alcance;
	}
	
	@Override
	public void atacar(Posicionable posicionable) {
		if  (posicionableEstaEnPropietario(posicionable)) {
			throw new AtacandoAUnAliadoError ();
		}
		posicionable.recibirDanio(this.danio);
	}
	
	public void atacarEnemigosAlAlcance (HashMap<Posicion, Posicionable> atacables) {
		
		for (Posicionable posicionableAtacable: atacables.values()) {
			try {
				this.atacar(posicionableAtacable);
			}catch(Exception e) {
				
			}
		}
	}
	
	@Override
	protected Ataque getAtaque() {
		return this.ataque;
	}






  
}
