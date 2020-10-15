/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveTimed extends Command {
  private final Timer m_timer = new Timer();

  public DriveTimed() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_drivetrain);
    m_timer.reset();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(m_timer.get() < 10.0){
      System.out.println("forwards");
      Robot.m_drivetrain.tankDrive(0.3, 0.3);
    }
    /*else if(m_timer.get() < 15.0){
      System.out.println("turn");
      Robot.m_drivetrain.tankDrive(-0.3, 0.3);
    }*/
    else if(m_timer.get() < 15.0){
      System.out.println("backwards");
      Robot.m_drivetrain.tankDrive(-0.3, -0.3);
    }
    else if(m_timer.get() < 25.0){
      System.out.println("forwards");
      Robot.m_drivetrain.tankDrive(0.3, 0.3);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_drivetrain.tankDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
