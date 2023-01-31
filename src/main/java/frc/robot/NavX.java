package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.SerialPort;

public class NavX {
	SerialPort serial;
	private AHRS imu;
	// IMUAdvanced imu;
	
	public NavX(){
		try {
			// serial = new SerialPort(57600, SerialPort.Port.kMXP);
			imu = new AHRS(SPI.Port.kMXP);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		// if (imu != null) {
		// 	LiveWindow.addSensor("IMU", "gyro", imu);
		// }
	}
	
	public float getYaw() {
		return -imu.getYaw();
	}
	
	public double getRate() {
		return imu.getRate();
	}

	public boolean isCalibrating() {
		return imu.isCalibrating();
	}

	public void test () {
		System.out.println(
				"Pitch: " + Math.round(imu.getPitch()) +
				" Roll: " + Math.round(imu.getRoll()) +
				" Yaw: " + Math.round(imu.getYaw())
				);
		
	}
	
	public void zeroYaw() {
		imu.zeroYaw();
	}
}
