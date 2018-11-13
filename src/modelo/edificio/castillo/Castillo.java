package modelo.edificio.castillo;

import modelo.edificio.Edificio;
import modelo.unidad.armaDeAsedio.ArmaDeAsedio;

public class Castillo extends Edificio {

    public Castillo() {
        this.vida = 1000;
        this.tamanio = 16;
        this.velocidadReparacion = 15;
    }

    public ArmaDeAsedio crearArmaAsedio(){
        ArmaDeAsedio nuevaArmaAsedio = new ArmaDeAsedio();
            return nuevaArmaAsedio;
    }

}
