package finalHPGame.ShapeUpdater.HorcruxUpdater;

import org.newdawn.slick.geom.Rectangle;

import finalHPGame.Location.Location;
import finalHPGame.ShapeUpdater.ShapeUpdater;

public class JournalUpdater implements ShapeUpdater {

	public JournalUpdater() {
	}

	/***/
	public void update(Rectangle s, int direction, Location myLoc) {
	 s.setBounds(new Rectangle(myLoc.getX()+25,myLoc.getY()+15,35,60));
	}
}
