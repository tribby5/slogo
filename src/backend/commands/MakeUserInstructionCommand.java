package backend.commands;

import java.util.ArrayList;
import java.util.List;

import backend.BackendController;
import backend.Command;
import backend.Variable;
import backend.parser.Expression;
import backend.parser.ListStartExpression;
import backend.parser.Input;

public class MakeUserInstructionCommand extends Command {
	private String name;
	private Input in;

	public MakeUserInstructionCommand(Input in1, BackendController controller) {
		super(in1, controller, 2);
		in = new Input(in1.getInput(), in1.getIndex(), in1.getBreakPoints());
		in.incrementIndex();
		name = in.get();
		in.incrementIndex();
		ListStartExpression expr = new ListStartExpression(in, controller);
		in.decrementByCount();
		in.decrementIndex();
		int numArgs = expr.getChildren().size();
		Command newCommand = new Command(in, controller);
		newCommand.setNumArgs(numArgs);
		getBackendController().getParser().getCommandTable().setCommand(newCommand);
		in1.incrementIndex();
	}

	@Override
	public double execute() {
		System.out.println("EXECUTING MAKE USER INSTRUCTION COMMAND");
		List<Variable> args = new ArrayList<Variable>();
		for (int i = 0; i < getChildren().get(0).getChildren().size(); i++) {
			Variable var = getChildren().get(0).getChildren().get(i).evaluate();
			System.out.println(getChildren().get(0).getChildren().get(i).getClass());
			args.add(var);
		}
		Expression commands = getChildren().get(1);
		UserCommand newCommand = new UserCommand(name, getBackendController(), in, args, commands);
		getBackendController().getParser().getCommandTable().setCommand(newCommand);
		return 0;
	}

}
