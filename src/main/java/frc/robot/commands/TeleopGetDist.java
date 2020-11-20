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
import frc.robot.RobotMap;

public class TeleopGetDist extends Command {
  private Timer timer = new Timer();

  public TeleopGetDist() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_encoder);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double leftPow = Robot.m_oi.getxBox().getRawAxis(RobotMap.leftJoy);
    double rightPow = Robot.m_oi.getxBox().getRawAxis(RobotMap.rightJoy);
    double avgPow = (Math.abs(leftPow) + Math.abs(rightPow))/2; // not very accurate, not accounting for diff in distance during turns

    Robot.m_drivetrain.tankDrive(-leftPow, -rightPow);
    Robot.m_encoder.setPower(avgPow);
    Robot.m_encoder.updateDistance();

    if(timer.get() % 5 == 0){
      // print out total distance traveled every 5 seconds
      System.out.println("Total Distance Traveled: " + Robot.m_encoder.getDistance());
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
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
