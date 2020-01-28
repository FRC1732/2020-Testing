/*----------------------------------------------------------------------------*/
/* CopyJS_2 (c) 2019 FIRST. All JS_2s Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick JS_1 = new Joystick(RobotMap.JOYSTICK_0);
  Joystick JS_2 = new Joystick(RobotMap.JOYSTICK_1);

  public OI() {
    new JoystickButton(JS_1, RobotMap.BTN_SPEED_1).whenPressed(new SetMotor_0());

    new JoystickButton(JS_1, RobotMap.BTN_SPEED_2).whenPressed(new MaintainRPM());
    new JoystickButton(JS_1, RobotMap.BTN_SPEED_4).whenPressed(new SetMotor_F50());
    new JoystickButton(JS_1, RobotMap.BTN_SPEED_3).whenPressed(new SetMotor_F75());
    new JoystickButton(JS_1, RobotMap.BTN_SPEED_5).whenPressed(new SetMotor_F100());

    new JoystickButton(JS_1, RobotMap.BTN_SPEED_6).whenPressed(new SetMotor_R25());
    new JoystickButton(JS_1, RobotMap.BTN_SPEED_7).whenPressed(new SetMotor_R50());
    new JoystickButton(JS_1, RobotMap.BTN_SPEED_10).whenPressed(new SetMotor_R75());
    new JoystickButton(JS_1, RobotMap.BTN_SPEED_11).whenPressed(new SetMotor_R100());
    
  
  }

  /**
   * Gets the JS_1 joystick's position, as a percent of fully pushed
   * 
   * @return the position, in the range of [-1, 1]
   */
  public double getJS_1Joystick() {
    return -1 * JS_1.getY() * JS_1.getY() * Math.signum(JS_1.getY());
  }
  
  /**
   * Gets the JS_2 joystick's position, as a percent of fully pushed
   * 
   * @return the position, in the range of [-1, 1]
   */
  public double getJS_2Joystick() {
    return -1 * JS_2.getY() * JS_2.getY() * Math.signum(JS_2.getY());
  }

}
