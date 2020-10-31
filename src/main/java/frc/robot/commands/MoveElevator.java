/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveElevator extends Command {
  private double power;

  public MoveElevator(double power) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.power = power;
    requires(Robot.m_elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //setting motor to break mode
    System.out.println("Elevator initialize");
    //Robot.m_elevator.enableMotors(true);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Elevator execute");
    Robot.m_elevator.move(power);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //setting motor to coast mode
    Robot.m_elevator.move(0);
    //Robot.m_elevator.enableMotors(false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //setting motor to coast mode
    Robot.m_elevator.move(0);
    //Robot.m_elevator.enableMotors(false);
  }
}