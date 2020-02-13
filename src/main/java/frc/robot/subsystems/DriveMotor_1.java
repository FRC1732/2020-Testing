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

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveMotor_1 extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private TalonSRX Motor_1 = new TalonSRX(RobotMap.TALON_CAN_3);
  private TalonSRX Motor_2 = new TalonSRX(RobotMap.TALON_CAN_4);

  private double motorSpeed = 0.0;

  public DriveMotor_1() {
    // Motor_1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    Motor_1.configFactoryDefault();
    Motor_2.configFactoryDefault();

    Motor_1.setInverted(false);
    Motor_1.config_kP(0, .12);
    Motor_1.config_kI(0, 0);
    Motor_1.config_kD(0, 0);
    Motor_1.config_kF(0, .0078);
    Motor_1.setNeutralMode(NeutralMode.Coast);

    Motor_2.setInverted(true);
    Motor_2.setNeutralMode(NeutralMode.Coast);
    Motor_2.follow(Motor_1);
  }

  public void printMotorVelocity() {
    System.out.println((Motor_1.getSelectedSensorVelocity()));
  }

  public double getMotorSpeed() {
    return motorSpeed;
  }

  public void increaseMotorSpeed(){
    motorSpeed += 0.01;
    motorSpeed = motorSpeed >= 1.00 ? 1 : motorSpeed;
    System.out.println("Motor ++ | " + motorSpeed);
    setCurrentMotorSpeed();
  }

  public void decreaseMotorSpeed(){
    motorSpeed -= 0.01;
    motorSpeed = motorSpeed <= -1.00 ? -1 : motorSpeed;
    System.out.println("Motor -- | " + motorSpeed);
    setCurrentMotorSpeed();
  }

  private void setCurrentMotorSpeed(){
    Motor_1.set(ControlMode.PercentOutput, motorSpeed);
  }

  public void forward_75() {
    motorSpeed = 0.75;
    System.out.println("Motor FORWARD SET | " + motorSpeed);
    setCurrentMotorSpeed();
  }

  public void forward_100() {
    motorSpeed = 1;
    System.out.println("Motor FORWARD SET | " + motorSpeed);
    setCurrentMotorSpeed();
  }

  public void forward_50() {
    motorSpeed = 0.5;
    System.out.println("Motor FORWARD SET | " + motorSpeed);
    setCurrentMotorSpeed();
  }

  public void forward_25() {
    motorSpeed = 0.25;
    System.out.println("Motor FORWARD SET | " + motorSpeed);
    setCurrentMotorSpeed();
  }

  // get sensor velocity returns ticks/100 milliseconds
  // multiplying by 600 => ticks/minute
  // 8192 is the number of ticks per revolution for the revRobotics through bore
  // encoder
  // dividing by 8192 => rpm
  public void maintainRPM() {
    Motor_1.set(ControlMode.Velocity, 86110);
  }

  public void stop() {
    motorSpeed = 0.0;
    System.out.println("Motor stopped!");
    setCurrentMotorSpeed();
  }

  public void reverse_25() {
    motorSpeed = -0.25;
    System.out.println("Motor REVERSE SET | " + motorSpeed);
    setCurrentMotorSpeed();
  }

  public void reverse_50() {
    motorSpeed = -0.50;
    System.out.println("Motor REVERSE SET | " + motorSpeed);
    setCurrentMotorSpeed();
  }

  public void reverse_75() {
    motorSpeed = -0.75;
    System.out.println("Motor REVERSE SET | " + motorSpeed);
    setCurrentMotorSpeed();
  }

  public void reverse_100() {
    motorSpeed = -1.0;
    System.out.println("Motor REVERSE SET | " + motorSpeed);
    setCurrentMotorSpeed();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
