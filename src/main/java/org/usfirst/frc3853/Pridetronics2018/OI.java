// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3853.Pridetronics2018;

import org.usfirst.frc3853.Pridetronics2018.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc3853.Pridetronics2018.subsystems.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  public JoystickButton liftRetract;
  public JoystickButton liftExtend;
  public JoystickButton cubeExport;
  public JoystickButton cubeImport;
  public JoystickButton changeDriveMode;

  public Joystick gamepad1;
  public Joystick rightJoy;
  public Joystick leftJoy;

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  public JoystickButton pistonOpen;
  public JoystickButton pistonClose;
  public JoystickButton TurnDegrees;
  public JoystickButton hookLower;
  public JoystickButton hookRaise;
  public JoystickButton hookBrakeOff;
  public JoystickButton hookBrakeOn;
  public JoystickButton forward;
  public JoystickButton buttonteleop;

  public OI() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    // Port 0 SECONDARY
    gamepad1 = new Joystick(1);
    rightJoy = new Joystick(2); // Port 1 SECONDARY
    leftJoy = new Joystick(0);
    // Claw Commands
    forward = new JoystickButton(gamepad1, 2);
    forward.whenPressed(new DriveForwardDistance(-.6, -.6));

    cubeImport = new JoystickButton(gamepad1, 6);
    cubeImport.whileHeld(new loadCube());

    cubeExport = new JoystickButton(gamepad1, 5);
    cubeExport.whileHeld(new releaseCube());

    liftExtend = new JoystickButton(leftJoy, 6);
    liftExtend.whileHeld(new liftUp());

    liftRetract = new JoystickButton(leftJoy, 5);
    liftRetract.whileHeld(new liftDown());

    // Pneumatics Commands

    pistonClose = new JoystickButton(gamepad1, 3);
    pistonClose.whileHeld(new pistonOpen());

    pistonOpen = new JoystickButton(gamepad1, 1);
    pistonOpen.whileHeld(new pistonClose());

    // Climb Commands

    hookRaise = new JoystickButton(leftJoy, 2);
    hookRaise.whileHeld(new hookRaise());

    hookLower = new JoystickButton(leftJoy, 1);
    hookLower.whileHeld(new hookLower());

    hookBrakeOff = new JoystickButton(leftJoy, 3);
    hookBrakeOff.whileHeld(new hookBrakeOff());

    hookBrakeOn = new JoystickButton(leftJoy, 4);
    hookBrakeOn.whileHeld(new hookBrakeOn());

    changeDriveMode = new JoystickButton(gamepad1, 10);
    changeDriveMode.whenPressed(new SwitchDriveModes());

    // Autonomous Commands

    // TurnDegrees = new JoystickButton(leftJoy, 9);
    // TurnDegrees.whenPressed(new TurnDegrees(true, 90));

    // SMART DASHBOARD SPAM!
    // SmartDashboard Buttonss
    // SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    // SmartDashboard.putData("ClawUp", new ClawUp(1));
    // SmartDashboard.putData("Clawup1", new ClawUp(2));
    // SmartDashboard.putData("DriveForwardDistance", new
    // DriveForwardDistance(-.6, 200));
    SmartDashboard.putData("Turn", new TurnEncoder(false, 9));
    SmartDashboard.putData("DriveForward", new DriveForwardDistance(-.6, 300));
    // SmartDashboard.putData("TurnEncoder", new TurnEncoder(true, 7));
    // SmartDashboard.putData("Turn", new Turn(true, 90));
    // driveForwardDistance(0.6, 12));
    // SmartDashboard.putData("driveTeleop", new driveTeleop());
    // SmartDashboard.putData("loadCube", new loadCube());
    // SmartDashboard.putData("releaseCube", new releaseCube());
    // SmartDashboard.putData("liftUp", new liftUp());
    // SmartDashboard.putData("liftDown", new liftDown());
    // SMART DASHBOARD SPAM!

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
  }

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
  public Joystick getleftJoy() {
    return leftJoy;
  }

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
  public Joystick getgamepad1() {
    return gamepad1;
  }
}
