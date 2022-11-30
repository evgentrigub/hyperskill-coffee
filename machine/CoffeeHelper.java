import java.util.*;

public class CoffeeHelper {
    public static IngredientAmount getCoffeeIngredients(int cupsQuantity) {
        var water = cupsQuantity * 200;
        var milk = cupsQuantity * 50;
        var beans = cupsQuantity * 15;

        return new IngredientAmount(water, milk, beans);
    }

    public static int getPossibleCups(IngredientAmount amount) {
        var waterPossible = (int)Math.floor(amount.waterQuantity / 200d);
        var milkPossible = (int) Math.floor(amount.milkQuantity / 50d);
        var beansPossible = (int) Math.floor(amount.beansQuantity / 15d);

        return Collections.min(List.of(waterPossible, milkPossible, beansPossible));
    }

    public static void printRequiredIngredients(int cupsQuantity, IngredientAmount amount) {
        System.out.println("For " + cupsQuantity + " cups of coffee you will need:");
        System.out.println(amount.waterQuantity + " ml of water");
        System.out.println(amount.milkQuantity + " ml of milk");
        System.out.println(amount.beansQuantity + " g of coffee beans");
    }

    public static boolean isPossibleMakeCoffee(IngredientAmount currentAmount, IngredientAmount requiredAmount) {
        return currentAmount.beansQuantity > requiredAmount.beansQuantity
                && currentAmount.milkQuantity > requiredAmount.milkQuantity
                && currentAmount.waterQuantity > requiredAmount.waterQuantity;
    }

    public static void calculateCoffeeDrink(int water, int milk, int beans, int money) {
        String notEnoughMessage = isEnoughIngredientsForCoffee(water, milk, beans);
        if(notEnoughMessage == null){
            CoffeeMachine.printSuccessMessage();
            CoffeeMachine.machineWater -= water;
            CoffeeMachine.machineMilk -= milk;
            CoffeeMachine.machineBeans -= beans;
            CoffeeMachine.machineCups -= 1;
            CoffeeMachine.machineMoney += money;
        } else {
            System.out.println(notEnoughMessage);
        }
        CoffeeMachine.showMenu();
    }

    private static String isEnoughIngredientsForCoffee(int water, int milk, int beans){
        if(CoffeeMachine.machineWater < water){
            return "Sorry, not enough water!";
        }
        if(CoffeeMachine.machineMilk < milk){
            return "Sorry, not enough milk!";
        }
        if(CoffeeMachine.machineBeans < beans){
            return "Sorry, not enough beans!";
        }
        return null;
    }
}
