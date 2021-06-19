package Homework04;

/**
 * @(#)Plane.java
 * 
 * 
 * @author Asaad.Da
 * @version 1.00 2021/6/20
 *	
 * This class for the plane.
 * 
 */


public class Plane { 
	
	 private static int numPlanes = 0; // Keeps track of plane serial numbers
	 private int id; // The plane's unique ID
	 private int tm; // The time of creation
	 
	 public Plane() { // The default constructor
		 numPlanes = 0; 
		 id = 0; 
		 tm = 0; 
	 } 
	 
	 public Plane(int currentTime) { // Another constructor
		 id = ++numPlanes; 
		 tm = currentTime; 
	 } 
	 
	 public int getNumPlanes() { // Returns the total number of planes
		 return numPlanes; 
	 } 
	 
	 public int getId() { // Returns the plane's ID
		 return id; 
	 } 
	 
	 public int getTime() { // Returns the plane's creation time
		 return tm; 
	 } 
	 
	 public void setReadyToLand() { // Prints a message; This is an arriving
		 System.out.print(" Plane "); // plane that is ready for landing
		 System.out.printf("%4d", id); 
		 System.out.println(" is ready to land."); 
	 } 
	 
	 public void setReadyToTakeoff() { // Prints a message; This is a departing
		 System.out.print(" Plane "); // plane that is ready for takeoff
		 System.out.printf("%4d", id); 
		 System.out.println(" is ready to take off."); 
	 } 
	 
	 public int land(int currentTime) { // Prints a message; This plane has landed 
		 int wait; // Calculates and returns the waiting time
		 // in the queue. 
		 wait = currentTime - tm; 
		 System.out.printf("%4d", currentTime); 
		 System.out.print(": Plane "); 
		 System.out.printf("%4d", id); 
		 System.out.print(" has landed; In queue "); 
		 System.out.printf("%4d", wait); 
		 System.out.println(" units."); 
		 return wait; 
	 } 
	 
	 public int fly(int currentTime) { // Prints a message; This plane took off 
		 int wait; // Calculates and returns the waiting time 
		 // in the queue. 
		 wait = currentTime - tm; 
	 	System.out.printf("%4d", currentTime); 
	 	System.out.print(": Plane "); 
	 	System.out.printf("%4d", id); 
	 	System.out.print(" took off; In queue "); 
	 	System.out.printf("%4d", wait); 
	 	System.out.println(" units."); 
	 	return wait; 
	 } 
	 
	 public void refuseLanding() { // Prints a message; This arriving plane
		 System.out.print(" Plane "); // did not find a place in the queue
		 System.out.printf("%4d", id); // and it is being directed to another airport
		 System.out.println(" was directed to another airport."); 
	 } 
	 
	 public void refuseTakeoff() { // Prints a message; This departing plane
		 System.out.print(" Plane "); // did not find a place in the queue
		 System.out.printf("%4d", id); // and is being postponed.
		 System.out.println(" was told to try later."); 
	 } 
	 
}








