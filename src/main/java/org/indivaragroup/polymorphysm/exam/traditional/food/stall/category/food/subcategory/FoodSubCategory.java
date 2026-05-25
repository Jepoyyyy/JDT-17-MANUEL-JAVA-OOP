package org.indivaragroup.polymorphysm.exam.traditional.food.stall.category.food.subcategory;

import org.indivaragroup.polymorphysm.exam.traditional.food.stall.interfacing.InterfaceFood;
import org.indivaragroup.polymorphysm.exam.traditional.food.stall.menu.Menu;

public class FoodSubCategory implements InterfaceFood {
    private String name;
    private String mainCategory;
    private String subCategory;
    private String anekaSubCategory;

    public FoodSubCategory(String name, String mainCategory, String subCategory, String anekaSubCategory) {
        this.name = name;
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.anekaSubCategory = anekaSubCategory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getMainCategory() {
        return this.mainCategory;
    }

    @Override
    public double calculatePrice() {
        if (Menu.CatFried.equals(this.mainCategory)) {
            if (Menu.SubCatVegetableFritter.equals(this.subCategory)) {
                return 3000;
            } else if (Menu.SubCatTofu.equals(this.subCategory)) {
                return 2500;
            }
            return 2000;
        }

        double basePrice = 0;
        if (Menu.SubCatFish.equals(this.subCategory)) {
            basePrice = 15000;
        } else if (Menu.SubCatChicken.equals(this.subCategory)) {
            basePrice = 20000;
        } else if (Menu.SubCatBeef.equals(this.subCategory)) {
            basePrice = 25000;
        }

        double methodPrice = 0;
        if (Menu.AnekaFry.equals(this.anekaSubCategory)) {
            methodPrice = 3000;
        } else if (Menu.AnekaBoil.equals(this.anekaSubCategory)) {
            methodPrice = 1500;
        } else if (Menu.AnekaToast.equals(this.anekaSubCategory)) {
            methodPrice = 5000;
        }

        return basePrice + methodPrice;
    }

    @Override
    public void displayMenuInfo() {
        String displayMethod = this.anekaSubCategory;
        if (Menu.CatFried.equals(this.mainCategory)) {
            displayMethod = Menu.AnekaFry;
        }

        System.out.printf("%-25s | %-10s | %-10s | Rp %,.0f\n",
                getName(), subCategory, displayMethod, calculatePrice());
    }
}