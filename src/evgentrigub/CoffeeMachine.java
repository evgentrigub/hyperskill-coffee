package evgentrigub;

import evgentrigub.helpers.CoffeeQuestionHelper;

import java.util.Scanner;

import static evgentrigub.models.Ingredients.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu(){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.next()){
            case "buy":
                CoffeeQuestionHelper.setBuyCoffeeCommand();
                break;
            case "fill":
                CoffeeQuestionHelper.setFillCoffeeCommand();
                showMenu();
                break;
            case "take":
                CoffeeQuestionHelper.setTakeCoffeeCommand();
                showMenu();
                break;
            case "remaining":
                printCurrentCoffeeMachineState();
                showMenu();
                break;
            case "exit":
                break;
        }
    }

    private static void printCurrentCoffeeMachineState() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(MACHINE_WATER + " ml of water");
        System.out.println(MACHINE_MILK + " ml of milk");
        System.out.println(MACHINE_BEANS + " g of coffee beans");
        System.out.println(MACHINE_CUPS + " disposable cups");
        System.out.println("$" + MACHINE_MONEY + " of money");
        System.out.println();
    }
}
