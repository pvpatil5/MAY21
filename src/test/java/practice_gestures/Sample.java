package practice_gestures;

public class Sample {
	public static void main(String[] args) {
		String s1= "Wel@Come";
		String [] arr=s1.split("@");
		Sample s2 = new  Sample();
		System.out.println(s2.reverseSting(arr[0])+"@"+s2.reverseSting(arr[1]));
	}
	public String reverseSting(String s)
	{
		char[] c =s.toCharArray();
		String rev = "" ;
		for (int i = c.length-1; i >=0 ; i--) 
		{
			rev=rev+c[i];
		}
		return rev;
	}
}
