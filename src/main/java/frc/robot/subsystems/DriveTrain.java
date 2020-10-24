/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/**
 * Add your docs here.
 * 
 * 
 */

public class DriveTrain<DutyCycleEncoder> extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private PWMTalonSRX left = new PWMTalonSRX(RobotMap.leftDrivePort), right = new PWMTalonSRX(RobotMap.rightDrivePort);
  private Encoder leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
  private Encoder rightEncoder = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
  //private Counter leftCount = new Counter(0);
  //private Counter rightCount = new Counter(1);

  public DriveTrain() {

    left.setInverted(true);
    /*leftCount.setUpSource(1);
    leftCount.setUpDownCounterMode();

    rightCount.setUpSource(1);
    rightCount.setUpDownCounterMode();

    leftCount.setDistancePerPulse(10);
    rightCount.setDistancePerPulse(10);*/

    
    leftEncoder.reset();
    rightEncoder.reset();
    leftEncoder.setDistancePerPulse(0.05);
    rightEncoder.setDistancePerPulse(0.05);
  }

  public void tankDrive(double lspeed, double rspeed) {
      
      // make controls not too sensitive
      if (lspeed < 0.05 && lspeed > -0.05){
        lspeed = 0;
      }
      if (rspeed < 0.05 && rspeed > -0.05){
        rspeed = 0;
      }

      left.set(lspeed);
      right.set(rspeed);
    }

  public double returnDistance(){
    double leftDistance = leftEncoder.getDistance();
    double rightDistance = rightEncoder.getDistance();
    //double leftDistance = leftCount.getDistance();
   // double rightDistance = rightCount.getDistance();
    return (leftDistance + rightDistance)/2;
  }

  public void resetCounters(){
    leftEncoder.reset();
    rightEncoder.reset();
    //leftCount.reset();
    //rightCount.reset();
  }

  public void printDistance(){
    System.out.println(returnDistance());
  }

  /*public void printPeriod(){
    System.out.println((leftCount.getPeriod() + rightCount.getPeriod())/2);
  }*/

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
    //System.out.println("driving");
    tankDrive(-Robot.m_oi.xBox.getRawAxis(RobotMap.leftJoy), -Robot.m_oi.xBox.getRawAxis(RobotMap.rightJoy));
  }
}
