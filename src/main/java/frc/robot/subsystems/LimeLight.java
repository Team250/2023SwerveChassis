package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Constants.LimeLightConstants;
import edu.wpi.first.cameraserver.CameraServer;

public class LimeLight extends SubsystemBase {
  /** Creates a new LimeLight. */
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry tx = table.getEntry("tx");
  private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry ta = table.getEntry("ta");
  private NetworkTableEntry tv = table.getEntry("tv");


  public LimeLight() {
    /**
     * tx - Horizontal Offset
     * ty - Vertical Offset 
     * ta - Area of target 
     * tv - Target Visible
     */
    CameraServer.startAutomaticCapture();
    CameraServer.getVideo();
    
    this.tx = table.getEntry("tx");
    this.ty = table.getEntry("ty");
    this.ta = table.getEntry("ta");
    this.tv = table.getEntry("tv");
  }

  @Override
  public void periodic() {
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
    return getTx().getDouble(0.0) + LimeLightConstants.HORAZONTAL_OFFSET;
  }

  public double getVerticalAngleOfError(){
    //+1 is a fudge factor cor camera mounting
    return getTy().getDouble(0.0) + LimeLightConstants.VERTICAL_OFFSET;
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
