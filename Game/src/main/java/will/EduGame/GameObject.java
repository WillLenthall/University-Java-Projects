package will.EduGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class GameObject {
	
	protected Image img;
	protected double x;
	protected double y;
	protected GraphicsContext gc;
	protected double width, length;
	protected Rectangle r;

		
	public GameObject(GraphicsContext gc, double x, double y)	{
		this.gc=gc;
		this.x=x;
		this.y=y;
	}
		

	public void update()	{
		
		if(img!=null)
		gc.drawImage(img, x, y);//, width, length);
	}


	public void execute() {
	
		
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


	public int getWaited() {
	
		return 0;
	}


	public void lowerWaited() {
		// TODO Auto-generated method stub
		
	}
	
	public Rectangle getR() {
		return r;
	}


	public void updateR() {
		// TODO Auto-generated method stub
		
	}

	
}
