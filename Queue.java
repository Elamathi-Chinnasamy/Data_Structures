import java.util.*;

class Queue
{
    int a[] = new int[5];
    int front = -1;
    int rear = -1;
    
    public void enqueue(int data)
    {
        if(rear == a.length-1)
        {
            System.out.println("Queue is full");
        }
        else
        {
            if (front == -1) 
            {
                front = 0;
            }
            rear++;
            a[rear] = data;
        }
    }
    
    public void dequeue()
    {
        if(front == -1 && rear == -1)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            System.out.println("Removed element: " + a[front]);
            front++;
        }
    }
    
    public void peek()
    {
        
        if(front == -1 && rear == -1)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            System.out.println("The element in the top is: " +a[front]);
        }
    }
    
    public void reverse()
    {
        if(rear != -1)
        {
            System.out.println("Displaying the element  in reverse");
        for(int i=rear; i>=front; i--)
        {
            System.out.println(a[i]);
        }
        }
    }
    
    public void display()
    {
        if(rear != -1)
        {
            System.out.println("Displaying the element");
        for(int i=front; i<=rear; i++)
        {
            System.out.println(a[i]);
        }
        }
    }
    
}

public class Main
{
	public static void main(String[] args) 
	{
	    Queue q = new Queue();
	    q.enqueue(10);
	    q.enqueue(20);
	    q.enqueue(30);
	    q.enqueue(40);
	    q.enqueue(50);
	    q.display();
	    q.reverse();
	    q.peek();
	    q.dequeue();
	    q.display();
	}
}