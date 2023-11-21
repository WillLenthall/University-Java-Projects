package will.EduGame;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class Model {

	ArrayList<GameObject> objectList = new ArrayList<GameObject>();
	protected int score = 0;
	
	public Model() {
		
	}
	

	public void addObject(GameObject object) {
		objectList.add(object);
	}
	
	public void removeObject(GameObject object) {
		objectList.remove(object);
	}
	
	public void update() {
		for (GameObject object:objectList) {
			object.update();
			object.updateR();
		}
	}
	
	public void execute() {
		for (GameObject object:objectList) {
			object.execute();
		}
	}
	
	public void clearUp() {
		
		ArrayList<GameObject> temp = new ArrayList<GameObject>();
		for (GameObject object:objectList) {
			double y = object.getY();
			double x = object.getX();
			if (y > 500 || x > 1000 || x < 0) {
				temp.add(object);
			}
		}
		
		for (GameObject object:temp) {
			removeObject(object);
		}
	}
	
	public boolean checkCollision(Flower flower) { //checks for collision
		
		ArrayList<GameObject> temp = new ArrayList<GameObject>();

		for (GameObject object:objectList) {
			if (object.getY()>200) {
				Rectangle objR = object.getR();
			
				if (objR.intersects(flower.x,flower.y,flower.width,flower.length)) {
					
					if (object instanceof Bug) {
						return true;	//ends game if flower and bug intersect
					}
					
					else {
						this.score+=15;
						temp.add(object);	//adds points if flower intersects droplet/beam
						
					}
					
				}
			}
		}
		for (GameObject object:temp) {	//removes objects which intersect with flower
			removeObject(object);
		}
		return false;		//continues game as long as no bug has collided
		
	}

}
