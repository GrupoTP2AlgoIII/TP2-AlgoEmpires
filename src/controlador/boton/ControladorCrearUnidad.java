package controlador.boton;

import modelo.edificio.EdificioOcupadoException;
import modelo.jugador.JugadorSinOroException;
import modelo.jugador.JugadorSuperaTopePoblacionalException;
import modelo.jugador.PosicionNoPerteneceAJugadorException;
import modelo.jugador.PosicionNoPerteneceAPoblacionError;
import modelo.mapa.Posicion;
import vista.ContenedorDatosPosicionable;
import vista.ContenedorMensajesJuego;
import vista.ContenedorPrincipal;

public class ControladorCrearUnidad {

	private Posicion posicionActual;
	private char tipoUnidad;
	private String mensajeConsola;
	
	public ControladorCrearUnidad(char tipo) {
		this.tipoUnidad = tipo;
		switch(this.tipoUnidad) {
			case 'A': this.mensajeConsola = "Arquero";
				break;
			case 'E': this.mensajeConsola = "Espadachin";
				break;
			case 'O': this.mensajeConsola = "Aldeano";
				break;
			case 'S': this.mensajeConsola = "Arma de asedio";
				break;
			default : return;				
		}
	}

	public void crear() {
		this.posicionActual = ContenedorDatosPosicionable.getInstance().getPosicion();	
		try {
			ContenedorPrincipal.getInstance().getJuego().obtenerJugadorActual().crearUnidadPropia(this.posicionActual,this.tipoUnidad);
			ContenedorPrincipal.getInstance().actualizarSinLimpiarConsola();
			ContenedorMensajesJuego.getInstance().agregarMensaje("Creacion "+this.mensajeConsola+" exitoso");
		}catch (JugadorSuperaTopePoblacionalException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al crear "+this.mensajeConsola+",supera tope poblacional");
		}catch (PosicionNoPerteneceAPoblacionError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al crear "+this.mensajeConsola+",el edificio no pertenece al jugador");
		}catch (PosicionNoPerteneceAJugadorException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al crear "+this.mensajeConsola+",el edificio no pertenece al jugador");
		}catch (JugadorSinOroException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al crear "+this.mensajeConsola+",no posee oro suficiente");
		}catch (EdificioOcupadoException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al crear "+this.mensajeConsola+",el edificio esta reparandose/construccion");
		}catch (Exception e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al crear "+this.mensajeConsola);
		}
		}
		
}

