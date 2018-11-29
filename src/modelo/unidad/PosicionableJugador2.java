package modelo.unidad;


public interface PosicionableJugador2 {

    public Posicionable vs(Posicionable peleable);

    public default void vs(PosicionableJugador2 posicionable){
        throw new RuntimeException("No puedes atacar a un rival del mismo equipo");
    }



    public default void vs(PosicionableJugador1 enemigo){
        enemigo.recibirDanio(10);

    }


    /*
    public void vs(PosicionableJugador2 amigo);


    public void vs(PosicionableJugador1 enemigo);

*/

    public int getVida();


    void recibirDanio(int ataquepipo);
}
