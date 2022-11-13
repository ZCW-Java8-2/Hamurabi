package hammurabi.docs.matuszek;
import hammurabi.docs.matuszek.Hammurabi;

import static hammurabi.docs.matuszek.Hammurabi.*;
import static hammurabi.docs.matuszek.disasterEvents.rand;

public class normalEvents {

    public normalEvents(){};
    public static void printStatus() {
        System.out.println("O great Hammurabi!");
        System.out.println("You are in year " + Hammurabi.getYear() + " of your ten year rule.");
        System.out.println("In the previous year " + Hammurabi.getStarvationPeopleDeath() + " people starved to death.");
        System.out.println("the previous year " + Hammurabi.getImmigrants() + " people entered the kingdom.");
        System.out.println("The population is now " + Hammurabi.getPeople() + " .");
        System.out.println("We harvested " + Hammurabi.getHarvest() + " bushels at " + Hammurabi.getBushelsPerAcre() + " bushels per acre.");
        System.out.println("Rats destroyed " + Hammurabi.getRatEaten() + " bushels, leaving " + Hammurabi.getBushelsOfGrain() + " bushels in storage.");
        System.out.println("The city owns " + Hammurabi.getAcres() + " acres of land.");
        System.out.println("Land is currently worth " + Hammurabi.getLandValue() + " bushels per acre.\n");
    }

    public static void playerTypeIn() {
        int acresToBuy = askHowManyAcresToBuy(Hammurabi.getLandValue(), Hammurabi.getBushelsOfGrain());
        Hammurabi.setAcresToBuy(acresToBuy);
        if (Hammurabi.getAcresToBuy() == 0) {
            int acresToSell = askHowManyAcresToSell(Hammurabi.getAcres());
            Hammurabi.setAcresToSell(acresToSell);

        }
        int grainToFeed = askHowMuchGrainToFeedPeople(Hammurabi.getBushelsOfGrain());
        Hammurabi.setGrainToFeed(grainToFeed);

        int acresToPlant = askHowManyAcresToPlant(Hammurabi.getAcres(), Hammurabi.getPeople(), Hammurabi.getBushelsOfGrain());
        Hammurabi.setAcresToPlant(acresToPlant);
    }
    public static void nextCal(){
        Hammurabi.setHarvestPeople(harvest(Hammurabi.getAcresToPlant(), Hammurabi.getBushelsOfGrain()));
        Hammurabi.setGrainEatenByRatsPeople(grainEatenByRats(Hammurabi.getBushelsOfGrain()));
        Hammurabi.setNewCostOfLandPeople(newCostOfLand());
    }
    static int askHowManyAcresToBuy(int price, int bushels) {
        System.out.println("How many acres do you wish to buy?");
        int in = scanner.nextInt();
        while (in * price > bushels) {
            System.out.println("Hammurabi: Think again. You have only " + bushels + " of grain.  ");
            System.out.println("Re-enter the numbers of acres you wish to buy");
            in = scanner.nextInt();
        }
        Hammurabi.setBushelsOfGrain(Hammurabi.getBushelsOfGrain() - in * price);
        Hammurabi.setAcres(Hammurabi.getAcres() + in);
        return in;
    }
    //Asks the player how many acres of land to buy, and returns that number.
    // You must have enough grain to pay for your purchase.

    static int askHowManyAcresToSell(int acresOwned) {

        System.out.println("How many acres do you wish to sell?");
        int in = scanner.nextInt();
        while (in > acresOwned) {
            System.out.println("Hammurabi: Thank again. You have only " + acresOwned + " of grain.  ");
            System.out.println("Re-enter the numbers of acres you wish to sell: ");
            in = scanner.nextInt();
        }
        Hammurabi.setBushelsOfGrain(Hammurabi.getBushelsOfGrain() + in * Hammurabi.getLandValue());
        Hammurabi.setAcres(Hammurabi.getAcres() - in);
        return in;
    }
    //Asks the player how many acres of land to sell, and returns that number. You can't sell more than you have.
    //Do not ask this question if the player is buying land; it doesn't make sense to do both in one turn.

