
package ossimulation;

import Support.LinkedQueue;

public class RoundRobinScheduler implements ProcessScheduler
{
    //Declare a Linked Queue
    private LinkedQueue<Process> q;
    //Declare a process to run
    private Process processToRun;
    //Store the number of turns to a variable
    private int numberOfTurns;

    public RoundRobinScheduler() 
    {
        //Create a new Linked Queue
        q = new LinkedQueue<>();
        //Initialize the number of turns to 5
        numberOfTurns = 5;
    }

    @Override
    public Process getProcessToRun() 
    {
        /*
            Round Robin
            Each processes will get 5 cycles to run.
            If the process is not done, it will pause and move to the back of the 
            queue for the other processes to take 5 turns.
        */

        if(q.isEmpty() && (processToRun == null || processToRun.getCycles() <= 0)) 
        {
            //if so, then make an idle process that runs for a cycle
            processToRun = new Process("Idle", 1);
        } 
        else if(processToRun == null || processToRun.getCycles() <= 0) 
        {
            //noting was running or it is done, a new process is needed
            //Remove aprocess from the queue
            processToRun = q.dequeue();
            //Re-initialize the number of turns to 5
            numberOfTurns = 5;
        } 
        else 
        {
            //continue to run the process that was running
            //Decrement the number of turns by 1
            numberOfTurns--;
        }
        //Display the current process to the screen
        System.out.println("ProcessToRun: " + processToRun);
        if((numberOfTurns <= 0) && (processToRun.getCycles() > 0))
        {
            //Move the current process to the back of the queue
            q.enqueue(processToRun);
            //Pull a new process from the queue
            processToRun = q.dequeue();
            //Re-initialize the number of turns to 5
            numberOfTurns = 5;
        }
        //Return the current process to the user
        return processToRun;
    }

    @Override
    public void scheduleProcess(Process p) 
    {
        //Display the scheduling process to the screen
        System.out.println("Scheduling PID " + p.getId());
        //Add this new process to the back of the queue
        q.enqueue(p);
    }
}
