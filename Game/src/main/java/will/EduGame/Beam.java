package will.EduGame;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Beam extends GameObject {
	
	protected Image img;
	protected double x, y;
	protected GraphicsContext gc;
	protected Rectangle r;
	private StrategyInterface strat;
	private double behaviour;
	protected double width = 9;
	protected double length = 36;
	
	public Beam(GraphicsContext gc, double x, double y, Strategy strategy) {
		super(gc, x, y);
		Random random = new Random();
		behaviour = random.nextInt(20);
		this.x = x;
		this.y = y;
		this.gc = gc;
		r = new Rectangle(x,y,width, length);
		this.strat = strategy;
		img = new Image(this.getClass().getResourceAsStream("beam.png"));	
		
	}
	
	public void update() {
		gc.drawImage(img,x,y);		//Draws beam
	}
	
	
	public void execute() {
		this.strat.execute(this, behaviour);	//executes behaviour according to strategy
	}
	
	public void setX(Double x) {
		this.x = x;
	}
	
	public void setY(Double y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void updateR() {
		r.setX(x);			//updates position of rectangle
		r.setY(y);
	}
	
	public Rectangle getR() {
		return r;
	}
	
}
