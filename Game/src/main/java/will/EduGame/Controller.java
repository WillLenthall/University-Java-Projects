package will.EduGame;

import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller implements EventHandler  {
	
	Model model;
	View view;
	Scene scene;
	Flower flower;
	Sun sun;
	FactoryIF factory;
	GraphicsContext gc;
	Strategy strategy = new Strategy();

	AnimationTimer timer = new AnimationTimer() {
		int timeElapsed = 1;	//a way to increase difficulty over time and keep track of time elapsed
		public void handle(long now) {
			
			view.drawBG();
			if (timeElapsed < 1500) {			//easier gameplay at the start
				if (timeElapsed % 150 == 0) {
					model.addObject(factory.createProduct(strategy));
				}
			}
			
			else if (timeElapsed > 1500 && timeElapsed<3000) {	//objects appear more quickly as time passes
				if (timeElapsed % 100 == 0) {
					model.addObject(factory.createProduct(strategy));
				}
			}
			
			else if (timeElapsed > 3000) {
				if (timeElapsed % 75 == 0) {
					model.addObject(factory.createProduct(strategy));
				}
			}
			
			model.execute();
			model.update();
			
			sun.update();
			flower.update();
			flower.updateR();
			timeElapsed++;
			model.clearUp();
			view.updateScore(model.score);
			if (model.checkCollision(flower)) {
				timer.stop();
				view.back();
				model = new Model();
				timeElapsed = 1;
			}
		} 
	};
	

	
	public Controller(Model model, View view, Flower flower) {
		super();
		this.model = model;
		this.view = view;
		this.flower = flower;
		
		this.gc = view.getGC();
		this.sun = new Sun(gc, 434, 20);
		this.factory = new Factory(gc);
		
		this.view.exitButton.setOnAction(this);
		this.view.newGameButton.setOnAction(this);

		}

	@Override
	public void handle(Event event) {
		if(event.getSource()==this.view.exitButton) {
			
			System.exit(0);			//closes the game
		}
		

		
		if (event.getSource()==this.view.newGameButton) {
			view.newGame();
			timer.start();			//starts the game
			
		}
		


	}
	
	
	

}
