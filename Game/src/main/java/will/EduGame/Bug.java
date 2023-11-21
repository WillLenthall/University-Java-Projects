package will.EduGame;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Bug extends GameObject {
	
	protected Image img;
	private double x, y;
	protected GraphicsContext gc;
	protected Rectangle r;
	protected double width = 56;
	protected double length = 42;
	Random random = new Random();
	private double behaviour;
	private StrategyInterface strat;
	private int waited = 20;	//causes the bug to briefly stop falling at flower height
	
	public Bug(GraphicsContext gc, double x, double y, Strategy strategy) {
		super(gc, x, y);
		this.strat = strategy;
		this.behaviour = random.nextInt(20);
		img = new Image(this.getClass().getResourceAsStream("bug.png"));
		
		if (behaviour < 10) {
			
		this.x = 0;
		this.y = y + (behaviour*5); // adds some randomness to starting location
		}
		
		else {				
		this.x = 940;
		this.y = y + (behaviour*5); // adds some randomness to starting location
		}
		this.gc = gc;
		r = new Rectangle(x,y,width, length);
		
			
		
	}
	
	public void update() {
		gc.drawImage(img,x,y);		//draws object
	}
	
	public void execute() {
		this.strat.execute(this, behaviour);		//executes behaviour according to strategy
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
	
	public void lowerWaited() {
		waited--;				
	}
	
	public int getWaited() {
		return waited;
	}
	
	public void updateR() {
		r.setX(x);				//updates position of rectangle
		r.setY(y);
	}
	
	public Rectangle getR() {
		return r;
	}
}
