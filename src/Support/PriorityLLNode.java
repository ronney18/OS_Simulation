
package Support;
//Include the Random library
import java.util.Random;

public class PriorityLLNode<T> extends LLNode<T>
{   
    //Store the priority integers to a variable
    private int priority;
    
    //Creating a priority node constructor
    public PriorityLLNode(T info)
    {
        //Call the constructor from the LLNode class
        super(info);
        //Create a random number generator
        Random rand = new Random();
        //Assign a random number from 1 to 3 to the priority number
        priority = 1 + rand.nextInt(3);
    }

    //Getting the priority number
    public int getPriority() 
    {
        //Return the priority number to the user
        return priority;
    }
}
