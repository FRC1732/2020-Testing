/*----------------------------------------------------------------------------*/
/* CopyJS_2 (c) 2019 FIRST. All JS_2s Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick JS_1 = new Joystick(RobotMap.JOYSTICK_0);
  Joystick JS_2 = new Joystick(RobotMap.JOYSTICK_1);

  XboxController XB_1 = new XboxController(RobotMap.JOYSTICK_0);
  DefaultDrive c_Drive;

  public OI() {
    
    new JoystickButton(XB_1, RobotMap.BTN_SPEED_1).whenPressed(new SetMotor_0());

    new JoystickButton(XB_1, RobotMap.BTN_SPEED_2).whenPressed(new SetMotor_F25());
    new JoystickButton(XB_1, RobotMap.BTN_SPEED_4).whenPressed(new SetMotor_F50());
    new JoystickButton(XB_1, RobotMap.BTN_SPEED_3).whenPressed(new SetMotor_F75());
    new JoystickButton(XB_1, RobotMap.BTN_SPEED_5).whenPressed(new SetMotor_F100());

    new JoystickButton(XB_1, RobotMap.BTN_SPEED_6).whenPressed(new SetMotor_R25());
    new JoystickButton(XB_1, RobotMap.BTN_SPEED_7).whenPressed(new SetMotor_R50());
    new JoystickButton(XB_1, RobotMap.BTN_SPEED_8).whenPressed(new SetMotor_R75());
    new JoystickButton(XB_1, RobotMap.BTN_SPEED_9).whenPressed(new SetMotor_R100());
    

    /*   driverController.getY(GenericHID.Hand.kLeft),
      driverController.getX(GenericHID.Hand.kRight)),
      m_robotDrive) */
  
  }

  /**
   * Gets the JS_1 joystick's position, as a percent of fully pushed
   * 
   * @return the position, in the range of [-1, 1]
   */
  public double getLeftJoystick() {
    return -1 * XB_1.getY(Hand.kLeft) * XB_1.getY(Hand.kLeft) * Math.signum(XB_1.getY(Hand.kLeft));
  }

  /**
   * Gets the JS_2 joystick's position, as a percent of fully pushed
   * 
   * @return the position, in the range of [-1, 1]
   */
  public double getRightJoystick() {
    return -1 * XB_1.getY(Hand.kRight) * XB_1.getY(Hand.kRight) * Math.signum(XB_1.getY(Hand.kRight));
  }

}
