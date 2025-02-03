/*
    CPU class takes a processes and runs the process for one cycle
    Execution is delayed to represent run time
*/
package ossimulation;

public class CPU
{
    //Finalize the cycle delay to 500
    private final int CYCLE_DELAY = 500;

    public void run(Process p) 
    {
        //Tick the processor
        p.tick();
        //Display the current process ID to the screen
        System.out.println("Running PID: " + p.getId());
        //Delay the processor
        delay();
    }

    private void delay() 
    {
        try 
        {
            //Pause the program for half a second
            Thread.sleep(CYCLE_DELAY);
        } 
        catch(InterruptedException ex) 
        {
            //Display an error to the user
            System.out.println("DELAY FAIL");
        }
    }
}