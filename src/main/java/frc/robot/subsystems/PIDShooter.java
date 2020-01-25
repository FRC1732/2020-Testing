/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.util.MotorUtil;

/**
 * Add your docs here.
 */
public class PIDShooter extends PIDSubsystem {
  private final TalonSRX shooterMaster = MotorUtil.createTalon(RobotMap.TALON_CAN_9, false);
  private final VictorSPX shooterFollower = MotorUtil.createVictor(RobotMap.TALON_CAN_11, false);
  /**
   * Add your docs here.
   */
  public PIDShooter() {
    // Intert a subsystem name and PID values here
    super("PIDShooter", 1, 0, 0);
    setSetpoint(6000);
    shooterFollower.follow(shooterMaster);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return shooterMaster.getSelectedSensorVelocity()*600/8192.0;
  }

  @Override
  public void usePIDOutput(double output) {
    shooterMaster.set(ControlMode.PercentOutput, output);
        
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
  }
}
