/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Shooter extends PIDSubsystem {
  private TalonSRX Motor_1 = new TalonSRX(Constants.SHOOTER_CAN_ID_TALONSRX);
  private VictorSPX Motor_2 = new VictorSPX(Constants.SHOOTER_CAN_ID_VICTORSPX);

  private double motorSpeed = 0.0;

  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0, 0, 0));

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

  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return 0;
  }

  public void printMotorVelocity() {
    System.out.println((Motor_1.getSelectedSensorVelocity()));
  }

  public double getMotorSpeed() {
    return motorSpeed;
  }

  public void increaseMotorSpeed() {
    motorSpeed += 0.01;
    motorSpeed = motorSpeed >= 1.00 ? 1 : motorSpeed;
    System.out.println("Motor ++ | " + motorSpeed * 100);
    setCurrentMotorSpeed();
  }

  public void decreaseMotorSpeed() {
    motorSpeed -= 0.01;
    motorSpeed = motorSpeed <= -1.00 ? -1 : motorSpeed;
    System.out.println("Motor -- | " + motorSpeed * 100);
    setCurrentMotorSpeed();
  }

  public void setMotorSpeed(double speed)
  {
    motorSpeed = speed;
    System.out.println("Motor speed SET | " + motorSpeed * 100);
    setCurrentMotorSpeed();
  }

  private void setCurrentMotorSpeed() {
    Motor_1.set(ControlMode.PercentOutput, motorSpeed);
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
}
