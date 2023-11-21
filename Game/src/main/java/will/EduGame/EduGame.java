package will.EduGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EduGame extends Application {
	
	Model model;
	View view;
	Controller controller;
	Flower flower;
	

	


	public static void main(String[] args) {
		launch(args);

	}
	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("EduGame");
		
		Pane root = new Pane();
		Scene scene = new Scene(root, 1000, 500);
		primaryStage.setScene(scene);
      	primaryStage.show();

      	model = new Model();
      	view = new View(root,model);
      	flower = new Flower(view.getGC(), 500, 350);
      	controller = new Controller(model,view, flower);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {	//handles keyboard input, would have preferred to put elsewhere
																//but i couldn't figure it out in time

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getCode() == KeyCode.D) {
					flower.moveRight();

				}
				
				if(event.getCode() == KeyCode.A) {
					flower.moveLeft();
				}

			}
		});
			
	}

		
}



