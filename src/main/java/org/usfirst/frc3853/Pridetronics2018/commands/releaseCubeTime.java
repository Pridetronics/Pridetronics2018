package org.usfirst.frc3853.Pridetronics2018.commands;

import org.usfirst.frc3853.Pridetronics2018.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class releaseCubeTime extends TimedCommand {

  public releaseCubeTime(double timeout) {
    super(timeout);
    requires(Robot.claw);
    }
    protected void initialize() {

    }

    protected void execute() {
      Robot.claw.release();

    }

    protected boolean isFinished() {

      return isTimedOut();

    }

    protected void end() {
       Robot.claw.stop();

    }

  }