import java.util.ArrayList;

class ArrayCode
{
	public <T> void reverse(T[] arr)
	{
		for(int i=0,j=arr.length-1;i<j;i++,j--)
		{	T temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
	}
	public <T> void display(T[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+ " ");
		System.out.println();
	}
	public void minMax(int arr[])
	{
		int min=arr[0],max=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<min)
				min=arr[i];
			else if(arr[i]>max)
				max=arr[i];
		}
		System.out.println("Min is "+min+" Max is "+max);
	}
	public int KthMax(int[] arr,int k)
	{
		if(k<=0 || k>arr.length)
			return -1;
		for(int j=0;j<k;j++)
			for(int i=0;i<arr.length-1;i++)
				if(arr[i]>arr[i+1])
					arr[i+1]=arr[i]+(arr[i]=arr[i+1])-arr[i+1];
	
		return arr[arr.length-k];
	}

	public int KthMin(int[] arr,int k)
	{
		if(k<=0 || k>arr.length)
			return -1;
		for(int j=0;j<k;j++)
			for(int i=arr.length-1;i>0;i--)
				if(arr[i]<arr[i-1])
					arr[i-1]=arr[i]+(arr[i]=arr[i-1])-arr[i-1];
	
		return arr[k-1];
	}
	
	public void zeroOneTwo(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
			for(int j=0;j<arr.length-1;j++)
				if(arr[j]-arr[j+1]>0)
					arr[j+1]=arr[j]+(arr[j]=arr[j+1])-arr[j+1];
		intDisplay(arr);
	}
	private void intDisplay(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public void negativeToOneSide(int arr[])
	{
		for(int i=0,j=arr.length-1;i<j;)
		{
			while(arr[i]<0)  
				i++;
			while(arr[j]>0)
				j--;
			if(i<j)
				arr[j]=arr[i]+(arr[i]=arr[j])-arr[j];
		}
		intDisplay(arr);
	}
	public void Union(int[] arr1,int[] arr2)
	{
		ArrayList<Integer> arr=new ArrayList<Integer>();
		int i=0,j=0;
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]<arr2[j])
			{
				arr.add(arr1[i++]);
			}
			else if(arr1[i]>arr2[j]) 
			{
				arr.add(arr2[j++]);
			}
			else
			{
				arr.add(arr1[i++]);
				j++;
			}
		}
		while(i<arr1.length)
			arr.add(arr1[i++]);

		while(j<arr2.length)
			arr.add(arr2[j++]);
		
		for(int k=0;k<arr.size();k++)
			System.out.print(arr.get(k)+" ");
		System.out.println();
	}

	public void Intersection(int[] arr1,int[] arr2)
	{
		ArrayList<Integer> arr=new ArrayList<Integer>();
		int i=0,j=0;
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]<arr2[j])
			{
				i++;
			}
			else if(arr1[i]>arr2[j]) 
			{
				j++;
			}
			else
			{
				arr.add(arr1[i++]);
				j++;
			}
		}
		
		for(int k=0;k<arr.size();k++)
			System.out.print(arr.get(k)+" ");
		System.out.println();
	}
	public <T >void cyclicRotate(T[] arr)
	{
		T temp=arr[0];
		for(int i=0;i<arr.length-1;i++)
			arr[i]=arr[i+1];
		arr[arr.length-1]=temp;
		display(arr);
	}
	public int largestSumSubArray(int arr[])
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int k=0;k<arr.length;k++)
		{
			for(int i=k;i<arr.length;i++)
			{
				int sum=0;
				for(int j=k;j<=i;j++)
				{
					sum+=arr[j];
					a.add(sum);
				}
			}
		}
		int max=a.get(0);
		for(int i=1;i<a.size();i++)
			if(a.get(i)>max)
				max=a.get(i);
		return max;
	}
	public static void main(String[] args)
	{
		ArrayCode array=new ArrayCode();
		String arr[]={"abc","pqr","xyz"};
		//Float arr[]={5.0f,4.0f,3.9f,2.5f,1.67f};
		array.reverse(arr);
		array.display(arr);
		int arr1[]={34,5445,76,98,123};
		array.minMax(arr1);
		System.out.println("Kth Max = "+array.KthMax(arr1,5));
		System.out.println("Kth Min = "+array.KthMin(arr1,3));
		int[] arr2={1,2,1,0,1,2,0,1,0,2,2,0,1};
		System.out.println("012 Series = ");
		array.zeroOneTwo(arr2);
		int [] arr3={1,2,3,-1,2,-4,23,-42,-23,32};
		System.out.println("negativeToOneSide = ");
		array.negativeToOneSide(arr3);
		int[] arr4={1,3,5,7,9};
		int[] arr5={2,3,5,7};
		System.out.println("Union = ");
		array.Union(arr4,arr5);
		System.out.println("Intersection = ");
		array.Intersection(arr4,arr5);
		System.out.println("Cyclic Rotate By 1 ");
		array.cyclicRotate(arr);
		array.cyclicRotate(arr);
		array.cyclicRotate(arr);
		int[] arr6={-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("LargestSumSubArray= "+array.largestSumSubArray(arr6));

	}
}


/*
1 2 3 4 5

1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
2
2 3
2 3 4
2 3 4 5
3
3 4
3 4 5
4
4 5
5*/