package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CenterSwitchScoring extends CommandGroup {

	public CenterSwitchScoring() {

		String fms = DriverStation.getInstance().getGameSpecificMessage();
		double station = (int) Math.round(SmartDashboard.getNumber("FieldPosition", 1));
		SmartDashboard.putNumber("FieldPositionSeen", station);

		if (station < 1) {
			station = 1;
		} else if (station > 3) {
			station = 3;
		}
		station = 2;

		if (fms.charAt(0) == 'L' && station == 2) {

			addSequential(new pistonOpen());
			addParallel(new RunLift(), 10.0);
			addSequential(new MoveToCenterSwitch(true));

		} else if (fms.charAt(0) == 'R' && station == 2) {

			addSequential(new pistonOpen());
			addParallel(new RunLift(), 10.0);
			addSequential(new MoveToCenterSwitch(false));

		}

	}
}
