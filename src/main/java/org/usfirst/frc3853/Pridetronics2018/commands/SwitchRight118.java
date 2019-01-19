package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SwitchRight118 extends CommandGroup {

	public SwitchRight118(boolean dir) {
		//addParallel(new RunLift(), 6.0);
		addSequential(new DriveForwardDistance(-.65, 112));
		//addSequential(new TurnEncoder(true, 7));
		//addSequential(new DriveForwardDistance(-.6, 14.56), 2);
		//addSequential(new releaseCubeTime(1));
		//addSequential(new DriveForwardDistance(0.6, 4.56));
		//addParallel(new RunLiftDown());
		//addSequential(new TurnEncoder(false, 12));
		//addSequential(new DriveForwardDistance(-0.65, 70));
		//addSequential(new TurnEncoder(true, 6));
		//addSequential(new DriveForwardDistance(-0.65, 36.06));
		//addSequential(new TurnEncoder(true, 7));
		//addParallel(new DriveForwardDistance(-.65, 10));
		//addSequential(new pistonClose(), 0.25);
		//addSequential(new loadCube(), 2.0);
		//addSequential(new pistonOpen(), 0.25);
	}
}