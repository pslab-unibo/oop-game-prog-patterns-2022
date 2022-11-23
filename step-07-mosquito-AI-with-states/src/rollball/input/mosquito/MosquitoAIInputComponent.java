package rollball.input.mosquito;

import rollball.input.InputComponent;
import rollball.input.InputController;
import rollball.model.*;

public class MosquitoAIInputComponent implements InputComponent {
	
	private AbstractState currentState;
	
	public MosquitoAIInputComponent(){
		currentState = new ChoosingState(this);
	}
	
	public void update(GameObject ball, InputController ctrl){
		currentState.handleUpdate(ball, ctrl);		
	}
	
	public void changeState(AbstractState newState) {
		currentState = newState;
	}

}
