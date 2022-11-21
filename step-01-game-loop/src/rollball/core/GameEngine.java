package rollball.core;

import java.util.logging.*;

/**
 * Game engine skeleton.
 * 
 * @author aricci
 *
 */
public class GameEngine  {

	private long period = 20; /* 20 ms = 50 frames per sec */
	
	private Logger logger = Logger.getLogger("GameEngine");
	
	public GameEngine(){
	}
	
	public void mainLoop(){
		long previousCycleStartTime = System.currentTimeMillis();
		while(true){
			long currentCycleStartTime = System.currentTimeMillis();
			long elapsed = currentCycleStartTime - previousCycleStartTime;
			processInput();
			/* move on the game state of elapsed time */
			updateGame(elapsed);
			render();
			waitForNextFrame(currentCycleStartTime);
			previousCycleStartTime = currentCycleStartTime;
		}
	}

	/**
	 * Take a little nap to synch with the frame rate
	 * 
	 * @param current
	 */
	protected void waitForNextFrame(long cycleStartTime){
		long dt = System.currentTimeMillis() - cycleStartTime;
		if (dt < period){
			try {
				Thread.sleep(period - dt);
			} catch (Exception ex){}
		}
	}
	
	/**
	 * Processing the input of the game got in a cycle.
	 */
	protected void processInput(){
		logger.log(Level.INFO, "..process input..");
	}
	
	/**
	 * Update the state of the game, given the amount of time elapsed wrt previous cycle.
	 *  
	 * @param elapsed
	 */
	protected void updateGame(long elapsed){
		logger.log(Level.INFO, "..update game: elapsed " + elapsed);
	}
	
	/**
	 * Rendering of the game in a cycle.
	 */
	protected void render(){
		logger.log(Level.INFO, "..render..");
	}

}
