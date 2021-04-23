class ArrayMissingDuplicateKSum
{
	public static void missingElement(int arr[])
	{
		int diff=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			while(arr[i]-i!=diff) 
			{				     
				System.out.print((diff+i)+" ");
				diff++;
			}
		}
	}
	public static void missingElements(int arr[])
	{
		int low=arr[0],high=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<low)
				low=arr[i];
			else if(arr[i]>high)
				high=arr[i];
		}
		int array[]=new int[high+1];
		for(int i=0;i<arr.length;i++)
		{
			array[arr[i]]++;
		}
		for(int i=low;i<=high;i++)
		{
			if(array[i]==0)
				System.out.print(i+" ");
		}
	}
	public static void duplicatesSorted(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			int j=i;
			if(arr[i]==arr[i+1])
			{
				System.out.print(arr[i]+" ");
				while(j+1<arr.length&&arr[j]==arr[j+1])
					j++;
				System.out.print(j-i+1+"times"+"\n");
				i=j;
			}
		}
	}
	public static void duplicatesSortedArray(int[] arr)
	{
		int array[]=new int[arr.length];
		for(int i=0;i<arr.length;i++)
			array[arr[i]]++;
		for(int i=arr[0];i<array.length;i++)
			if(array[i]>1)
				System.out.println(i+" is present "+array[i]+" times.");
	}
	public static void duplicatesUnSorted(int[] arr)
	{
		int count=1;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==-1)
				continue;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
					arr[j]=-1;
				}
			}
			System.out.println(arr[i]+" : "+count+" times");
			count=1;
		}
	}
	public static void duplicatesUnSortedArray(int[] arr)
	{
		int low=arr[0],high=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<low)
				low=arr[i];
			else if(arr[i]>high)
				high=arr[i];
		}	
	 	int array[]=new int[high+1];
		for(int i=0;i<arr.length;i++)
			array[arr[i]]++;
		for(int i=low;i<array.length;i++)
			if(array[i]>1)
				System.out.println(i+" is present "+array[i]+" times.");	
	}
	public static void main(String[] args)
	{
		int arr[]={1,2,3,6};
		ArrayMissingDuplicateKSum.missingElement(arr);//works for sorted only
		ArrayMissingDuplicateKSum.missingElements(arr);//works for Sorted and unsorted
		int arr1[]={1,2,2,3,4,4,5,6,7,7,8,9,9,9};
		ArrayMissingDuplicateKSum.duplicatesSorted(arr1);
		ArrayMissingDuplicateKSum.duplicatesSortedArray(arr1);
		int arr2[]={1,4,2,8,4,5,7,2,7,1,3,2};
		ArrayMissingDuplicateKSum.duplicatesUnSorted(arr2);
		int arr3[]={1,4,2,8,4,5,7,2,7,1,3,2};
		ArrayMissingDuplicateKSum.duplicatesUnSortedArray(arr3);
	}
}