/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.util.MotorUtil;

/**
 * Add your docs here.
 */
public class DriveMotor_1 extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private TalonSRX Motor_1 = MotorUtil.createTalon(RobotMap.TALON_CAN_30 , false);
  private VictorSPX Motor_2 = MotorUtil.createVictor(RobotMap.VICTOR_CAN_28, true);

  public DriveMotor_1(){
    //Motor_1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    Motor_1.config_kP(0, .12);
    Motor_1.config_kI(0, 0);
    Motor_1.config_kD(0, 0);
    Motor_1.config_kF(0, .0078);
    Motor_1.setNeutralMode(NeutralMode.Coast);
  
    Motor_2.setNeutralMode(NeutralMode.Coast);
    Motor_2.follow(Motor_1);
  }

  public double getMotorVelocity(){
    return(Motor_1.getSelectedSensorVelocity());
  }

  public void forward_100() {
    Motor_1.set(ControlMode.PercentOutput, 1);
    System.out.println(Motor_1.getSelectedSensorVelocity()*600/8192.0+" rpm");
  }

  public void forward_75() {
    Motor_1.set(ControlMode.PercentOutput, 0.75);
    System.out.println(Motor_1.getSelectedSensorVelocity()*600/8192.0+" rpm");
  }

  public void forward_50() {
    Motor_1.set(ControlMode.PercentOutput, 0.5);
    System.out.println(Motor_1.getSelectedSensorVelocity()*600/8192.0+" rpm");
  }

  public void forward_25() {
    Motor_1.set(ControlMode.PercentOutput, 0.25);
    System.out.println(Motor_1.getSelectedSensorVelocity()*600/8192.0+" rpm");
  }

  //get sensor velocity returns ticks/100 milliseconds
  //multiplying by 600 => ticks/minute
  //8192 is the number of ticks per revolution for the revRobotics through bore encoder
  //dividing by 8192 => rpm
  public void maintainRPM(){
    //Motor_1.set(ControlMode.Velocity,81920);
    Motor_1.set(ControlMode.Velocity, 81920);
    System.out.println(Motor_1.getSelectedSensorVelocity()*600/8192.0+" rpm1");
  }

  public void stop()
  {
    Motor_1.set(ControlMode.PercentOutput, 0);
  }

  public void reverse_25() {
    Motor_1.set(ControlMode.PercentOutput, -0.25);
  }
  
  public void reverse_50() {
    Motor_1.set(ControlMode.PercentOutput, -0.50);
  }
  
  public void reverse_75() {
    Motor_1.set(ControlMode.PercentOutput, -0.75);
  }
    
  public void reverse_100() {
    Motor_1.set(ControlMode.PercentOutput, -1);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
