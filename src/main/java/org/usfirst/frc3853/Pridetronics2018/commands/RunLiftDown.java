package org.usfirst.frc3853.Pridetronics2018.commands;

import org.usfirst.frc3853.Pridetronics2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class RunLiftDown extends Command {

	boolean isComplete = false;
	
	
    public RunLiftDown() {
    	System.out.println("Runliftdown");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	liftTimeDown = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	manageLift();
    }
   

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isComplete;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    private double liftTimeDown;
	static final private double targetTimeDown = 0.8;
	
	static final private double speedDown = -0.6;
	
	private void manageLift() {
		
		if(liftTimeDown < targetTimeDown) {
			liftTimeDown += 20;
			Robot.lift.upSpeed(speedDown);
			isComplete = false;
		}else if (liftTimeDown >= targetTimeDown){
			Robot.lift.stop();
			isComplete = true;
		}
	
	}
}