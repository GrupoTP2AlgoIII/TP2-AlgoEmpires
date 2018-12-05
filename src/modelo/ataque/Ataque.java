package modelo.ataque;

import modelo.edificio.Edificio;
import modelo.mapa.Posicion;
import modelo.unidad.Unidad;

public class Ataque {
	
	private int danioUnidad;
	private int danioEdificio;
	private int distancia;
	
	public Ataque (int danioEdificio, int danioUnidad, int distancia) {
		this.danioEdificio = danioEdificio;
		this.danioUnidad = danioUnidad;
		this.distancia = distancia;
	}
	
	public void atacar (Unidad recibeAtaque) {
		recibeAtaque.recibirDanio (this.danioUnidad);
	}
	
	public void atacar (Edificio recibeAtaque) {
		recibeAtaque.recibirDanio (this.danioEdificio);
		
	}
	
	public void atacar (Unidad unidadAtacada, Posicion posicionAtacado, Posicion posicionAtacante) {
		if (!posicionAtacado.perteneceALaCuadricula(posicionAtacante, distancia, this.distancia)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		this.atacar(unidadAtacada);
	}
	
	public void atacar (Edificio edificioAtacado, Posicion posicionAtacado, Posicion posicionAtacante) {
		if (!posicionAtacado.perteneceALaCuadricula(posicionAtacante, distancia, this.distancia)) {
			throw new AtacandoEnPosicionFueraDelAlcanceError ();
		}
		this.atacar(edificioAtacado);
	}
	
}
