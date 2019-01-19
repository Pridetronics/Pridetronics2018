package org.usfirst.frc3853.Pridetronics2018.commands;

import org.usfirst.frc3853.Pridetronics2018.Robot;
import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwitchScoringRight extends CommandGroup {

	public SwitchScoringRight() {

	  String fms = DriverStation.getInstance().getGameSpecificMessage();
	  int station = DriverStation.getInstance().getLocation();

	    if (fms.charAt(1) == 'R' && station == 1) {
	      addSequential(new DriveForwardDistance(-.7, 305));
	      addSequential(new TurnEncoder(true, 8));
	      addSequential(new DriveForwardDistance(.7, 6));
	      addSequential(new RunScaleLift(), 4.7);
	      addSequential(new DriveForwardDistance(-.7, 6));
	      addSequential(new releaseCubeTime(1));
	      addSequential(new DriveForwardDistance(.7, 6));
	      SmartDashboard.putString("ScaleScoring", "itworks2");
	      //addSequential(new DriveForwardDistance(.6, 31.56));
	      //addSequential(new DriveForwardDistance(.6, 40.04));
	      //addSequential(new RunScaleLift());
	      //addSequential(new releaseCube());
	    } else if (fms.charAt(0) == 'R' && station == 1){
	      addParallel(new RunLift(), 6.0);
	      //addSequential(new DriveForwardDistance(-0.6, 97.0)); // Move 100 inches
	      //addSequential(new DriveForwardDistance(0.6, 0.70)); // Stop
	      addSequential(new SwitchRight(true));
	    } else {
	      addSequential(new DriveForwardDistance(-0.6, 97.0));
	    }
	}
}
