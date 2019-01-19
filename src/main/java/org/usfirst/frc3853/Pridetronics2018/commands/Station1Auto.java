package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Station1Auto extends CommandGroup {

	public Station1Auto(String position, int station) {
		
   if (position.charAt(0) == 'L')
		addSequential(new ClawUp(3));
		addSequential(new holdLift(15));
		addSequential(new DriveForwardDistance(-0.6, 149));
		addSequential(new TurnEncoder(false, 9));
		addSequential(new DriveForwardDistance(-0.6, 11));
		addSequential(new releaseCubeTime(1));
		addSequential(new TurnEncoder(true, 9));
		addParallel(new DriveForwardDistance(-0.6, 73));
		addSequential(new liftDown());
		addSequential(new TurnEncoder(false, 9));
		addSequential(new DriveForwardDistance(-0.6, 36.06));
		addSequential(new TurnEncoder(false, 9));
		addParallel(new DriveForwardDistance(-0.6, 15));
		addSequential(new loadCube());
		addSequential(new releaseCubeTime(1));

//	} else if (position.charAt(1) == 'R') {
		// Scale
		addSequential(new DriveForwardDistance(-0.6, 210));
		addSequential(new Turn(false, 88));
		addSequential(new ClawUp(1));

//	} else if (position.charAt(0) == 'R') {
		//Switch
		addSequential(new ClawUp(3));
		addSequential(new holdLift(15));
		addSequential(new DriveForwardDistance(-0.6, 222));
		addSequential(new TurnEncoder(false, 9));
		addSequential(new DriveForwardDistance(-0.6, 119.75));
		addSequential(new TurnEncoder(false, 9));
		addSequential(new DriveForwardDistance(-0.6, 7));
		addSequential(new releaseCubeTime(1));
		addSequential(new DriveForwardDistance(0.6, 13));
		addParallel(new DriveForwardDistance(-0.6, 13));
		addSequential(new loadCube());
		addSequential(new releaseCubeTime(1));


		}
	}
