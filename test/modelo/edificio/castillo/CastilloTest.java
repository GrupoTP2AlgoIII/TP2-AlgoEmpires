package modelo.edificio.castillo;

import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.edificio.EdificiosNoSePuedenDesplazarError;
import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.DesplazarAPosicionOcupadaError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CastilloTest {

    @Test
    public void test01CrearCastilloYCreoArmaAsedio() {
    	Mapa mapa = new Mapa ();
    	Jugador jugador = new Jugador (mapa, "anto", "juan");
        Castillo sanJorge = new Castillo();
        
        sanJorge.avanzarTurno();
        sanJorge.actualizar();
        sanJorge.avanzarTurno();
        sanJorge.actualizar();
        sanJorge.avanzarTurno();
        sanJorge.actualizar();

        
        Unidad escorpion = sanJorge.crearUnidadPropia('A', jugador);
		boolean retorno = false;
		
		if(escorpion != null) {
			retorno = true;
		}	
		
		assertEquals (true,retorno);
    }
    
    @Test
    public void test02CastilloAtacaEnemigosEnSuRango(){
    	
    	Mapa mapa = new Mapa();
    	    	
    	mapa.posicionarEnFilaColumna(new Espadachin(), 8, 8);
    	mapa.ponerEdificioDesdeHasta(new PlazaCentral(0), 8, 4, 9, 5);
    	
    	HashMap<Posicion, Posicionable> atacables = new HashMap <Posicion, Posicionable> ();
    	Posicion posicion1 = new Posicion(8,8);
    	Posicion posicion2 = new Posicion(8,4);
    	atacables.put(posicion1, mapa.obtenerPosicionableEn(posicion1));
    	atacables.put(posicion2, mapa.obtenerPosicionableEn(posicion2));
    	
    	mapa.ponerEdificioDesdeHasta(new Castillo(0,new Jugador(mapa,"Juan","Pedro")), 4, 4, 7, 7);
    	Castillo castillo = (Castillo) mapa.obtenerPosicionableEn(new Posicion(4,4));
    	castillo.setAtacables(atacables);
    	castillo.atacarEnemigosAlAlcance();
    	
    	assertEquals(80, mapa.obtenerPosicionableEn(new Posicion(8,8)).getVida());
    	assertEquals(430, mapa.obtenerPosicionableEn(new Posicion(8,4)).getVida()); 	
	    	
    }
    
    @Test (expected = EdificiosNoSePuedenDesplazarError.class )
    public void test03DesplazarCastilloDebeLanzarExcepcion () {
    	
    	Castillo castillo = new Castillo ();
    	castillo.desplazarHasta(new Posicion (5,5));
    	
    }
    
    @Test
    public void test04CastilloRecibeDanioDeArqueroYSeLeDescuentaVida () {
    	
    	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = primerJugador.jugadorSiguiente();
    	Arquero arquero = new Arquero (1, 1, primerJugador);
    	Castillo castillo = new Castillo (1,2,4,5, segundoJugador);
    	castillo.recibirDanioDe(arquero);
    	
    	assertEquals (castillo.getVida(), 990);
    }
    
    @Test
    public void test05CastilloRecibeDanioDePosicionableYSeLeDescuentaVida () {
    	
    	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = primerJugador.jugadorSiguiente();
    	Posicionable arquero = new Arquero (1, 1, primerJugador);
    	Castillo castillo = new Castillo (1,2,4,5, segundoJugador);
    	castillo.recibirDanioDe(arquero);
    	
    	assertEquals (castillo.getVida(), 990);   	
    }
    
    @Test (expected = DesplazarAPosicionOcupadaError.class)
    public void test06ElCastilloNoPuedeRecibirNingunPosicionableYaQueSuPosicionEstaOcupada () {
       	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = primerJugador.jugadorSiguiente();
    	Arquero arquero = new Arquero (1,1, primerJugador);
    	Castillo castillo = new Castillo (1, 2, 4 ,5, segundoJugador);
    	mapa.posicionarPosicionableEnPosicion(arquero, new Posicion (1,1));
    	mapa.posicionarPosicionableEnPosicion(castillo, new Posicion (1, 2));
    	mapa.posicionarDesdeEnHasta (new Posicion (1,1), new Posicion (1,2));
 
    }
    
    @Test (expected = AtacandoEnPosicionFueraDelAlcanceError.class)
    public void test07CastilloAtacaAUnaUnidadQueSeEncuentraFueraDeSuAlcanceLanzaExcepcion () {
       	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = primerJugador.jugadorSiguiente();
    	Arquero arquero = new Arquero (15, 15, primerJugador);
    	Castillo castillo = new Castillo (1, 2, 4 ,5, segundoJugador);
    	mapa.posicionarPosicionableEnPosicion(arquero, new Posicion (15,15));
    	mapa.posicionarPosicionableEnPosicion(castillo, new Posicion (1, 2));
    	
    	castillo.atacar(arquero, new Posicion (15, 15));
    	
    }
    
    @Test (expected = AtacandoEnPosicionFueraDelAlcanceError.class)
    public void test08CastilloAtacaAUnEdificioQueSeEncuentraFueraDeSuAlcanceLanzaExcepcion () {
       	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = primerJugador.jugadorSiguiente();
    	Cuartel cuartel = new Cuartel (10, 10, 11, 11, primerJugador);
    	Castillo castillo = new Castillo (1, 2, 4 ,5, segundoJugador);
    	mapa.posicionarPosicionableEnPosicion(cuartel, new Posicion (10,10));
    	mapa.posicionarPosicionableEnPosicion(castillo, new Posicion (1, 2));
    	
    	castillo.atacar(cuartel, new Posicion (10, 10));
    	
    }
    
}