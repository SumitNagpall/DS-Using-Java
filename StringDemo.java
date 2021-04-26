class StringDemo
{
	public static void duplicateCharacterString(String s)
	{
		int x=0,H=0;
		for(int i=0;i<s.length();i++)
		{
			x=1;
			x=x<<(int)s.charAt(i)-97;
			if((x&H)>0)
				System.out.println(s.charAt(i)+" is duplicate");
			else
				H=x|H;
		}
	}
	public static void duplicateCharacterInString(String s)
	{
		int array[]=new int[26];
		for(int i=0;i<s.length();i++)
			array[(int)s.charAt(i)-97]++;

		for(int i=0;i<26;i++)
			if(array[i]>1)
				System.out.print((char)(i+97));
	}
	public static boolean checkAnagram(String a,String b)
	{
		if(a.length()!=b.length())
			return false;
		int array[]=new int[26];
		for(int i=0;i<a.length();i++)
			array[(int)a.charAt(i)-97]++;
		for(int i=0;i<a.length();i++)
			array[(int)b.charAt(i)-97]--;
		for(int i=0;i<array.length;i++)
			if(array[i]!=0)
				return false;
		return true;
	}
	private static void swap(char[] s,int l,int i)
	{
		char temp=s[l];
		s[l]=s[i];
		s[i]=temp;
	}
	public static void permutationSwap(char[] s,int l)
	{
		if(l==s.length)
		{
			for(int i=0;i<s.length;i++)
				System.out.print(s[i]);
			System.out.print(" ");
		}
		else
		{
			for(int i=l;i<s.length;i++)
			{
				swap(s,l,i);
				permutationSwap(s,l+1);
				swap(s,l,i);
			}
		}
	}
	public static void main(String[] args)
	{
		StringDemo.duplicateCharacterString("aabccdee");
		System.out.println("Is Anagram: "+StringDemo.checkAnagram("decimal","medical"));
		
		StringDemo.permutationSwap("ABC".toCharArray(),0);
	}
}