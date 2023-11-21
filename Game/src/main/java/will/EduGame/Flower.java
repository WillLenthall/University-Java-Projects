package will.EduGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Flower extends GameObject {
	
	protected Image img;
	protected double x, y;
	protected GraphicsContext gc;
	protected Rectangle r;
	protected double width = 70;
	protected double length = 143;
	protected int score = 0;

	public Flower(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		
		this.x = x;
		this.y = y;
		this.gc = gc;
		r = new Rectangle(x,y,width, length);
		
		img = new Image(this.getClass().getResourceAsStream("flower.png"));	
		
	}
	

	public void moveRight() {
		if (x<930) //prevents moving off screen
		x+=10;
		
	}

	public void moveLeft() {
		if (x>0) //prevents moving offscreen
		x-=10;
		
	}
	
	public void update() {
		gc.drawImage(img,x,y);		//draws image
	}
	
	public void updateR() {
		r.setX(x); //updates the position of the rectangle (y never changes)
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getX() {
		return x;
	}
	
	public Rectangle getR() {
		return r;
	}
	

}
