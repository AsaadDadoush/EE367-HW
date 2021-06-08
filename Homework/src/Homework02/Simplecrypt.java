package Homework02;

import java.io.*;
import java.util.*;

/**
 * @(#)Simplecrypt.java
 * @version 1.00 6/6/2021
 * A simple program to encryption and decryption for a file
 * @author Asaad.Da
 * author link {@link https://github.com/AsaadDadoush }
 * 
 */


public class Simplecrypt {

	public static void main(String[] args) {
		
		//Initializing of the program
		Simplecrypt obj = new Simplecrypt();
		Scanner input =  new Scanner(System.in);
		//ask the user to enter the key 
		System.out.println("Enter The Key to Dec/Enc The file :");
		String Key = input.nextLine();// here to put the key word
		int H = obj.convKey(Key); // convert the key value into integer
		
		/**
		 * create an array that contains all the characters that we use in keyboard
		 * and order them in array N with respect to their ASCII value 
		 */
		int N = 128;
		char[] S = new char[N];
		
		for(int i = 0; i <= 127; i++) {  //reads all the ASCII values and insert them into array S
			 S[i]  = (char)i;
			}	
	
	    /**
	     * Reads the file and do the enc/dec operation
	     */
	    try{
	    	//output
	    	File output = new File("C:\\Users\\asaad\\Desktop\\Homework 02\\clear.txt");
			BufferedWriter wr = new BufferedWriter(
					new FileWriter(output));  //The file that we want to write an (output) on it
			
			
	    	//input
			File inputt = new File("C:\\Users\\asaad\\Desktop\\Homework 02\\crypt.crp");
			BufferedReader br = null ;
					
			
			if(inputt.exists() && !inputt.isDirectory()) { 
			   br = new BufferedReader(
						new FileReader(inputt)); //The file that we read the (input) from it
			}
			else {
				System.out.println("Error file not found");
				br.close();
			}
			
			int c = 0;     // that value to read and write in file char by char 
			int L =0;  	   // this the location of every char in the array S
			int enc = 0;   // this value we use for function encryption
			int dec = 0;   // thos value used for function decryption 
			char c_ = (char) enc;  //the value of c after we do the function to write it into the new file 
				
				//Asks the user to chose which operator to use 
				System.out.println("what opertation the you want to use enter (1) for enc (2) for dec :");
				int choice = input.nextInt();
				
			while((c = br.read()) != -1) { // reads the input file 
				
				for (int element : S) {   //
				    if (element == c) {   
				    	L = c;
				    	
				    dec = (N+L-H%N) % N;	// the function that we use to dec the text plain 
				    enc = (L+H%N) % N; // the function that we use to enc the text plain 
					// 1 for enc 2 or dec
				    if(choice == 1 ) { // check if the choice equal to 1 so do the encryption function
				    c_ = (char) enc;
				    }
				    else if(choice ==2) {  // check if the choice equal to 1 so do the decryption  function
				    	c_ = (char) dec;
				    }
				    else { // if none of them we print error message then exit 
				    	System.out.println("Error Wrong operation"); 
				    	br.close();
				    	wr.close();
				    }
				    
				    wr.write(c_); // write in the output file
				    }
				}
//               System.out.print(c_);	// that was for testing 
			}
			
			if(choice == 1) {
				System.out.println("java Simplecrypt enc " + inputt.getName() + " " + " " + output.getName() + " " + Key);
			}
			else if (choice == 2) {
				System.out.println("java Simplecrypt dec " + inputt.getName() + " " + " " + output.getName() + " " + Key);
			}
			System.out.println("The process done successfully");
			System.out.println("Exiting The programm......");
					
			br.close();
			wr.close();
		}catch(Exception ex) {
			return;
		}
		
	}
	
	/**
	 * @param - key
	 * That input user entered it must be String value
	 * to convert it to ASCII code 
	 * @return H
	 * that value we got form the function when we multiply the ASCII valute of each
	 * Char then multiply it by its position 
	 */
	public int convKey(String key) {
		int H=0;
		int c=1;
	    for(int i=0; i<key.length(); i++){
	      int asciiValue = key.charAt(i);
	      H = H + c * asciiValue;
	      c++;
	    }
	    return H;
	}
	
}
