class MergeArraySorting
{
	public int[] mergeArray(int a[],int b[])
	{
		int c[] = new int[a.length+b.length];
		int i=0,j=0,k=0;
		while(i<a.length && j<b.length)
			if(a[i]<b[j])
				c[k++]=a[i++];
			else
				c[k++]=b[j++];

		while(i<a.length)
			c[k++]=a[i++];

		while(j<b.length)
			c[k++]=b[j++];
		return c;
	}
	public void merge(int[] arr,int l,int mid,int h)
	{
		int i=l,j=mid+1,k=l;
		int c[]=new int[arr.length];
		while(i<=mid && j<=h)
		{
			if(arr[i]<arr[j])
				c[k++]=arr[i++];
			else
				c[k++]=arr[j++];
		}
		while(i<=mid)
			c[k++]=arr[i++];

		while(j<=h)
			c[k++]=arr[j++];
		
		for(int x=l;x<=h;x++)
			arr[x]=c[x];
	}
	public void mergeSortIterative(int[] arr)
	{
		int i,l,mid,h;
		for(i=2;i<=arr.length;i*=2)
		{
			for(int j=0;i+j-1<arr.length;j+=i)
			{
				l=j;
				h=j+i-1;
				mid=(int)(l+h)/2;
				merge(arr,j,mid,h);
			}
		}
		if(i/2<arr.length)
			merge(arr,0,(i/2)-1,arr.length-1);
	}
	public void mergeSort(int[] arr,int l,int h)
	{
		if(l<h)
		{
			int mid=(int)(l+h)/2;
			mergeSort(arr,0,mid);
			mergeSort(arr,mid+1,h);
			merge(arr,l,mid,h);
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
		MergeArraySorting ms = new MergeArraySorting();
		int a[]={1,3,5,7};
		int b[]={2,4,6,8,10};

		int c[]=ms.mergeArray(a,b);
		ms.display(c);
		int d[]={8,3,7,0,7,6,6,2};
		ms.mergeSortIterative(d);
		ms.display(d);
		int arr[]={8,3,4,2,7,6,5,2};
		ms.mergeSort(arr,0,arr.length-1);
		ms.display(arr); 
	}
}