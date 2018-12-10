package modelo.edificio.cuartel;

import modelo.edificio.EdificiosNoSePuedenDesplazarError;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.arquero.Arquero;

import org.junit.Test;
import static org.junit.Assert.*;

public class CuartelTest {

    @Test
    public void test01CuartelEsCreadoYCreaArqueroQueAtacaAUnAldeanoYLeResta15DeVida(){
    	Mapa mapa = new Mapa ();
    	Jugador jugador = new Jugador (mapa, "anto", "juan");
    	
        Cuartel cuartel =  new Cuartel();

        cuartel.avanzarTurno();
        cuartel.actualizar();
        cuartel.avanzarTurno();
        cuartel.actualizar();
        cuartel.avanzarTurno();
        cuartel.actualizar();
        
         
		Unidad arquero = cuartel.crearUnidadPropia('A', jugador);
		
		arquero.recibirDanio(10);
		
		assertEquals (arquero.getVida(), 65);

    }

    @Test
    public void test02CuartelEsCreadoYCreaEspadachinQueAtacaAUnAldeanoYLeResta25DeVida() {
    	Mapa mapa = new Mapa ();
    	Jugador jugador = new Jugador (mapa, "anto", "juan");
    	
        Cuartel cuartel =  new Cuartel();
        cuartel.avanzarTurno();
        cuartel.actualizar();
        cuartel.avanzarTurno();
        cuartel.actualizar();
        cuartel.avanzarTurno();
        cuartel.actualizar();

        Unidad soldier = cuartel.crearUnidadPropia('S', jugador);
        soldier.posicionarEnFilaColumna(1,1);
        
        assertEquals (soldier.getPosicion().getFila(), 1);
        assertEquals (soldier.getPosicion().getColumna(), 1);
		
    }
    
    @Test (expected = EdificiosNoSePuedenDesplazarError.class)
    public void test03DesplazarUnCuartelDebeLanzarExcepcion () {
    	
    	Cuartel cuartel = new Cuartel ();
    	cuartel.desplazarHasta(new Posicion (5,5));
    }
    
    @Test (expected = CuartelNoPuedeAtacarError.class)
    public void test04ElCuartelNoPuedeAtacarAUnaUnidad () {
    	
    	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = new Jugador (mapa, "juan", "anto");
    	Cuartel cuartel = new Cuartel (1, 1, 2, 2, primerJugador);
    	Arquero arquero = new Arquero (2, 3, segundoJugador);
    	
    	cuartel.atacar(arquero, new Posicion (2,3));
    }
    
    @Test (expected = CuartelNoPuedeAtacarError.class)
    public void test05ElCuartelNoPuedeAtacarAUnEdificio () {
    	
    	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = new Jugador (mapa, "juan", "anto");
    	Cuartel cuartel = new Cuartel (1, 1, 2, 2, primerJugador);
    	PlazaCentral plaza = new PlazaCentral (2, 3, 3, 4, segundoJugador);
    	
    	cuartel.atacar(plaza, new Posicion (2,3));
    }
    
    @Test (expected = CuartelNoPuedeAtacarError.class)
    public void test06ElCuartelNoPuedeAtacarAUnPosicionable () {
    	
    	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = new Jugador (mapa, "juan", "anto");
    	Cuartel cuartel = new Cuartel (1, 1, 2, 2, primerJugador);
    	Posicionable arquero = new Arquero (2, 3, segundoJugador);
    	
    	cuartel.atacar(arquero);
    }
    
    @Test
    public void test07CuartelEsCreadoYCreaEspadachinQueAtacaAUnAldeanoYLeResta25DeVida() {
    	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = new Jugador (mapa, "juan", "anto");
    	Cuartel cuartel =  new Cuartel(1, 1, 2, 2, primerJugador);
    	Aldeano aldeano = new Aldeano (2,4,segundoJugador);
        cuartel.avanzarTurno();
        cuartel.actualizar();
        cuartel.avanzarTurno();
        cuartel.actualizar();
        cuartel.avanzarTurno();
        cuartel.actualizar();

        Unidad soldier = cuartel.crearUnidadPropia('S', primerJugador);
        soldier.posicionarEnFilaColumna(2,3);
 
        soldier.atacar(aldeano, new Posicion (2,4));
        
        assertEquals (aldeano.getVida(), 25);
		
    }
}