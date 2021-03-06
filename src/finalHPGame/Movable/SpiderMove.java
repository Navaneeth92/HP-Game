package finalHPGame.Movable;

import finalHPGame.CharList;
import finalHPGame.Characters.Enemy;
import finalHPGame.Location.Location;

public class SpiderMove implements Movable {

	private int timer;
	private boolean setLocation;
	/**Where the spider should move to*/
	private Location target;
	private Location playablePreviousLocation;

	public SpiderMove(){
		timer =0;
		setLocation = false;
	}

	/*
	 * THE GOAL: To move the spider in a certain direction where the one of the spider's coordinates
	 * 			 and one of the playable coordinates are equal. Then, make the spider shoot.
	 * Find the x and y of the target.
	 * Find the which way to move, either the x or the y
	 * 		Ex. The target is at (90,100) and this Spider (0,0)
	 * 			Boolean setLocation = false;
	 * 			1. Make a location (90,0) and check if it works, Go to step 3. Else step 2.
	 * 			2. Make a location (0,100) and check if it works, Go to step 3.
	 * 			3. Set fired = true; move to Location that works quickly.
	 * 			4. face or get the direction of target for where to shoot the bullet
	 * 			5. System.out.println("hit") setLocation = false
	 * 				
	 * */

	public void moveCharacter(CharList list, Enemy self, int delta) {
		setTargetLocation(list.getMainCharacter().getLocation(),self);
		move(delta, self);
	}


	//Step 1 and 2
	public void setTargetLocation(Location mainCharLoc, Enemy self){
		if(mainCharLoc.getBounds().inBounds(mainCharLoc.getX(), self.getPositionY())){
			target = new Location(mainCharLoc.getX(), self.getPositionY(),mainCharLoc.getLevel());
			playablePreviousLocation = mainCharLoc.getCopyOfLocation();
			setLocation = true;
		}
		else if(mainCharLoc.getBounds().inBounds(self.getPositionX(), mainCharLoc.getY())){
			target = new Location(self.getPositionX(), mainCharLoc.getY(), mainCharLoc.getLevel());
			setLocation = true;
			playablePreviousLocation = mainCharLoc.getCopyOfLocation();
		}
	}

	/*Step 3.
	 * Move towards Location target
	 * and if with then radius of 5 in the target, set the self.location = to target
	 */
	/**Move the self towards Location target
	 * @param delta - move it based on time*/
	public void move(int delta, Enemy self){
		timer+=delta;
		if(timer>500){
			timer=0;
			if(self.getPositionX()!=target.getX()){
				moveX(self);
			}
			else if(self.getPositionY()!=target.getY()){
				moveY(self);
			}
			if(self.getLocation().equals(target)){
				int direction = self.getLocation().directionOf(playablePreviousLocation);
				System.out.println("Shoot");
				setLocation = false;
				target =null;
			}
		}
	}
	public void moveX(Enemy self){
		if(Math.abs(self.getPositionX()-target.getX())>5){
			if(target.getX()>self.getPositionX()){
				self.addPositionX(10);
			}
			else{
				self.addPositionX(-10);
			}
		}
		else{
			self.getLocation().replaceX(target.getX());
		}
	}
	
	public void moveY(Enemy self){
		if(Math.abs(self.getPositionY()-target.getY())>5){
			if(target.getY()>self.getPositionY()){
				self.addPositionY(10);
			}
			else{
				self.addPositionY(-10);
			}
		}
		else{
			self.getLocation().replaceY(target.getY());
		}
	}
}
