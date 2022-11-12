package hammurabi.docs.matuszek;//package Hammurabi;
import java.util.Random;         // imports go here
import java.util.Scanner;

    public class Hammurabi {         // must save in a file named Hammurabi.java
        Random rand = new Random();  // this is an instance variable
        Scanner scanner = new Scanner(System.in);

        int people;
        int bushelsOfGrain;
        int acres;
        int landValue;

        public Hammurabi(int peo,int bus, int acr, int lan){
            this.people=peo;
            this.bushelsOfGrain=bus;
            this.acres=acr;
            this.landValue=lan;
        }
//*   100 people
//*   2800 bushels of grain in storage
//*   1000 acres of land
//*   Land value is 19 bushels/acre

        public static void main(String[] args) { // required in every Java program
            new Hammurabi(100,2800,1000,19).playGame();
        }

        void playGame() {
            // declare local variables here: grain, population, etc.
            // statements go after the declations
        }

        //other methods go here
        int askHowManyAcresToBuy(int price, int bushels){
            System.out.println("How many acres do you wish to buy?");
            int in=scanner.nextInt();
            while(in*price>bushels || in <=0){
                System.out.println("Hammurabi: Thank again. You have only "+ bushels+" of grain.  ");
                System.out.println("Re-enter the numbers of acres you wish to buy");
                in=scanner.nextInt();
            }
                return in;
        }

        //Asks the player how many acres of land to buy, and returns that number. You must have enough grain to pay for your purchase.

        int askHowManyAcresToSell(int acresOwned){
            return 1;
        }

        //Asks the player how many acres of land to sell, and returns that number. You can't sell more than you have.
        //Do not ask this question if the player is buying land; it doesn't make sense to do both in one turn.

        int askHowMuchGrainToFeedPeople(int bushels){
            return 1;
        }

        //Ask the player how much grain to feed people, and returns that number. You can't feed them more grain than you have. You can feed them more than they need to survive.

        int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
            return 1;
        }

        //Ask the player how many acres to plant with grain, and returns that number. You must have enough acres, enough grain, and enough people to do the planting. Any grain left over goes into storage for next year.
        int plagueDeaths(int population){
            return 1;
        }

       // Each year, there is a 15% chance of a horrible plague. When this happens, half your people die. Return the number of plague deaths (possibly zero).
        int starvationDeaths(int population, int bushelsFedToPeople){
            return 1;
        }

       // Each person needs 20 bushels of grain to survive. If you feed them more than this, they are happy, but the grain is still gone. You don't get any benefit from having happy subjects. Return the number of deaths from starvation (possibly zero).

       boolean uprising(int population, int howManyPeopleStarved){
           return true;
       }

       // Return true if more than 45% of the people starve. (This will cause you to be immediately thrown out of office, ending the game.)

       int immigrants(int population, int acresOwned, int grainInStorage){
           return 1;
       }

        //Nobody will come to the city if people are starving (so don't call this method). If everyone is well fed, compute how many people come to the city as: (20 * _number of acres you have_ + _amount of grain you have in storage_) / (100 * _population_) + 1.

       int harvest(int acres, int bushelsUsedAsSeed){
           return 1;
       }

        //Choose a random integer between 1 and 6, inclusive. Each acre that was planted with seed will yield this many bushels of grain. (Example: if you planted 50 acres, and your number is 3, you harvest 150 bushels of grain). Return the number of bushels harvested.

        int grainEatenByRats(int bushels){
            return 1;
        }

        //There is a 40% chance that you will have a rat infestation. When this happens, rats will eat somewhere between 10% and 30% of your grain. Return the amount of grain eaten by rats (possibly zero).

       int newCostOfLand(){
           return 1;
       }

        //The price of land is random, and
    }

