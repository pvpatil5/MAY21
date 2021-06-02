package practice_gestures;

public class inttointarray {

	public static void main(String[] args) {

		int a = 1234567888;

		String s1 =new Integer(a).toString();

		char[] arr=	s1.toCharArray();

		int [] ar= new int [arr.length];

		for (int i = 0; i < arr.length; i++)
		{
			ar[i]= Character.getNumericValue(arr[i]);
		}
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]);
		}


	}

}
