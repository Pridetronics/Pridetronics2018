package org.usfirst.frc3853.Pridetronics2018.commands;

import org.usfirst.frc3853.Pridetronics2018.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwitchScoring extends CommandGroup {

	public SwitchScoring() {
		String fms = DriverStation.getInstance().getGameSpecificMessage();
		double station = (int) Math.round(SmartDashboard.getNumber("FieldPosition", 1));
		SmartDashboard.putNumber("FieldPositionSeen", station);

		if (station < 1) {
			station = 1;
		} else if (station > 3) {
			station = 3;
		}
		
		// System.out.println("SwitchScoring");
		if (fms.charAt(0) == 'L' && station == 1) {
			//System.out.println("SwitchScoring1");
			//addSequential(new pistonOpen());
			addParallel(new RunLift(), 6.0);
			//addSequential(new DriveForwardDistance(-0.6, 97.0)); // Move 100 inches
			//addSequential(new DriveForwardDistance(0.6, 0.70)); // Stop
			addSequential(new Switch(true));
			
		} else if (fms.charAt(0) == 'R' && station == 1) {
			addSequential(new DriveForwardDistance(-0.6, 130));
		}
	}
}