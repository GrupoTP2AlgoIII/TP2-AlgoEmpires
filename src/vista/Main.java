package vista;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	PantallaInicial pantallaInicial = new PantallaInicial();        
         
        Scene scene = new Scene(pantallaInicial); 
         
        primaryStage.setTitle("AlgoEmpires");
        primaryStage.setScene(scene); 
        primaryStage.show();
        
    }
    
}
