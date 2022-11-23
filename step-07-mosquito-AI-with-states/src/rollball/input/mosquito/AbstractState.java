package rollball.input.mosquito;

import rollball.input.InputController;
import rollball.model.GameObject;

public abstract class AbstractState {

	private MosquitoAIInputComponent context;

	public AbstractState(MosquitoAIInputComponent context) {
		this.context = context;
	}
	
	public abstract void handleUpdate(GameObject ball, InputController ctrl);


	protected MosquitoAIInputComponent getContext() {
		return context;
	}
}