    static int askHowMuchGrainToFeedPeople(int bushels) {

        System.out.println("How many bushels do you wish to feed your people?");
        int in = scanner.nextInt();
        while (in > bushels ) {
            System.out.println("Hammurabi: Think again. You have only " + Hammurabi.getBushelsOfGrain() + " of grain.");
            System.out.println("Re-enter the numbers of bushels you wish to feed people: ");
            in = scanner.nextInt();
        }

        Hammurabi.setBushelsOfGrain(Hammurabi.getBushelsOfGrain() - in);
        return in;
    }

    //Ask the player how much grain to feed people,
    // and returns that number. You can't feed them more grain than you have.
    // You can feed them more than they need to survive.

    static int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        System.out.println("How many acres do you wish to plant with seed?");
        int in = scanner.nextInt();
        while (in > acresOwned || in > bushels || in>population*10) {
            System.out.println("Hammurabi: Think again. You have only " + Hammurabi.getBushelsOfGrain() + " of grain.  ");
            System.out.println("Re-enter the numbers of acres you wish to plant with seed: ");
            in = scanner.nextInt();
        }

        Hammurabi.setBushelsOfGrain(Hammurabi.getBushelsOfGrain() - in);
        return in;
    }
    // Return true if more than 45% of the people starve. (This will cause you to be immediately thrown out of office, ending the game.)

    static int immigrants(int population, int acresOwned, int grainInStorage) {

        if (Hammurabi.getStarving() == 0) {
            Hammurabi.setImmigrants((20 * acresOwned + grainInStorage) / (100 * population) + 1);
        }
        Hammurabi.setPeople(Hammurabi.getPeople() + Hammurabi.getImmigrants());
        return Hammurabi.getImmigrants();
           /*
           if(starvationDeaths(population,grainInStorage)>0){
               return 0;
           }else{
               return (20*acresOwned+grainInStorage)/(100*population)+1;
           }
           */

    }

    //Nobody will come to the city if people are starving (so don't call this method).
    // If everyone is well fed, compute how many people come to the city as:
    // (20 * _number of acres you have_ + _amount of grain you have in storage_) / (100 * _population_) + 1.

    static int harvest(int acres, int bushelsUsedAsSeed) {

        Hammurabi.setBushelsPerAcre(rand.nextInt(6) + 1);
        Hammurabi.setHarvest(Hammurabi.getBushelsPerAcre() * acres);
        Hammurabi.setBushelsOfGrain(Hammurabi.getBushelsOfGrain() - bushelsUsedAsSeed + Hammurabi.getHarvest());
        return Hammurabi.getHarvest();

    }

    //Choose a random integer between 1 and 6, inclusive. Each acre that was planted with seed will yield this many bushels of grain.
    // (Example: if you planted 50 acres, and your number is 3, you harvest 150 bushels of grain). Return the number of bushels harvested.

    static int grainEatenByRats(int bushels) {
        boolean ratInfestation = false;
        int ratEaten = 0;
        if (rand.nextFloat() * 100 <= 40) {
            ratInfestation = true;
        }
        if (ratInfestation) {
            ratEaten = bushels * (rand.nextInt(31 - 10) + 10) / 100;
        }

        Hammurabi.setRatEaten(ratEaten);
        return Hammurabi.getRatEaten();
    }

    //There is a 40% chance that you will have a rat infestation. When this happens, rats will eat somewhere between 10% and 30% of your grain. Return the amount of grain eaten by rats (possibly zero).

    static int newCostOfLand() {
        int min = 17, max = 24;
        Hammurabi.setLandValue(rand.nextInt(max - min) + min);
        return Hammurabi.getLandValue();
    }

}
