// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import frc.robot.commands.*;
import frc.robot.Constants;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.SendableCameraWrapper;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import java.util.function.DoubleSupplier;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class ShuffleboardSub extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    // public LED() {
    public ShuffleboardSub() {
        Shuffleboard.getTab("Automated");
        Shuffleboard.selectTab(2);
    }

    @Override
    public void periodic() {
        try {
        Shuffleboard.getTab("Automated")
        .add(SendableCameraWrapper.wrap("LLCamera", "http://10.2.50.26:5800"))
        .withWidget(BuiltInWidgets.kCameraStream)
        .withPosition(2, 0)
        .withSize(3, 3);
        Shuffleboard.getTab("Automated")
        .add("LL tx: ", LimeLight.getXCoord())
        .withPosition(0, 1)
        .getEntry();
        Shuffleboard.getTab("Automated")
        .add("LL ty: ", LimeLight.getYCoord())
        .withPosition(0, 2)
        .getEntry();
        Shuffleboard.getTab("Automated")
        .add("LL ts: ", LimeLight.getTs())
        .withPosition(0, 3)
        .getEntry();
        }
        catch (Exception e) {
        }
        Shuffleboard.update();
    }
    
    public void LLShuffleboard() {
        try {
        Shuffleboard.getTab("LimeLight")
        .add(SendableCameraWrapper.wrap("LLCamera", "http://10.2.50.26:5800"))
        .withWidget(BuiltInWidgets.kCameraStream)
        .withPosition(2, 0)
        .withSize(5, 5);
        Shuffleboard.selectTab(3);
        }
        catch (Exception e) {
        }
        Shuffleboard.update();
    }

    public void shuffleboardMain() {
        Shuffleboard.selectTab(3);
    }
}