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
   	
	public ContextMenu crearMenu(String tipoPosicionable) {
		switch (tipoPosicionable) {
		case "A ":
			return crearMenuAldeano();
		case "ES":
			return crearMenuEspadachin();
		case "AR":
			return crearMenuArquero();
		case "AS":
			return crearMenuArmaDeAsedio();
		case "PC":
			return crearMenuPlazaCentral();
		case "CL":
			return crearMenuCuartel();
		case "CT":
			return crearMenuCastillo();
		default:
			return null;
		}
	}
	
	private ContextMenu crearMenuAldeano (){
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
	
	private ContextMenu crearMenuArquero(){      
        ContextMenu menuArquero = new ContextMenu();
		MenuItem atacar = new ItemsMenu ("Atacar",new ControladorMenuAtacar());
        MenuItem mover = new ItemsMenu ("Mover",new ControladorMenuMover());
        menuArquero.getItems().addAll(atacar, mover);
        return menuArquero;
    }
	
	private ContextMenu crearMenuArmaDeAsedio(){
        ContextMenu menuArmaDeAsedio = new ContextMenu();
        MenuItem atacar = new ItemsMenu ("Atacar",new ControladorMenuAtacar());
        MenuItem mover = new ItemsMenu ("Mover",new ControladorMenuMover());
        MenuItem montar = new ItemsMenu ("Montar",new ControladorMenuMontar());
        MenuItem desmontar = new ItemsMenu ("Desmontar",new ControladorMenuDesmontar());
        menuArmaDeAsedio.getItems().addAll(atacar, mover,montar,desmontar);
        return menuArmaDeAsedio;
    }
	
	private ContextMenu crearMenuEspadachin (){ 
        ContextMenu menuEspadachin = new ContextMenu();
        MenuItem atacar = new ItemsMenu ("Atacar",new ControladorMenuAtacar());
        MenuItem mover = new ItemsMenu ("Mover",new ControladorMenuMover());
        menuEspadachin.getItems().addAll(atacar, mover);
        return menuEspadachin;
    }

	private ContextMenu crearMenuPlazaCentral() {
        ContextMenu menuPlazaCentral = new ContextMenu();
        MenuItem crearAldeano = new ItemsMenu ("Crear aldeano (Costo = 25)",new ControladorMenuPlazaCentral());
        menuPlazaCentral.getItems().addAll(crearAldeano);
		return menuPlazaCentral;
	}

	private ContextMenu crearMenuCuartel() {
        ContextMenu menuCuartel = new ContextMenu();
        MenuItem crearEspadachin = new ItemsMenu ("Crear espadachin (Costo = 50)",new ControladorMenuCuartelCrearEspadachin());
        MenuItem crearArquero = new ItemsMenu ("Crear arquero (Costo = 75)",new ControladorMenuCuartelCrearArquero());
        menuCuartel.getItems().addAll(crearEspadachin,crearArquero);
		return menuCuartel;
	}

	private ContextMenu crearMenuCastillo() {
	       ContextMenu menuCastillo = new ContextMenu();
	        MenuItem crearArmaDeAsedio = new ItemsMenu ("Crear arma de asedio (Costo = 200)",new ControladorMenuCastillo());
	        menuCastillo.getItems().addAll(crearArmaDeAsedio);
			return menuCastillo;
	}

}
