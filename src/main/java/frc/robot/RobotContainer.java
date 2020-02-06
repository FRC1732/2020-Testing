/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// imported needed libraries to use to get buttons, joysticks, and put this on smartdashbaord
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;

// importing our code so we can program the buttons to do certain commands
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  public static DriveTrain m_drive;
  public static Intake m_Intake;

  public static Joystick left, right;
  public Button a;
  public Button b;
  public JoystickButton lmove;
  public JoystickButton rmove;
  public JoystickButton mistake;
  public Drive driving;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_drive = new DriveTrain();
    m_Intake = new Intake();

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    // a.whenPressed(new Spin());
    left = new Joystick(Constants.JOYSTICK_LEFT);
    right = new Joystick(Constants.JOYSTICK_RIGHT);
    m_drive.setDefaultCommand(new Drive());
    JoystickButton intake = new JoystickButton(left, 1);
    JoystickButton outtake = new JoystickButton(right, 1);

    intake.whenReleased(new StopIntake());
    outtake.whenPressed(new SpinBackward());
    intake.whenPressed(new SpinForward());
    outtake.whenReleased(new StopIntake());

  }

  /**
   * Gets the JS_1 joystick's position, as a percent of fully pushed
   * 
   * @return the position, in the range of [-1, 1]
   */
  public static double getLeftJoystick() {
    return left.getY() * left.getY() * Math.signum(left.getY());
  }

  /**
   * Gets the JS_2 joystick's position, as a percent of fully pushed
   * 
   * @return the position, in the range of [-1, 1]
   */
  public static double getRightJoystick() {
    return right.getY() * right.getY() * Math.signum(right.getY());
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

  public Command getDrive() {
    return driving;
  }
}