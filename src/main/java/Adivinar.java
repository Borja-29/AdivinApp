
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Adivinar extends Application {
		
	private Label introduceNumero;
	
	private TextField numero;
	
	private Button comprobar;
	
	private VBox root;
	
	int aleatorio = (int) Math.floor(Math.random()*100+1);
	
	int contador=0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		introduceNumero = new Label();
		introduceNumero.setText("Introduce un n�mero del 1 al 100");
		
		numero = new TextField();
		numero.maxWidth(100);
		numero.setAlignment(Pos.CENTER);
		
		comprobar = new Button("Comprobar");
		comprobar.setOnAction(e -> onComprobarAction(e));

		
		root = new VBox();
		root.setSpacing(15);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(introduceNumero, numero, comprobar);
		
		Scene escena = new Scene(root, 320, 200);
		primaryStage.setScene(escena);
		primaryStage.setTitle("AdivinApp");
		primaryStage.show();
	}
	
	private void onComprobarAction(ActionEvent e) {
		contador++;
		try {
			int a = Integer.parseInt(numero.getText());
			if (a >= 1 && a <= 100) {
				if(a == aleatorio) {
					aleatorio = (int) Math.floor(Math.random()*100+1);
					Alert aciertoAlerta = new Alert(AlertType.INFORMATION);
					aciertoAlerta.setTitle("AdivinApp");
					aciertoAlerta.setHeaderText("�Has Ganado!");
					aciertoAlerta.setContentText("Solo has necesitado "+contador+" intentos.\n\n Vuelve a jugar y hazlo mejor.");
					aciertoAlerta.showAndWait();
					contador=0;
					
				}else {
					Alert falloAlerta = new Alert(AlertType.WARNING);
					falloAlerta.setTitle("AdivinApp");
					falloAlerta.setHeaderText("�Has fallado!");
					if(a<aleatorio)
						falloAlerta.setContentText("El n�mero a adivinar es mayor que "+a+".\n\n Vuelve a intentarlo.");
					else
						falloAlerta.setContentText("El n�mero a adivinar es menor que "+a+".\n\n Vuelve a intentarlo.");
					falloAlerta.showAndWait();
				}
			}else {
				Alert errorAlerta = new Alert(AlertType.ERROR);
				errorAlerta.setTitle("AdivinApp");
				errorAlerta.setHeaderText("Error");
				errorAlerta.setContentText("El n�mero introducido no es valido.");
				errorAlerta.showAndWait();
			}
		}catch(Exception f){
			Alert errorAlerta = new Alert(AlertType.ERROR);
			errorAlerta.setTitle("AdivinApp");
			errorAlerta.setHeaderText("Error");
			errorAlerta.setContentText("El n�mero introducido no es valido.");
			errorAlerta.showAndWait();
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
