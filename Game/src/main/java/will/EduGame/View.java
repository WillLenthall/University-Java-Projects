package will.EduGame;

import java.io.InputStream;



import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class View {
	
	Pane root;
	Model model;
	Canvas canvas;
	GraphicsContext gc;
	Label titleLabel = new Label();
	Label scoreLabel = new Label();
	Button newGameButton = new Button();
	Button exitButton = new Button();
	//Button backButton = new Button();
	
	public View(Pane root, Model model) { //draws main page
		
		super();
		this.root = root;
		this.model = model;

		
		canvas = new Canvas(1000,500);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.LIGHTBLUE);
		gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
		root.getChildren().add(canvas);
		
		Font myFont = new Font("Serif", 20);
		
		titleLabel.setText("PHOTOSYNTHESIS");
		titleLabel.setLayoutX(400);
		titleLabel.setLayoutY(75);
		titleLabel.setFont(myFont);
		root.getChildren().add(titleLabel);
		
		scoreLabel.setText("Score: "+model.score);
		scoreLabel.setLayoutX(900);
		scoreLabel.setLayoutY(50);
		scoreLabel.setFont(myFont);
		root.getChildren().add(scoreLabel);
		
		newGameButton.setText("New Game");
		newGameButton.setLayoutX(430);
		newGameButton.setLayoutY(200);
		root.getChildren().add(newGameButton);

		
		exitButton.setText("Exit");
		exitButton.setLayoutX(450);
		exitButton.setLayoutY(300);
		root.getChildren().add(exitButton);
		

		
		drawBG();
	}
	

	
	public void back() {
		root.getChildren().add(newGameButton);
		root.getChildren().add(exitButton);
		

	}
	
	public void newGame() {
		root.getChildren().remove(newGameButton);	//draws new game button
		root.getChildren().remove(exitButton);
		root.getChildren().remove(titleLabel);
		
	}
	
	public GraphicsContext getGC() {	// for passing gc outside class
		return gc;
	}
	

	public void drawBG() {
		Image bgImage = new Image(this.getClass().getResourceAsStream("background.png"));
		gc.drawImage(bgImage, 0, 0); //draws background
	}
	
	public void updateScore(int score) {
		scoreLabel.setText("Score: "+score);	//updates score
	}
	
	//public void drawObject(GameObject object) {
	//	gc.drawImage(object.img,object.x,object.y);		remnant of different drawing strategy

	//}

}
