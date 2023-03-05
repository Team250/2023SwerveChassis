package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Constants.LimeLightConstants;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.DriverStation;
import frc.common.math.MathUtils;

public class LimeLight extends SubsystemBase {
  /** Creates a new LimeLight. */
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry tx = table.getEntry("tx");
  private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry ta = table.getEntry("ta");
  private NetworkTableEntry tv = table.getEntry("tv");
  double a = 1;

  private static final double Tag_Height = Units.inchesToMeters(26.5);
  private static final double LL_Height = Units.inchesToMeters(LimeLightConstants.Height);
  private static final double LL_Angle = Math.toRadians(LimeLightConstants.Angle);
  private static final double Tag_Error = Math.toRadians(2.5);

  private final DriveTrain m_drivetrain;

  private double theta;
  private boolean shooterHasTargets = false;
  private double distanceToTarget = Double.NaN;
  private double angleToTarget = Double.NaN;


  public LimeLight(DriveTrain driveTrain) {
    this.m_drivetrain = driveTrain;
    /**
     * tx - Horizontal Offset
     * ty - Vertical Offset 
     * ta - Area of target 
     * tv - Target Visible
     */
    CameraServer.startAutomaticCapture();
    CameraServer.getVideo();
    
    if (DriverStation.getAlliance() == DriverStation.Alliance.Blue){
      //blue tag pipeline
      NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setInteger(0);
    }
    else if (DriverStation.getAlliance() == DriverStation.Alliance.Red){
      //red tag pipeline
      NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setInteger(1);  
    }
    else{
      //all tag pipeline
      NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setInteger(2);
    }
    this.tx = table.getEntry("tx");
    this.ty = table.getEntry("ty");
    this.ta = table.getEntry("ta");
    this.tv = table.getEntry("tv");
  }

  @Override
  public void periodic() {

    boolean hasTarget = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0) > 0.5;

    double pitch = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    double yaw = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);

    SmartDashboard.putBoolean("hasTarget", hasTarget);
    SmartDashboard.putNumber("distance to target", distanceToTarget);
    SmartDashboard.putNumber("angle to target", angleToTarget);

    theta = Math.toRadians(pitch) + LL_Angle;
    distanceToTarget = (Tag_Height - LL_Height) / Math.tan(theta);
    angleToTarget = m_drivetrain.getPose().getRotation().getRadians() + Math.toRadians(yaw);
    // This method will be called once per scheduler run

     //read values periodically
    double x = this.tx.getDouble(0.0);
    double y = this.ty.getDouble(0.0);
    double area = this.ta.getDouble(0.0);


    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);

  }

  public boolean isOnTarget() {
    shooterHasTargets = shooterHasTargets();
      if (shooterHasTargets) {
          double delta = angleToTarget - m_drivetrain.getPose().getRotation().getRadians();
          if (delta > Math.PI) {
              delta = 2.0 * Math.PI - delta;
          }

          return MathUtils.epsilonEquals(delta, 0, Tag_Error);
      } else {
          return false;
      }
    }

  public boolean shooterHasTargets() {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0) > 0.5;
  }

  public double getDistanceToTarget() {
    return distanceToTarget;
  }

  public double getAngleToTarget() {
      return angleToTarget;
  }

  public static double getXCoord(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
  }
  public static double getYCoord(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
  }
  public static double isTag(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
  }
  public static double getShort(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tshort").getDouble(0);
  }
  public static double getLong(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tlong").getDouble(0);
  }
  public static double getTs(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0);
  }
  public static double getThor(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("thor").getDouble(0);
  }
  public static double getVert(){
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tvert").getDouble(0);
  }

  public double getHorazontalAngleOfError(){
    //+1 is a fudge factor cor camera mounting
    return getTx().getDouble(0.0) + LimeLightConstants.Horizontal_Offset;
  }

  public double getVerticalAngleOfError(){
    //+1 is a fudge factor cor camera mounting
    return getTy().getDouble(0.0) + LimeLightConstants.Height;
  }


 public NetworkTableEntry getTx() {
    return tx;
  }

  public NetworkTableEntry getTy() {
    return ty;
  }

  public NetworkTableEntry getTa() {
    return ta;
  }


}
