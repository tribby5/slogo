package commands;

import backend.BackendController;
import backend.Command;

public class LessThanCommand extends Command {

	public LessThanCommand(BackendController controller) {
		super(controller);
		setNumArgs(2);
	}

	@Override
	public double execute() {
		return getArgs().get(0).getValue() < getArgs().get(1).getValue() ? 1 : 0;
	}

}