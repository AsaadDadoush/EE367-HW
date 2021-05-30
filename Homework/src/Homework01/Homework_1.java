package Homework01;
import java.util.*;
import java.util.Random;

/**
 * @(#)Homework.java
 * @author Asaad.Da
 * @version 1.00 2021/27/5
 * {@link https://github.com/AsaadDadoush/EE367-HW/tree/master/Homework}
 * Use this link for the Source code
 */

public class Homework_1 {
	
	
	public static void main(String [] args) {
		
		Homework_1 obj = new Homework_1();
		System.out.println(obj.isMultiple(100, 1000));
		System.out.println(obj.sumLess(5));
		System.out.println(obj.oddSum(10));
		
		/**
		 * This is to test the class flower if is everything goes okey
		 */
		Flower flowobj = new Flower("Sharyn",5,25.55f);
		
		System.out.printf("\n\nName: %s\nnumber of petals: %d\nprice: %f",
				flowobj.getName(),flowobj.getNumberOfpetals(),flowobj.getPrice());
		
		flowobj.setName("Sharyn_V2");
		flowobj.setNumberOfPetals(7);
		flowobj.setPrice(27.77f);
		
		System.out.printf("\n\nName: %s\nnumber of petals: %d\nprice: %f",
				flowobj.getName(),flowobj.getNumberOfpetals(),flowobj.getPrice());
		
		
		/**
		 * C-1.23
		 * I used java Random class to solve this problem
		 * First create array a , b
		 * Second create array c 
		 * Store the product of arrays a , b in c
		 * print the results 
		 * 
		 */
		Random r = new Random();
		int n = 5;
		int[] a =  new int[n];
		int[] b =  new int[n];
		int[] c =  new int[n];
		
		for(int i= 0; i < a.length; i++ ) {
			a[i] = r.nextInt(10) + 1;
			b[i] = r.nextInt(10) + 1;
			c[i] =  a[i] * b[i];
			System.out.printf("\n%d * %d = %d",a[i],b[i],c[i]);
			
		}
		
		/**
		 * R-2.6
		 * this is short code fragment be usuing Fibonacci progression that starts with
		 * 2 and 2 to  find the 8th value
		 */
		int num1 = 2;
		int num2 = 2;
		int sum;
		int total = 8;
		
		System.out.print("\n\n\n"+num1);
		
		for(int i= 1; i < total;i++) {
		sum = num1+num2;
		System.out.print(", " + num2);
		num1 = num2;
		num2 = sum;
		}
		
		AbsProgression abs = new AbsProgression();
		System.out.println("\n\n\n\n");
		abs.advanceuntil(100);
		
		
	}
	
	/**
	 * R-1.3
	 * compute 2 numbers to see if n is multiple of m or not
	 * @param n
	 * @param m
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
