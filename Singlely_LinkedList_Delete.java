class Node 
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

class LinkedList
{
    Node head,tail;
    
   public void insertEnd(int data)
    {
        Node NewNode = new Node(data);
        if(head==null)
        {
            head=NewNode;
            tail = NewNode;
            
        }
        else
        {
            tail.next=NewNode;
            tail = NewNode;
        }
    }
    
    public void display()
    {
        Node temp = head;
        if(temp == null)
        {
            System.out.println("list is empty");
        }
        while(temp != null)
        {
            System.out.println(temp.data+" is inserted");
            temp = temp.next;
        }
    }
    
    public void insertAtBegining(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        
    }
    
    public void insertAtSpecific(int pos, int data)
    {
        Node newNode = new Node(data);
        Node temp = head;
        for(int i=0; i<pos-1; i++)
        {
            
            temp = temp.next;
            newNode.next = temp.next;
        }
        
        temp.next = newNode;
    }
    
    public void deleteAtBegin()
    {
        if(head == null)
        {
            head = head.next;
        }
    }
    
    public void deleteAtEnd()
    {
        Node temp = head;
        while(temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        LinkedList link = new LinkedList();
        link.insertEnd(10);
        link.insertEnd(20);
        link.insertEnd(30);
        link.insertAtBegining(01);
        link.insertAtSpecific(3, 250);
        link.deleteAtEnd();
        link.deleteAtBegin();
        link.display();
        
    }
}




    