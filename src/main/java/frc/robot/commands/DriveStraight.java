/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveStraight extends Command {
  private double motorPower;
  private double distance;

  public DriveStraight(double motorPower, double distance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.motorPower = motorPower;
    this.distance = distance;
    requires(Robot.m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("INIT");
    Robot.m_drivetrain.resetCounters();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.m_drivetrain.printDistance();
    System.out.println("EXECUTE");
    Robot.m_drivetrain.tankDrive(motorPower, motorPower);   
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    /*(if(Math.abs(Robot.m_drivetrain.returnDistance()) > distance){
      return true;
    }*/
    Robot.m_drivetrain.printDistance(); 
    Robot.m_drivetrain.printPeriod();
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
