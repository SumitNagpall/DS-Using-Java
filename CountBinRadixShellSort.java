class CountBinRadixShellSort
{
	class Node
	{
		Node head;
		Node tail;
		int data;
		Node next;
		Node()
		{
			this.next=null;
		}
	}
	private int max(int arr[])
	{
		int maxValue=arr[0];
		for(int i=1;i<arr.length;i++)
			if(arr[i]>maxValue)
				maxValue=arr[i];
		return maxValue;
	}
	public void countSort(int arr[])
	{
		int array[] = new int[max(arr)+1];
		for(int i=0;i<arr.length;i++)
			array[arr[i]]++;
		int i=0,j=0;
		while(i<array.length)
		{
			if(array[i]>0)
			{
				arr[j++]=i;
				array[i]--;
			}
			else
				i++;
		}
	}
	public void binBucketSort(int arr[])
	{
		Node nodeArray[] = new Node[max(arr)+1];
		for(int i=0;i<arr.length;i++)
		{
			Node n = new Node();
			n.data=arr[i];
			if(nodeArray[arr[i]]==null)
			{
				n.head=n;
				n.tail=n;
				nodeArray[arr[i]]=n;
			}
			else
			{
				nodeArray[arr[i]].tail.next=n;
				nodeArray[arr[i]].tail=n;
			}
		}
		int i=0,j=0;
		while(i<nodeArray.length)
		{
			if(nodeArray[i]!=null)
			{
			    Node n = nodeArray[i].head;
			    while(n!=null)
				{
				    arr[j++]=n.data;
					n=n.next;
				}
			}
			i++;
		}

	}
	public void radixSort(int arr[])
	{
		Node nodeArray[] = new Node[10]; //Radix -> Decimal Value
		
		for(int k=0;k<(int)Math.log10(23)+1;k++)
		{
			for(int i=0;i<arr.length;i++)
			{
				Node n=new Node();
				n.data=arr[i];
				int x=arr[i]/(int)Math.pow(10,k)%10;
				if(nodeArray[x]==null)
				{
					n.head=n;
					n.tail=n;
					nodeArray[x]=n;
				}
				else
				{
					nodeArray[x].tail.next=n;
					nodeArray[x].tail=n;
				}
			}
		
			int i=0,j=0;
			while(i<nodeArray.length)
			{
				if(nodeArray[i]!=null)
				{
				    Node n = nodeArray[i].head;
				    while(n!=null)
					{
						arr[j++]=n.data;
						n=n.next;
					}
				}
				i++;
			}
			for(int l=0;l<nodeArray.length;l++)
				nodeArray[l]=null;
		}	
	}
	private void swap(int arr[],int i,int j)
	{
		arr[j]=arr[i]+(arr[i]=arr[j])-arr[j];
	}
	public void shellSort(int arr[])
	{
		int gap=arr.length/2;
		while(gap>0)
		{	for(int i=0;i+gap<arr.length;i+=gap)
			{
				if(arr[i]>arr[i+gap])
					swap(arr,i,i+gap);
				int j=i;
				while(j-gap>=0 && arr[j]<arr[j-gap])
				{
					swap(arr,j,j-gap);
					j=j-gap;
				}
			}
			gap/=2;
		}
	}
	public void shellSort1(int arr[])
	{
		for(int gap=arr.length/2;gap>0;gap/=2)
			for(int i=gap;i<arr.length;i+=gap)
			{
				int temp=arr[i];
				int j=i-gap;
				while(j>=0 && arr[j]>temp)
				{
					arr[j+gap]=arr[j];
					j=j-gap;
				}
				arr[j+gap]=temp;
			}
		
	}

	public void display(int[] c)
	{
		for(int i=0;i<c.length;i++)
			System.out.print(c[i]+" ");
		System.out.println();
	}

	public static void main(String[] args)
	{
		CountBinRadixShellSort cbrs = new CountBinRadixShellSort();
		int arr[]={5,4,2,5,3,1,2};
		cbrs.countSort(arr);
		cbrs.display(arr);
		int arr1[]={5,4,2,5,3,1,2};
		cbrs.binBucketSort(arr1);
		cbrs.display(arr1);
		int arr2[]={9,8,7};
		cbrs.radixSort(arr2);
		cbrs.display(arr2);
		int arr3[]={9,8,7,6,5,4,3,2,1,1,2,3,4,5};
		cbrs.shellSort1(arr3);
		cbrs.display(arr3);
	}
}