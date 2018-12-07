package modelo.edificio.cuartel;



import modelo.edificio.Edificio;
import modelo.jugador.Jugador;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;

public class Cuartel extends Edificio{

	   public Cuartel() {
	   	    this.vida = 250;
		    this.costo = 50;
	        this.tamanio = 4;
	        this.velocidadReparacion = 50;
	        this.vidaFull = vida;
	    }

		public Cuartel(Jugador jugador) {
			this.vida = 250;
			this.costo = 50;
			this.tamanio = 4;
			this.velocidadReparacion = 50;
			this.vidaFull = vida;
			this.propietario = jugador;
		}
/*		
		public Cuartel(Posicion desde, Jugador jugador) {
			this.posicion = desde;
			this.vida = 250;
			this.costo = 50;
			this.tamanio = 4;
			this.velocidadReparacion = 50;
			this.vidaFull = vida;
			this.propietario = jugador;
		}
*/	   
	   public Cuartel(int desdeX, int desdeY, int hastaX, int hastaY, Jugador jugador) {
		   
		   this.posicionDesde = new Posicion (desdeX, desdeY);
		   this.posicionHasta = new Posicion (hastaX, hastaY);
	   	   this.vida = 250;
		   this.costo = 50;
	       this.tamanio = 4;
	       this.velocidadReparacion = 50;
	       this.vidaFull = vida;
	       this.propietario = jugador;
	   }
	   
	   public void atacar (Posicionable posicionable) {
		   throw new CuartelNoPuedeAtacarError ();
	   }
	   
	   public void atacar (Unidad unidad, Posicion posicionAtacado) {
		   throw new CuartelNoPuedeAtacarError ();		   
	   }
	   
	   public void atacar (Edificio edificio, Posicion posicionAtacado) {
		   throw new CuartelNoPuedeAtacarError ();
	   }
	   
	   	@Override
	    public Unidad crearUnidad(char tipo) {
	    	if(tipo == 'A')
	    		return estado.crearArquero();
	    	else
	    		return estado.crearEspadachin();
		}

		@Override
		public Unidad crearUnidadPropia(char tipo, Jugador jugador) {
			if(tipo == 'A')
				return estado.crearArqueroDeJugador(this.propietario);
			else
				return estado.crearEspadachinDeJugador(this.propietario);
		} 
	
}
