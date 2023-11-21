package will.EduGame;

public class Strategy implements StrategyInterface {
		
	public void execute(GameObject gObject, double behaviour) {
		
		if (gObject instanceof Bug) {
		
			double y = gObject.getY() + 1;
			
			if (y==300 && gObject.getWaited()!=0) {
				gObject.lowerWaited();
				y--;
			}
			gObject.setY(y);
		
			if (behaviour < 10) {
			
				double x = gObject.getX() + (behaviour/3);	
				gObject.setX(x);
			
			}								//dictates the side from which bugs emerge
											//and the rate of their change in x
			else {
			
				double x = gObject.getX() - (behaviour/3);			
				gObject.setX(x);
			}
		}
		
		else if (gObject instanceof Beam) {
			
			double y = gObject.getY();
			y++;
			
			double x = gObject.getX();
			behaviour++;
			if (behaviour <= 10) {
				
				x -= (behaviour/10); 		//uses the randomly rolled behaviour to determine
											//the angle upon which the beam descends				
			}
			else {
				behaviour -=10;
				x+= (behaviour/10);
				
			}
			gObject.setX(x);
			gObject.setY(y);
		}
		
		else if (gObject instanceof Droplet) {
			double y = gObject.getY();
			y+=2;
			gObject.setY(y);		//droplet descends straight down
		}
		
	}
}
