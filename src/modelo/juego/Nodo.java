package modelo.juego;

public class Nodo<Jugador> {
    protected Nodo<Jugador> siguiente;
    protected Nodo<Jugador> anterior;
    Jugador dato;

   public Nodo(Jugador nuevo)

    {
        this.dato = nuevo;
    }

    public Jugador obtenerDato(){
       return this.dato;
    }

}