package controlador.boton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.jugador.JuegoFinalizadoException;
import modelo.jugador.PosicionDesocupadaError;
import modelo.jugador.PosicionNoPerteneceAJugadorException;
import modelo.jugador.PosicionNoPerteneceAPoblacionError;
import modelo.mapa.Posicion;
import modelo.unidad.AtacandoAUnAliadoError;
import modelo.unidad.AtaquesPorTurnoExcedidosError;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioDesmontadaException;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioDesmontandoseException;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioMontandoseException;
import modelo.vacio.PosicionableVacioNoPuedeSerAtacadoException;
import vista.ContenedorDatosPosicionable;
import vista.ContenedorMensajesJuego;
import vista.ContenedorPrincipal;

public class ControladorMenuAtacar implements EventHandler<ActionEvent> {

	
	private Posicion posicionActual;
	private Posicion posicionAAtacar;
	
	@Override
	public void handle(ActionEvent event) {
		int ladoAreaAtaque = (ContenedorDatosPosicionable.getInstance().getNumeroRango()*2)+1;
		ControladorSeleccionUsuarioDesdeHasta controlador = new ControladorSeleccionUsuarioDesdeHasta(posicionActual,
				posicionAAtacar,ladoAreaAtaque);		
		this.posicionActual = controlador.getDesdeCalculada();
		this.posicionAAtacar = controlador.getHastaCalculada();
		
		try {
			ContenedorPrincipal.getInstance().getJuego().obtenerJugadorActual().atacar(posicionActual,posicionAAtacar);
			ContenedorPrincipal.getInstance().getJuego().actualizarJuego();
			ContenedorPrincipal.getInstance().actualizarSinLimpiarConsola();
			ContenedorMensajesJuego.getInstance().agregarMensaje("Ataque exitoso");
		}catch (ArmaDeAsedioDesmontandoseException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al atacar,el arma de asedio se esta desmontando");
		}catch (PosicionNoPerteneceAPoblacionError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al atacar,la unidad no pertence al jugador");
		}catch (PosicionNoPerteneceAJugadorException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al atacar,la unidad no pertenece al jugador");
		}catch (PosicionDesocupadaError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al atacar,la posicion esta vacia");
			ContenedorPrincipal.getInstance().getJuego().actualizarJuego();
			ContenedorPrincipal.getInstance().actualizarSinLimpiarConsola();
		}catch (AtaquesPorTurnoExcedidosError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al atacar,cantidad maxima de ataques por turno es 1");
		}catch (AtacandoAUnAliadoError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al atacar,estas atacando a un aliado");
		}catch (PosicionableVacioNoPuedeSerAtacadoException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al atacar,la posicion esta vacia");
		}catch (ArmaDeAsedioDesmontadaException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al atacar,el arma de asedio esta desmontada");
		}catch (ArmaDeAsedioMontandoseException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al atacar,el arma de asedio se esta montando");
		}catch (JuegoFinalizadoException e) {
			ContenedorPrincipal.getInstance().getJuego().actualizarJuego();
			ContenedorPrincipal.getInstance().actualizarSinLimpiarConsola();
			ContenedorPrincipal.getInstance().finJuego(e.getNombreGanador());
		}catch (Exception e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al atacar");
		}
	}

}
