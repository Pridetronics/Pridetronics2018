package org.usfirst.frc3853.Pridetronics2018.commands;

import org.usfirst.frc3853.Pridetronics2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunLift extends Command {

    public RunLift() {
    	System.out.println("Runlift");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	liftTime = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    Robot.lift.up();
    }
   

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    private double liftTime;
	static final private double targetTime = 1.1;
	static final private double speedHold = 0.3;
	static final private double speedUp = 1;
	private void manageLift() {
		
		if(liftTime < targetTime) {
			liftTime += 20;
			Robot.lift.upSpeed(speedUp);
		}else {
			Robot.lift.upSpeed(speedHold);
		}
		
	}
}
