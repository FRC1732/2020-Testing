/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// imported needed libraries to use to get buttons, joysticks, and put this on smartdashbaord
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// importing our code so we can program the buttons to do certain commands
import frc.robot.commands.Drivetrain.Drive;
import frc.robot.commands.Intake.SpinBackward;
import frc.robot.commands.Intake.SpinForward;
import frc.robot.commands.Intake.StopIntake;
import frc.robot.commands.Shooter.DecreaseShooterSpeed;
import frc.robot.commands.Shooter.IncreaseShooterSpeed;
import frc.robot.commands.Shooter.SetShooterSpeed;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public Drivetrain m_drive;
  // public Intake m_Intake;
  public Shooter m_Shooter;
  
  public Joystick left;
  public Joystick right;
  public Command m_autoCommand;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_drive = new Drivetrain();
    // m_Intake = new Intake();
    m_Shooter = new Shooter();
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    left = new Joystick(Constants.JOYSTICK_LEFT);
    right = new Joystick(Constants.JOYSTICK_RIGHT);
    m_drive.setDefaultCommand(new Drive(m_drive, left, right));
    

    // Intake - IN
    // new JoystickButton(left, Constants.JOYSTICK_SPINFORWARD).whenPressed(new SpinForward(m_Intake));
    // new JoystickButton(left, Constants.JOYSTICK_SPINFORWARD).whenReleased(new StopIntake(m_Intake));

    // Intake - OUT
    // new JoystickButton(left, Constants.JOYSTICK_SPINBACKWARD).whenPressed(new SpinBackward(m_Intake));
    // new JoystickButton(left, Constants.JOYSTICK_SPINBACKWARD).whenReleased(new StopIntake(m_Intake));

    //Shooter
    new JoystickButton(left, Constants.JOYSTICK_SET_SHOOTER_0).whenPressed(new SetShooterSpeed(m_Shooter, 0));
    new JoystickButton(left, Constants.JOYSTICK_SET_SHOOTER_25).whenPressed(new SetShooterSpeed(m_Shooter, 0.25));
    new JoystickButton(left, Constants.JOYSTICK_DECR_SHOOTER).whenPressed(new DecreaseShooterSpeed(m_Shooter));
    new JoystickButton(left, Constants.JOYSTICK_SET_SHOOTER_50).whenPressed(new SetShooterSpeed(m_Shooter, 0.50));
    new JoystickButton(left, Constants.JOYSTICK_INCR_SHOOTER).whenPressed(new IncreaseShooterSpeed(m_Shooter));
    new JoystickButton(left, Constants.JOYSTICK_SET_SHOOTER_75).whenPressed(new SetShooterSpeed(m_Shooter, 0.75));
    new JoystickButton(left, Constants.JOYSTICK_SET_SHOOTER_100).whenPressed(new SetShooterSpeed(m_Shooter, 1.00));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}