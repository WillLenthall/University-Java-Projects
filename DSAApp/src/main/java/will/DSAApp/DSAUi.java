package will.DSAApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class DSAUi extends Application {
	Pane root = new Pane();
	Scene scene = new Scene(root,600,300);
	Label instructions = new Label(); 
	Label outLabel = new Label();
	TextField inTextField = new TextField();
	Button submitButton = new Button();
	EventHandler<ActionEvent> bHandler = new EventHandler<ActionEvent>() {


		@Override
		public void handle(ActionEvent event) {
			
			String input = inTextField.getText(); // Takes the input as a String
			PostFixConverter pfc = new PostFixConverter(input); // creates the converter class and checks the string is valid
			String output = pfc.converter(input); // returns an output
			outLabel.setText(output); // prints the output on UI

			
		}};



	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setScene(scene); // design details for the instructions label
		primaryStage.show();
		instructions.setLayoutX(50);
		instructions.setLayoutY(50);
		instructions.setText("Please enter an infix expression including only letters and the operators + * /");
		root.getChildren().add(instructions);
		
		outLabel.setText(""); // design details for the output label
		outLabel.setLayoutX(50);
		outLabel.setLayoutY(150);
		root.getChildren().add(outLabel);
		
		inTextField.setText(""); // design details for the input textbox
		inTextField.setLayoutX(50);
		inTextField.setLayoutY(100);
		root.getChildren().add(inTextField);
		
		submitButton.setText("Convert");   // design details for the button
		submitButton.setLayoutX(50);
		submitButton.setLayoutY(200);
		root.getChildren().add(submitButton);
		submitButton.setOnAction(bHandler);

	}


}
