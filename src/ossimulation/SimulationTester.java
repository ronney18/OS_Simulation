/*
    Name: Ronney Sanchez
    Date: 4/6/17
    Course: CIS252 Computer Science II
    Program: Project 2 (Operating System Simulation)
    Description: This program simulates an operating system. Where new process
    schedulers come and the program uses different algorithm to sort these process
    schedulers and execute in a given number of cycles.
*/
package ossimulation;

public class SimulationTester
{
    public static void main(String[] args)
    {
        System.out.println("This is the FIRST COME FIRST SERVE process scheduler.\n");
        //Create a process scheduler that uses the First Come First Serve algorithm
        ProcessScheduler firstScheduler = new FirstComeFistServeScheduler();
        //Create a new operating system simulation
        OSSimulation os1 = new OSSimulation(firstScheduler);
        //Simulate the operating system for 50 cycles
        os1.simulate(150);
        
        System.out.println("\nThis is the ROUND ROBIN process scheduler.\n");
        //Create a process scheduler that uses the Round Robin algorithm
        ProcessScheduler secondScheduler = new RoundRobinScheduler();
        //Create a new operating system simulation
        OSSimulation os2 = new OSSimulation(secondScheduler);
        //Simulate the operating system for 50 cycles
        os2.simulate(150);
        
        System.out.println("\nThis is the SHORTEST JOB NEXT process scheduler.\n");
        //Create a process scheduler that uses the Shortest Job Next algorithm
        ProcessScheduler thirdScheduler = new ShortestJobNextScheduler();
        //Create a new operating system simulation
        OSSimulation os3 = new OSSimulation(thirdScheduler);
        //Simulate the operating system for 50 cycles
        os3.simulate(150);
      
        System.out.println("\nThis is the PRIORITY QUEUE process scheduler.\n");
        //Create a process scheduler that uses the Priority Queue algorithm
        ProcessScheduler forthScheduler = new PriorityQueueScheduler();
        //Create a new operating system simulation
        OSSimulation os4 = new OSSimulation(forthScheduler);
        //Simulate the operating system for 50 cycles
        os4.simulate(150);
    } 
}

/*
    Completion:
    This program required a lot of thinking of how to create different schedulers
    to sort the process in a specified way. The idea was easy to think of but
    it took time to think about how to write the algorithm in code. Once the
    code was well thought out, the scheduling program was easy to implement. Its
    the thinking of the scheduling algorithm that takes time to imlement.
*/
