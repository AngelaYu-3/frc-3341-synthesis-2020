/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  //motor ports
  public static int leftDrivePort = 0;
  public static int rightDrivePort = 1;

  //joystick ports/axes
  public static int xboxPort = 0;
  public static int leftJoy = 1;
  public static int rightJoy = 5;
  public static int leftEncoderA = 0;
  public static int leftEncoderB = 1;
  public static int rightEncoderA = 2;
  public static int rightEncoderB = 3;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
