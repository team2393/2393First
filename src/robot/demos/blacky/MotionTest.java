package robot.demos.blacky;

import static first.Testing.assertEquals;

public class MotionTest
{
    public static void main(String[] args)
    {
        // Don't reach full speed
        System.out.println("Short move, not reaching 0.3");
        MotionCurve motion = new MotionCurve(0.1, 0.3, 3.0);
        for (double t=0.0; t<=3.1; t += 0.1)
            System.out.format("%3.2f %5.3f\n", t, motion.getSpeed(t));
        assertEquals(0.000, motion.getSpeed(0), 0.01);
        assertEquals(0.150, motion.getSpeed(1.5), 0.01);
        assertEquals(0.000, motion.getSpeed(10.0), 0.01);

        // Reach full speed after 3 sec, run until 7 sec, then break
        System.out.println("\nLonger move, reaching 0.3");
        motion = new MotionCurve(0.1, 0.3, 10.0);
        for (double t=0.0; t<=10.1; t += 0.1)
            System.out.format("%3.2f %5.3f\n", t, motion.getSpeed(t));
        assertEquals(0.0, motion.getSpeed(0), 0.01);
        assertEquals(0.3, motion.getSpeed(3.5), 0.01);
        assertEquals(0.3, motion.getSpeed(6.9), 0.01);
        assertEquals(0.0, motion.getSpeed(10.0), 0.01);

        System.out.println("\nReverse move");
        motion = new MotionCurve(0.1, -0.3, 10.0);
        for (double t=0.0; t<=10.1; t += 0.1)
            System.out.format("%3.2f %5.3f\n", t, motion.getSpeed(t));
        assertEquals(0.0, motion.getSpeed(0), 0.01);
        assertEquals(-0.3, motion.getSpeed(3.5), 0.01);
        assertEquals(-0.3, motion.getSpeed(6.9), 0.01);
        assertEquals(0.0, motion.getSpeed(10.0), 0.01);
    }
}
