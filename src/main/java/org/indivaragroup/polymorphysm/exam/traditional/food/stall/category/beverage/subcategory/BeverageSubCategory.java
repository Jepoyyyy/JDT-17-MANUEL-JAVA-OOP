package org.indivaragroup.polymorphysm.exam.traditional.food.stall.category.beverage.subcategory;

import org.indivaragroup.polymorphysm.exam.traditional.food.stall.interfacing.InterfaceDrink;

public class BeverageSubCategory implements InterfaceDrink {
    private String name;
    private String mainCategory;
    private String temperature;
    private String taste;
    private double price;

    public BeverageSubCategory(String name, String mainCategory, String temperature, String taste, double price) {
        this.name = name;
        this.mainCategory = mainCategory;
        this.temperature = temperature;
        this.taste = taste;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double calculatePrice() {
        return this.price;
    }

    @Override
    public void displayMenuInfo() {
        System.out.printf("%-25s | %-10s | %-12s | Rp %,.0f\n",
                getName(), temperature, taste, calculatePrice());
    }
}