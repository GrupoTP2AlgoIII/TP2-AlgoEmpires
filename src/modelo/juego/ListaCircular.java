package modelo.juego;


public class ListaCircular<Jugador> {
    int largo = 0;
    private Nodo<Jugador> primero = null;


    public void insertarPrimero(Jugador x) {
        Nodo<Jugador> nuevo=new Nodo<Jugador>(x);
        nuevo.dato=x;
        if (this.primero==null) {
            nuevo.siguiente=nuevo;
            nuevo.anterior=nuevo;
            this.primero=nuevo;
        } else {
            Nodo ultimo=this.primero.anterior;
            nuevo.siguiente=this.primero;
            nuevo.anterior=ultimo;
            this.primero.anterior=nuevo;
            ultimo.siguiente=nuevo;
            this.primero=nuevo;
        }
    }


    public Jugador devolverPrimero(){
        return this.primero.obtenerDato();
    }

    public void siguiente(){
        this.primero = this.primero.siguiente;

    }

}
