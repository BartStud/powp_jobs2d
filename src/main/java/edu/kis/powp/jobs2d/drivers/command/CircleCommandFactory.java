package edu.kis.powp.jobs2d.drivers.command;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class CircleCommandFactory {
    public static DriverCommand createCommand() {
        List<DriverCommand> commands = new LinkedList<>();
        int xCenter = 0;
        int yCenter = 0;
        int radius = 100;
        int dAngle = 10;

        commands.add(new SetPositionCommand(xCenter,yCenter + radius));
        for (int theta = dAngle; theta < 360 + dAngle; theta += dAngle){
            double rad = (double) theta /180 * Math.PI;
            double x = xCenter + radius * sin(rad);
            double y = yCenter + radius * cos(rad);
            commands.add(new OperateToCommand((int) x, (int) y));
        }

        return new ComplexCommand(commands);
    }
}
