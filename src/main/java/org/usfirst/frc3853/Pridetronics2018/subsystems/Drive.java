// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3853.Pridetronics2018.subsystems;

import org.usfirst.frc3853.Pridetronics2018.RobotMap;
import org.usfirst.frc3853.Pridetronics2018.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3853.Pridetronics2018.OI;
import org.usfirst.frc3853.Pridetronics2018.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.SendableBase;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
//import edu.wpi.first.wpilibj.Spark;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

public class Drive extends Subsystem {

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  private final SpeedController leftDriveMotor = RobotMap.driveleftDriveMotor;
  private final SpeedController rightDriveMotor = RobotMap.driverightDriveMotor;
  public final DifferentialDrive robotDrive = RobotMap.driverobotDrive;
  private final Encoder leftDriveEncoder = RobotMap.driveleftDriveEncoder;
  private final Encoder rightDriveEncoder = RobotMap.driverightDriveEncoder;

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  private Joystick stick;

  private final double rampLimit = 1.0;
  
  private RampComponent leftRamp;
  
  private RampComponent rightRamp;
  @Override
  public void initDefaultCommand() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    setDefaultCommand(new driveTeleop());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
  leftRamp = new RampComponent(rampLimit);

  rightRamp = new RampComponent(rampLimit);
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
    // Put code here to be run every loop

  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void doTeleop(Joystick stick) {

    // stick = Robot.oi.getgamepad();

    double rightValue;
    double leftValue;
    rightValue = stick.getRawAxis(5);
    leftValue = stick.getRawAxis(1);

    rightValue = driveSquare(rightValue, .5);
    leftValue = driveSquare(leftValue, .5);
    
    rightValue = rightRamp.applyAsDouble(rightValue);
    leftValue = leftRamp.applyAsDouble(leftValue);

    robotDrive.tankDrive(leftValue, rightValue);
  }

  public double driveSquare(double input, double degree) {
    double a = .2;
    return (Math.pow(input, 3) + a * (degree * input)) / (a * degree + 1);
  }

  public void stop() {
    robotDrive.tankDrive(0, 0);
  }

  public void driveForward(double speed) {
    // speed is 0 stopped to 1 full speed
    speed = Math.abs(speed);
    if (speed > 1) {
      speed = 1;
    }
    robotDrive.tankDrive(-speed, -speed);
  }

  public Encoder getRightEncoder() {
    return rightDriveEncoder;
  }

  public Encoder getLeftEncoder() {
    return leftDriveEncoder;
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    // TODO Auto-generated method stub
    robotDrive.tankDrive(leftSpeed, rightSpeed);
  }

}
