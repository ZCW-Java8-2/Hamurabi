import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                  INPUT
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int acresToBuySOUT(int price){
        int acresToBuy = getNumber("How many acres would you like to buy? The price is currently " + price + " bushels per acre.");
//        int acresToBuy = getNumber("How many galaxies would you like to buy? The price is currently " + price + " stars per galaxy.");
        return acresToBuy;
    }

    public int acresToSellSOUT(int price){
        int acresToSell = getNumber("How many acres would you like to sell? The Price is currently " + price + " bushels per acre.");
//        int acresToSell = getNumber("How many galaxies would you like to sell? The price is currently " + price + " stars per galaxy.");
        return acresToSell;
    }

    public int bushelsToFeed(){
        int bushelsFed = getNumber("How many bushels would you like to feed your nation?");
//        int bushelsFed = getNumber("How many stars would you like to feed your aliens with?");
        return bushelsFed;
    }

    public int acresToPlant(){
//        int acresPlanted = getNumber("How many galaxies to duplicate stars?");
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
        System.out.println("**It takes 1 bushel of grain to farm an acre of land**");
        System.out.println("**The market price for land fluctuates yearly**");
        System.out.println("**It's recommended to calculate before answering, there is no turning back**");
        System.out.println("\n");
        System.out.println("**WARNING!!!**");
        System.out.println("**THE GAME IS OVER WHEN DEATH BY STARVATION IS MORE THAN 45% OF CURRENT POPULATION!!!**");
        System.out.println("**THE GAME IS OVER WHEN ACRES ARE LESS THAN 7 PER POPULATION!!!**");
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
//        System.out.println("\n");
//        System.out.println("Greetings, commander. You have been selected by the Universe of ZCW8.2 to lead for ten million years.");
//        System.out.println("For the sake of the aliens, you need to feed them with stars, and using galaxies to duplicate the stars");
//        System.out.println("You may also buy and sell galaxies by the transaction of stars");
//        System.out.println("\n");
//        System.out.println("The following will help you in your decisions:");
//        System.out.println("\n");
//        System.out.println("**Each alien needs at least 20 stars per 1 million years to survive**");
//        System.out.println("**Each alien can utilize at most 10 galaxies to grow stars**");
//        System.out.println("**To duplicate stars, each galaxy needs 1 star**");
//        System.out.println("**The stars cost for galaxy fluctuates every 1 million years**");
//        System.out.println("**It's recommended to calculate before answering, there is no turning back**");
//        System.out.println("\n");
//        System.out.println("**WARNING!!!**");
//        System.out.println("**THE GAME IS OVER WHEN DEATH BY STARVATION IS MORE THAN 45% OF CURRENT ALIENS!!!**");
//        System.out.println("**THE GAME IS OVER WHEN GALAXIES ARE LESS THAN 7 PER ALIEN!!!**");
//        System.out.println("\n");
//        System.out.println("Now, let's begin!");
//        System.out.println("\n");
//        System.out.println("Commander, ZCW8.2 is currently waiting for your order.");
//        System.out.println("There are " + population + " aliens that you must feed");
//        System.out.println("Our wormhole currently has " + bushels + " stars in dimension");
//        System.out.println("ZCW8.2 has " + landsOwned + " galaxies in our possession");
//        System.out.println("Galaxies are available for trading for " + price + " stars");
//        System.out.println("Space pirates destroyed 200 stars");
//        System.out.println("\n");
    }

    public void printSummary(int year, int immigrants, int sDeaths, int pDeaths, int population, int rats, int bushels, int landsOwned, int price) {
//        System.out.println("\n");
//        System.out.println("\n");
//        System.out.println("Greetings, Commander");
//        System.out.println("You are now in year " + year + " million of your ten million year rule");
//        System.out.println("\n");
//        System.out.println("In the previous 1 million years, " + immigrants + " aliens came to ZCW8.2");
//        System.out.println("In the previous 1 million years, " + sDeaths + " aliens starved to death");
//        System.out.println("In the previous 1 million years, " + pDeaths + " aliens died from EMPs");
//        System.out.println("The population is now " + population);
////        System.out.println("We harvested " + state.getHarvest() + " bushels"); <-Bugged due to RNG, DO WE WANT TO FIX THIS? --EMORY
//        System.out.println("Space pirates destroyed " + rats + " stars");
//        System.out.println("There are " + bushels + " stars left in the wormhole");
//        System.out.println("ZCW8.2 has " + landsOwned + " galaxies in our possession");
//        System.out.println("Galaxies are available for trading for " + price + " stars");
//        System.out.println("\n");
//    }
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
//        System.out.println("\n");
//        System.out.println("Stars remaining: " + bushels
//                + "\nAliens number: " + population
//                + "\nGalaxies: " + landsOwned);
//        System.out.println("\n");
//    }

    public void gameEndingPrompt(int deathsPool, int immigrantsPool, int population, int landsOwned) { //<-Newly added
        System.out.printf("You completed the game with %.4f%% starvation deaths out of %s\n",
                (double) deathsPool / (1000 + immigrantsPool) * 100, population);
        System.out.printf("You completed the game with %.4f acres per population\n",
                (double) landsOwned / population);
    }
//        System.out.printf("You completed the game with %.4f%% starvation deaths, %s deaths by starvation vs %s total population\n",
//                (double) deathsPool / (100 + immigrantsPool) * 100, deathsPool, 100 + immigrantsPool);
//        System.out.printf("You completed the game with %.4f galaxies per alien\n",
//                (double) landsOwned / population);
//    }

    public void monster() {
        System.out.println("\n");
        System.out.println("You MONSTER!! You killed so many people!! WE WILL AVENGE THEM!!!!!!");
        System.out.println("\n");
    }
//        System.out.println("\n");
//        System.out.println("Due to your terrible decisions making, you are hereby dethroned from your Commander position and are being hunted by the aliens.");
//        System.out.println("\n");
//    }

    public void boring() {
        System.out.println("You brought great... okayness... to our kingdom... thanks for not killing all of us?");
        System.out.println("\n");
        System.out.println("You have brought normalization to your kingdom. You are one boring ruler!");
        System.out.println("\n");
    }
//        System.out.println("\n");
//        System.out.println("You have made it to the end of the 10 million years without much damage or extra miles. The aliens thanked you.");
//        System.out.println("\n");
//    }

    public void thriving() {
        System.out.println("\n");
        System.out.println("Your kingdom is thriving! You are one superb ruler!");
        System.out.println("\n");
    }
//        System.out.println("\n");
//        System.out.println("On behalf of ZCW8.2, we thank you for your effort to drive the Universe forward. GLaDOS have a cake for you.");
//        System.out.println("\n");
//    }

    public void guts(){
        System.out.println("\n");
        System.out.println("While you brought your kingdom to make it through the years, you are " +
                "still a terrible ruler. Your people hated your guts!");
        System.out.println("\n");
    }
//        System.out.println("\n");
//        System.out.println("You have made it to the end of 10 million years. However, the aliens are currently building a time machine to undo your mistakes.");
//        System.out.println("\n");
//    }
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