package Homework04;

/** 
 * @(#)AirportSimulator.java 
 * 
 * 
 * @author Asaad.Da
 * @version 1.00 2021/6/20 
 * 
 * This class simulates a small airport with a single runway. 
 * The policy of the airport authority is to give priority to 
 * landing over departing planes. 
 */ 
import java.util.*; 
public class AirportSimulator { 
 // Specifying needed plane queues 
 protected static ArrayQueue<Plane> landing; // The landing FIFO queue
 protected static ArrayQueue<Plane> takeoff; // The takeoff FIFO queue
 // Creating random number generators with Poison Distribution 
 protected static PoisonDistGenerator poisonArrive = new PoisonDistGenerator(); 
 protected static PoisonDistGenerator poisonDepart = new PoisonDistGenerator(); 
 // Creating an input stream scanner 
 protected static Scanner in = new Scanner(System.in); 
 private static int maxQueue = 5; // Queue maximum allowable size, default 5
 private static int currentTime = 1; // Current time; unit = time to takeoff or land
 private static int endTime = 30; // Total number of time units to run 
 private static int idleTime; // Number of units when the runway is idle
 private static int numPlanes; // Number of planes processed
 private static int numLanded; // Number of planes that landed
 private static int numTookoff; // Number of planes that took off 
 private static int numRefused; // Number of planes denied use of the airport
 private static int landWait; // Total waiting time for planes that landed
 private static int takeoffWait; // Total waiting time for planes that took off
 private static double expectArrive; // Expected no. planes arriving in a time unit
 private static double expectDepart; // Expected no. planes newly ready to depart
 // The main simulation method 
 public static void main(String[] args) { 
 Plane p; // A temporary plane reference
 boolean again = true; // Control for running the simulation again
 do { // This loop for repeating the simulation
 start(); // Initialize static fields & data structures
 System.out.println(); 
 System.out.println();  // The main simulation loop; Each iteration represents one time unit 
 // Every thing that can happen simultaneously in a single unit of time 
 // is done within this loop's body. 
 for (currentTime=1; currentTime <= endTime; currentTime++) { 
 numPlanes += generateArrive(currentTime); // Create arriving planes
 numPlanes += generateDepart(currentTime); // Create departing planes
 // Execute the Airport authority policy: Land one plane; if none, fly one plane 
 if (!landing.isEmpty()) { // Check the landing queue first
 p = landing.serve(); 
 landWait = landWait + p.land(currentTime); 
 numLanded++; 
 } 
 else if (!takeoff.isEmpty()) { // Check the departing queue
 p = takeoff.serve(); 
 takeoffWait = takeoffWait + p.fly(currentTime); 
 numTookoff++; 
 } 
 else // If none, report idle runway
 runwayIdle(currentTime); 
 } // End of the main loop
 // Print all the statistical results of the simulation 
 conclude(); 
 // Reset all the static fields and data structures to their default values 
 reset(); 
 // Ask if another run is required 
 System.out.print("Do you want to run another simulation (true/false)? "); 
 again = (in.nextBoolean()); 
 } while (again); 
 return; 
 } 
// Prompts the user for the required input values, and initializes all the program 
 // static fields & data structures. It also checks for the correctness of the input data. 
 // 
 public static void start() { 
 boolean ok = true; 
 System.out.println("This program simulates an airport with only one runway."); 
 System.out.println("One plane can land or depart in each unit of time."); 
 System.out.println(); 
 System.out.print("What is the maximum allowed length of the queue? "); 
 maxQueue = in.nextInt(); 
 System.out.println(); 
 System.out.print("Up to " + maxQueue + " planes can "); 
 System.out.println("be waiting to land or take off at any time."); 
 System.out.println();  System.out.print("How many units of time will the simulation run? "); 
 endTime = in.nextInt(); 
 System.out.println(); 
 do { 
 System.out.print("Enter the expected number of arrivals per unit time"); 
 System.out.print(" (a real number)? "); 
 expectArrive = in.nextDouble(); 
 System.out.println(); 
 System.out.print("Enter the expected number of departures per unit time"); 
 System.out.print(" (a real number)? "); 
 expectDepart = in.nextDouble(); 
 System.out.println(); 
 if ((expectArrive < 0.0) || (expectDepart < 0.0)) { 
 System.out.println("These numbers must be non-negative"); 
 System.out.println(); 
 ok = false; 
 } 
 else if ((expectArrive + expectDepart) > 1.0) { 
 System.out.print("The airport will become saturated. "); 
 System.out.print("Want to read new numbers (true/false)? "); 
 ok = !(in.nextBoolean()); 
 System.out.println(); 
 } 
 else ok = true; 
 } while (!ok); 
 landing = new ArrayQueue<Plane>(maxQueue); // Create the landing queue
 takeoff = new ArrayQueue<Plane>(maxQueue); // Create the take off queue
 poisonArrive.setExpectedNumber(expectArrive); // Set expect arrivals value
 poisonDepart.setExpectedNumber(expectDepart); // Set expect departs value
 } 
// Generates a number of planes ready to land according to the Poison distribution 
 // and the given expected number. Tries to put the new planes in the queue; if the 
 // queue is full then the plane is denied service and refused acceptance. 
 // 
 // Returns the number of created planes. 
 // 
 public static int generateArrive(int currentTime) { 
 Plane p; 
 int j = poisonArrive.getNumber(); 
 for (int i=1; i <= j; i++) { 
 p = new Plane(currentTime); 
 p.setReadyToLand(); 
 if (landing.isFull()) {  p.refuseLanding(); 
 numRefused++; 
 } 
 else 
 landing.enqueue(p); 
 } 
 return j; 
 } 
 // Generates a number of planes ready to take off according to the Poison 
 // distribution and the given expected number. Tries to put the new planes 
 // in the queue; if the queue is full then the plane is denied service. 
 // 
 // Returns the number of created planes 
 // 
 public static int generateDepart(int currentTime) { 
 Plane p; 
 int j = poisonDepart.getNumber(); 
 for (int i=1; i <= j; i++) { 
 p = new Plane(currentTime); 
 p.setReadyToTakeoff(); 
 if (takeoff.isFull()) { 
 p.refuseTakeoff(); 
 numRefused++; 
 } 
 else 
 takeoff.enqueue(p); 
 } 
 return j; 
 } 
 // Reports an idle runway and updates the counter 
 // 
 public static void runwayIdle(int currentTime) { 
 System.out.printf("%4d", currentTime); 
 System.out.println(": Runway is idle."); 
 idleTime++; 
 } 
 // Writes out all the required statistics and finish the simulation 
 // 
 public static void conclude() { 
 System.out.println(); 
 System.out.println(); 
 System.out.println("Simulation has concluded after " + endTime + " units."); 
 System.out.println();  System.out.print("Expected number of arrivals was: "); 
 System.out.println(poisonArrive.getExpectedNumber()); 
 System.out.print("Expected number of departures was: "); 
 System.out.println(poisonDepart.getExpectedNumber()); 
 System.out.println(); 
 System.out.print("Total number of planes processed: "); 
 System.out.printf("%4d", numPlanes); 
 System.out.println(); 
 System.out.print(" Number of planes landed: "); 
 System.out.printf("%4d", numLanded); 
 System.out.println(); 
 System.out.print(" Number of planes tookoff: "); 
 System.out.printf("%4d", numTookoff); 
 System.out.println(); 
 System.out.print(" Number of planes refused: "); 
 System.out.printf("%4d", numRefused); 
 System.out.println(); 
 System.out.print(" Number left ready to land: "); 
 System.out.printf("%4d", landing.size()); 
 System.out.println(); 
 System.out.print(" Number left ready to take off: "); 
 System.out.printf("%4d", takeoff.size()); 
 System.out.println(); 
 System.out.println(); 
 System.out.println(); 
 if (endTime > 0) { 
 System.out.print("Percentage of time runway idle: "); 
 System.out.printf("%6.2f", (idleTime/(double)endTime)*100.0); 
 System.out.println("%"); 
 } 
 if (numLanded > 0) { 
 System.out.print("Average waiting time to land: "); 
 System.out.printf("%6.2f", (landWait/(double)numLanded)); 
 System.out.println(); 
 } 
 if (numTookoff > 0) { 
 System.out.print("Average waiting time to take off: "); 
 System.out.printf("%6.2f", (takeoffWait/(double)numTookoff)); 
 System.out.println(); 
 System.out.println(); 
 System.out.println(); 
 } 
 }  // Resets all the static fields to their default values and clears the queues 
 // 
 public static void reset() { 
 Plane p = new Plane(); 
 landing.clear(); 
 takeoff.clear(); 
 currentTime = 1; 
 endTime = 30; 
 idleTime = 0; 
 numPlanes = 0; 
 numLanded = 0; 
 numTookoff = 0; 
 numRefused = 0; 
 landWait = 0; 
 takeoffWait = 0; 
 } 
} 