import java.util.*;

/**
 * @(#)Homework.java
 * @author Asaad.Da
 *
 */


public class Homework_1 {
	
	
	public static void main(String [] args) {
		
		Homework_1 obj = new Homework_1();
		
		System.out.println(obj.isMultiple(100, 1000));
		System.out.println(obj.sumLess(5));
		System.out.println(obj.oddSum(10));
		
		
		
	}
	
	
	/**
	 * R-1.3
	 * compute 2 numbers to see if n is multiple of m or not
	 * @param n, m
	 * these two numbers that needs to compare them
	 * @return
	 * return true if n is multiple of m
	 */
	public boolean isMultiple(long n , long m) {
		
		if(m % n == 0) {
			return true;
		}else
			return false;
	}
	
	/**
	 * R-1.5
	 * Find the sum of the positive numbers that less than n or equal
	 * @param n
	 * This n is need to use 
	 * @return
	 * sum of all positive numbers less than n or equal
	 */
	
	public int sumLess(int n) {
		
		int sum = 0;
		for(int i= n; i <= n && i > 0 ; i--) {
			
			sum += i;
		}
		return sum;
	}
	
	/**
	 * R-1.6
	 * Find the sum of the odd positive numbers that less than n or equal
	 * @param n
	 * This n is need to use
	 * @return
	 * The sum of all odd positive less than n or equal
	 */
	public int oddSum(int n) {
		
		int sum = 0;
		for(int i= n; i <= n && i  > 0; i--) {
			if (!(i % 2 == 0)){
				sum += i;
			}
		}
		return sum;
	}
	
	
	
	
	
}
