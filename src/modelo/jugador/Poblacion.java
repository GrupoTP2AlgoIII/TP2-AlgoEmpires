package modelo.jugador;

import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.vacio.Vacio;

import java.util.HashMap;
import java.util.Map;

public class Poblacion {
    private int oro;
    private int produccionDeOro;
    private int topeDePoblacion;
    private int cantidadPoblacion;
    private Map<Posicion, Posicionable> posicionables;


    public Poblacion(Map <Posicion, Posicionable> posicionablesJugador)

    {
        this.posicionables = new HashMap<Posicion, Posicionable>();
        this.oro = 100; //oro inicial = 200
        this.produccionDeOro = 0;
        this.topeDePoblacion = 50;
        this.cantidadPoblacion = 0;

    }
    
    public void posicionablePerteneceAJugador(Posicion posicionPosicionable) {
    	if(!(this.posicionables.containsKey(posicionPosicionable))) {
    		throw new PosicionNoPerteneceAJugadorException();
    	}
    }
    
    public boolean posicionableEstaEnPoblacion(Posicionable posicionableDado){
        return posicionables.containsValue(posicionableDado);
    }
      
    public boolean posicionableEstaEnPoblacion(Posicion posicionableDado){
        return posicionables.containsKey(posicionableDado);
    } 

    public void descontarOro(Posicionable unidad) {
        this.oro=unidad.descontarOro(this.oro);
    }

    public void aumentarOro(int oroAIncrementar) {
        this.oro += oroAIncrementar;
    }
    
    public void produccionDeOro(){
    	this.produccionDeOro = 0;
    	for (Posicionable actual : this.posicionables.values()) {
    		this.produccionDeOro += actual.produccionDeOro();
    	}
    }

    public void aumentarPoblacion(Unidad unidad) {
        if(this.cantidadPoblacion < this.topeDePoblacion) {
            this.agregarUnidad(unidad);
        }else {
            throw new JugadorSuperaTopePoblacionalException();
        }

    }

    public void quitarPosicionablesDestruidos() {
        for (Posicion posicion : posicionables.keySet()){
            Posicionable actual = posicionables.get(posicion);
            if(actual.getVida() <= 0) {
                this.decrementarPoblacion(actual);
                posicionables.put(posicion,new Vacio(posicion));
            }
        }
    }

    private void decrementarPoblacion(Posicionable actual) {
		this.cantidadPoblacion -= actual.decrementarPoblacion();
	}
    
    public void avanzarTurno() {
        for (Posicionable actual : posicionables.values()){
             int produccionRecursoUnidad =actual.avanzarTurno();
             this.aumentarOro(produccionRecursoUnidad);
        }

    }

    public int getCantidad(){
        return posicionables.size();
    }

    public void agregarPosicionable(Posicion posicionDelPosicionable, Posicionable posicionable){
        this.posicionables.put(posicionDelPosicionable, posicionable);
    }

    public void agregarUnidad(Unidad unidad){
        this.posicionables.put(unidad.getPosicion(),unidad);
        this.cantidadPoblacion++;
    }

    public Posicionable obtenerEdificio(Posicion posicionEdificio){
    	if (!posicionables.containsKey(posicionEdificio)) {
    		throw new PosicionNoPerteneceAPoblacionError ();
    	}
        return this.posicionables.get(posicionEdificio);
    }

    public Posicionable obtenerPosicionable(Posicion posicion){
    	if (!posicionables.containsKey(posicion)) {
    		throw new PosicionNoPerteneceAPoblacionError ();
    	}
        return this.posicionables.get(posicion);
    }

    //Esta es una decision de disenio

    public void agregarEdificio(Map <Posicion, Posicionable> plazaConstruida){
        this.posicionables.putAll(plazaConstruida);
    }
    
    // Metodo para la vista
    
    public int obtenerOro() {
    	return this.oro;
    }
    
    public int obtenerCantidadPoblacion() {
    	return this.cantidadPoblacion;
    }
    
	public int obtenerProduccionOro() {
        this.produccionDeOro();
		return this.produccionDeOro;
	}

	public void reemplazarPosicionDesdeEnHasta(Posicion desde, Posicion hasta) {
		this.posicionables.put(hasta, this.posicionables.get(desde));
		this.posicionables.put(desde, new Vacio(desde));		
	}

	public void actualizar() {
		for (Posicionable actual : posicionables.values()){
        	actual.actualizar();
        }
		
	}
}

