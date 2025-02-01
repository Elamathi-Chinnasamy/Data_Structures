import java.util.*;

class Stack
{
    int a[] = new int[5];
    int top = -1;
    
    public void push(int data)
    {
        if(top == a.length-1)
        {
            System.out.println("Stack is full");
        }
        else
        {
            top++;
            a[top] = data;
        }
    }
    
    public void pop()
    {
        if(top == -1)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println("the list after deletion");
            top--;
        }
    }
    
    public void peek()
    {
        
        if(top == -1)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println("The element in the top is: " +a[top]);
        }
    }
    
    public void display()
    {
        if(top != -1)
        {
            System.out.println("Displaying the element");
        for(int i=top; i>=0; i--)
        {
            System.out.println(a[i]);
        }
        }
    }
    
    public void reverse()
    {
        if(top != -1)
        {
            System.out.println("Displaying the element in reverse");
        for(int i=0; i<=top; i++)
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
	    Stack s = new Stack();
	    s.push(10);
	    s.push(20);
	    s.push(30);
	    s.push(40);
	    s.push(50);
	    s.display();
	    s.reverse();
	    s.peek();
	    s.pop();
	    s.display();
	}
}
