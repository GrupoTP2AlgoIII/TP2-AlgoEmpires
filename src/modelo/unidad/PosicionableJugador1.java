package modelo.unidad;



public interface PosicionableJugador1 {

    public Posicionable vs(Posicionable peleable);


    public default void vs(PosicionableJugador1 posicionable){
        throw new RuntimeException("No puedes atacar a un rival del mismo equipo");
    }


    public default void vs(PosicionableJugador2 enemigo){
        enemigo.recibirDanio(10);

    }


    int getVida();



    void recibirDanio(int ataquepipo);
}
