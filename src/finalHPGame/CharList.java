package finalHPGame;

import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import finalHPGame.Characters.Character;
import finalHPGame.Characters.Enemy;
import finalHPGame.Characters.Magician;

/**Contains the Characters in the game*/
public class CharList {
	/**Contains the Characters*/
	ArrayList<Character> characters;

	/**The Character in the list is based on the level*/
	public CharList(int level) throws SlickException{

		characters = new ArrayList<Character>();



		//add the characters we would have in level one.
		if(level==1){

			/*The first character is always the playable character
			  in this level it is Harry*/

			//characters.add(new Magician(200,300,"hp",level));
			characters.add(new Magician(400,300,"hp",level));
			characters.add(new Enemy(300,400,"d",level));

			for(int x = 1; x<10; x++){
				// to make sure the objects don't 
				//have the same x and y coordinates to begin with.
				float randx = (float)Math.random()*200;
				float randy = (float)Math.random()*300;
				characters.add(new Enemy(250+randx,300+randy,"snake",level));
			}
		}
		else if(level==2){
			characters.add(new Magician(200,300,"ron",level));
		}
	}

	/**Draws every character in the list*/
	public void drawEveryone(){
		for(Character c: characters){
			c.draw();
		}
	}

	/**Prints every character in the list*/
	public void printEveryone(){
		for(Character c: characters){
			System.out.println(c);
		}
	}

	/**Gets the list of characters*/
	public ArrayList<Character> getCharacterList(){
		return characters;
	}

	/**gets the main character in the list*/
	public Magician getMainCharacter(){
		return (Magician) characters.get(0);
	}

	/**The enemies will be removed if considered "killed"*/
	/*Killed = If the user is pressing F and the enemy intersects with
	the circle spell.*/
	public void killEnemies(Shape spellBound, boolean isUsing){
		if(isUsing){
			//Get all the enemies in the list
			for(int x = 0; x<characters.size();x++){
				if(characters.get(x) instanceof Enemy){
					//if the enemy intersects, then remove it.
					if(spellBound.intersects(characters.get(x).getPersonalSpace())){
						characters.remove(x);
						--x;
					}
				}
			}
		}
	}


	/**Calls the move method by all Enemies
	 * @param delta - how long the main character has moved
	 */
	public void moveEnemies(int delta){
		for(Character c: characters){
			if(c instanceof Enemy){
				((Enemy) c).moveToward(this.getMainCharacter());

				if( ((Enemy) c).getPersonalSpace().intersects(this.getMainCharacter().getPersonalSpace())){
					getMainCharacter().decreaseHealth(delta);
				}
			}
		}
	}
}

