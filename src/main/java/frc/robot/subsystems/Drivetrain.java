/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.util.MotorUtil;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final CANSparkMax Motor_Master_Left = new CANSparkMax(RobotMap.TALON_CAN_1, MotorType.kBrushless);
  private final CANSparkMax Motor_Left_1 = new CANSparkMax(RobotMap.TALON_CAN_2, MotorType.kBrushless);
  private final CANSparkMax Motor_Left_2 = new CANSparkMax(RobotMap.TALON_CAN_3, MotorType.kBrushless);

  private final CANSparkMax Motor_Master_Right = new CANSparkMax(RobotMap.TALON_CAN_4, MotorType.kBrushless);
  private final CANSparkMax Motor_Right_1 = new CANSparkMax(RobotMap.TALON_CAN_5, MotorType.kBrushless);
  private final CANSparkMax Motor_Right_2 = new CANSparkMax(RobotMap.TALON_CAN_6, MotorType.kBrushless);

  public void Drivetrain() {
    Motor_Master_Left.restoreFactoryDefaults();
    Motor_Left_1.restoreFactoryDefaults();
    Motor_Left_2.restoreFactoryDefaults();

    Motor_Master_Right.restoreFactoryDefaults();
    Motor_Right_1.restoreFactoryDefaults();
    Motor_Right_2.restoreFactoryDefaults();

    Motor_Left_1.follow(Motor_Master_Left);
    Motor_Left_2.follow(Motor_Master_Left);

    Motor_Right_1.follow(Motor_Master_Right);
    Motor_Right_2.follow(Motor_Master_Right);

    Motor_Master_Left.setInverted(false); 
    Motor_Left_1.setInverted(false); 
    Motor_Left_2.setInverted(false); 

    Motor_Master_Right.setInverted(false); 
    Motor_Right_1.setInverted(false); 
    Motor_Right_2.setInverted(false); 

    Motor_Master_Left.setIdleMode(IdleMode.kBrake);
    Motor_Left_1.setIdleMode(IdleMode.kBrake);
    Motor_Left_2.setIdleMode(IdleMode.kBrake);

    Motor_Master_Right.setIdleMode(IdleMode.kBrake);
    Motor_Right_1.setIdleMode(IdleMode.kBrake);
    Motor_Right_2.setIdleMode(IdleMode.kBrake);
  }

  public void set(final double left, final double right) {
    Motor_Master_Left.set(left);
    Motor_Master_Right.set(right);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
