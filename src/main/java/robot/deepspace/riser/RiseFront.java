package robot.deepspace.riser;

import edu.wpi.first.wpilibj.command.Command;
import robot.deepspace.OI;

public class RiseFront extends Command
{
    private final Riser riser;

    public RiseFront(Riser riser) 
    { 
        requires(riser);
        this.riser = riser;
    }

    @Override
    protected void execute() 
    {
        riser.dropBack(true);
        riser.dropFront(false);
        riser.setSpeed(OI.getSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished()
    {
        return false;
    }
}
