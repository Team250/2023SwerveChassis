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
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.ShuffleboardSub;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants.*;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.DriveTrain;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class LLAutoCenterLeft extends CommandBase {


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
        private final DriveTrain m_driveTrain;
        private final ShuffleboardSub m_shuffle;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


    public LLAutoCenterLeft(DriveTrain subsystem, ShuffleboardSub subsystem2) {


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS;
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_driveTrain = subsystem;
        m_shuffle = subsystem2;
        addRequirements(m_driveTrain, m_shuffle);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    m_shuffle.LLShuffleboard();
    if (LimeLight.isTag() == 1){
      m_driveTrain.setDrive(
        // (LimeLight.getYCoord()+DriveConstants.kLL_Fwd_Offset)/DriveConstants.kLLTransitionalSpeed,
      0,
        (LimeLight.getXCoord()+DriveConstants.kLL_LR_Offset)/DriveConstants.kLLTransitionalSpeed,0,
      true,false);
    }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_shuffle.shuffleboardMain();
        // m_driveTrain.setDrive(0.0, 0.0, 0.0,m_driveTrain.getFieldOriented());
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (LimeLight.getXCoord() < (DriveConstants.kLL_LR_Offset + DriveConstants.kLL_Tolerance) && LimeLight.getXCoord() > (DriveConstants.kLL_LR_Offset - DriveConstants.kLL_Tolerance)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}