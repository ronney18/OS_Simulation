
package Support;
import ossimulation.Process;

//The sorted linked queue inherits from the linked queue
public class SortedLinkedQueue extends LinkedQueue<Process>
{
    //Sort the nodes by cycle time after added to the queue
    public void enqueueSort(Process element)
    {
        //Create a new node that holds the new element
        LLNode<Process> newNode = new LLNode<>(element);
        //Assign null to the previous node
        LLNode<Process> previous = null;
        //Assign the front to the current node
        LLNode<Process> current = front;
        
        //Loop through the linked queue until the number of cycles is less than the current's cycles
        while((current != null) && (element.getCycles() >= current.getInfo().getCycles()))
        {
            //Assign current to the previous node
            previous = current;
            //Assign the next link to the current node
            current = current.getLink();
        }
        
        //Assign the new node to the front if both the previous and current node is null
        if((previous == null) && (current == null))
        {
            //Assign the new node to the front
            front = newNode;
        }
        
        else if(previous == null)
        {
            if(newNode.getInfo().getCycles() < current.getInfo().getCycles())
            {
                //Set the new node's link to the current node
                newNode.setLink(current);
                //Assign the new node to the front
                front = newNode;
            }
            
            else
            {
                //Set the current's link to the new node
                current.setLink(newNode);
            }
        }
        
        else
        {
            //Set the previous' link to the new node
            previous.setLink(newNode);
            //Assign the next link to the previous
            previous = previous.getLink();
            //Set the previous' link to the current node
            previous.setLink(current);
        }
    }
}
