package finalHPGame.States;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Instructions extends BasicGameState{


	Image ready;
	Image bathroom;
	int posX;
	int posY;

	public Instructions(int state){
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		bathroom= new Image("res/bathroom.jpg");
		ready = new Image("res/playNow.png");


	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		bathroom.draw(0,0,1050,800);
		g.drawString("Instructions:", 100, 50);
		ready.draw(750,600);
		g.drawString("x "+ posX+ "  y"+ posY,50,200);


	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		posX = Mouse.getX();
		posY = Mouse.getY();

		//play now button
		if((posX>750 && posX<953)&&(posY>155 && posY<195)){
			if(Mouse.isButtonDown(0)){
				System.out.println("clicked");
				sbg.getState(1).init(gc, sbg);
				sbg.enterState(1);
			}
		}
	}

	public int getID(){
		return 100;
	}

}
