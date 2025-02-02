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
	
	public void deleteAtBegin()
	{
		if(head != null)
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
	
	public void deleteAtSpecific(int pos)
	{
		Node temp = head;
		for(int i=0; i<pos-1; i++)
		{
			temp = temp.next;
		}
		temp.next = temp.next.next;
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
			System.out.print(" displaying the elements: ");
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
	
	public void reverse()
	{
		Node current = head;
		Node temp = null;
		Node next = null;
		while(current != null)
		{
			next = current.next;
			current.next = temp;
			temp = current;
			current = next;
		}
		head = temp;
	}
	
	public void removeDuplicates()
	{
		Node current = head;
		while(current != null)
		{
			Node temp = current;
			while(temp.next != null)
			{
				if(temp.next.data == current.data)
				{
					temp.next = temp.next.next;
				}
				else
				{
					temp = temp.next;
				}
			}
			current = current.next;
		}
	}
}

public class SLL
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
		}
		System.out.println("after insertion");
		L.display();
		System.out.println("Removing duplicates");
		L.removeDuplicates();
		L.display();
		System.out.println("after reversing");
		L.reverse();
		L.display();
		System.out.println("after deletion at begin");
		L.deleteAtBegin();
		L.display();
		System.out.println("after deletion at end");
		L.deleteAtEnd();
		L.display();
		System.out.println("enter the index of the element to be deleted");
		int pos = scan.nextInt();
		L.deleteAtSpecific(pos);
		L.display();
		
	}
}
