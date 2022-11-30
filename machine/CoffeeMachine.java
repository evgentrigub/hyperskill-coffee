import java.util.Scanner;

public class CoffeeMachine {
    public static int machineWater = 400;
    public static int machineMilk = 540;
    public static int machineBeans = 120;
    public static int machineCups = 9;
    public static int machineMoney = 550;

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
        System.out.println("");
        System.out.println("The coffee machine has:");
        System.out.println(machineWater + " ml of water");
        System.out.println(machineMilk + " ml of milk");
        System.out.println(machineBeans + " g of coffee beans");
        System.out.println(machineCups + " disposable cups");
        System.out.println("$" + machineMoney + " of money");
        System.out.println("");
    }

    public static void printSuccessMessage() {
        System.out.println("I have enough resources, making you a coffee!");
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
