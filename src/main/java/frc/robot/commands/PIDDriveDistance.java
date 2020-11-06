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

public class PIDDriveDistance extends Command {
  private double distance;
  private double power;
  private double kP = 10; //proportional constant
  private double force = 0.05; //estimated value to convert power to velocity
  private Timer timer = new Timer();

  public PIDDriveDistance(double distance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.distance = distance; 
    timer.reset();
    power = distance * kP;
    requires(Robot.m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.start();
  }

  // Called repeatedly when this Command is scheduled to run ~1/20ms
  @Override
  protected void execute() {
      double velocity = power/force;
      double distTrav = velocity * timer.get();
      double error = distance - distTrav; 

      //error gets smaller as time goes on so power inputed to motors decreases too
      power = error * kP;
      Robot.m_drivetrain.tankDrive(power, power);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return power <= 0;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_drivetrain.tankDrive(0, 0);
    timer.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
