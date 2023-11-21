package will.EduGame;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Droplet extends GameObject {
	
	protected Image img;
	protected double x, y;
	protected GraphicsContext gc;
	protected Rectangle r;
	private StrategyInterface strat;
	protected double width = 22;
	protected double length = 28;
	
	public Droplet(GraphicsContext gc, double x, double y, Strategy strategy) {
		super(gc, x, y);
		Random random = new Random();

		int i = random.nextInt(3);		//decides which cloud to fall from
		this.strat = strategy;
		if (i == 0) {
			this.x = x;
			this.y = 120;
		}
		
		else if (i == 1) {
			this.x = 750;
			this.y = 150;
		}
		
		else if (i == 2) {
			this.x = 930;
			this.y = 80;
		}
		this.gc = gc;
		r = new Rectangle(x,y,width, length);
		
		img = new Image(this.getClass().getResourceAsStream("water.png"));	
	}
	
	public void update() {
		gc.drawImage(img,x,y);	//draws image
	}
	
	public void setStrategy(StrategyInterface strategy) {
		//this.strat = strategy;
	}
	
	public void execute() {
		this.strat.execute(this, 0);	//executes strategy
	}
	
	public void setY(Double y) {
		this.y = y;
	}
	
	public double getY() {
		return y;
	}
	
	public void updateR() {
		r.setX(x);		//updates rectangle
		r.setY(y);
	}
	
	public Rectangle getR() {
		return r;
	}

}
