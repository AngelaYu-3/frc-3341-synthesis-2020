/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

 // private PWMTalonSRX elevator = new PWMTalonSRX(RobotMap.elevatorPort);
  private PWMTalonSRX elevator = new PWMTalonSRX(2);

  public Elevator(){
    //enableMotors(false); 
  }

  public void move(double power){
    elevator.set(power);
  }

  /*public void enableMotors(boolean on){
    NeutralMode mode;
    if(on){
      mode = NeutralMode.Brake;
    }
    else{
      mode = NeutralMode.Coast;
    }

    elevator.setNeutralMode(mode);
  }*/

  /*public void periodic(){
      boolean downElev = Robot.m_oi.getxBox().getRawButton(3);
      boolean upElev = Robot.m_oi.getxBox().getRawButton(4);

      if(downElev){
        move(0.5);
      }
      
      if(upElev){
        move(-0.5);
      }
  }*/

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
