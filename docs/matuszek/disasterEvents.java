package hammurabi.docs.matuszek;

import java.util.Random;

public class disasterEvents {

    public disasterEvents(){}
    static Random rand = new Random();  // this is an instance variable
    public static void disasterCal(){
        Hammurabi.setPlaguePeopleDeath( plagueDeaths(Hammurabi.getPeople()));
        Hammurabi.setStarvationPeopleDeath( starvationDeaths(Hammurabi.getPeople(), Hammurabi.getGrainToFeed()));
        Hammurabi.setUprisingPeople(uprising(Hammurabi.getPeople(), Hammurabi.getStarvationPeopleDeath()));
    }

    static int plagueDeaths(int population){
        int plaDea = rand.nextInt(100)+1;
        if(plaDea<=15) {
            Hammurabi.setPeopleDeath(Hammurabi.getPeople() / 2);
            return Hammurabi.getPeopleDeath();
        }else return 0;

        /*
        int plagueDeaths(int population) {
            int plaDea = rand.nextInt(100) + 1;
            if (plaDea <= 15) {
                return population / 2;
            } else return 0;
            */

    }


    // Each year, there is a 15% chance of a horrible plague. When this happens, half your people die.
    // Return the number of plague deaths (possibly zero).
    static int starvationDeaths(int population, int bushelsFedToPeople) {
        int numberOfStar = bushelsFedToPeople / 20 - population;
        if (numberOfStar >= 0) {
            return 0;
        } else {

            Hammurabi.setPeople(Hammurabi.getPeople() - Math.abs(numberOfStar));
            return Math.abs(numberOfStar);
        }
    }
    // Each person needs 20 bushels of grain to survive. If you feed them more than this, they are happy,
    // but the grain is still gone. You don't get any benefit from having happy subjects.
    // Return the number of deaths from starvation (possibly zero).

    static boolean uprising(int population, int howManyPeopleStarved) {

        double starvingRate = (double) howManyPeopleStarved / population;
        if (starvingRate > 0.450) {
            Hammurabi.setGameOver(true);
        } else if (starvingRate <= 0.450) {
            Hammurabi.setGameOver(false);
        }

        return Hammurabi.isGameOver();


    }
}
