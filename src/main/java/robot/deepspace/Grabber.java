package robot.deepspace;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** Grabber for the hatch panel (disk)
 *  with solenoid to open/close.
 *  Sensor detects if hatch is on grabber.
 * 
 *  For cargo (ball), two spinner motors to pull
 *  ball in or push out.
 *  Sensor to detect ball.
 */
public class Grabber 
{
    private final Solenoid grabber = new Solenoid(RobotMap.GRABBER_SOLENOID);
    private final Solenoid extender = new Solenoid(RobotMap.EXTEND_SOLENOID);
    private final DigitalInput hatch_sensor = new DigitalInput(RobotMap.HATCH_SENSOR);

    //TODO 2 motors for intake wheels 
    //TODO One sensor in intake, should stop motors once cargo is detected
    //TODO Eject motor

    public Grabber() 
    {
        open(false);
    }

    public boolean isOpen()
    {
        return grabber.get();
    }

    /** Open/close
     *  @param is_open true to open, false to close
     */
    public void open(final boolean is_open)
    {
        grabber.set(is_open);

        SmartDashboard.putBoolean("Grabber Is Open", isOpen());
    }

    /** @param do_extend true to extend, false to pull in */
    public void extend(final boolean do_extend)
    {
        extender.set(do_extend);
    }

    /** @return true when hatch detected */
    public boolean isHatchDetected()
    {
        return hatch_sensor.get();
    }
}
