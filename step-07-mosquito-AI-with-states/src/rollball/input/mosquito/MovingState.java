package rollball.input.mosquito;

import rollball.input.InputController;
import rollball.model.GameObject;

public class MovingState extends AbstractState {

	private static final long DECISION_PERSISTANCE_TIME = 500;
	private long startMovingAt;

	public MovingState(MosquitoAIInputComponent context) {
		super(context);
		startMovingAt = System.currentTimeMillis();
	}
	
	public void handleUpdate(GameObject ball, InputController ctrl) {
		if (isTimeToChoose()) {
			this.getContext().changeState(new ChoosingState(this.getContext()));
		}
	}

	private boolean isTimeToChoose(){
		return System.currentTimeMillis() - startMovingAt > DECISION_PERSISTANCE_TIME;
	}
	
}
