/*
Michael Penta
An interface for a process scheduler
Your schedulers must implement this
*/
package ossimulation;

public interface ProcessScheduler
{
    //Implement the process to run
    public Process getProcessToRun();
    //Implement a scheduler process
    public void scheduleProcess(Process p);
}
