package org.usfirst.frc3853.Pridetronics2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveToCenterSwitch extends CommandGroup {

  public MoveToCenterSwitch(boolean dir) {

    addSequential(new DriveForwardDistance(-0.6, 30));
    addSequential(new TurnEncoder(dir, 7));
    if (dir == true) {
      addSequential(new DriveForwardDistance(-0.6, 43.5));
    } else {
      addSequential(new DriveForwardDistance(-0.6, 33.5));
    }
    addSequential(new TurnEncoder(!dir, 7));
    addSequential(new DriveForwardDistance(-0.6, 63));
    addSequential(new releaseCubeTime(1));

  }
}
