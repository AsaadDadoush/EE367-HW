package Homework01;

/**
 * C-2.24
 * @(#)AbsProgression.java
 * @author asaad
 * this calss is extended for Progression class to find the
 * absolute value of the difference between the previous two values 
 * in a specific range that the user enter
 * @version 1.00 2021/30/5
 * 
 */

public class AbsProgression extends Progression {
	
	protected long prev;
	
	/** Constructs AbsProgression, starting 2, 200, 198, 2, 196, ... */
	 public AbsProgression() { this(2, 200); }
	
	 /**Constructs AbsProgression, with give first and second values. */
	 public AbsProgression(long first, long second) {
	 super(first);
	 prev = Math.abs(second - first);  // fictitious value preceding the first
	 }
	 
	 /** Replaces (prev,current) with (current, current+prev).
	  * 
	  *  @param Range 
	  *  This is the range of numbers that the user wants to estimate
	  *  
	  **/
	 protected void advanceuntil(int Range) {
		 for(int i= 1; i <= Range;i++) {

		 long temp = prev;
	 prev = current;
	 current = Math.abs(current-temp);
	 System.out.print(temp +", ");
		 }
	 }
	}


