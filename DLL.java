package DS;
import java.util.*;

class Node
{
	int data;
	Node next;
	Node prev;
	
	Node(int data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

class LinkedList
{
	Node head, tail;
	
	public void insertAtEnd(int data)
	{
		Node newNode = new Node(data);
		if(tail == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	public void insertAtBegin(int data)
	{
		Node newNode = new Node(data);
		if(head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}
	
	public void insertAtSpecific(int pos, int data)
	{
		Node newNode = new Node(data);
		Node temp = head;
		
		for(int i=0; i<pos-1; i++)
		{
			temp = temp.next;
		}
		newNode.next = temp.next;
		if(temp.next != null)
		{
			newNode.next.prev = newNode;
		}
		tail.next = newNode;
		newNode.prev = temp;
		
	}
	
	public void deleteAtEnd()
	{
		Node temp = head;
		tail.prev=tail;
		while(temp.next.next != null)
		{
			temp = temp.next;
		}
		temp.next = null;
	}
	
	public void deleteAtBegin()
	{
		if(head == null)
		{
			System.out.println("list is empty");
		}
		head = head.next;
		if(head != null)
		{
			head.prev = null;
		}
	}
	
	public void deleteAtSpecific(int pos)
	{
		if(head == null)
		{
			System.out.println("list is empty");
		}
		Node temp = head;
		if(pos == 0)
		{
			deleteAtBegin();
			return;
		}
		
		for(int i=0; temp != null && i<pos; i++)
		{
			temp = temp.next;
		}
		if(temp == null)
		{
			System.out.println("position out of bound");
		}
		if(temp.next == null)
		{
			deleteAtEnd();
			return;
		}
		temp.next.prev = temp.prev;
		temp.prev.next = temp.next;
		temp = null;
		
	}
	
	public void reverse()
	{
		if(head == null)
		{
			System.out.println("list is empty");
		}
		Node current = head;
		Node temp = null;
		
		while(current != null)
		{
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		
		if(temp != null)
		{
			head = temp.prev;
		}
	}
	
	public void removeDuplicates()
	{
		if(head == null)
		{
			System.out.println("list is empty");
		}
		Node current = head;
		while(current != null && current.next != null)
		{
			Node temp = current.next;
			while(temp != null && current.data == temp.data)
			{
				temp = temp.next;
			}
			current.next = temp;
			if(temp != null) 
			{
				temp.prev = current;
			}
			current = current.next;
		}
	}
	
	public void display()
	{
		Node temp = head;
		
		if(head == null)
		{
			System.out.println("list is empty");
		}
		
		while(temp != null)
		{
			System.out.print(temp.data);
			if(temp.next != null)
			{
				System.out.print("<->");
			}
			temp = temp.next;
		}
		System.out.println();
	}
	
}

public class DLL
{
	public static void main(String[] args)
	{
		LinkedList D = new LinkedList();
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the no.of.elements to be inserted: ");
		int n = scan.nextInt();
		System.out.println("enter the elements to be inserted: ");
		for(int i=0; i<n; i++)
		{
			int data = scan.nextInt();
			D.insertAtEnd(data);
			//D.insertAtBegin(data);
			//D.insertAtSpecific(data);
		}
		System.out.println("after insertion");
		D.display();
		System.out.println("Removing duplicates");
		D.removeDuplicates();
		D.display();
		System.out.println("after reversing");
		D.reverse();
		D.display();
		System.out.println("after deletion at begin");
		D.deleteAtBegin();
		D.display();
		System.out.println("after deletion at end");
		D.deleteAtEnd();
		D.display();
		System.out.println("enter the index of the element to be deleted");
		int pos = scan.nextInt();
		D.deleteAtSpecific(pos);
		D.display();
		
	}
}
