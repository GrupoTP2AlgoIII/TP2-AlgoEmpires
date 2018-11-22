package modelo.ataque;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.juego.Juego;
import modelo.jugador.PosicionOcupadaError;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.aldeano.AldeanoNoPuedeAtacarError;
import modelo.unidad.armaDeAsedio.ArmaDeAsedio;
import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;

public class AtaqueTest {

	@Test
	public void test01AtacarUnaUnidadDentroDelRangoDeAlcance () throws PosicionFueraDelMapaError, PosicionOcupadaError, AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		
		Arquero arquero = new Arquero (5, 5);
		Espadachin espadachin = new Espadachin (7,7);
		Juego juego = new Juego ();
		juego.agregarUnidadEnFilaColumna(arquero, 5, 5);
		juego.agregarUnidadEnFilaColumna(espadachin, 7, 7);
		arquero.atacar(espadachin);
		
		//el espadachin inicia con vida = 100
		//el ataque del arquero le resta 15 a la vida del espadachin
		assertEquals (espadachin.getVida(), 85);
		
	}
	
	@Test (expected = AtacandoEnPosicionFueraDelAlcanceError.class)
	public void test02AtacarUnaUnidadFueraDelRangoDeAlcanceLanzaExcepcion () throws PosicionFueraDelMapaError, PosicionOcupadaError, AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		
		Arquero arquero = new Arquero (5, 5);
		Espadachin espadachin = new Espadachin (15,15);
		Juego juego = new Juego ();
		juego.agregarUnidadEnFilaColumna(arquero, 5, 5);
		juego.agregarUnidadEnFilaColumna(espadachin, 15, 15);
		arquero.atacar(espadachin);
		
	}
	
	@Test (expected = AtacandoEnPosicionFueraDelAlcanceError.class)
	public void test03ArmaDeAsedioAtacaAUnArqueroFueraDelRangoDeAlcanceLanzaExcepcion () throws PosicionFueraDelMapaError, PosicionOcupadaError, AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio (5, 5);
		Arquero arquero = new Arquero (30, 30);
		Juego juego = new Juego ();
		juego.agregarUnidadEnFilaColumna(arquero, 30, 30);
		juego.agregarUnidadEnFilaColumna(armaDeAsedio, 5, 5);
		armaDeAsedio.atacar(arquero);
		
	}
	
	@Test
	public void test04ArqueroAtacaACuartelYTodoElCuartelPerteneceAlRangoDeAlcanceDelArquero () throws PosicionFueraDelMapaError, PosicionOcupadaError, AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		
		Arquero arquero = new Arquero (5, 5);
		Cuartel cuartel = new Cuartel(7, 4, 8, 5);
		Juego juego = new Juego ();
		juego.agregarUnidadEnFilaColumna(arquero, 5, 5);
		juego.agregarEdifcioDesdeHasta(cuartel, 7, 4, 8, 5);
		arquero.atacar(cuartel);
		
		//el cuartel inicialmente tiene 240 de vida
		//el arquero le resta 10 de vida
		assertEquals (cuartel.getVida(), 240);
	}
	
	@Test
	public void test05EspadachinAtacaAPlazaCentralQueSoloDosPosicionesPertenecesAlRangoDeAlcanceDelEspadachin () throws AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		
		Espadachin espadachin = new Espadachin (5, 5);
		PlazaCentral plaza = new PlazaCentral (5, 6, 6, 7);
		espadachin.atacar(plaza);
		
		//la plaza inicia con vida = 450
		//espadachin resta 15 de vida
		assertEquals (plaza.getVida(), 435);
	}
	
	@Test (expected = AtacandoEnPosicionFueraDelAlcanceError.class)
	public void test06ArqueroAtacaAPlazaCentralFueraDelRangoDeAlcance () throws AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		
		Arquero arquero = new Arquero (5, 5);
		PlazaCentral plaza = new PlazaCentral (10, 4, 11, 5);
		arquero.atacar(plaza);
	}
	
	
	
	
}
