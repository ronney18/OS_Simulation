/*
Michael Penta
A process with a number of cycles it requres, a unique ID, and a name
A toString method is availabe 

*/
package ossimulation;

public class Process
{
    //Initialize the next ID to 0
    private static int NEXT_ID = 0;
    //Store the number of cycles to a variable
    private int cycles;
    //Store the ID number to a variable
    private int id;
    //Store the process name to a variable
    private String name;

    public Process(String name, int time) 
    {
        //Assign the time to the cycles
        cycles = time;
        //Assign the name to the process name
        this.name = name;
        //Assign the next ID to the process ID
        this.id = NEXT_ID++;
    }

    public void tick() 
    {
        //Decrement the number of cycles by 1
        cycles--;
    }

    public void setCycles(int cycles) 
    {
        //Set the number of cycles to the user's cycle
        this.cycles = cycles;
    }

    public int getCycles() 
    {
        //Return the number of cycles to the user
        return cycles;
    }

    public void setName(String s) 
    {
        //Set the process' name to the name
        name = s;
    }

    public String getName() 
    {
        //Return the process name to the user
        return name;
    }

    public int getId() 
    {
        //Return the process ID to the user
        return id;
    }

    public void setId(int id) 
    {
        //Set the process' ID to the given id
        this.id = id;
    }

    @Override
    public String toString() 
    {
        //Return the formatted string of the processor to the user
        return name + " Process, Processes ID = " + id + ", Cycles remaining = " + cycles + '\n';
    }
    
}