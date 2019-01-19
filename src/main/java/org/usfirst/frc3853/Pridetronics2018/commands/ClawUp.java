package org.usfirst.frc3853.Pridetronics2018.commands;

import org.usfirst.frc3853.Pridetronics2018.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class ClawUp extends TimedCommand {

	public ClawUp(double timeout) {
		super(timeout);
		requires(Robot.lift);
		// TODO Auto-generated constructor stub
	}

	protected void initialize() {

	}

	protected void execute() {
		Robot.lift.up();

	}

	protected boolean isFinished() {

		return isTimedOut();

	}

	protected void end() {

	}

}
