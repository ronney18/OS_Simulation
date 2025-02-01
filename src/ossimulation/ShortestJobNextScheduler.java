
package ossimulation;

import Support.SortedLinkedQueue;

public class ShortestJobNextScheduler implements ProcessScheduler
{
    //Declare a Sorted Linked Queue
    private SortedLinkedQueue q;
    //Declare a process to run 
    private Process processToRun;

    public ShortestJobNextScheduler() 
    {
        //Create a new Sorted Linked Queue
        q = new SortedLinkedQueue();
    }

    @Override
    public Process getProcessToRun() 
    {
        /*
            Shortest Job Next 
            Each processes are sorted based on the number of cycles.
            The process with the shortest number of cycles is in the front of 
            the queue and the process with the longest number of cycles is in 
            the back of the queue.
         */
        if(q.isEmpty() && (processToRun == null || processToRun.getCycles() <= 0)) 
        {
            //if so, then make an idle process that runs for a cycle
            processToRun = new Process("Idle", 1);
        } 
        else if(processToRun == null || processToRun.getCycles() <= 0) 
        {
            //noting was running or it is done, a new process is needed
            //Pull the next shortest job from the queue
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

    /*
        All new processes will be sortest from least number of cycles to greatest
        number of cycles on the queue
     */
    @Override
    public void scheduleProcess(Process p) 
    {
        //Display the scheduling process to the screen
        System.out.println("Scheduling PID " + p.getId());
        /*
            Add this new process to the queue and sort the queue from least 
            number of cycles to greatest number of cycles
        */
        q.enqueueSort(p);
    }

}
