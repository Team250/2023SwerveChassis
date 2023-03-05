// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import java.util.HashMap;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.DriverStation;

import com.pathplanner.lib.PathPlannerTrajectory.EventMarker;
import com.pathplanner.lib.auto.PIDConstants;
import frc.robot.subsystems.*;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
  
   /**
    * public static final class DriveConstants {
    *   public static final int kLeftMotor1Port = 0;
    *   public static final int kLeftMotor2Port = 1;
    *   public static final int kRightMotor1Port = 2;
    *   public static final int kRightMotor2Port = 3; 
    * }
    */ 

    public static final class LimeLightConstants {
      public static final double Angle = 0;
      public static final double Height = 0;
      public static final double Horizontal_Offset = 0;
      public static final Number[] redTags = {1,2,3,5};
      public static final Number[] blueTags = {4,6,7,8};
    }

    public static final class LEDConstants {
      public static final int PWMPort = 0;
      public static final int LEDCount = 30;
  }

    public static final class DriveConstants {
      public static final double kStabilizationP = 1;
      public static final double kStabilizationI = 0.5;
      public static final double kStabilizationD = 0;

      public static final double kTurnP = 1;
      public static final double kTurnI = 0;
      public static final double kTurnD = 0;

      public static final double kMaxTurnRateDegPerS = 100;
      public static final double kMaxTurnAccelerationDegPerSSquared = 300;

      public static final double kTurnToleranceDeg = 2;
      public static final double kTurnRateToleranceDegPerS = 1; // degrees per second

      public static final double kLL_LR_Offset = 20;
      public static final double kLL_Fwd_Offset = 13;
      public static final double kLL_Tolerance = 4;
      public static final double kLLTransitionalSpeed = 150; // amount to divide the output by to slow the robot
      public static final double kLLRotationalSpeed = 100;


        // Driving Parameters - Note that these are not the maximum capable speeds of
        // the robot, rather the allowed maximum speeds
        public static final double kMaxSpeedMetersPerSecond = 4.8;
        public static final double kMaxAngularSpeed = 2 * Math.PI; // radians per second

        /* Custom PID Controllers */
        // public static final PIDConstants robotRotationPID = new PIDConstants(0.1, 0, 0.00005);
        // public static final PIDConstants targetRotationPID = new PIDConstants(6, 0, 0.05);
        // public static final PIDConstants targetTranslationPID = new PIDConstants(4, 0, 0.005);
        
        // Chassis configuration
        public static final double kTrackWidth = Units.inchesToMeters(18);
        // Distance between centers of right and left wheels on robot
        public static final double kWheelBase = Units.inchesToMeters(27.5);
        // Distance between front and back wheels on robot

        public static final double kDirectionSlewRate = 1.2; // radians per second
        public static final double kMagnitudeSlewRate = 25.0; // percent per second (1 = 100%) (originally 1.8)
        public static final double kRotationalSlewRate = 15.0; // percent per second (1 = 100%) (originally 2.0)

        public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
            new Translation2d(kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));
    
        // Angular offsets of the modules relative to the chassis in radians
        public static final double kFrontLeftChassisAngularOffset = -Math.PI / 2;
        public static final double kFrontRightChassisAngularOffset = 0;
        public static final double kBackLeftChassisAngularOffset = Math.PI;
        public static final double kBackRightChassisAngularOffset = Math.PI / 2;
    
        // SPARK MAX CAN IDs
        public static final int kFrontLeftDrivingCanId = 1;
        public static final int kRearLeftDrivingCanId = 5;
        public static final int kFrontRightDrivingCanId = 3;
        public static final int kRearRightDrivingCanId = 7;
    
        public static final int kFrontLeftTurningCanId = 2;
        public static final int kRearLeftTurningCanId = 6;
        public static final int kFrontRightTurningCanId = 4;
        public static final int kRearRightTurningCanId = 8;

        public static final int kArmCanId = 9;
    
        public static final boolean kGyroReversed = false;
      }
    
      public static final class ModuleConstants {
        // The MAXSwerve module can be configured with one of three pinion gears: 12T, 13T, or 14T.
        // This changes the drive speed of the module (a pinion gear with more teeth will result in a
        // robot that drives faster).
        public static final int kDrivingMotorPinionTeeth = 14;
    
        // Invert the turning encoder, since the output shaft rotates in the opposite direction of
        // the steering motor in the MAXSwerve Module.
        public static final boolean kTurningEncoderInverted = true;
    
        // Calculations required for driving motor conversion factors and feed forward
        public static final double kDrivingMotorFreeSpeedRps = NeoMotorConstants.kFreeSpeedRpm / 60;
        public static final double kWheelDiameterMeters = 0.0762;
        public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
        // 45 teeth on the wheel's bevel gear, 22 teeth on the first-stage spur gear, 15 teeth on the bevel pinion
        public static final double kDrivingMotorReduction = (45.0 * 22) / (kDrivingMotorPinionTeeth * 15);
        public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
            / kDrivingMotorReduction;
    
        public static final double kDrivingEncoderPositionFactor = (kWheelDiameterMeters * Math.PI)
            / kDrivingMotorReduction; // meters
        public static final double kDrivingEncoderVelocityFactor = ((kWheelDiameterMeters * Math.PI)
            / kDrivingMotorReduction) / 60.0; // meters per second
    
        public static final double kTurningEncoderPositionFactor = (2 * Math.PI); // radians
        public static final double kTurningEncoderVelocityFactor = (2 * Math.PI) / 60.0; // radians per second
    
        public static final double kTurningEncoderPositionPIDMinInput = 0; // radians
        public static final double kTurningEncoderPositionPIDMaxInput = kTurningEncoderPositionFactor; // radians
    
        public static final double kDrivingP = 0.04;
        public static final double kDrivingI = 0;
        public static final double kDrivingD = 0;
        public static final double kDrivingFF = 1 / kDriveWheelFreeSpeedRps;
        public static final double kDrivingMinOutput = -1;
        public static final double kDrivingMaxOutput = 1;
    
        public static final double kTurningP = 1;
        public static final double kTurningI = 0;
        public static final double kTurningD = 0;
        public static final double kTurningFF = 0;
        public static final double kTurningMinOutput = -1;
        public static final double kTurningMaxOutput = 1;
    
        public static final IdleMode kDrivingMotorIdleMode = IdleMode.kBrake;
        public static final IdleMode kTurningMotorIdleMode = IdleMode.kBrake;
    
        // public static final int kDrivingMotorCurrentLimit = 50; // amps
        // public static final int kTurningMotorCurrentLimit = 20; // amps
        public static final int kDrivingMotorCurrentLimit = 7; // amps
        public static final int kTurningMotorCurrentLimit = 5; // amps
      }
    
      public static final class OIConstants {
        public static final int kDriverControllerPort = 0;
        public static final double kDriveDeadband = 0.06;
        public static final double kTurnDeadband = 0.06;
      }
    
public static final class AutoConstants { 

        
  public final LED m_lED = new LED(Constants.LEDConstants.PWMPort, Constants.LEDConstants.LEDCount);
  // public final Servo m_servo = new Servo(1);
  public final Arm m_arm = new Arm();
  public final DriveTrain m_driveTrain = new DriveTrain();

    
        public static final double kDrivingP = .04;
        public static final double kDrivingI = 0;
        public static final double kDrivingD = 0;
        
        public static final double kTurningP = 1;
        public static final double kTurningI = 0;
        public static final double kTurningD = 0;

        public static final double kMaxSpeedMetersPerSecond = 3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 3;
        public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
        public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;
    
        public static final double kPXController = 1;
        public static final double kPYController = 1;
        public static final double kPThetaController = 1;
    
        
        // Constraint for the motion profiled robot angle controller
        public static final TrapezoidProfile.Constraints kThetaControllerConstraints = new TrapezoidProfile.Constraints(
            kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
      }
    
      public static final class NeoMotorConstants {
        public static final double kFreeSpeedRpm = 5676;
}
}
