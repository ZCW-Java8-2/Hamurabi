import java.util.*;

public class GameEngine {

    Random random = new Random();
    int randomNum = random.nextInt();

    // *****************************************************************************************************************
    // ***************** CONSTRUCTOR/GAME INITIALIZATION/ROUND INITILIZATION/EXIT

    public GameEngine() {
    }

    public int calculateAcresToBuy(int acresToBuy, int price, int bushels){
        if ( (acresToBuy * price) > bushels){
            System.out.println("You FOOL! You don't have enough bushels to buy that many acres!");
            return 0;
        } else return acresToBuy;
    }

    public int calculateAcresToSell(int acresOwned) {
        return 0;
    }

    public int calculateGrainToFeedPeople(int bushels) {
        return 0;
    }

    public int calculateAcresToPlant(int acresToPlant, int acresOwned, int population, int bushels) {
        if (acresToPlant > acresOwned){
            System.out.println("You dum dum, you only have " + acresOwned + " acres!");
            return 0;
        } else if ( acresToPlant/10 > population){
            System.out.println("You don't have enough people to plant that many acres!!");
            return 0;
        } else if (acresToPlant/2 > bushels){
            System.out.println("You don't have enough grain to plant that many acres!");
            return 0;
        } else {
            return acresToPlant; // do state.changeBushels((acresToPlant*2)*-1) in the UserInterface class...
        }
    }

    // *****************************************************************************************************************
    // ***************** SUPPLEMENTARY FEATURES

    public int plagueDeaths(int population) {
        return 0;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople) {
        return 0;
    }

    public boolean uprising(int population, int howManyPeopleStarved) {
        return true;
    }

    public int immigrants (int population, int acresOwned, int grainInStorage) {
        return 0;
    }

    public int harvest (int bushelsUsedAsSeed) {
        return 0;
    }

    public int grainEatenByRats (int bushels) {
        return random.nextInt(21)+10;
    }
}
