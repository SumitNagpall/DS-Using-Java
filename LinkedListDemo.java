class LinkedListDemo
{
	Node head;
	class Node
	{
		int data;
		Node next;
		Node()
		{
			next=null;
		}
	}
	public void linkedListArray(int arr[])
	{
		if(arr.length==0)
			return;
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
	public void linkedListDisplay()
	{
		if(head==null)
			return;
		Node n=head;
		while(n!=null)
		{
			System.out.print(n.data+" ");
			n=n.next;
		}
		System.out.println();
	}
	public void linkedListReverse(Node node)
	{
		if(node==null)
			return;
		linkedListReverse(node.next);
		System.out.print(node.data+" ");
	}	
	public void linkedlistMax()
	{
		Node n=head;
		if(n==null)
			return;
		int max=n.data;
		n=n.next;
		while(n!=null)
		{
			if(n.data>max)
				max=n.data;
			n=n.next;
		}
		System.out.println("\nMax Value is "+max);
	}
	public int linkedlistRecursiveMax(Node node)
	{
		int max=0; 
		if(node==null)
			return Integer.MIN_VALUE;
		max=linkedlistRecursiveMax(node.next);
		return max>node.data?max:node.data;
	}

	public int linkedlistRecursiveMin(Node node)
	{
		if(node==null)
			return Integer.MAX_VALUE;
		int min=linkedlistRecursiveMax(node.next);
		return node.data<min?node.data:min;
	}
	public static void main(String[] args)
	{
		LinkedListDemo ll=new LinkedListDemo();
		int arr[]={1,2,3,4,5,0};
		ll.linkedListArray(arr);
		ll.linkedListDisplay();
		ll.linkedListReverse(ll.head);
		ll.linkedlistMax();
		System.out.println("Max value is "+ll.linkedlistRecursiveMax(ll.head));
		System.out.println("Max value is "+ll.linkedlistRecursiveMin(ll.head));
	}
}