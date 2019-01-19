package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Station3Auto extends CommandGroup {

	public Station3Auto(String position, int station) {

		if (position.charAt(1) == 'R') {
			// Switch
			 addSequential(new ClawUp(3));
			 addSequential(new holdLift(15));
			 addParallel((new DriveForwardDistance(-0.6, 120)));
			 addSequential(new releaseCubeTime(1));
			 

		} else if (position.charAt(0) == 'R') {
			// Scale
			addSequential(new DriveForwardDistance(-0.6, 149));
			addSequential(new Turn(true, 88));

		} else if (position.charAt(1) == 'L') {
			// Scale
			addSequential(new DriveForwardDistance(-0.6, 273.75));
			addSequential(new Turn(false, 88));
			addSequential(new ClawUp(1));
		}
	}
}
