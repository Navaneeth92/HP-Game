package finalHPGame.ShapeUpdater.HorcruxUpdater;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.ShapeUpdater;

public class CupUpdater implements ShapeUpdater {


	public void update(Rectangle s, int direction, Location myLoc) {
		 s.setBounds(new Rectangle(myLoc.getX()+33,myLoc.getY()+15,35,60));
	}

}
