
package ossimulation;
import Support.PriorityLinkedQueue;

public class PriorityQueueScheduler implements ProcessScheduler
{
    //Declare a priority linked queue
    private PriorityLinkedQueue q;
    //Declare a process to run
    private Process processToRun;
    
    public PriorityQueueScheduler() 
    {
        //Create a new Priority Linked Queue
        q = new PriorityLinkedQueue();
    }

    @Override
    public Process getProcessToRun() 
    {
        /*
            Priority Queue 
            The queue is sorted based on the priority nodes. The node with the
            first priority goes to the front and the node with the third priority
            goes to the back.
         */
        if(q.isEmpty() && (processToRun == null || processToRun.getCycles() <= 0)) 
        {
            //if so, then make an idle process that runs for a cycle
            processToRun = new Process("Idle", 1);
        } 
        else if(processToRun == null || processToRun.getCycles() <= 0) 
        {
            //noting was running or it is done, a new process is needed
            //Remove the next priority node from the queue
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

    @Override
    public void scheduleProcess(Process p) 
    {
        //Display the scheduling process to the screen
        System.out.println("Scheduling PID " + p.getId());
        //Add this new scheduler to the queue and sort the queue from first to third priority
        q.enqueuePriority(p);
    }
}
