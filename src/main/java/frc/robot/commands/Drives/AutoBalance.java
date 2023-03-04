package frc.robot.commands.Drives;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LimeLight;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.Constants;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;

public class AutoBalance extends CommandBase {
    private boolean isFinished = false;
    private final DriveTrain m_driveTrain;
    private PIDController balanceController = new PIDController(AutoConstants.kDrivingP, AutoConstants.kDrivingI, AutoConstants.kDrivingD);
    
    public AutoBalance(DriveTrain subsystem) {

        m_driveTrain = subsystem;
        addRequirements(m_driveTrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_driveTrain.setDrive(balanceController.calculate(m_driveTrain.getPitch(),0), 0, 0, true, false);
    }



    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return balanceController.atSetpoint();
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
