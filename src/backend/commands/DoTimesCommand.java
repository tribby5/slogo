package backend.commands;

import java.util.List;

import backend.BackendController;
import backend.Command;
import backend.Variable;
import backend.parser.Input;

public class DoTimesCommand extends Command {

	public DoTimesCommand(Input in, BackendController controller) {
		super(in, controller, 2);
	}

	@Override
	public double execute() {
		int limit = (int) getChildren().get(0).getChildren().get(1).evaluate().getValue();
		int i = 1;
		double ret = 0;
		String name = "";
		while (i <= limit) {
			Variable counter = getChildren().get(0).getChildren().get(0).evaluate();
			name = counter.getKey();
			Variable set = new Variable(name, i);
			getBackendController().setVariable(set);
			List<Variable> args = getArgs();
			ret = args.get(1).getValue();
			i++;
		}
		getBackendController().getParser().getVariableTable().removeVariable(new Variable(name, i));
		return ret;
	}

}
