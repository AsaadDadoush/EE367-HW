package Homework03;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Rec {

	public static void main(String[] args) {
		
		Rec obj = new Rec();
		
		
		int[] xar = {5 ,4,5,6,2,1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(xar));
		obj.Rerange(xar, 0, xar.length - 1);
		System.out.println(Arrays.toString(xar));
	}
	
	/**
	 * 
	 * @param A - This the array that the user enter
	 * @param n - The range to apply the search operation
	 * @return    Return the max value of the Array
	 * time order O(n) space order O(1)
	 */
	public static int findMax(int[] A, int n) {
		
		if(n == 1) {
			return A[0];
		}else
			return Math.max(A[n-1], findMax(A, n-1));
		
		
	}
	
	public static double power(double x, int n) {
		if(n == 0) {
			return 1;
		}else
			return x * power(x,n-1);
		
	}
	
	public static double powerimp(double x, int n) {
		 if (n == 0)
		 return 1;
		 else {
		 double partial = powerimp(x, n/2); // rely on truncated division of n
		 double result = partial * partial;
		 if (n % 2 == 1) // if n odd, include extra factor of x
		 result *= x;
		 return result;
		 }
	}
	
	public static double NonRecPower(double x, int n) {
		
		double sum = 1;
		while(n > 0) {
			
			if(n % 2 == 1) sum *= x;
			x = x * x;
			n /= 2;
			
		}
		return sum;
		
	}
	
	/**
	 * @param n  the number of 1/n that we want to enter
	 * @return   return the sum of the 1/n + ..... + 1/n-1
	 */
	public static double harmonic(int n) {
	    if(n < 2) {
	        return 1.0;
	    } else {
	        return (1.0 / n) + harmonic(n - 1);
	    }
	}
	/**
	 * @param s  the String number that will entered
	 * @return value  the int value of that string
	 */
	 static int stringInt(String s) {
	 
	        if (s.length() == 1)
	            return (s.charAt(0) - '0');
	        double v = stringInt(s.substring(1));
	        double value = s.charAt(0) - '0';
	        value = value * Math.pow(10, s.length() - 1) + v;
	        return (int)(value);
	    }
	 
	 public static int RecProduct(int n , int m) {
		 if( n < m ) {
			 return RecProduct(m, n);
		 }
		 else if (m != 0) {
			 return (n + RecProduct(n, m -1));
		 }
		 else
			 return 0;
	 }
	 
	 
	 /**
	  * 
	  * @param arr  a array of integer values
	  * @param low   low lowest index
	  * @param high  high highest index
	  */
	 public void Rerange(int[] arr,int low, int high) {
		 if( low < high ) {
			 if(arr[low] % 2 == 0) {
				 low++;
			 } else {
				 if(arr[high] % 2 == 0) {
					 int temp = arr[low];
					 arr[low] = arr[high];
					 arr[high] = temp;
					 low++;
				 }
				 high--;
			 }
			 Rerange(arr, low, high);
		 }
		 
		 
	 }

}


