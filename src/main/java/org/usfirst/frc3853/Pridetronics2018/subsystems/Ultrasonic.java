package org.usfirst.frc3853.Pridetronics2018.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;

public class Ultrasonic
{
	private double _voltsPerMillimeter = 0;
	
	// SensorType:  1 = Short, 2 = Long, default to 1.  Set in class instantiation. 
	private int _sensorType = 1;
	
	// Which Analog Input is our sensor wired to?  Default to zero.  Set in class instantiation. 
	private int _analogInputPosition = 0;
	
	// Create a reference to the AnalogSensor
	AnalogInput _ai; // = new AnalogInput(_analogInputPosition);
	
	//Create our Constructor, taking in the SensorType and AnalogInputPosition 
	public Ultrasonic (int SensorType, int AnalogInputPosition)
	{
		_sensorType = SensorType;
		_analogInputPosition = AnalogInputPosition;
		
		_ai = new AnalogInput(_analogInputPosition);
		
		if (SensorType == 1) //Short
		{
			_voltsPerMillimeter = .001;
		}
		else // "Long"
		{
			_voltsPerMillimeter = 0.00065359477124183;
		}
		
	}

	public void SetSensorType(int SensorType)
	{
		_sensorType = SensorType;
	}
	
	public double GetRawSensorVoltage()
	{
		double voltageValue = 0;
		_ai.setGlobalSampleRate(4);

		voltageValue = _ai.getVoltage();
		
		return voltageValue;
	}
	
	public double GetDistanceInMillimeters()
	{
		double distance = 0;
		
		distance = _voltsPerMillimeter * this.GetRawSensorVoltage();
		return distance;
	}

	public double GetDistanceInMeters()
	{
		double distance = 0;
		double distanceInMillimeters = this.GetDistanceInMillimeters();
		
		distance = distanceInMillimeters / 1000; // 1000 MM in a M
		
		return distance;
	}
	
	public double GetDistanceInInches()
	{
		double distance = 0;
		double distanceInMillimeters = this.GetDistanceInMillimeters();
		
		distance = distanceInMillimeters / 25.4; // 25.4 mm in an inch
		
		return distance;
	}
	
	public double GetDistanceInFeet()
	{
		double distance = 0;
		double distanceInMillimeters = this.GetDistanceInMillimeters();
		
		distance = distanceInMillimeters / 304.8; // 304.8 mm in a foot
		
		return distance;
	}
	
}
