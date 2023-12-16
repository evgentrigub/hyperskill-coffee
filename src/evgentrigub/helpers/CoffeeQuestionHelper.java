package evgentrigub.helpers;

import evgentrigub.CoffeeMachine;
import evgentrigub.models.IngredientAmount;
import evgentrigub.models.Ingredients;

import java.util.Scanner;

public class CoffeeQuestionHelper {
    public static IngredientAmount getCurrentIngredientsQuantity(){
        var scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        var water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        var milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        var beans = scanner.nextInt();

        return new IngredientAmount(water, milk, beans);
    }

    public static int getCoffeeQuantity(){
        System.out.println("Write how many cups of coffee you will need:");
        return new Scanner(System.in).nextInt();
    }

    public static void setFillCoffeeCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        Ingredients.MACHINE_WATER +=scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        Ingredients.MACHINE_MILK +=scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        Ingredients.MACHINE_BEANS +=scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        Ingredients.MACHINE_CUPS +=scanner.nextInt();
    }

    public static void setBuyCoffeeCommand() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        showCoffeeMenu(num);
    }

    public static void setTakeCoffeeCommand() {
        System.out.println("I gave you $" + Ingredients.MACHINE_MONEY);
        Ingredients.MACHINE_MONEY = 0;
    }

    public static void showCoffeeMenu(String num) {
        switch (num) {
            case "1" -> CoffeeHelper.calculateCoffeeDrink(250, 0, 16, 4);
            case "2" -> CoffeeHelper.calculateCoffeeDrink(350, 75, 20, 7);
            case "3" -> CoffeeHelper.calculateCoffeeDrink(200, 100, 12, 6);
            default -> CoffeeMachine.showMenu();
        }
    }
}
