package modelo.edificio.plazaCentral;



import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.jugador.Jugador;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class PlazaCentral extends Edificio {

	public PlazaCentral(){
		this.vida = 450;
		this.costo = 100 ;
		this.tamanio = 4;
		this.simbolo = "PC";
		this.velocidadReparacion = 25;
		this.vidaFull = 450;
	}
		   
    public PlazaCentral(int desdeX, int desdeY, int hastaX, int hastaY, Jugador jugador) {
    	this.posicionDesde = new Posicion (desdeX, desdeY);
    	this.posicionHasta = new Posicion (hastaX, hastaY);
        this.vida = 450;
        this.costo = 100 ;
        this.tamanio = 4;
        this.velocidadReparacion = 25;
        this.vidaFull = 450;
        this.simbolo = "PC";
        this.propietario = jugador;
        this.posiciones.add(new Posicion(desdeX,desdeY));
    }

   public PlazaCentral(int turnos) {
	   super(turnos);
	   this.vida = 450;
	   this.costo = 100;
	   this.tamanio = 4;
	   this.simbolo = "PC";
	   this.velocidadReparacion = 25;
	   this.vidaFull = 450;
   }

   public PlazaCentral(int turnos, Jugador jugadorDado) {
	   super(turnos);
	   this.vida = 450;
	   this.costo = 100;
	   this.tamanio = 4;
	   this.velocidadReparacion = 25;
	   this.vidaFull = 450;
	   this.simbolo = "PC";
	   this.propietario = jugadorDado;

   }
   
   public PlazaCentral(Jugador jugador) {
		this.vida = 450;
		this.costo = 100;
		this.tamanio = 4;
		this.simbolo = "PC";
		this.velocidadReparacion = 25;
		this.vidaFull = 450;
		this.propietario = jugador;
   }
   
   public void atacar (Posicionable posicionable) {
	   throw new PlazaCentralNoPuedeAtacarError ();
   }

   public void atacar (Unidad unidad, Posicion posicionAtacado) {
	   throw new PlazaCentralNoPuedeAtacarError ();
   }

   public void atacar (Edificio edificio, Posicion posicionAtacado) {
	   throw new PlazaCentralNoPuedeAtacarError ();
   }

   public Unidad crearUnidadPropia(char tipo, Jugador jugador) {
	return estado.crearAldeanoDeJugador(this.propietario);
   }
   
	//VISTA
	@Override
	protected Ataque getAtaque() {
		return new Ataque (0,0,0);
	}

}
