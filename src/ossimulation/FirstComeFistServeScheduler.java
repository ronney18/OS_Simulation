/*
    This is a first come first serve Process scheduler
    Each processes in the queue is run in the order
    in which they arrive and each process is run to completion before moving to next
    A queue is used to enforce FIFO order
*/
package ossimulation;

import Support.LinkedQueue;

class FirstComeFistServeScheduler implements ProcessScheduler
{   
    //Declare a Linked Queue
    private LinkedQueue<Process> q;
    //Declare a process to run 
    private Process processToRun;

    public FirstComeFistServeScheduler() 
    {
        //Create a new Linked Queue
        q = new LinkedQueue<>();
    }

    @Override
    public Process getProcessToRun() 
    {
        /*
            first come first serve. 
            if the running process can run, it will continue until finished
            otherwise get a new process to run
            if the queue is empty, run an idle process
         */

        if(q.isEmpty() && (processToRun == null || processToRun.getCycles() <= 0)) 
        {
            //if so, then make an idle process that runs for a cycle
            processToRun = new Process("Idle", 1);
        } 
        else if(processToRun == null || processToRun.getCycles() <= 0) 
        {
            //noting was running or it is done, a new process is needed
            //Remove a process from the queue
            processToRun = q.dequeue();
        } 
        else 
        {
            //continue to run the process that was running
        }
        //Display the current process to the screen
        System.out.println("ProcessToRun: " + processToRun);
        //Return the current process to the user
        return processToRun;
    }

    //All new processes go to the back of the queue
    @Override
    public void scheduleProcess(Process p) 
    {
        //Display the scheduling process to the screen
        System.out.println("Scheduling PID " + p.getId());
        //Add this new process to the back of the queue
        q.enqueue(p);
    }
}
