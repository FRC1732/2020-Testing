/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class MaintainRPM extends CommandBase {
  private final Shooter m_shooter;

  public MaintainRPM(Shooter shooter) {
    m_shooter = shooter;
    // Use requires() here to declare subsystem dependencies
    addRequirements(shooter);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_shooter.maintainRPM();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    m_shooter.printMotorVelocity();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
  }
}
