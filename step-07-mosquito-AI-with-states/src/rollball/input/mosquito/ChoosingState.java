package rollball.input.mosquito;

import java.util.Random;

import rollball.common.V2d;
import rollball.input.InputController;
import rollball.model.GameObject;

public class ChoosingState extends AbstractState {

	private Random rand;

	public ChoosingState(MosquitoAIInputComponent context) {
		super(context);
		rand = new Random(System.currentTimeMillis());
	}

	public void handleUpdate(GameObject ball, InputController ctrl) {
		int choice = rand.nextInt(4);
		if (choice == 0){
			double speed = ball.getCurrentVel().module();
			ball.setVel(new V2d(0,1).mul(speed));
		} else if (choice == 1){
			double speed = ball.getCurrentVel().module();
			ball.setVel(new V2d(0,-1).mul(speed));
		} else if (choice == 2){
			double speed = ball.getCurrentVel().module();
			ball.setVel(new V2d(-1,0).mul(speed));			
		} else {
			double speed = ball.getCurrentVel().module();
			ball.setVel(new V2d(1,0).mul(speed));			
		}		
		this.getContext().changeState(new MovingState(this.getContext()));
	}
}
