package vista;

import controlador.boton.ControladorMenuAtacar;
import controlador.boton.ControladorMenuCastillo;
import controlador.boton.ControladorMenuConstruirCuartel;
import controlador.boton.ControladorMenuMover;
import controlador.boton.ControladorMenuPlazaCentral;
import controlador.boton.ControladorMenuConstruirPlazaCentral;
import controlador.boton.ControladorMenuCuartelCrearArquero;
import controlador.boton.ControladorMenuCuartelCrearEspadachin;
import controlador.boton.ControladorMenuDesmontar;
import controlador.boton.ControladorMenuMontar;
import controlador.boton.ControladorMenuReparar;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class Menues{
   	
	
	public ContextMenu crearMenuAldeano (){
        ContextMenu menuAldeano = new ContextMenu();
		Menu construir = new Menu();
        construir.setText("Construir");
        MenuItem plaza = new ItemsMenu("PlazaCentral (Costo = 100)",new ControladorMenuConstruirPlazaCentral());
        MenuItem cuartel = new ItemsMenu ("Cuartel (Costo = 50)",new ControladorMenuConstruirCuartel());
        construir.getItems().addAll(plaza,cuartel);         
        MenuItem reparar = new ItemsMenu ("Reparar",new ControladorMenuReparar());
        MenuItem mover = new ItemsMenu ("Mover",new ControladorMenuMover());
        menuAldeano.getItems().addAll(construir, reparar,mover);
        return menuAldeano;
    }
	
	public ContextMenu crearMenuArquero(){      
        ContextMenu menuArquero = new ContextMenu();
		MenuItem atacar = new ItemsMenu ("Atacar",new ControladorMenuAtacar());
        MenuItem mover = new ItemsMenu ("Mover",new ControladorMenuMover());
        menuArquero.getItems().addAll(atacar, mover);
        return menuArquero;
    }
	
	public ContextMenu crearMenuArmaDeAsedio(){
        ContextMenu menuArmaDeAsedio = new ContextMenu();
        MenuItem atacar = new ItemsMenu ("Atacar",new ControladorMenuAtacar());
        MenuItem mover = new ItemsMenu ("Mover",new ControladorMenuMover());
        MenuItem montar = new ItemsMenu ("Montar",new ControladorMenuMontar());
        MenuItem desmontar = new ItemsMenu ("Desmontar",new ControladorMenuDesmontar());
        menuArmaDeAsedio.getItems().addAll(atacar, mover,montar,desmontar);
        return menuArmaDeAsedio;
    }
	
	public ContextMenu crearMenuEspadachin (){ 
        ContextMenu menuEspadachin = new ContextMenu();
        MenuItem atacar = new ItemsMenu ("Atacar",new ControladorMenuAtacar());
        MenuItem mover = new ItemsMenu ("Mover",new ControladorMenuMover());
        menuEspadachin.getItems().addAll(atacar, mover);
        return menuEspadachin;
    }

	public ContextMenu crearMenuPlazaCentral() {
        ContextMenu menuPlazaCentral = new ContextMenu();
        MenuItem crearAldeano = new ItemsMenu ("Crear aldeano (Costo = 25)",new ControladorMenuPlazaCentral());
        menuPlazaCentral.getItems().addAll(crearAldeano);
		return menuPlazaCentral;
	}

	public ContextMenu crearMenuCuartel() {
        ContextMenu menuCuartel = new ContextMenu();
        MenuItem crearEspadachin = new ItemsMenu ("Crear espadachin (Costo = 50)",new ControladorMenuCuartelCrearEspadachin());
        MenuItem crearArquero = new ItemsMenu ("Crear arquero (Costo = 75)",new ControladorMenuCuartelCrearArquero());
        menuCuartel.getItems().addAll(crearEspadachin,crearArquero);
		return menuCuartel;
	}

	public ContextMenu crearMenuCastillo() {
	       ContextMenu menuCastillo = new ContextMenu();
	        MenuItem crearArmaDeAsedio = new ItemsMenu ("Crear arma de asedio (Costo = 200)",new ControladorMenuCastillo());
	        menuCastillo.getItems().addAll(crearArmaDeAsedio);
			return menuCastillo;
	}

}
