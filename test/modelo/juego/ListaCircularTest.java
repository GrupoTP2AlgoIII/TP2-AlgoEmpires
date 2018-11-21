package modelo.juego;

import modelo.jugador.Jugador;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaCircularTest {

    @Test
    public void ListaCircularInsertaJugadoresEnPrimerPosicionCorrectamente() {
        Jugador Pocho =  new Jugador("pocho");
        Jugador Mario = new Jugador("mario");
        ListaCircular<Jugador> listacircular = new ListaCircular<Jugador>();
        listacircular.insertarPrimero(Pocho);
        listacircular.insertarPrimero(Mario);
        listacircular.siguiente();
        listacircular.siguiente();
        listacircular.siguiente();

        assertEquals(listacircular.devolverPrimero().getNombre(), "pocho");
    }

    @Test

    public void ListaCircularCirculaCorrectamente(){

        Jugador Pocho =  new Jugador("pocho");
        Jugador Mario = new Jugador("mario");

        ListaCircular<Jugador> listacircular = new ListaCircular<Jugador>();

        listacircular.insertarPrimero(Pocho);
        listacircular.insertarPrimero(Mario);


        assertEquals(listacircular.devolverPrimero().getNombre(), "mario");

        listacircular.siguiente();


        assertEquals(listacircular.devolverPrimero().getNombre(), "pocho");


        listacircular.siguiente();


        assertEquals(listacircular.devolverPrimero().getNombre(), "mario");

    }
}