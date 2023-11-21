package will.EduGame;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

public class Factory implements FactoryIF {
	GraphicsContext gc;
	Random random = new Random();
	
	
	@Override
	public GameObject createProduct(Strategy strategy) {
		
		int i = random.nextInt(3);		//randomises which game object will be built, probably should have done this in the controller instead
		
		if (i==0) {
			return new Bug(gc, 50, 50, strategy);
		}
		
		else if (i==1) {
			return new Beam(gc, 500, 80, strategy);

		}
		else if (i==2) {
			return new Droplet(gc, 150, 150, strategy);
		}
		else
		
		return null;
		
	}
	
	public Factory(GraphicsContext gc) {
		super();
		this.gc = gc;
	}

	
}
