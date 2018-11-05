package meetups;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import robot.subsystems.DriveSubsystem;

public class EncoderMoveCommand extends Command
{
    private final DriveSubsystem drive;
    private final Encoder encoder;
    private final double position;

    /** Command that moves to desired position
     *  @param drive Motors
     *  @param encoder Encoder that tells us about current position
     *  @param position Desired position
     */
    public EncoderMoveCommand(DriveSubsystem drive, Encoder encoder, double position)
    {
        this.drive = drive;
        this.encoder = encoder;
        this.position = position;
    }

    @Override
    protected void execute()
    {
        // TODO Compute drive speed based on encoder and desired position
    }

    @Override
    protected boolean isFinished()
    {
        // TODO What should we return here?
        return false;
    }

    @Override
    protected void end()
    {
        // TODO Turn motors off
    }
}