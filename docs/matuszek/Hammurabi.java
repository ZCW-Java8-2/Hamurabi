package hammurabi.docs.matuszek;//package Hammurabi;
import java.util.Random;         // imports go here
import java.util.Scanner;
import hammurabi.docs.matuszek.normalEvents.*;

    public class Hammurabi {         // must save in a file named Hammurabi.java
        Random rand = new Random();  // this is an instance variable
        Scanner scanner = new Scanner(System.in);

        int year = 0;
        boolean gameOver = false;
        int harvest = 0;
        int ratEaten = 0;
        int starving = 0;
        int immigrants = 0;
        public int people = 100;
        public int bushelsOfGrain = 2800;
        public int acres = 1000;
        public int landValue = 25;

        int peopleDeath = 0;
        int plagueDeath = 0;




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
           //
            Hammurabi h = new Hammurabi( 100,2800,1000,19);
            h.playGame();
        }
        void playGame() {
            // declare local variables here: grain, population, etc.
            // statements go after the declations
            while(!gameOver){
                this.year += 1;

            }
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
        //Asks the player how many acres of land to buy, and returns that number.
        // You must have enough grain to pay for your purchase.

        int askHowManyAcresToSell(int acresOwned){

            System.out.println("How many acres do you wish to sell?");
            int in=scanner.nextInt();
            while(in>acresOwned){
                System.out.println("Hammurabi: Thank again. You have only "+ acresOwned+" of grain.  ");
                System.out.println("Re-enter the numbers of acres you wish to sell: ");
                in=scanner.nextInt();
            }
            return in;
        }
        //Asks the player how many acres of land to sell, and returns that number. You can't sell more than you have.
        //Do not ask this question if the player is buying land; it doesn't make sense to do both in one turn.

        int askHowMuchGrainToFeedPeople(int bushels){

            System.out.println("How many bushels do you wish to feed your people?");
            int in=scanner.nextInt();
            while(in>bushels){
                System.out.println("Hammurabi: Think again. You have only "+ bushelsOfGrain+" of grain.  ");
                System.out.println("Re-enter the numbers of acres you wish to sell: ");
                in=scanner.nextInt();
            }
            return in;
        }

        //Ask the player how much grain to feed people,
        // and returns that number. You can't feed them more grain than you have.
        // You can feed them more than they need to survive.

        int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
            System.out.println("How many acres do you wish to plant with seed?");
            int in=scanner.nextInt();
            while(in>acresOwned || in>(bushels-population*20)){
                System.out.println("Hammurabi: Think again. You have only "+ bushelsOfGrain+" of grain.  ");
                System.out.println("Re-enter the numbers of acres you wish to plant with seed: ");
                in=scanner.nextInt();
            }
            bushels-=in;
            return in;
        }

        //Ask the player how many acres to plant with grain, and returns that number.
        // You must have enough acres, enough grain, and enough people to do the planting.
        // Any grain left over goes into storage for next year.
        int plagueDeaths(int population){
            int plaDea = rand.nextInt(100)+1;
            if(plaDea<=15) {
                return this.peopleDeath = population / 2;
            }else return 0;
        }


       // Each year, there is a 15% chance of a horrible plague. When this happens, half your people die.
       // Return the number of plague deaths (possibly zero).
        int starvationDeaths(int population, int bushelsFedToPeople){
            int numberOfStar=bushelsFedToPeople/20-population;
            if(numberOfStar>=0) {
                return 0;
            }else return Math.abs(numberOfStar);
        }
       // Each person needs 20 bushels of grain to survive. If you feed them more than this, they are happy,
        // but the grain is still gone. You don't get any benefit from having happy subjects.
        // Return the number of deaths from starvation (possibly zero).

       boolean uprising(int population, int howManyPeopleStarved){

            double starvingRate = (double) howManyPeopleStarved / population;
            if(starvingRate > 0.450){
                this.gameOver = true;
            } else if (starvingRate <= 0.450) {
                this.gameOver = false;
            }

           return this.gameOver;


           

       }

       // Return true if more than 45% of the people starve. (This will cause you to be immediately thrown out of office, ending the game.)

       int immigrants(int population, int acresOwned, int grainInStorage){

           if(starving == 0){
               this.immigrants = (20 * acresOwned + grainInStorage) / (100 * population) + 1;
           }

            return immigrants;
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

       int harvest(int acres, int bushelsUsedAsSeed){

           int fertilizer = rand.nextInt(7 - 1) + 1;
            this.harvest = bushelsUsedAsSeed * fertilizer * acres;
            return harvest;
          /*
           int ran = rand.nextInt(6)+1;
            return 1;
            */

       }

        //Choose a random integer between 1 and 6, inclusive. Each acre that was planted with seed will yield this many bushels of grain.
        // (Example: if you planted 50 acres, and your number is 3, you harvest 150 bushels of grain). Return the number of bushels harvested.

        int grainEatenByRats(int bushels){
            boolean ratInfestation = false;
            int ratEaten = 0;
            if(rand.nextFloat() * 100  <= 40){
                ratInfestation = true;
            }
            if(ratInfestation){
                ratEaten = bushels * (rand.nextInt(31 - 10 ) + 10) / 100;
            }
            this.ratEaten = ratEaten;
            return this.ratEaten;
        }

        //There is a 40% chance that you will have a rat infestation. When this happens, rats will eat somewhere between 10% and 30% of your grain. Return the amount of grain eaten by rats (possibly zero).

       int newCostOfLand(){
            int min = 17, max = 24;
           this.landValue = rand.nextInt(max - min) + min;
            return this.landValue;
       }

        //The price of land is random, and
    }

