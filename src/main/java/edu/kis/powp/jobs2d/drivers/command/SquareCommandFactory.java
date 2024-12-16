package edu.kis.powp.jobs2d.drivers.command;

import java.util.LinkedList;
import java.util.List;

public class SquareCommandFactory {
    public static DriverCommand createCommand() {
        List<DriverCommand> commands = new LinkedList<>();
        commands.add(new SetPositionCommand(100,100));
        commands.add(new OperateToCommand(100,-100));
        commands.add(new OperateToCommand(-100,-100));
        commands.add(new OperateToCommand(-100,100));
        commands.add(new OperateToCommand(100,100));
        return new ComplexCommand(commands);
    }
}
