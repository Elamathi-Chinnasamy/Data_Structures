package DS;
import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}

class LinkedList
{
	Node head, tail;
	
	public void insertAtEnd(int data)
	{
		Node newNode = new Node(data);
		
		if(head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void insertAtBegin(int data)
	{
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		//System.out.println(head); for address of head
	}
	
	public void insertAtSpecific(int pos, int data)
	{
		Node newNode = new Node(data);
		Node temp = head;
		for(int i=0; i<pos-1; i++)
		{
			temp = temp.next;
		}
		if(temp == null) 
		{
			System.out.println("position out of bounds");
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	public void display()
	{
		if(head == null)
		{
			System.out.println("List is empty");
		}
		else
		{
			Node temp = head;
			System.out.println("displaying the elements: ");
			while(temp != null)
			{
				System.out.print(temp.data);
				if(temp.next != null)
				{
					System.out.print("->");
				}
				temp = temp.next;
			}
			System.out.println();
		}
	}
}

public class Main 
{
	public static void main(String[] args)
	{
		LinkedList L = new LinkedList();
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the no.of.elements to be inserted: ");
		int n = scan.nextInt();
		System.out.println("enter the elements to be inserted: ");
		for(int i=0; i<n; i++)
		{
			int data = scan.nextInt();
			L.insertAtEnd(data);
			/*
			L.insertAtBegin(data);
			L.insertAtSpecific(data);
			*/
		}
		L.display();
	}
}
