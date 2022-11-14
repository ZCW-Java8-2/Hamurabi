import java.util.*;

import static java.lang.Math.floor;

public class GameEngine {

    Random random = new Random();

    // *****************************************************************************************************************
    // ***************** GAME INITIALIZATION/ROUND INITILIZATION/EXIT

    public GameEngine() {
    }

    public int calculateAcresToBuy(int acresToBuy, int price, int bushels){
        if ( (acresToBuy * price) > bushels){
            System.out.println("You FOOL! You're trying to buy more than what you can afford, you get nothing and like it!");
            return 0;
        } else {
            return acresToBuy;
        }
    }

    public int calculateAcresToSell(int acresToSell, int landOwned) {
        if (acresToSell > landOwned) {
            System.out.println("Selling too much than what you own!");
            return 0;
        } else {
            return acresToSell;
        }
    }

    public int calculateGrainToFeedPeople(int bushels, int bushelsFed) {
        if (bushelsFed > bushels){
            return 0;
        } else {
            return bushelsFed;
        }
    }

    public int calculateAcresToPlant(int acresToPlant, int acresOwned, int population, int bushels) {

        //Tested my own method, 7 tests all passed
        while(true) {
            if (acresToPlant > population*10) {
                acresToPlant = population*10;
            } else if (acresToPlant > acresOwned) {
                acresToPlant = acresOwned;
            } else if (acresToPlant > bushels) {
                acresToPlant = bushels;
            }
            if (acresToPlant <= population*10 &&
                    acresToPlant <= acresOwned &&
                    acresToPlant <= bushels) {
                break;
            }
        }
//        System.out.println("Update: " + acresToPlant + " " + acresOwned + " " + population + " " + bushels);
        return acresToPlant;
    }
    //Original method

//        if (acresToPlant > acresOwned){
//            System.out.println("You dum dum, you only have " + acresOwned + " acres!");
//            return 0;
//        } else if ( acresToPlant/10 > population){
//            System.out.println("You don't have enough people to plant that many acres!!");
//            return 0;
//        } else if (acresToPlant/2 > bushels){
//            System.out.println("You don't have enough grain to plant that many acres!");
//            return 0;
//        } else {
//            return acresToPlant; // do state.changeBushels((acresToPlant*2)*-1) in the UserInterface class...
//        }
//    }

    // *****************************************************************************************************************
    // ***************** SUPPLEMENTARY FEATURES

    public int plagueDeaths(int population) {
        if(random.nextInt(101) < 15) return population/2;
        return 0;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople) {
        if(population - (int) floor(bushelsFedToPeople/20) < 0) return 0;
        return population - (int) floor(bushelsFedToPeople/20);
    }

    public boolean uprising(int population, int howManyPeopleStarved) {
        if ((double) howManyPeopleStarved / population > 0.45) return true;
        return false;
    }

    public int immigrants (int population, int acresOwned, int grainInStorage, int bushelsFedToPeople) {
        if(starvationDeaths(population, bushelsFedToPeople) > 0) return 0;
        return (20 * acresOwned + grainInStorage) / (100 * population) + 1;
    }

    public int harvest (int bushelsUsedAsSeed) {
        //Returning for the number of bushels harvested per acre
        return (random.nextInt(6)+1)*bushelsUsedAsSeed;
    }

    public int grainEatenByRats (int bushels) {
        if(random.nextInt(100) < 40) return (random.nextInt(21)+10)*bushels/100;
        return 0;
    }
}
