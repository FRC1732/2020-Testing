/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  private VictorSPX intakeMotor;
  private Solenoid intakeSolenoid;

  public Intake() {
    intakeMotor = new VictorSPX(Constants.INTAKE_INTAKEMOTOR_ID);
    intakeSolenoid = new Solenoid(Constants.INTAKE_INTAKESOLENOID_ID);
  }

  public void setIntakeMotor (double motor){
    intakeMotor.set(ControlMode.PercentOutput, motor);
  }

  public void extendIntake(boolean extendIntakeSolenoid){
    intakeSolenoid.set(extendIntakeSolenoid);
  }
  public void spinForward(){
      setIntakeMotor(.75);
  }

  public void spinBackward(){
    setIntakeMotor(-.75);
  }

  public void stop(){
    setIntakeMotor(0);
  }

  public void extendIntakeFord(){
      extendIntake(true);
  }
  public void stopIntakeFord(double motor){
    intakeMotor.set(ControlMode.PercentOutput,motor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
