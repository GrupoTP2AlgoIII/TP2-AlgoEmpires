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
    public void start(Stage stage) {
    	
    	stage.setOnCloseRequest(e -> {
    		e.consume();
         	cerrarPrograma();
         });
     	
     	PantallaInicial pantallaInicial = new PantallaInicial(stage);
        Scene scene = new Scene(pantallaInicial);
                  
        stage.setTitle("AlgoEmpires");
        stage.setScene(scene); 
        stage.show();
         
     }
     
     private void cerrarPrograma() {
     	Boolean respuesta = RespuestaBox.display("Salir", "Esta seguro que quiere salir?");
     	if (respuesta) {
     		Platform.exit();
     	}
     }

}