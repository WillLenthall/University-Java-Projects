package will.EduGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Sun extends GameObject {
	
	protected Image img;
	protected double x, y;
	protected GraphicsContext gc;
	protected Rectangle r;
	//protected double width = 70;
	//protected double length = 143;
	
	public Sun(GraphicsContext gc, double x, double y) {
		super(gc, x, y);
		
		this.x = x;
		this.y = y;
		this.gc = gc;
		r = new Rectangle(x,y,width, length);
		
		img = new Image(this.getClass().getResourceAsStream("sun.png"));	
		
	}
	
	public void update() {
		gc.drawImage(img,x,y);	//draws image
	}
	
}
