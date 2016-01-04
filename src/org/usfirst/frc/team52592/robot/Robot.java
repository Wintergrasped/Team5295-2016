
package org.usfirst.frc.team52592.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	int CC = 0;
	
	int BSTOP = 0;
	int TSTOP= 1;
	
	boolean Flash = false;
	boolean MEnabled = true;
	boolean LED = false;
	boolean TopStop = false;
	boolean BottomStop = false;
	
	RobotDrive Robo;
	Joystick J1 = new Joystick(0);
	Joystick J2 = new Joystick(1);
	
	Talon LF = new Talon (0);
	Talon RF = new Talon (1);
	Talon LR = new Talon (2);
	Talon RR = new Talon (3);
	
	PWM RE = new PWM(8);
	PWM GR = new PWM(9);
	PWM BL = new PWM(7);
	
	Button A = new JoystickButton(J1, 1);
	Button B = new JoystickButton(J1, 2);
	Button X = new JoystickButton(J1, 3);
	Button Y = new JoystickButton(J1, 4);
	Button LB = new JoystickButton(J1, 5);
	Button RB = new JoystickButton(J1, 6);
	Button JB1 = new JoystickButton(J1, 9);
	Button JB2 = new JoystickButton(J1, 10);
	
	Button BACK = new JoystickButton(J1, 7);
	Button START = new JoystickButton(J1, 8);

	AnalogInput BStop = new AnalogInput(BSTOP);
	AnalogInput TStop = new AnalogInput(TSTOP);
	
	DigitalOutput D1 = new DigitalOutput(0);

    public void robotInit() {
    	J1.getRawAxis(2);
    }

    public void autonomousPeriodic() {

    }
    
    public void teleopPeriodic() {
    	double LL = J1.getThrottle()-J1.getThrottle()*2;
    	boolean Buttoned = false;

    	if (A.get() == true) {
    		if (Y.get()==true){
    			
    		}else{
    		RoboDrive("reverse");
    		Buttoned = true;
    		}
    	}
    	if (B.get() == true){
    		if (Y.get() == true){
    			RoboDrive("straif right");
    		}else{
    		RoboDrive("turn right");
    		Buttoned = true;
    		}
    		Buttoned = true;
    	}
    	if (X.get() == true){
    		if (Y.get() == true){
    			RoboDrive("straif left");
    		}else{
    		RoboDrive("turn left");
    		Buttoned = true;
    		}
    		Buttoned = true;
    	}
    		
    	if(Buttoned == false){
    		if (MEnabled == true) {
    			LF.set(J1.getThrottle());
    			LR.set(J1.getThrottle());
        		RF.set(LL);
        		RR.set(LL);
    		}else{
    			LF.set(0);
    			LR.set(0);
        		RF.set(0);
        		RR.set(0);
    		}
    	}
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
    
public void RoboDrive(String Direction) {
	double LL = J1.getThrottle()-J1.getThrottle()*2;
	boolean Buttoned = false;
	String D = Direction;
	
	if (D == "forward") {
		LF.set(J1.getThrottle());
		LR.set(J1.getThrottle());
		
		RF.set(LL);
		RR.set(LL);
	}else if (D == "reverse") {
		LF.set(LL);
		LR.set(LL);
		
		RF.set(J1.getThrottle());
		RR.set(J1.getThrottle());
	}else if (D == "turn left") {
		LF.set(LL);
		LR.set(LL);
		
		RF.set(LL);
		RR.set(LL);
	}else if (D == "turn right") {
		LF.set(J1.getThrottle());
		LR.set(J1.getThrottle());
		
		RF.set(J1.getThrottle());
		RR.set(J1.getThrottle());
	}else if (D == "straif right") {
		LF.set(J1.getThrottle());
		LR.set(LL);
		
		RF.set(J1.getThrottle());
		RR.set(LL);
	}else if (D == "straif left") {
		LF.set(LL);
		LR.set(J1.getThrottle());
		
		RF.set(LL);
		RR.set(J1.getThrottle());
	}
	
	
}
}
