package backend.commands;

import backend.BackendController;
import backend.Command;
import backend.parser.Input;

public class LessThanCommand extends Command {

	public LessThanCommand(Input in, BackendController controller) {
		super(in, controller, 2);
	}

	@Override
	public double execute() {
		return getArgs().get(0).getValue() < getArgs().get(1).getValue() ? 1 : 0;
	}

}
