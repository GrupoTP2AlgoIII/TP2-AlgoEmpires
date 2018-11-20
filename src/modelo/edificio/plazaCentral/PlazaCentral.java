package modelo.edificio.plazaCentral;

import modelo.ataque.Ataque;
import modelo.edificio.Edificio;
import modelo.unidad.Unidad;

public class PlazaCentral extends Edificio {

		   public PlazaCentral()

		   {
		        this.vida = 450;
                this.costo = 100 ;
		        this.tamanio = 4;
		        this.velocidadReparacion = 25;
		        this.vidaFull = 450;
		    }
		   
		    public Unidad crearAldeano() {
		    	return estado.crearAldeano();
		    }


		    public int avanzarTurno() {
				estado = estado.avanzarTurno(this);
				return 0;
		    }
		    
			@Override
			public void reparar() {
				estado = estado.reparar(this);	
			}

			@Override
			public int getVida() {
				return this.vida;
			}

			@Override
			protected int getVidaFull() {
				return this.vidaFull;
			}

			@Override
			protected void sumarVida() {
				int vidaRepararPorTurno = 25;
				if(this.vida < this.vidaFull) {
					this.vida += vidaRepararPorTurno;
				}		
			}

			@Override
			public int getTurnosConstruccion() {
				return estado.getTurnosOcupado();
			}


			
			@Override
			public int getVelocidadDeReparacion() {
				return this.velocidadReparacion;
			}

			@Override
			public void atacado(Ataque ataque) {
				this.vida -= ataque.getAtaqueEdificio();
				
			}
			

		    

}
