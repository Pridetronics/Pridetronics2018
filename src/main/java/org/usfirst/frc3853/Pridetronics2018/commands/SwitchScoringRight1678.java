package org.usfirst.frc3853.Pridetronics2018.commands;

import org.usfirst.frc3853.Pridetronics2018.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwitchScoringRight1678 extends CommandGroup {

	public SwitchScoringRight1678() {
		String fms = DriverStation.getInstance().getGameSpecificMessage();
		addSequential(new WaitShort(10.0));
		// System.out.println("SwitchScoring");
		if (fms.charAt(0) == 'R') {
			//System.out.println("SwitchScoring1");
			//addSequential(new pistonOpen());
			
			addParallel(new RunLift(), 6.0);
			//addSequential(new DriveForwardDistance(-0.6, 97.0)); // Move 100 inches
			//addSequential(new DriveForwardDistance(0.6, 0.70)); // Stop
			addSequential(new SwitchRight1678(true));
			
		} else {
			addSequential(new DriveForwardDistance(-0.6, 101));
		}
	}
}