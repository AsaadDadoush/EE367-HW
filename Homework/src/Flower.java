/**
 * R-1.10
 * @(#)Flower.java
 * A simple Class to set and get a customize flower that enter by user
 * @author asaad
 * @version 1.00 2021/27/5
 *
 */
public class Flower {
	
	private String name;
	private int numberOfPetals;
	private Float price;
	
	//empty constructor
	public Flower() {
		
	}
	/**
	 * A constructor for Flower class
	 * @param name
	 * @param numberOfPetals
	 * @param price
	 */
	public Flower(String name, int numberOfPetals, Float price) {
		this.name = name;
		this.numberOfPetals = numberOfPetals;
		this.price = price;
		
	}
	
	/**
	 * Set a name for the flower
	 * @param name
	 * the name that user set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set a number of petals for the flower
	 * @param numberOfpetals
	 * The number of petals that user set
	 */
	public void setNumberOfPetals(int numberOfpetals) {
		this.numberOfPetals = numberOfpetals;
	}
	
	/**
	 * Set a price for the flower
	 * @param price
	 * the pirce that user set
	 */
	public void setPrice(Float price) {
		this.price = price;
		
	}
	
	/**
	 * get a name for the flower
	 * @param - none
	 * @return
	 * The name of the flower
	 */
	public String getName() {
		return name;
		
	}
	
	/**
	 * get a number of petals for the flower
	 * @param - none
	 * @return
	 * The number of petals for the flower
	 */
	public int getNumberOfpetals() {
		return numberOfPetals;
		
	}
	
	/**
	 * get a price for the flower
	 * @param - none
	 * @return
	 * The price of the flower
	 */
	public Float getPrice() {
		return price;
	}

}
