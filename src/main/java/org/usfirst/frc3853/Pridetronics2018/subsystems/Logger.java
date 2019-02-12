/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc3853.Pridetronics2018.subsystems;

import org.usfirst.frc3853.Pridetronics2018.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;

/**
 * Add your docs here.
 */
public class Logger extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static double TimeStamp;
  public static double ModifiedTimeStamp;
  PowerDistributionPanel pdp = new PowerDistributionPanel();

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }

  public void sendVoltage() {
    double voltage = pdp.getVoltage();
    SmartDashboard.putNumber("Voltage of the Robot", voltage);
  }

  public void sendCurrent() {
    double current0 = pdp.getCurrent(0);
    double current1 = pdp.getCurrent(1);
    double current2 = pdp.getCurrent(2);
    double current3 = pdp.getCurrent(3);
    double current5 = pdp.getCurrent(5);
    double current7 = pdp.getCurrent(7);
    double current13 = pdp.getCurrent(13);
    double current15 = pdp.getCurrent(15);

    SmartDashboard.putNumber("Current0", current0);
    SmartDashboard.putNumber("Current1", current1);
    SmartDashboard.putNumber("Current2", current2);
    SmartDashboard.putNumber("Current3", current3);
    SmartDashboard.putNumber("Current5", current5);
    SmartDashboard.putNumber("Current7", current7);
    SmartDashboard.putNumber("Current13", current13);
    SmartDashboard.putNumber("Current15", current15);

  }

  public void sendTotalCurrent() {
    double totalcurrentofpdp = pdp.getTotalCurrent();
    SmartDashboard.putNumber("TotalCurrent", totalcurrentofpdp);
  }

  public static double sendFPGATimestamp() {
    TimeStamp = Timer.getFPGATimestamp();
    ModifiedTimeStamp = TimeStamp - Robot.DisabledTime;
    return ModifiedTimeStamp;
  }
}
