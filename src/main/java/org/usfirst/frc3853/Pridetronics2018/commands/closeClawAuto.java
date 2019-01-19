package org.usfirst.frc3853.Pridetronics2018.commands;

import org.usfirst.frc3853.Pridetronics2018.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class closeClawAuto extends InstantCommand {
  
  public void Initialize() {
    
    Robot.pneumatics.pneuClose();
    
    
  }

}
