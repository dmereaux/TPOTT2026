package org.example;

public class Clothing {
    private int id;
    private String name;
    private double price;
    private boolean isPopular;

    public Clothing(int id, String name, double price, boolean isPopular) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isPopular = isPopular;
    }

    // Getters and Setters
    public int getId() {
    	return this.id;
    }
    public String getName()
    {return this.name;}
    public double getPrice()
    { return this.price;}
    public boolean isPopular()
    
    {
    	return isPopular;
    }
}
