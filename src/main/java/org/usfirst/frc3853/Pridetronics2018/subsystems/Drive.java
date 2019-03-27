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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
  private final SpeedController leftDriveMotor = RobotMap.leftDriveMotorLead;
  private final SpeedController rightDriveMotor = RobotMap.rightDriveMotorLead;
  public final DifferentialDrive robotDrive = RobotMap.driverobotDrive;
  private final Encoder leftDriveEncoder = RobotMap.driveleftDriveEncoder;
  private final Encoder rightDriveEncoder = RobotMap.driverightDriveEncoder;

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  private Joystick gamepad;
  private Joystick leftJoy;
  private Joystick rightJoy;

  private int driveState = 0;

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

  public void setJoystick(Joystick newGamepad, Joystick newLeftJoy, Joystick newRightJoy) {
    gamepad = newGamepad;
    System.out.println("Gamepad");
    leftJoy = newLeftJoy;
    System.out.println("Left Joy");
    rightJoy = newRightJoy;
    System.out.println("Right Joy");
    driveState = 0;
    SmartDashboard.putBoolean("DM", true);
  }

  public void changeMode() {

    if (driveState == 0) {
      driveState = 1;
      SmartDashboard.putString("Drive Mode", "Gamepad Tank");
    } else if (driveState == 1) {
      driveState = 2;
      SmartDashboard.putString("Drive Mode", "Joystick Arcade");
    } else {
      driveState = 0;
      SmartDashboard.putString("Drive Mode", "Joystick Tank");
    }

  }

  @Override
  public void periodic() {
    // Put code here to be run every loop

  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void doTeleop() {

    // stick = Robot.oi.getgamepad();
    if (driveState == 0) {
      System.out.println("Drive State = 0");
      double rightValue;
      double leftValue;
      rightValue = gamepad.getRawAxis(5);
      leftValue = gamepad.getRawAxis(1);

      // rightValue = driveSquare(rightValue, .5);
      // leftValue = driveSquare(leftValue, .5);

      // rightValue = rightRamp.applyAsDouble(rightValue);
      // leftValue = leftRamp.applyAsDouble(leftValue);

      robotDrive.tankDrive(leftValue, rightValue);
    } else if (driveState == 1) {
      System.out.println("Drive State = 1");
      robotDrive.arcadeDrive(leftJoy.getY(), leftJoy.getX(), true);
    } else {
      System.out.println("Drive State = 2");
      robotDrive.tankDrive(rightJoy.getY(), rightJoy.getX(), true);
    }
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
