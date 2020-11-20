/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class Encoder extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private double power;
  private double velocity;
  private static double distance;

  private double targetDistance;
  private double timeNeeded;
  private Timer timer = new Timer();
  
  private double k_force = 40; // NOTE: determine w/ exp done w/ 0.5 power--assuming constant for all powers

  public Encoder(double power){
      this.power = power;
      velocity = power/k_force;
  }

  public Encoder(double power, double targetDistance){
    this.power = power;
    this.targetDistance = targetDistance;
    velocity = power/k_force;
    timeNeeded = velocity/targetDistance;
  }

  public void updateDistance(){
     // 0.02 because updateDistance() will be called in command execute() 
     // which is called by scheduler every 20ms
      distance += 0.02 * velocity; 
  }

  public double getDistance(){
      System.out.println(distance);
      return distance;
  }

  public void moveToTargetDistance(){
    timer.reset();
    timer.start();

    while(timer.get() < timeNeeded){
      Robot.m_drivetrain.tankDrive(power, power);
    }
    Robot.m_drivetrain.tankDrive(0, 0);

    timer.stop();
  }

  public void setPower(double power){
    this.power = power;
  }

  
 
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
