package modelo.jugador;

import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.vacio.Vacio;

import java.util.HashMap;
import java.util.Map;

public class Poblacion {
    private int oro;
    private int poblacion;
    private int produccionDeOro;
    private int topeDePoblacion;
    private int cantidadPoblacion;
    private Map<Posicion, Posicionable> posicionables;


    public Poblacion(Map <Posicion, Posicionable> posicionablesJugador)

    {
        this.posicionables = new HashMap<Posicion, Posicionable>();
        this.oro = 200; //oro inicial = 200
        this.produccionDeOro = 60; // 3 x 20 (3 aldeanos por 20 de oro);
        this.topeDePoblacion = 50;

    }

    public boolean posicionableEstaEnPoblacion(Posicionable posicionableDado){
        return posicionables.containsValue(posicionableDado);
    }


    public void descontarOro(Posicionable unidad)
    {
        this.oro=unidad.descontarOro(this.oro);
    }

    public void aumentarOro(int oroAIncrementar)
    {
        this.oro += oroAIncrementar;
    }
    public void decrementarProduccionDeOro(Posicionable unidad)
    {
        unidad.decrementarProduccion(this.produccionDeOro);
    }



    public void aumentarPoblacion(Unidad unidad) {
        if(this.cantidadPoblacion < this.topeDePoblacion) {
            this.produccionDeOro = unidad.aumentarProduccionDeOro(this.produccionDeOro);
            this.agregarUnidad(unidad);
            this.cantidadPoblacion += 1;
        }else {
            throw new JugadorSuperaTopePoblacionalException();
        }

    }

    public void quitarPosicionablesDestruidos() {
        Posicionable vacio = new Vacio();
        for (Posicion posicion : posicionables.keySet()){
            Posicionable actual = posicionables.get(posicion);
            if(actual.getVida() <= 0) {
                this.decrementarProduccionDeOro(actual);
                posicionables.replace(posicion,actual, vacio);
            }
        }
    }

    public void avanzarTurno() {
        this.quitarPosicionablesDestruidos();
        Posicionable anterior = null;
        for (Posicionable actual : posicionables.values()){
            if(anterior != actual) {
                int produccionRecursoUnidad =actual.avanzarTurno();
                this.aumentarOro(produccionRecursoUnidad);
            }
            anterior = actual;
        }

    }

    public void decrementarPoblacion(Unidad unidad) {
        Posicionable vacio = new Vacio();
        for (Posicion posicion : posicionables.keySet()) {
            Posicionable actual = posicionables.get(posicion);
            if (actual.getVida() <= 0) {
                this.decrementarProduccionDeOro(actual);
                posicionables.replace(posicion, actual, vacio);
            }
            posicionables.replace(posicion, actual, vacio);
            this.poblacion--;
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
        this.cantidadPoblacion+=1;
    }

    public Posicionable obtenerEdificio(Posicion posicionEdificio){
        return this.posicionables.get(posicionEdificio);
    }

    public Posicionable obtenerPosicionable(Posicion posicion){
        return this.posicionables.get(posicion);
    }

    //Esta es una decision de diseño

    public void agregarEdificio(Map <Posicion, Posicionable> plazaConstruida){
        this.posicionables.putAll(plazaConstruida);
    }
    
    // Metodo para la vista
    
    public int obtenerOro() {
    	return this.oro;
    }
    
    public int obtenerCantidadPoblacion() {
    	return this.poblacion;
    }
}

