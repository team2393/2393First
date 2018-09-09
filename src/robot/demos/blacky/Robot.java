package robot.demos.blacky;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.BasicRobot;

public class Robot extends BasicRobot
{
    private final static double max_speed = 0.2;

    // Subsystems, Components
    public static Wheels wheels = new Wheels();
    public static Gyro gyro = new ADXRS450_Gyro();
    
    // Commands
    private Command jog = new SmoothMove(0.3, 0.6, 7.0);
    private Command forward = new Move(max_speed, -1);
    private Command left = new Turn(-max_speed/2, -1);
    private Command rock = new RocknRoll(max_speed, -1);
    private Command wiggle = new Wiggle(max_speed, -1);
    private Command hold = new HoldHeading();
    
    @Override
    public void robotInit ()
    {
        super.robotInit();
        System.out.println("Left and right wheels connected to PWM " + RobotMap.PWM_LEFT + " resp. " + RobotMap.PWM_RIGHT);
        
        // Publish commands to allow control from dashboard
        SmartDashboard.putData("Jog", jog);
        SmartDashboard.putData("Forward", forward);
        SmartDashboard.putData("Left", left);
        SmartDashboard.putData("Rock'n'Roll", rock);
        SmartDashboard.putData("Wiggle", wiggle);
        SmartDashboard.putData("Hold Heading", hold);
    }

    @Override
    public void robotPeriodic()
    {
        Scheduler.getInstance().run();
    }
    
    @Override
    public void autonomousInit()
    {
        super.autonomousInit();
        CommandGroup moves = new CommandGroup();
        moves.addSequential(new SmoothMove(0.25, 1.0, 3.0));
        moves.addSequential(new SmoothMove(0.5, 1.0, 5.0));
        moves.addSequential(new SmoothMove(0.1, max_speed, 5.0));
        moves.addSequential(new Wiggle(0.3, 2.0));
        moves.addSequential(new SmoothMove(0.1, -max_speed/2, 3.0));
        moves.addSequential(new RocknRoll(0.3, 3.0));
        moves.start();
    }
    
    // In teleop, use dashboard to trigger commands
}
