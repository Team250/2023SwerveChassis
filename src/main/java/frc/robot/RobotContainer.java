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
import frc.robot.commands.LLAutos.*;
import frc.robot.commands.Autos.*;
import frc.robot.commands.Arms.*;
// import frc.robot.commands.Servo180;
import frc.robot.commands.Autos.DontMove;
import frc.robot.commands.Autos.MoveForward;
import frc.robot.commands.Autos.RightMobilityCharge;
import frc.robot.commands.Autos.CenterMobilityCharge;
import frc.robot.commands.Drives.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.DigitalOutput;
// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;
// import edu.wpi.first.hal.AllianceStationID;
// import edu.wpi.first.wpilibj.DriverStation.Alliance;
// import edu.wpi.first.wpilibj.DriverStation.Alliance.*;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
// import edu.wpi.first.hal.DriverStationJNI;
import edu.wpi.first.wpilibj2.command.button.POVButton;
// import edu.wpi.first.wpilibj.AnalogInput;
// import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants.AutoConstants;
// import com.pathplanner.lib.PathPoint;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.PathConstraints;
import java.util.HashMap;
import edu.wpi.first.wpilibj.Servo;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
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

//   private static DigitalInput m_input = new DigitalInput(1);
//   private static DigitalOutput m_output = new DigitalOutput(0);
    // private final AnalogInput m_input = new AnalogInput(0);
  private static RobotContainer m_robotContainer = new RobotContainer();
  public final ShuffleboardSub m_shuffle = new ShuffleboardSub();
  public final LED m_lED = new LED(Constants.LEDConstants.PWMPort, Constants.LEDConstants.LEDCount);
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    // public final Servo m_servo = new Servo(1);
    public final Arm m_arm = new Arm();
    public final DriveTrain m_driveTrain = new DriveTrain();
    // public final ServoSub m_servo = new ServoSub(1);

