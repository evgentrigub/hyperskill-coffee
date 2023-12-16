package evgentrigub.helpers;

import evgentrigub.CoffeeMachine;
import evgentrigub.models.IngredientAmount;
import evgentrigub.models.Ingredients;

import java.util.*;

public class CoffeeHelper {

    public static int getPossibleCups(IngredientAmount amount) {
        var waterPossible = (int)Math.floor(amount.waterQuantity / 200d);
        var milkPossible = (int) Math.floor(amount.milkQuantity / 50d);
        var beansPossible = (int) Math.floor(amount.beansQuantity / 15d);

        return Collections.min(List.of(waterPossible, milkPossible, beansPossible));
    }

    public static void calculateCoffeeDrink(int water, int milk, int beans, int money) {
        String notEnoughMessage = isEnoughIngredientsForCoffee(water, milk, beans);
        if(notEnoughMessage == null){
            printSuccessMessage();
            Ingredients.MACHINE_WATER -= water;
            Ingredients.MACHINE_MILK -= milk;
            Ingredients.MACHINE_BEANS -= beans;
            Ingredients.MACHINE_CUPS -= 1;
            Ingredients.MACHINE_MONEY += money;
        } else {
            System.out.println(notEnoughMessage);
        }
        CoffeeMachine.showMenu();
    }

    private static String isEnoughIngredientsForCoffee(int water, int milk, int beans){
        if(Ingredients.MACHINE_WATER < water){
            return "Sorry, not enough water!";
        }
        if(Ingredients.MACHINE_MILK < milk){
            return "Sorry, not enough milk!";
        }
        if(Ingredients.MACHINE_BEANS < beans){
            return "Sorry, not enough beans!";
        }
        return null;
    }

    private static void printSuccessMessage() {
        System.out.println("I have enough resources, making you a coffee!");
    }

    // deprecated
    public static IngredientAmount getCoffeeIngredients(int cupsQuantity) {
        var water = cupsQuantity * 200;
        var milk = cupsQuantity * 50;
        var beans = cupsQuantity * 15;

        return new IngredientAmount(water, milk, beans);
    }

    // deprecated
    public static void printRequiredIngredients(int cupsQuantity, IngredientAmount amount) {
        System.out.println("For " + cupsQuantity + " cups of coffee you will need:");
        System.out.println(amount.waterQuantity + " ml of water");
        System.out.println(amount.milkQuantity + " ml of milk");
        System.out.println(amount.beansQuantity + " g of coffee beans");
    }

    // deprecated
    public static boolean isPossibleMakeCoffee(IngredientAmount currentAmount, IngredientAmount requiredAmount) {
        return currentAmount.beansQuantity > requiredAmount.beansQuantity
                && currentAmount.milkQuantity > requiredAmount.milkQuantity
                && currentAmount.waterQuantity > requiredAmount.waterQuantity;
    }

    // deprecated
    private void printPossibleCupsOfCoffee(){
        var currentIngredients = CoffeeQuestionHelper.getCurrentIngredientsQuantity();
        var possibleCupsOfCoffee = CoffeeHelper.getPossibleCups(currentIngredients);

        var requiredCupsQuantity = CoffeeQuestionHelper.getCoffeeQuantity();

        if (possibleCupsOfCoffee < requiredCupsQuantity){
            printNoMessage(possibleCupsOfCoffee);
        } else if(requiredCupsQuantity == possibleCupsOfCoffee){
            printYesMessage();
        } else {
            printYesMessage(possibleCupsOfCoffee - requiredCupsQuantity);
        }
    }

    private static void printYesMessage() {
        System.out.println("Yes, I can make that amount of coffee");
    }

    private static void printYesMessage(int extraQuantity) {
        System.out.println("Yes, I can make that amount of coffee (and even" + extraQuantity + "more than that)");
    }

    private static void printNoMessage(int cupsQuantity) {
        System.out.println("No, I can make only" + cupsQuantity + " cup(s) of coffee");
    }
}
