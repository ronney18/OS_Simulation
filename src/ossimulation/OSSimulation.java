/*  Michael Penta
 *  An OS simmulator with an interchangable process scheduler
 */
package ossimulation;
//Include the random library
import java.util.Random;

public class OSSimulation
{
    //Finalize the process scheduler to a variable
    private final ProcessScheduler scheduler;
    //Finalize the CPU to a variable
    private final CPU cpu;
    //Initialize the new process rate to 0.09
    private double newProcessRate = 0.09;

    public OSSimulation(ProcessScheduler s)
    {
        //Create a new CPU
        cpu = new CPU();
        //Assign the process scheduler to the scheduler variable
        scheduler = s;
    }
    /*
     Each cycle of simulation starts with a 
     chance that new processes are generated
     Then a process is fetched from the scheduler 
     that process is run on the cpu for one cycle
     */

    public void simulate(int cyclesToSimulate)
    {
        //Create a random number generator
        Random rand = new Random();
        //Display the number of cycles to simulate to the screen
        System.out.println("CYCLES TO SIMULATE : " + cyclesToSimulate);
        //Schedule a system start up at the beginning of the program
        scheduler.scheduleProcess(new Process("SystemStartUp", 10));

        //Schedule a new process until the number of cycles reaches zero
        while (cyclesToSimulate > 0)
        {
            //Schedule a new random process if the random number is less than the new process rate
            if (rand.nextDouble() < newProcessRate)
            {
                //Schedule a new random process
                scheduler.scheduleProcess(this.getRandomProcess());
            }
            //Assign the new process to run to the process
            Process p = scheduler.getProcessToRun();
            //Run the new process to the CPU
            cpu.run(p);
            //Decrement the number of cycles by 1
            --cyclesToSimulate;
            //Display the number of cycles remaining to the screen
            System.out.println("CYCLES REMAINING: " + cyclesToSimulate);
        }
    }

    /*
     Generate a processes with a random number of cycyles
     Three types of processes are named
     */
    public Process getRandomProcess()
    {
        //Create a random number generator
        Random rand = new Random();
        //Assign a random number between 5 and 19 to the number of cycles
        int numOfCycles = 5 + rand.nextInt(15);
        //Assign a random number between 0 and 2 to the type decider
        int typeDecider = rand.nextInt(3);
        Process p;

        //If the type decider is equal to 0
        if (typeDecider == 0)
        {
            //Assign an Admin process to the current processor
            p = new Process("Admin", numOfCycles);
        }
        else
        {
            //If the type decider is equal to 1
            if (typeDecider == 1)
            {
                //Assign a System process to the current processor
                p = new Process("System", numOfCycles);
            }
            //If the type decider is equal to 2
            else
            {
                //Assign a User process to the current processor
                p = new Process("User", numOfCycles);
            }
        }
        //Return the current processor to the user
        return p;
    }

    public double getNewProcessRate()
    {
        //Return the new process rate to the user
        return newProcessRate;
    }

    public void setNewProcessRate(double newProcessRate)
    {
        //Set the process rate to the variable
        this.newProcessRate = newProcessRate;
    }

}
