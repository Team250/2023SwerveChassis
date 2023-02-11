// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands.LLAutos;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import frc.robot.Constants;
import frc.robot.NavX;
import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Twist2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.apriltag.AprilTagPoseEstimator;
import edu.wpi.first.apriltag.AprilTagPoseEstimate;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.RobotContainer;
import edu.wpi.first.apriltag.AprilTag;
import frc.robot.subsystems.LimeLight;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.subsystems.DriveTrain.*;
import frc.robot.Constants.*;
import edu.wpi.first.wpilibj.GenericHID.*;
import edu.wpi.first.wpilibj.XboxController;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.DriveTrain;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class LLAutoCenter extends CommandBase {
    // private final Rotation2d rotation = new Rotation2d(0);
    // private final Pose2d startPose = new Pose2d(0,0,rotation);
    // private final Pose2d endPose = new Pose2d(100,0,rotation);
    // private Trajectory traj = TrajectoryGenerator.generateTrajectory(startPose, null, endPose, null);
    // private final PIDController targetTranslationPID = Constants.DriveConstants.targetTranslationPID.getController();
    // private final PIDController robotRotationPID = Constants.DriveConstants.robotRotationPID.getController();
        private final NavX m_gyro = new NavX();
        private final XboxController xboxcontroller = new XboxController(0);
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final DriveTrain m_driveTrain;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    public LLAutoCenter(DriveTrain subsystem) {

        
    // PIDController rotationPID = new PIDController(0.1, 0, 0.00005);
    // rotationPID.enableContinuousInput(-180, 180);
    // PIDController translationPID = new PIDController(0.1, 0, 0.00005);
    // translationPID.enableContinuousInput(-180, 180);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS;
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_driveTrain = subsystem;
        addRequirements(m_driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        xboxcontroller.setRumble(RumbleType.kBothRumble, 1.0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double rotAmount = 0;
        if (m_gyro.getYaw() > 10){
            rotAmount = m_gyro.getYaw() + m_driveTrain.getFieldOffsetAngle();
        }else if (m_gyro.getYaw() < -10){
            rotAmount = -m_gyro.getYaw() + m_driveTrain.getFieldOffsetAngle();
        }
        
        // m_driveTrain.setX();

        // if (LimeLight.getTs() < 40) {
        //     rotAmount = -LimeLight.getTs()+5;
        // }else if (LimeLight.getTs() > 60) {
        //     rotAmount = LimeLight.getTs()-5;
        // }

        if (LimeLight.isTag() == 1.0){
            m_driveTrain.setDrive(0, -LimeLight.getXCoord()/100, rotAmount/360, true, true);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        xboxcontroller.setRumble(RumbleType.kBothRumble, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