// Joysticks
private final XboxController driverController = new XboxController(0);
private final XboxController manipController = new XboxController(1);
// private final Joystick joystick1 = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    

  
  // A chooser for autonomous commands
	// private SendableChooser<PathPlannerTrajectory> m_chooser = new SendableChooser<>();
  private SendableChooser<Command> m_chooser = new SendableChooser<>();
  
  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
    HashMap<String, Command> eventMap = new HashMap<>();
    eventMap.put("LEDPurple", new LEDPurple(m_lED));
    eventMap.put("LEDOff", new LEDOff(m_lED));
    eventMap.put("ArmDown", new LowerArm(m_arm));
    eventMap.put("CloseArm", new CloseArm(m_arm));
    eventMap.put("AutoBalance", new AutoBalance(m_driveTrain));

    Shuffleboard.getTab("Autonomous").add(m_chooser);   

    // PathPlannerTrajectory trajTest = PathPlanner.loadPath("New Path", new PathConstraints(0.33, 0.33));
    // PathPlannerTrajectory forward = PathPlanner.loadPath("Forward", new PathConstraints(0.33, 0.33));
    
    // PathPlannerTrajectory smMovement = PathPlanner.loadPath("Small Movement", new PathConstraints(0.33, 0.33));
    // PathPlannerTrajectory ldMobChrg = PathPlanner.loadPath("New Path", new PathConstraints(0.33, 0.33));
    // PathPlannerTrajectory mdMobChrg = PathPlanner.loadPath("New Path", new PathConstraints(0.33, 0.33));
    // PathPlannerTrajectory rghtMobChrg = PathPlanner.loadPath("New Path", new PathConstraints(0.33, 0.33));
        
    // m_chooser.addOption("Small Movement", smMovement);
    // m_chooser.addOption("Test Auto", trajTest);
    // m_chooser.addOption("Forward", forward);
    // m_chooser.addOption("Loading Mobility Charge", ldMobChrg);
    // m_chooser.addOption("Center Mobility Charge", mdMobChrg);
    // m_chooser.addOption("Right Moblity Charge", rghtMobChrg);
    m_chooser.addOption("Loading Mobility Charge", new LoadMobilityCharge(m_driveTrain));
    m_chooser.addOption("Loading Mobility", new LoadMobility(m_driveTrain));
    m_chooser.addOption("Loading Mobility Aquire", new LoadMobilityAquire(m_driveTrain));
    m_chooser.addOption("Center Mobility Charge", new CenterMobilityCharge(m_driveTrain));
    m_chooser.addOption("Center Mobility", new CenterMobility(m_driveTrain));
    m_chooser.addOption("Opp Mobility Charge", new RightMobilityCharge(m_driveTrain));
    m_chooser.addOption("Opp Mobility", new RightMobility(m_driveTrain));
    m_chooser.addOption("Move Forward", new MoveForward(m_driveTrain));
    m_chooser.addOption("Tune Rotation", new RotationTuning(m_driveTrain));

    SmartDashboard.putData(m_shuffle);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_lED);
    SmartDashboard.putData(m_arm);
    SmartDashboard.putData(m_driveTrain);

    // SmartDashboard Buttons
    SmartDashboard.putNumber("DrivingP", AutoConstants.kDrivingP);
    SmartDashboard.putNumber("DrivingI",AutoConstants.kDrivingI);
    SmartDashboard.putNumber("DrivingD",AutoConstants.kDrivingD);
    
    SmartDashboard.putNumber("TurningP",AutoConstants.kTurningP);
    SmartDashboard.putNumber("TurningI",AutoConstants.kTurningI);
    SmartDashboard.putNumber("TurningD",AutoConstants.kTurningD);


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
    SmartDashboard.putData("Toggle Slew", new ToggleSlew(m_driveTrain));

    // SmartDashboard.putBoolean("input value", m_input.getVoltage() > 2.8);
    // SmartDashboard.putData("Spin Servo", new SpinServo( m_servo ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();
    
    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_arm.setDefaultCommand(new LowerArm( m_arm ));
    m_driveTrain.setDefaultCommand(new Drive( m_driveTrain ));


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_lED.setDefaultCommand(new LED250(m_lED));

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    // m_chooser.setDefaultOption("Small Movement", smMovement);
    m_chooser.setDefaultOption("None", new DontMove(m_driveTrain));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

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

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS

