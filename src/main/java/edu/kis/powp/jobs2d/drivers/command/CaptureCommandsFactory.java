package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CaptureCommandsFactory {
    public static DriverCommand createCommand(Consumer<Job2dDriver> fn) {
        List<DriverCommand> commands = new ArrayList<>();
        fn.accept(new Job2dDriver() {
            @Override
            public void setPosition(int i, int i1) {
                commands.add(new SetPositionCommand(i, i1));
            }

            @Override
            public void operateTo(int i, int i1) {
                commands.add(new OperateToCommand(i, i1));
            }
        });

        return new ComplexCommand(commands);
    }
}
