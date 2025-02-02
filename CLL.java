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
			head = tail = newNode;
			tail.next = head;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}
	}
	
	public void insertAtBegin(int data)
	{
		Node newNode = new Node(data);
		if(head == null)
		{
			head = tail = newNode;
			tail.next = head;
		}
		else
		{
			newNode.next = head;
			head = newNode;
			tail.next = head;
			
		}
	}
	
	public void insertAtSpecific(int pos, int data)
	{
		Node newNode = new Node(data);
		if(head == null)
		{
			System.out.println(" list is empty");
		}
		Node temp = head;
		for(int i=0; i<pos-1; i++)
		{
			temp = temp.next;
			
			if(temp == head)
			{
				System.out.println("Position out of bounds");
			}
		}
		newNode.next = temp.next;
		temp.next = newNode;
		if(temp == tail)
		{
			tail = newNode;
		}
	}
	
	public void deleteAtBegin()
	{
		if(head == null)
		{
			System.out.println("List is empty");
		}
		if(head == tail)
		{
			head = null;
			tail = null;
		}
		else
		{
			head = head.next;
			tail.next = head;
		}
	}
	
	public void deleteAtEnd()
	{
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
		if(head == tail)
		{
			head = null;
			tail = null;
		}
		else
		{
			Node temp = head;
			while(temp.next != tail)
			{
				temp = temp.next;
			}
			temp.next = head;
			tail = temp;
		}
	}
	
	public void deleteAtSpecific(int pos)
	{
		if(head == null)
		{
			System.out.println("List is empty");
		}
		Node temp = head;
		for(int i=0; i<pos-1; i++)
		{
			temp = temp.next;
			if(temp == head)
			{
				System.out.println("position out of bounds");
			}
		}
		temp.next = temp.next.next;
		if(temp.next == head)
		{
			tail = temp;
		}
		
	}
	
	public void display()
	{
		if(head == null)
		{
			System.out.println("List is empty");
		}
		Node temp = head;
		do
		{
			System.out.print(temp.data);
			temp = temp.next;
			if(temp != head)
			{
				System.out.print("->");
			}
		}while(temp != head);
			System.out.println();
	}
	
	public void reverse()
	{
		if(head == null || head.next == head)
		{
			return;
		}
		Node temp = tail, current = head, next = null;
		do
		{
			next = current.next;
			current.next = temp;
			temp = current;
			current = next;
		}while(current != head);
		tail = head;
		head = temp;
		tail.next = head;
	}
	
	public void removeDuplicates()
	{
		if(head  == null)
		{
			return;
		}
		Node current = head;
		do
		{
			Node temp = current;
			while(temp.next != head)
			{
				if(temp.next.data == current.data)
				{
					temp.next = temp.next.next;
				}
				if(temp.next == head)
				{
					tail = temp;
				}
				else
				{
					temp = temp.next;
				}
			}
			current = current.next;
		}while(current != head);
	}
}

public class CLL
{
	public static void main(String[] args)
	{
		LinkedList C = new LinkedList();
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the no.of.elements to be inserted: ");
		int n = scan.nextInt();
		System.out.println("enter the elements to be inserted: ");
		for(int i=0; i<n; i++)
		{
			int data = scan.nextInt();
			C.insertAtEnd(data);
		}
		System.out.println("after insertion");
		C.display();
		System.out.println("Removing duplicates");
		C.removeDuplicates();
		C.display();
		System.out.println("after reversing");
		C.reverse();
		C.display();
		System.out.println("after deletion at begin");
		C.deleteAtBegin();
		C.display();
		System.out.println("after deletion at end");
		C.deleteAtEnd();
		C.display();
		System.out.println("enter the index of the element to be deleted");
		int pos = scan.nextInt();
		C.deleteAtSpecific(pos);
		C.display();
		
	}
}
