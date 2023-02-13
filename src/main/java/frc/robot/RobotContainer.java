// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.LEDs.*;
import frc.robot.commands.Shuffleboard.*;
import frc.robot.commands.LLAutos.*;
import frc.robot.commands.Arms.*;
import frc.robot.commands.Drives.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;
import edu.wpi.first.hal.AllianceStationID;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.DriverStation.Alliance.*;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.hal.DriverStationJNI;
import edu.wpi.first.wpilibj2.command.button.POVButton;

// import com.pathplanner.lib.PathConstraints;
// import com.pathplanner.lib.PathPlanner;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();
  public final ShuffleboardSub m_shuffle = new ShuffleboardSub();
  public final LED m_lED = new LED(Constants.LEDConstants.PWMPort, Constants.LEDConstants.LEDCount);
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    // public final Servo m_servo = new Servo(1);
    public final Arm m_arm = new Arm();
    public final DriveTrain m_driveTrain = new DriveTrain();

// Joysticks
private final XboxController xboxController1 = new XboxController(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {

    SmartDashboard.putData(m_shuffle);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_lED);
    SmartDashboard.putData(m_arm);
    SmartDashboard.putData(m_driveTrain);

    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("Drive", new Drive( m_driveTrain ));
    SmartDashboard.putData("ToggleOrientedDrive", new ToggleOrientedDrive( m_driveTrain ));
    SmartDashboard.putData("DriverOrientedDrive", new DriverOrientedDrive( m_driveTrain ));
    SmartDashboard.putData("RobotOrientedDrive", new RobotOrientedDrive( m_driveTrain ));
    SmartDashboard.putData("LowerArm", new LowerArm( m_arm ));
    SmartDashboard.putData("ArmToHybridNode", new ArmToHybridNode( m_arm ));
    SmartDashboard.putData("ArmToMidNode", new ArmToMidNode( m_arm ));
    SmartDashboard.putData("ArmToHighNode", new ArmToHighNode( m_arm ));
    SmartDashboard.putData("OpenArm", new OpenArm( m_arm ));
    SmartDashboard.putData("CloseArm", new CloseArm( m_arm ));
    SmartDashboard.putData("LockDriveLeftRight", new LockDriveLeftRight( m_driveTrain ));
    // SmartDashboard.putData("Spin Servo", new SpinServo( m_servo ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();
    
    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_arm.setDefaultCommand(new LowerArm( m_arm ));
    m_driveTrain.setDefaultCommand(new Drive( m_driveTrain ));


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_shuffle.setDefaultCommand(new SetUpShuffleboard(m_shuffle));
    m_lED.setDefaultCommand(new LED250(m_lED));

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    // m_chooser.addOption("pathplannerTest",
    //   PathPlanner.loadPathGroup(
    //           "New Path",
    //           new PathConstraints(
    //                   AutonConfig.kMaxSpeed, AutonConfig.kMaxAccel)))););
    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons

final JoystickButton xboxButtonX = new JoystickButton(xboxController1, XboxController.Button.kX.value);        
xboxButtonX.onTrue(new ToggleOrientedDrive( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("Xbox Button X",new ToggleOrientedDrive( m_driveTrain ));
                        


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
final JoystickButton xboxButtonLB = new JoystickButton(xboxController1, XboxController.Button.kLeftBumper.value);        
xboxButtonLB.onTrue(new LEDYellow( m_lED ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
  SmartDashboard.putData("LED's Yellow",new LEDYellow( m_lED ));
                        
final JoystickButton xboxButtonRB = new JoystickButton(xboxController1, XboxController.Button.kRightBumper.value);        
xboxButtonRB.onTrue(new LEDPurple( m_lED ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
    SmartDashboard.putData("LED's Purple",new LEDPurple( m_lED ));

final JoystickButton xboxButtonY = new JoystickButton(xboxController1, XboxController.Button.kY.value);        
xboxButtonY.onTrue(new LEDOff( m_lED ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
    SmartDashboard.putData("LED's Purple",new LEDOff( m_lED ));
    

final JoystickButton xboxButtonStart = new JoystickButton(xboxController1, XboxController.Button.kStart.value);        
xboxButtonStart.onTrue(new LockDriveForwardReverse( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
    SmartDashboard.putData("Lock Left Right Drive",new LockDriveForwardReverse( m_driveTrain ));

final JoystickButton xboxButtonBack = new JoystickButton(xboxController1, XboxController.Button.kBack.value);        
xboxButtonBack.onTrue(new LockDriveLeftRight( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
    SmartDashboard.putData("Lock Left Right Drive",new LockDriveLeftRight( m_driveTrain ));
    

final JoystickButton xboxButtonB = new JoystickButton(xboxController1, XboxController.Button.kB.value);        
xboxButtonB.onTrue(new LockRotation( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
    SmartDashboard.putData("Lock Rotation",new LockRotation( m_driveTrain ));


final POVButton xboxButton0 = new POVButton(xboxController1, 0); //Dpad up
xboxButton0.whileTrue(new LLAutoCenter( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
    SmartDashboard.putData("LimeLight Auto Center",new LLAutoCenter( m_driveTrain ));
xboxButton0.whileTrue(new TurnToAngle(0+m_driveTrain.getFieldOffsetAngle(), m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
    SmartDashboard.putData("Turn to 0 plus field offset",new TurnToAngle(0+m_driveTrain.getFieldOffsetAngle(), m_driveTrain ));

  
final POVButton xboxButton270 = new POVButton(xboxController1, 270); //Dped left   
xboxButton270.whileTrue(new LLAutoCenterLeft( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
    SmartDashboard.putData("LimeLight Auto Center Left",new LLAutoCenterLeft( m_driveTrain ));

final POVButton xboxButton90 = new POVButton(xboxController1, 90); //Dpad right
xboxButton90.whileTrue(new LLAutoCenterRight( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
    SmartDashboard.putData("LimeLight Auto Center Right",new LLAutoCenterRight( m_driveTrain ));
}

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public XboxController getXboxController1() {
      return xboxController1;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

