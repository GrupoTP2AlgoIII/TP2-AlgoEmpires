package modelo.jugador;

import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;

import java.util.Map;

public class Poblacion {
    private Map<Posicion, Posicionable> posicionables;


    public Poblacion(Map <Posicion, Posicionable> posicionablesJugador){
        this.posicionables = posicionablesJugador;
    }

    public boolean PosicionableEstaEnPoblacion(Posicionable posicionableDado){
        return posicionables.containsValue(posicionableDado);
    }


    public int getCantidad(){
        return posicionables.size();
    }
}



