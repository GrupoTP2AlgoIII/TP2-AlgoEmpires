package modelo.ataque;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.juego.Juego;
import modelo.mapa.Posicion;
import modelo.unidad.armaDeAsedio.ArmaDeAsedio;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioMontadaNoPuedeDesplazarseError;
import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;

public class AtaqueTest {

	@Test
	public void test01AtacarUnaUnidadDentroDelRangoDeAlcance () {
		
		Arquero arquero = new Arquero (5, 5);
		Espadachin espadachin = new Espadachin (7,7);
		Juego juego = new Juego ("Pedro", "Maria");
		juego.agregarUnidadEnFilaColumna(arquero, 5, 5);
		juego.agregarUnidadEnFilaColumna(espadachin, 7, 7);
		arquero.atacar(espadachin, new Posicion (7,7));
		
		//el espadachin inicia con vida = 100
		//el ataque del arquero le resta 15 a la vida del espadachin
		assertEquals (espadachin.getVida(), 85);
		
	}

	@Test (expected = AtacandoEnPosicionFueraDelAlcanceError.class)
	public void test02AtacarUnaUnidadFueraDelRangoDeAlcanceLanzaExcepcion () {
		
		Arquero arquero = new Arquero (5, 5);
		Espadachin espadachin = new Espadachin (15,15);
		Juego juego = new Juego ("Pedro", "Maria");
		juego.agregarUnidadEnFilaColumna(arquero, 5, 5);
		juego.agregarUnidadEnFilaColumna(espadachin, 15, 15);
		arquero.atacar(espadachin, new Posicion (15,15));
		
	}
	
	@Test (expected = AtacandoEnPosicionFueraDelAlcanceError.class)
	public void test03ArmaDeAsedioAtacaAUnArqueroFueraDelRangoDeAlcanceLanzaExcepcion () {
		
		ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio (5, 5);
		armaDeAsedio.montar();
		armaDeAsedio.avanzarTurno();
		Arquero arquero = new Arquero (30, 30);
		Juego juego = new Juego ("Pedro", "Maria");
		juego.agregarUnidadEnFilaColumna(arquero, 30, 30);
		juego.agregarUnidadEnFilaColumna(armaDeAsedio, 5, 5);
		armaDeAsedio.atacar(arquero, new Posicion (30,30));
		
	}

	@Test
	public void test04ArqueroAtacaACuartelYTodoElCuartelPerteneceAlRangoDeAlcanceDelArquero ()  {
		
		Arquero arquero = new Arquero (5, 5);
		Cuartel cuartel = new Cuartel(7, 4, 8, 5);
		Juego juego = new Juego ("Pedro", "Maria");
		juego.agregarUnidadEnFilaColumna(arquero, 5, 5);
		arquero.atacar(cuartel, new Posicion (7,4));
		
		//el cuartel inicialmente tiene 240 de vida
		//el arquero le resta 10 de vida
		assertEquals (cuartel.getVida(), 240);
	}
	
	@Test
	public void test05EspadachinAtacaAPlazaCentralQueSoloDosPosicionesPertenecesAlRangoDeAlcanceDelEspadachin () {
		
		Espadachin espadachin = new Espadachin (5, 5);
		PlazaCentral plaza = new PlazaCentral (5, 6, 6, 7);
		espadachin.atacar(plaza, new Posicion (5,6));
		
		//la plaza inicia con vida = 450
		//espadachin resta 15 de vida
		assertEquals (plaza.getVida(), 435);
	}

	@Test (expected = AtacandoEnPosicionFueraDelAlcanceError.class)
	public void test06ArqueroAtacaAPlazaCentralFueraDelRangoDeAlcance ()  {
		
		Arquero arquero = new Arquero (5, 5);
		PlazaCentral plaza = new PlazaCentral (10, 4, 11, 5);
		arquero.atacar(plaza, new Posicion (10,4));
	}
	
	@Test (expected = ArmaDeAsedioDesmontadaNoPuedeAtacarError.class)
	public void test08AtacarConArmaDeAsedioDesmontadaDebeLanzarExcepcion ()  {
		
		Cuartel cuartel = new Cuartel (5,5,6,6);
		ArmaDeAsedio arma = new ArmaDeAsedio (6,8);
		//el arma inicia desmontada
		arma.atacar(cuartel);
	}
	
	@Test (expected = ArmaDeAsedioDesmontadaNoPuedeAtacarError.class)
	public void test09MontarArmaDeAsedioYAtacarEnElMismoTurnoDebeLanzarExcepcion () {
		
		Cuartel cuartel = new Cuartel (5,5,6,6);
		ArmaDeAsedio arma = new ArmaDeAsedio (6,8);
		arma.montar ();
		arma.atacar(cuartel);
	}
	
	@Test
	public void test10MoverArmaDeAsedioDesmontadaHaciaLaDerecha () {
		
		ArmaDeAsedio arma = new ArmaDeAsedio (6,8);
		arma.avanzarTurno();
		//arma desmontada
		arma.desplazarHasta(new Posicion (6,9));
	
	}
	
	@Test (expected = ArmaDeAsedioMontadaNoPuedeDesplazarseError.class)
	public void test11MoverArmaDeAsedioMontadaHaciaDebeLanzarExcepcion () {
		
		ArmaDeAsedio arma = new ArmaDeAsedio (6,8);
		arma.montar();
		arma.avanzarTurno();
		arma.desplazarHasta(new Posicion (6,9));
		
	}
}
