class LinkedListDelDupRev
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
	public void createLinkedList(int arr[])
	{
		Node n=new Node();
		n.data=arr[0];
		head=n;
		for(int i=1;i<arr.length;i++)
		{
			Node node=new Node();
			node.data=arr[i];
			n.next=node;
			n=n.next;
		}
	}	
	public void displayLinkedList()
	{
		Node n=head;
		while(n!=null)
		{
			System.out.print(n.data+" ");
			n=n.next;
		}
		System.out.println();
	}
	private int countValues()
	{
		int count=-1;
		Node n=head;
		while(n!=null)
		{
			count++;
			n=n.next;
		}
		return count;
	}
	public int linkedListDelete(int index)
	{
		int x=-1;
		Node node=head;
		if(index<0 || index>countValues() || node==null)
			return x;
		for(int i=0;i<index-1;i++)
			node=node.next;
		if(index==0)
		{
			x=head.data;
			head=head.next;
		}
		else
		{
			x=node.next.data;
			node.next=node.next.next;
		}
		return x;
	}
	public boolean linkedListIsSorted()
	{
		Node node=head;
		int x=Integer.MIN_VALUE;
		while(node!=null)
		{
			if(node.data<x)
				return false;
			x=node.data;
			node=node.next;
		}
		return true;
	}
	public void linkedListDuplicateSorted()
	{
		Node node=head;
		int x=0;
		if(node==null)
			return;
		else
			x=node.data;
		node=node.next;
		while(node!=null)
		{
			boolean val=false;
			while(node!=null && node.data==x )
			{
				node=node.next;
				val=true;
			}
			if(val==true)
				System.out.print(x+" ");
			if(node!=null)
			{
				x=node.data;
				node=node.next;
			}
		}
	}
	public void linkedListDuplicateUnSorted()
	{
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		Node node=head;
		while(node!=null)
		{
			if(node.data<min)
				min=node.data;
			else if(node.data>max)
				max=node.data;
			node=node.next;
		}
		int arr[]=new int[max+1];
		node=head;
		while(node!=null)
		{
			arr[node.data]++;
			node=node.next;
		}
		for(int i=min;i<arr.length;i++)
			if(arr[i]>1)
				System.out.print(i+" ");
	}
	public void linkedListRemoveDuplicateSorted()
	{
		Node node=head;
		int x=0;
		if(node==null)
			return;
		else
			x=node.data;
		Node prev=node;
		node=node.next;
		while(node!=null)
		{
			while(node!=null && node.data==x)
				node=node.next;
			prev.next=node;
			if(node!=null)
			{
				x=node.data;
				prev=node;
				node=node.next;
			}
		}
	}
	public void linkedListRemoveDuplicateUnSorted()
	{
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		Node node=head;
		while(node!=null)
		{
			if(node.data<min)
				min=node.data;
			else if(node.data>max)
				max=node.data;
			node=node.next;
		}
		int arr[]=new int[max+1];
		int array[]=new int[max+1];
		node=head;
		while(node!=null)
		{
			arr[node.data]++;
			array[node.data]++;
			node=node.next;
		}
		Node prev=head;
		node=head.next;
		while(node!=null)
		{
			if(arr[node.data]==array[node.data] && node.data!=head.data)
			{
				prev.next=node;
				prev=node;
			}
			arr[node.data]--;
			node=node.next;
		}
		prev.next=null;
	}
	public void linkedListReverse()
	{
		Node p=head,q=null,r=null;
		while(p!=null)
		{
			r=q;
			q=p;
			p=p.next;
			q.next=r;
		}
		head=q;
	}
	public void LinkedListRecReverse(Node p,Node q)
	{
		if(p==null)
		{
			head=q;
			return;
		}	
		LinkedListRecReverse(p.next,p);
		p.next=q;
	}
	public static void main(String[] args)
	{
		int arr[]={1,1,1,1,1,1,2,3,3,4,4,4,5};
		LinkedListDelDupRev ll=new LinkedListDelDupRev();
		ll.createLinkedList(arr);
		ll.displayLinkedList();
		System.out.println("Value deleted at index 0 i.e "+ll.linkedListDelete(0));
		ll.displayLinkedList();
		System.out.println("Value deleted at index 4 i.e "+ll.linkedListDelete(4));
		ll.displayLinkedList();
		System.out.println("Value deleted at index 10 i.e "+ll.linkedListDelete(10));
		ll.displayLinkedList();
		System.out.println("LinkedList is Sorted ?  "+ll.linkedListIsSorted());
		System.out.println("Duplicate values are  ");
		ll.linkedListDuplicateSorted();
		System.out.println("\nDuplicate values Unsorted are  ");
		ll.linkedListDuplicateUnSorted();
		ll.linkedListRemoveDuplicateSorted();
		System.out.print("Value without Duplication Sorted ");
		ll.displayLinkedList();
		ll.linkedListRemoveDuplicateUnSorted();
		System.out.print("\nValue without Duplication UnSorted ");
		ll.displayLinkedList();
		ll.linkedListReverse();
		ll.displayLinkedList();
		ll.LinkedListRecReverse(ll.head,null);
		ll.displayLinkedList();
	}
}