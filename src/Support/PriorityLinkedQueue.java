
package Support;
import ossimulation.Process;

//The priority linked queue inherits from the linked queue
public class PriorityLinkedQueue extends LinkedQueue<Process>
{
    public void enqueuePriority(Process element)
    {
        //Create a new priority node that holds the new element
        PriorityLLNode<Process> newNode = new PriorityLLNode(element);
        //Assign null to the previous node
        PriorityLLNode<Process> previous = null;
        //Assign the front to the current node
        PriorityLLNode<Process> current = (PriorityLLNode<Process>) front;
        
        //Loop through the linked queue until the priority number is greater than the current's number
        while((current != null) && (newNode.getPriority() >= current.getPriority()))
        {
            //Assign current to the previous node
            previous = current;
            //Assign the next link to the current node
            current = (PriorityLLNode<Process>) current.getLink();
        }
        
        //Assign the new node to the front if both the previous and current node is null
        if((previous == null) && (current == null))
        {
            //Assign the new node to the front
            front = newNode;
        }
        
        else if(previous == null)
        {
            if(newNode.getPriority() < current.getPriority())
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
            previous = (PriorityLLNode<Process>) previous.getLink();
            //Set the previous' link to the current node
            previous.setLink(current);
        }
    }
}
