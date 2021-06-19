package Homework04;

/** 
 * @(#)PoisonDistGenerator.java 
 * 
 * @author Asaad.Da
 * @version 1.00 2021/6/20 
 * 
 * This class provides a random non-negative integer with a Poison distribution 
 * based on an expected number, which is a double real number between 0 and 1.0. 
 */ 

import java.util.Random; // Random number of uniform distribution. 
import java.lang.Math; // Provides the exp() method. 



public class PoisonDistGenerator { 
 
	
 private double expectedNumber; // Stores the expected number value
 private static Random rand; // Stores a random number sequence
 
 
 static { // Create the random number sequence
 rand = new Random(); // initialized from system current time
 rand.setSeed(System.currentTimeMillis()); 
 } 
 
 
 public PoisonDistGenerator() { // Default constructor
 expectedNumber = 0.5; // Default expected number value is 0.5
 } 
 
 
 public PoisonDistGenerator(double e) { // Another constructor
 expectedNumber = e; // Initialize with the given value.
 } 
 
 
 public void setExpectedNumber(double e) { // Changes the expected value.
 expectedNumber = e; 
 } 
 
 
 public double getExpectedNumber() { // Returns the expected value.
 return expectedNumber; 
 } 
 
 
 public int getNumber() { // Generates the next number of the random
 double em, x; // number sequence with the requested 
 int n; // Poison distribution.
 em = Math.exp(-expectedNumber); 
 x = rand.nextDouble(); 
 n = 0; 
 while (x > em) { 
 n++; 
 x = x * rand.nextDouble(); 
 } 
 return n; 
 } 
 
 
  }