final JoystickButton xboxButtonLBumper = new JoystickButton(driverController, XboxController.Button.kLeftBumper.value);        
xboxButtonLBumper.onTrue(new ToggleOrientedDrive( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
                        SmartDashboard.putData("Xbox Button X",new ToggleOrientedDrive( m_driveTrain ));
          

// final JoystickButton xboxButtonStart = new JoystickButton(driverController, XboxController.Button.kStart.value);        
// xboxButtonStart.onTrue(new LockDriveForwardReverse( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
//     SmartDashboard.putData("Lock Left Right Drive",new LockDriveForwardReverse( m_driveTrain ));

// final JoystickButton xboxButtonBack = new JoystickButton(driverController, XboxController.Button.kBack.value);        
// xboxButtonBack.onTrue(new LockDriveLeftRight( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
//     SmartDashboard.putData("Lock Left Right Drive",new LockDriveLeftRight( m_driveTrain ));
    
// final JoystickButton xboxButtonB = new JoystickButton(driverController, XboxController.Button.kB.value);        
// xboxButtonB.onTrue(new LockRotation( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
//     SmartDashboard.putData("Lock Rotation",new LockRotation( m_driveTrain ));

final POVButton xboxButton0 = new POVButton(driverController, 0);        
xboxButton0.onTrue(new SequentialCommandGroup(new TurnToAngle(0,m_driveTrain), new LLAutoCenter(m_driveTrain, m_shuffle)).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final POVButton xboxButton90 = new POVButton(driverController, 90);        
xboxButton90.onTrue(new SequentialCommandGroup(new TurnToAngle(0,m_driveTrain), new LLAutoCenterRight(m_driveTrain, m_shuffle)).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final POVButton xboxButton270 = new POVButton(driverController, 270);        
xboxButton270.onTrue(new SequentialCommandGroup(new TurnToAngle(0,m_driveTrain), new LLAutoCenterLeft(m_driveTrain, m_shuffle)).withInterruptBehavior(InterruptionBehavior.kCancelSelf));


final JoystickButton xboxButtonA = new JoystickButton(driverController, XboxController.Button.kA.value);        
xboxButtonA.whileTrue(new TurnToAngle(0, m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton xboxButtonX = new JoystickButton(driverController, XboxController.Button.kX.value);        
xboxButtonX.whileTrue(new TurnToAngle(270, m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton xboxButtonY = new JoystickButton(driverController, XboxController.Button.kY.value);        
xboxButtonY.whileTrue(new TurnToAngle(90, m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton xboxButtonB = new JoystickButton(driverController, XboxController.Button.kB.value);        
xboxButtonB.whileTrue(new TurnToAngle(180, m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));



final JoystickButton manipXboxButtonLBumper = new JoystickButton(manipController, XboxController.Button.kLeftBumper.value);        
manipXboxButtonLBumper.onTrue(new LEDYellow(m_lED ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton manipXboxButtonRBumper = new JoystickButton(manipController, XboxController.Button.kRightBumper.value);        
manipXboxButtonRBumper.onTrue(new LEDPurple(m_lED ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton manipXboxButtonY = new JoystickButton(manipController, XboxController.Button.kY.value);        
manipXboxButtonY.onTrue(new ArmToHighNode(m_arm ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton manipXboxButtonB = new JoystickButton(manipController, XboxController.Button.kB.value);        
manipXboxButtonB.whileTrue(new ArmToMidNode(m_arm ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton manipXboxButtonA = new JoystickButton(manipController, XboxController.Button.kA.value);        
manipXboxButtonA.whileTrue(new ArmToHybridNode(m_arm ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton manipXboxButtonX = new JoystickButton(manipController, XboxController.Button.kX.value);        
manipXboxButtonX.whileTrue(new LowerArm(m_arm ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton manipXboxButtonStart = new JoystickButton(manipController, XboxController.Button.kStart.value);        
manipXboxButtonStart.whileTrue(new OpenArm(m_arm ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

final JoystickButton manipXboxButtonBack = new JoystickButton(manipController, XboxController.Button.kBack.value);        
manipXboxButtonBack.whileTrue(new CloseArm(m_arm ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));


// final JoystickButton xboxButtonA = new JoystickButton(driverController, XboxController.Button.kA.value);        
// xboxButtonA.whileTrue(new AutoBalance( m_driveTrain ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

// final JoystickButton xboxButtonY = new JoystickButton(driverController, XboxController.Button.kY.value); //Dpad up
// xboxButtonY.whileTrue(new SequentialCommandGroup(new TurnToAngle(0,m_driveTrain), new LLAutoCenter(m_driveTrain, m_shuffle)).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
//     // SmartDashboard.putData("LimeLight Auto Center",new LLAutoCenter(0,m_driveTrain ));

// final JoystickButton xboxButtonX = new JoystickButton(driverController, XboxController.Button.kX.value); //Dped left   
// xboxButtonX.whileTrue(new SequentialCommandGroup(new TurnToAngle(0,m_driveTrain), new LLAutoCenterLeft(m_driveTrain, m_shuffle)).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
//     // SmartDashboard.putData("LimeLight Auto Center Left",new LLAutoCenterLeft(0, m_driveTrain ));

// final JoystickButton xboxButtonB = new JoystickButton(driverController, XboxController.Button.kB.value); //Dpad right
// xboxButtonB.whileTrue(new SequentialCommandGroup(new TurnToAngle(0,m_driveTrain), new LLAutoCenterRight(m_driveTrain, m_shuffle)).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
//     // SmartDashboard.putData("LimeLight Auto Center Right",new LLAutoCenterRight(0, m_driveTrain ));
}

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public XboxController getdriverController() {
      return driverController;
}
public XboxController getmanipController() {
      return manipController;
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

