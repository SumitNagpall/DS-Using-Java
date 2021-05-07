class LinkedListInsertSort
{
	Node head=null;
	class Node
	{
		int data;
		Node next;
		Node()
		{
			next=null;
		}
	}
	private int totalCount()
	{
		int count=0;
		Node node=head;
		while(node!=null)
		{
			count++;
			node=node.next;
		}
		return count;
	}
	public void linkedListInsert(int i,int x)
	{
		if(i<0 || i>totalCount())
			return;
		Node n=new Node();
		n.data=x;
		Node node=head;
		for(int j=0;j<i-1;j++)
			node=node.next;
		if(i==0)
		{
			n.next=head;
			head=n;
		}
		else
		{
			n.next=node.next;
			node.next=n;
		}
	}
	public void display(Node node)
	{
		if(node==null)
			return;
		System.out.print(node.data+" ");
		display(node.next);
	}
	public int linkedListSearch(int x)
	{
		int index=-1;
		Node node=head;
		while(node!=null)
		{
			if(node.data==x)
			{
				index++;
				break;
			}
			node=node.next; 
		}		
		return index;
	}
	public void LinkedListInsertSorted(int x)
	{
		Node node=head;
		Node n=new Node();
		n.data=x;
		if(node==null)
			head=n;
		else
		{
			while(node.next!=null && node.next.data<x)
				node=node.next;
			if(node==head && node.data>x)
			{
				n.next=head;
				head=n;
			}
			else
			{
				n.next=node.next;
				node.next=n;
			}
		}
	}
	public void linkedListMove2First(int x)
	{
		Node node=head;
		while(node.next!=null)
		{
			if(node.next.data==x)
			{
				Node temp=head;
				head=node.next;
				node.next=node.next.next;
				head.next=temp;
				break;
			}
			node=node.next;
		}
	}
	public static void main(String[] args)
	{
		LinkedListInsertSort ll = new LinkedListInsertSort();
		ll.linkedListInsert(0,2);
		ll.linkedListInsert(1,3);
		ll.linkedListInsert(2,4);
		ll.linkedListInsert(0,1);
		ll.linkedListInsert(4,5);
		ll.linkedListInsert(10,10);
		ll.display(ll.head);
		System.out.println("\nValue present at index "+ll.linkedListSearch(1));
		ll.LinkedListInsertSorted(40);
		ll.LinkedListInsertSorted(34);
		ll.LinkedListInsertSorted(42);
		ll.LinkedListInsertSorted(16);
		ll.LinkedListInsertSorted(47);
		ll.LinkedListInsertSorted(56);
		ll.LinkedListInsertSorted(23);
		ll.display(ll.head);
		ll.linkedListMove2First(56);
		ll.linkedListMove2First(16);
		ll.linkedListMove2First(17);
		System.out.println();
		ll.display(ll.head);
	}
}