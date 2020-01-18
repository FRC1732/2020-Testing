/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.util.MotorUtil;

/**
 * Add your docs here.
 */
public class DriveMotor_1 extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final TalonSRX Motor_1 = MotorUtil.createTalon(RobotMap.TALON_CAN_1, false);

  public void forward_100() {
    Motor_1.set(ControlMode.PercentOutput, 100);
  }

  public void forward_75() {
    Motor_1.set(ControlMode.PercentOutput, 75);
  }

  public void forward_50() {
    Motor_1.set(ControlMode.PercentOutput, 50);
  }

  public void forward_25() {
    Motor_1.set(ControlMode.PercentOutput, 25);
  }

  public void stop()
  {
    Motor_1.set(ControlMode.PercentOutput, 0);
  }

  public void reverse_25() {
    Motor_1.set(ControlMode.PercentOutput, -25);
  }
  
  public void reverse_50() {
    Motor_1.set(ControlMode.PercentOutput, -50);
  }
  
  public void reverse_75() {
    Motor_1.set(ControlMode.PercentOutput, -75);
  }
    
  public void reverse_100() {
    Motor_1.set(ControlMode.PercentOutput, -100);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
