import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                  INPUT
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int acresToBuySOUT(int price){
        int acresToBuy = getNumber("How many acres would you like to buy? The price is currently " + price + " bushels per acre.");
        return acresToBuy;
    }

    public int acresToSellSOUT(int price){
        int acresToSell = getNumber("How many acres would you like to sell? The Price is currently " + price + " bushels per acre.");
        return acresToSell;
    }

    public int bushelsToFeed(){
        int bushelsFed = getNumber("How many bushels would you like to feed your nation?");
        return bushelsFed;
    }

    public int acresToPlant(){
        int acresPlanted = getNumber("How many acres to plant?");
        return acresPlanted;
    }

    public boolean exitGame() {
        System.out.println("\n");
        int options = getNumber("Would you like to play again? 1 = Yes, 2 = No");
        boolean answer = true;
        switch (options) {
            case 1:
                System.out.println("That's the spirit! Let's play again!");
                answer = true;
                break;
            case 2:
                System.out.println("Goodbye :-(");
                answer = false;
                break;
        }
        return answer;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                  OUTPUT
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void announceGame(int population, int bushels, int landsOwned, int price) {
        System.out.println("\n");
        System.out.println("Congratulations, you are the newest ruler of ancient Sumer, elected for a ten year term of office.");
        System.out.println("Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people.");
        System.out.println("Grain is the general currency, measured in bushels.");
        System.out.println("\n");
        System.out.println("The following will help you in your decisions:");
        System.out.println("\n");
        System.out.println("**Each person needs at least 20 bushels of grain per year to survive**");
        System.out.println("**Each person can farm at most 10 acres of land**");
        System.out.println("**It takes 2 bushels of grain to farm an acre of land**");
        System.out.println("**The market price for land fluctuates yearly**");
        System.out.println("\n");
        System.out.println("Now, let's begin!");
        System.out.println("\n");
        System.out.println("O great One! Your kingdom await your orders!");
        System.out.println("There are " + population + " people that you must feed!");
        System.out.println("Our coffers have " + bushels + " bushels in storage.");
        System.out.println("The city owns " + landsOwned + " acres of land.");
        System.out.println("Land is available to purchase for " + price + " bushels per acre");
        System.out.println("Rats destroyed 200 bushels");
        System.out.println("\n");
    }

    public void printSummary(int year, int immigrants, int sDeaths, int pDeaths, int population, int rats, int bushels, int landsOwned, int price) {
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("O great Hammurabi");
        System.out.println("You are now in year " + year + " of your ten year rule.");
        System.out.println("\n");
        System.out.println("In the previous year " + immigrants + " people came to the kingdom.");
        System.out.println("In the previous year " + sDeaths + " people starved to death.");
        System.out.println("In the previous year " + pDeaths + " people died from plague");
        System.out.println("The population is now " + population);
//        System.out.println("We harvested " + state.getHarvest() + " bushels"); <-Bugged due to RNG, DO WE WANT TO FIX THIS? --EMORY
        System.out.println("Rats destroyed " + rats + " bushels");
        System.out.println("There are only " + bushels + " bushels left in storage.");
        System.out.println("The city owns " + landsOwned + " acres of land.");
        System.out.println("Land is currently worth " + price + " bushels per acre");
        System.out.println("\n");
    }

    public void prompt(int bushels, int population, int landsOwned) { //<-Newly added
        System.out.println("\n");
        System.out.println("Bushels left: " + bushels
                + "\npopulation number: " + population
                + "\nAcres: " + landsOwned);
        System.out.println("\n");
    }

    public void gameEndingPrompt(int deathsPool, int immigrantsPool, int population, int landsOwned) { //<-Newly added
        System.out.printf("You completed the game with %.4f%% starvation deaths out of %s\n",
                (double) deathsPool / (1000 + immigrantsPool) * 100, population);
        System.out.printf("You completed the game with %.4f acres per population\n",
                (double) landsOwned / population);
    }

    public void monster() {
        System.out.println("\n");
        System.out.println("You MONSTER!! You killed so many people!! WE WILL AVENGE THEM!!!!!!");
        System.out.println("\n");
    }

    public void boring() {
//        System.out.println("You brought great... okayness... to our kingdom... thanks for not killing all of us?");
        System.out.println("\n");
        System.out.println("You have brought normalization to your kingdom. You are one boring ruler!");
        System.out.println("\n");
    }

    public void thriving() {
        System.out.println("\n");
        System.out.println("Your kingdom is thriving! You are one superb ruler!");
        System.out.println("\n");

    }

    public void guts(){
        System.out.println("\n");
        System.out.println("While you brought your kingdom to make it through the years, you are " +
                "still a terrible ruler. Your people hated your guts!");
        System.out.println("\n");
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                  SCANNERS
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    int getNumber(String message) {
        while (true) {
            System.out.println(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }

    String getString(String message) {
        while (true) {
            System.out.println(message);
            try {
                return scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a word!");
            }
        }
    }
}