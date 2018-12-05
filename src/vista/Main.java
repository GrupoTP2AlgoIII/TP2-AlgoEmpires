package vista;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
        primaryStage.setOnCloseRequest(e -> {
        	e.consume();
        	cerrarPrograma();
        });
    	
    	PantallaInicial pantallaInicial = new PantallaInicial(primaryStage);
        Scene scene = new Scene(pantallaInicial);
                 
        primaryStage.setTitle("AlgoEmpires");
        primaryStage.setScene(scene); 
        primaryStage.show();
        
    }
    
    private void cerrarPrograma() {
    	Boolean respuesta = RespuestaBox.display("Salir", "¿Esta seguro que quiere salir?");
    	if (respuesta) {
    		Platform.exit();
    	}
    }
    
}
