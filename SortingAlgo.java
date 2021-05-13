class SortingAlgo
{
	public void bubbleSort(int arr[])
	{
		for(int i=0;i<arr.length-1;i++)
			for(int j=0;j<arr.length-1-i;j++)
				if(arr[j]>arr[j+1])
					arr[j+1]=arr[j]+(arr[j]=arr[j+1])-arr[j+1];
	}
	public void bubbleSortImproved(int arr[])
	{
		for(int i=0;i<arr.length-1;i++)
		{
			boolean val=true;
			for(int j=0;j<arr.length-1-i;j++)
				if(arr[j]>arr[j+1])
				{
					arr[j+1]=arr[j]+(arr[j]=arr[j+1])-arr[j+1];
					val=false;
				}
			if(val==true)
				break;
		}
	}
	public void insertionSort(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			int val=arr[i],j=i-1;
			while(j>=0 && arr[j]>val)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=val;
		}
	}
	private void swap(int arr[],int i,int j)
	{
		arr[j]=arr[i]+(arr[i]=arr[j])-arr[j];	
	}
	public void selectionSort(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			int j=i,k=i;
			while(++j<arr.length)
				if(arr[j]<arr[k])
					k=j;  
			swap(arr,i,k);
		}	
	}
	private int partitionQuick(int[] arr,int l,int h)
	{
		int pivot=arr[l];
		int i=l,j=h;
		while(i<j)
		{
			while(i<arr.length && arr[i]<=pivot)
				i++;
			while(j>0 &&arr[j]>pivot)
				j--;
			if(i<j)
				swap(arr,i,j);
		}
		swap(arr,l,j);
		return j;	
	}
	public void quickSort(int arr[],int l,int h)
	{
		if(l<h)
		{
			int partition=partitionQuick(arr,l,h);
			quickSort(arr,l,partition-1);
			quickSort(arr,partition+1,h);
		}
	}

	public void display(int[]arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		SortingAlgo s = new SortingAlgo();
		int arr[] = {5,4,3,2,1};
		s.bubbleSort(arr);
		s.display(arr);
		s.bubbleSortImproved(arr);
		s.display(arr);
		int array[] = {5,4,3,2,1};
		s.insertionSort(array);
		s.display(array);
		int arr1[] = {5,4,3,2,1};
		s.selectionSort(arr1);
		s.display(arr1);
		int arr2[] = {5,4,3,2,1};
		s.quickSort(arr2,0,arr2.length-1);
		s.display(arr2);

	}
}