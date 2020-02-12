/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
  private Drivetrain m_drive;
  private Joystick left, right;

  /**
   * Creates a new Drive.
   */
  public Drive(Drivetrain drive, Joystick left, Joystick right) {
    m_drive = drive;
    this.left = left;
    this.right = right;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed = left.getY() * left.getY() * Math.signum(left.getY());
    double rightSpeed = right.getY() * right.getY() * Math.signum(right.getY());
    System.out.println("LEFT: " + leftSpeed);
    System.out.println("RIGHT: " + rightSpeed);
    m_drive.regDrive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}