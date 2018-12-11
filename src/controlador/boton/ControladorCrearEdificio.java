package controlador.boton;

import modelo.jugador.JugadorSinOroException;
import modelo.jugador.PosicionNoPerteneceAJugadorException;
import modelo.jugador.PosicionNoPerteneceAPoblacionError;
import modelo.mapa.Posicion;
import modelo.unidad.aldeano.AldeanoOcupadoException;
import vista.ContenedorMensajesJuego;
import vista.ContenedorPrincipal;

public class ControladorCrearEdificio {
	
	private Posicion posicionAldeano;
	private Posicion posicionAConstruir;
	private char tipoConstruccion;
	private String mensajeConsola;
	
	public ControladorCrearEdificio(char tipo) {
		this.tipoConstruccion = tipo;
		if(this.tipoConstruccion == 'C') {
			this.mensajeConsola = "Cuartel";
			return;
		}
		this.mensajeConsola = "Plaza";
	}

	public void crear() {
		int ladoAreaDeConstruccion = 3;
		ControladorSeleccionUsuarioDesdeHasta controlador = new ControladorSeleccionUsuarioDesdeHasta(posicionAldeano,
				posicionAConstruir,ladoAreaDeConstruccion);
		this.posicionAldeano = controlador.getDesdeCalculada();
		this.posicionAConstruir = controlador.getHastaCalculada();
		
		try {
			if(posicionAldeano.getFila() > posicionAConstruir.getFila()) {
				posicionAConstruir=new Posicion(posicionAConstruir.getFila()-1,posicionAConstruir.getColumna()-1);
			}
			ContenedorPrincipal.getInstance().getJuego().obtenerJugadorActual().
				construirEdificioPropio(posicionAldeano, posicionAConstruir,this.tipoConstruccion);
			ContenedorPrincipal.getInstance().actualizarSinLimpiarConsola();
			ContenedorMensajesJuego.getInstance().agregarMensaje("Construyendo "+this.mensajeConsola);
		}catch (AldeanoOcupadoException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al construir,el aldeano esta ocupado");
		}catch (PosicionNoPerteneceAPoblacionError e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al construir,el aldeano no pertence a tu poblacion");
		}catch (PosicionNoPerteneceAJugadorException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al construir,el aldeano no pertenece a tu poblacion");
		}catch (JugadorSinOroException e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al construir,no posee oro suficiente");
		}catch (Exception e) {
			ContenedorMensajesJuego.getInstance().agregarMensaje("Error al construir");
		}
		
	}



}
