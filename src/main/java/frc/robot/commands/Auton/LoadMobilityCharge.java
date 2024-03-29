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

package frc.robot.commands.Auton;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import java.util.function.DoubleSupplier;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.SwerveAutoBuilder;
import com.pathplanner.lib.commands.FollowPathWithEvents;
import java.util.HashMap;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem.*;
import frc.robot.Constants;
import frc.robot.NavX;
import frc.robot.commands.LEDs.*;
import frc.robot.commands.Arms.*;
import frc.robot.commands.Autos.AutoBalance;
import frc.robot.commands.Drives.*;
import frc.robot.NavX;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LED;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class LoadMobilityCharge extends SequentialCommandGroup {

    public LoadMobilityCharge(DriveTrain subsystem) {

        LED m_lED = new LED(Constants.LEDConstants.PWMPort, Constants.LEDConstants.LEDCount);
        // public final Servo m_servo = new Servo(1);
        Arm m_arm = new Arm();
        DriveTrain m_driveTrain = new DriveTrain();
        NavX m_gyro = new NavX();
            
        HashMap<String, Command> eventMap = new HashMap<>();
        eventMap.put("LEDPurple", new LEDPurple(m_lED));
        eventMap.put("LEDOff", new LEDOff(m_lED));
        eventMap.put("ArmDown", new LowerArm(m_arm));
        eventMap.put("CloseArm", new CloseArm(m_arm));
        eventMap.put("OpenArm", new OpenArm(m_arm));
        eventMap.put("AutoBalance", new AutoBalance(m_driveTrain, m_gyro));


        PathPlannerTrajectory loadMobilityChrg = PathPlanner.loadPath("Loading Mobility Charge", new PathConstraints(0.33, 0.33));
        addCommands(
            new FollowPathWithEvents(subsystem.followTrajectoryCommand(loadMobilityChrg, true), loadMobilityChrg.getMarkers(), eventMap)
        );
    }
}