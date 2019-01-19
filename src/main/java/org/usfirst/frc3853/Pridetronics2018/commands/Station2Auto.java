package org.usfirst.frc3853.Pridetronics2018.commands;

import org.usfirst.frc3853.Pridetronics2018.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Station2Auto extends CommandGroup {

  public Station2Auto() {
    
    addSequential(new DriveForwardDistance(-0.6, 90));
  }
}