package Homework04;

/** 
 * @(#)ArrayQueue.java 
 * 
 * 
 * @author  Asaad.Da
 * @version 1.00 2021/6/20 
 * 
 * This class provides a FIFO queue for the elements stored in it. 
 * It is an adapter from the standard generic Java ArrayDeque class 
 * to provide the methods for the FIFO queue. 
 */ 

import java.util.ArrayDeque; 
public class ArrayQueue<E> extends ArrayDeque<E> { 
	
 private int limit; // Impose a limit on the queue size
 
 
 public ArrayQueue() { // The default constructor
 super(); 
 limit = 16; // Default size limit is 16
 } 
 
 public ArrayQueue(int numElements) { // Another constructor 
 super(numElements); 
 limit = numElements; // The queue has the given size limit
 } 
 
 
 public boolean enqueue(E e) { // Adaptor method for adding one element
 return offer(e); 
 } 
 
 
 public E serve() { // Adaptor method for removing one element
 return poll(); 
 } 
 
 
 public boolean isFull() { // A new method to test if the queue is full
 return (size() == limit); 
 } 
 
 
 
 
 
 
 
 
}