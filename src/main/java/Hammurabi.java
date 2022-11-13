import java.util.*;

public class Hammurabi {

    Random random = new Random();
    int randomNum = random.nextInt();

    // *****************************************************************************************************************
    // ***************** CONSTRUCTOR/GAME INITIALIZATION/ROUND INITILIZATION/EXIT

    public Hammurabi() {
    }

    public int howManyAcresToBuy(int acresToBuy, int price, int bushels){
        if ( (acresToBuy * price) > bushels){
            System.out.println("You FOOL! You don't have enough bushels to buy that many acres!");
            return 0;
        } else return acresToBuy;
    }

    public int howManyAcresToSell(int acresOwned) {
        return 0;
    }

    public int howMuchGrainToFeedPeople(int bushels) {
        return 0;
    }

    public int howManyAcresToPlant(int acresOwned, int population, int bushels) {
        return 0;
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
