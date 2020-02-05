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
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SpinForward;
import frc.robot.commands.SpinBackward;
import frc.robot.commands.StopIntake;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  public static DriveTrain m_drive = new DriveTrain();
  public static Intake m_Intake = new Intake();
  public static SpinForward m_spinForward = new SpinForward(m_Intake);
  public static SpinBackward m_spinBackward = new SpinBackward(m_Intake);
    public static StopIntake m_stopIntake = new StopIntake(m_Intake);

  public static Joystick left = new Joystick(Constants.JOYSTICK_LEFT);
  public static Joystick right = new Joystick(Constants.JOYSTICK_RIGHT);
  public static JoystickButton spinForward = new JoystickButton(left, Constants.JOYSTICK_SPINFORWARD);
  public static JoystickButton spinBackward = new JoystickButton(left, Constants.JOYSTICK_SPINBACKWARD);
  public static JoystickButton stopIntake = new JoystickButton(left, Constants.JOYSTICK_STOPINTAKE);
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
    left = new Joystick(Constants.JOYSTICK_LEFT);
    right = new Joystick(Constants.JOYSTICK_RIGHT);
    spinForward.whenPressed(m_spinForward);
    spinBackward.whenPressed(m_spinBackward);
    stopIntake.whenPressed(m_stopIntake);
    m_drive.setDefaultCommand(new Drive());

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

  public Command getDrive()
  {
    return driving;
  }
}