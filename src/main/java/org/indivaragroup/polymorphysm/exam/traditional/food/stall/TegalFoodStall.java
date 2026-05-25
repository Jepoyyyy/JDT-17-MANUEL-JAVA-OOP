package org.indivaragroup.polymorphysm.exam.traditional.food.stall;

import org.indivaragroup.polymorphysm.exam.traditional.food.stall.category.food.subcategory.FoodSubCategory;
import org.indivaragroup.polymorphysm.exam.traditional.food.stall.category.beverage.subcategory.BeverageSubCategory;
import org.indivaragroup.polymorphysm.exam.traditional.food.stall.interfacing.InterfaceDrink;
import org.indivaragroup.polymorphysm.exam.traditional.food.stall.interfacing.InterfaceFood;
import org.indivaragroup.polymorphysm.exam.traditional.food.stall.interfacing.InterfaceTegalFoodStall;
import org.indivaragroup.polymorphysm.exam.traditional.food.stall.menu.Menu;

public class TegalFoodStall implements InterfaceTegalFoodStall {

    private InterfaceFood[] foods;
    private InterfaceDrink[] drinks;

    public TegalFoodStall() {
        initMockData();
    }

    private void initMockData() {
        this.foods = new InterfaceFood[5];
        this.foods[0] = new FoodSubCategory("AYAM BAKAR JERMAN", Menu.CatMeat, Menu.SubCatChicken, Menu.AnekaToast);
        this.foods[1] = new FoodSubCategory("IKAN GORENG ASAM LAMBUNG", Menu.CatMeat, Menu.SubCatFish, Menu.AnekaFry);
        this.foods[2] = new FoodSubCategory("SATE SAPI BUTEK", Menu.CatMeat, Menu.SubCatBeef, Menu.AnekaToast);
        this.foods[3] = new FoodSubCategory("BAKWAN GORENG KRESS", Menu.CatFried, Menu.SubCatVegetableFritter, Menu.AnekaFry);
        this.foods[4] = new FoodSubCategory("TAHU REBUS SEHAT", Menu.CatFried, Menu.SubCatTofu, Menu.AnekaBoil);

        this.drinks = new InterfaceDrink[3];
        this.drinks[0] = new BeverageSubCategory("ES TEH MANIS", Menu.CatBeverage, Menu.TempCool, Menu.TasteSweet, 5000);
        this.drinks[1] = new BeverageSubCategory("KOPI HITAM PANAS", Menu.CatBeverage, Menu.TempHot, Menu.TasteLessSugar, 7000);
        this.drinks[2] = new BeverageSubCategory("AIR MINERAL DINGIN", Menu.CatBeverage, Menu.TempCool, Menu.TastePlain, 4000);
    }

    @Override
    public void showFoodMenu() {
        System.out.println("MENU LAUK MAKANAN");
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("[" + Menu.CatMeat + "]");
        int meatCounter = 1;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i] != null && Menu.CatMeat.equals(foods[i].getMainCategory())) {
                System.out.print(meatCounter + ". ");
                foods[i].displayMenuInfo();
                meatCounter++;
            }
        }

        System.out.println("\n[" + Menu.CatFried + "]");
        int friedCounter = 1;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i] != null && Menu.CatFried.equals(foods[i].getMainCategory())) {
                System.out.print(friedCounter + ". ");
                foods[i].displayMenuInfo();
                friedCounter++;
            }
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    @Override
    public void showDrinkMenu() {
        System.out.println("\nMENU ANEKA MINUMAN");
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("[" + Menu.CatBeverage + "]");
        int drinkCounter = 1;
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] != null) {
                System.out.print(drinkCounter + ". ");
                drinks[i].displayMenuInfo();
                drinkCounter++;
            }
        }
        System.out.println("-------------------------------------------------------------------------");
    }
}