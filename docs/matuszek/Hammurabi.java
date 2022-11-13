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

        /*
        int people;
        int bushelsOfGrain;
        int acres;
        int landValue;
        int bushelsPerAcre;


        public Hammurabi(int peo, int bus, int acr, int lan) {
            this.people = peo;
            this.bushelsOfGrain = bus;
            this.acres = acr;
            this.landValue = lan;
          */

        }


        public static void main(String[] args) { // required in every Java program


            new Hammurabi(100, 2800, 1000, 19).playGame();

        }

        void playGame() {
            // declare local variables here: grain, population, etc.
            // statements go after the declations

            int people = 100;
            int bushelsOfGrain = 2800;
            int acres = 1000;
            int landValue = 19;
            int acresToBuy =0;
            int acresToSell =0;
            int grainToFeed =0;
            int acresToPlant = 0;
            int plaguePeopleDeath =0;
            int starvationPeopleDeath=0;
            boolean uprisingPeople =false;
            int immigrantsPeople = 0;
            int harvestPeople = 0;
            int grainEatenByRatsPeople =0;
            int newCostOfLandPeople =0;


            for (int i = 1; i < 11; i++) {
                System.out.println("O great Hammurabi!");
                System.out.println("You are in year " + i + " of your ten year rule.");
                System.out.println("In the previous year " + starvationPeopleDeath + " people starved to death.");
                System.out.println("the previous year " + this.getImmigrants() + " people entered the kingdom.");
                System.out.println("The population is now "+this.getPeople()+" .");
                System.out.println("We harvested "+this.getHarvest()+ " bushels at "+this.getBushelsPerAcre()+ " bushels per acre.");
                System.out.println("Rats destroyed "+ this.getRatEaten()+" bushels, leaving "+this.getBushelsOfGrain()+" bushels in storage.");
                System.out.println("The city owns "+this.getAcres()+ " acres of land.");
                System.out.println("Land is currently worth "+ this.getLandValue()+" bushels per acre.\n");

                acresToBuy=this.askHowManyAcresToBuy(this.getLandValue(), this.getBushelsOfGrain());
                if(acresToBuy==0){
                    acresToSell=this.askHowManyAcresToSell(this.getAcres());

                }
                grainToFeed=askHowMuchGrainToFeedPeople(this.bushelsOfGrain);
                acresToPlant=askHowManyAcresToPlant(this.acres,this.people, this.bushelsOfGrain);
                plaguePeopleDeath = plagueDeaths(this.people);
                starvationPeopleDeath = starvationDeaths(this.people, grainToFeed);
                uprisingPeople = uprising(this.people, starvationPeopleDeath);
                if (uprisingPeople) {
                    System.out.println("Too many people starved to death. Game Over!");
                    break;
                }
                if(starvationPeopleDeath>0){
                    immigrantsPeople = immigrants(this.people, this.acres, this.bushelsOfGrain);
                }
                harvestPeople = harvest(acresToPlant, this.bushelsOfGrain);
                grainEatenByRatsPeople =grainEatenByRats(this.bushelsOfGrain);
                newCostOfLandPeople =newCostOfLand();

            }


        }

        //other methods go here
        int askHowManyAcresToBuy(int price, int bushels) {
            System.out.println("How many acres do you wish to buy?");
            int in = scanner.nextInt();
            while (in * price > bushels) {
                System.out.println("Hammurabi: Think again. You have only " + bushels + " of grain.  ");
                System.out.println("Re-enter the numbers of acres you wish to buy");
                in = scanner.nextInt();
            }
            this.bushelsOfGrain-=in*price;
            this.acres+=in;
            return in;
        }
        //Asks the player how many acres of land to buy, and returns that number.
        // You must have enough grain to pay for your purchase.

        int askHowManyAcresToSell(int acresOwned) {

            System.out.println("How many acres do you wish to sell?");
            int in = scanner.nextInt();
            while (in > acresOwned) {
                System.out.println("Hammurabi: Thank again. You have only " + acresOwned + " of grain.  ");
                System.out.println("Re-enter the numbers of acres you wish to sell: ");
                in = scanner.nextInt();
            }
            this.bushelsOfGrain+=in*this.landValue;
            this.acres-=in;
            return in;
        }
        //Asks the player how many acres of land to sell, and returns that number. You can't sell more than you have.
        //Do not ask this question if the player is buying land; it doesn't make sense to do both in one turn.

        int askHowMuchGrainToFeedPeople(int bushels) {

            System.out.println("How many bushels do you wish to feed your people?");
            int in = scanner.nextInt();
            while (in > bushels ) {
                System.out.println("Hammurabi: Think again. You have only " + bushelsOfGrain + " of grain.");
                System.out.println("Re-enter the numbers of bushels you wish to feed people: ");
                in = scanner.nextInt();
            }
            this.bushelsOfGrain-=in;

            return in;
        }

        //Ask the player how much grain to feed people,
        // and returns that number. You can't feed them more grain than you have.
        // You can feed them more than they need to survive.

        int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
            System.out.println("How many acres do you wish to plant with seed?");
            int in = scanner.nextInt();
            while (in > acresOwned || in > bushels || in>population*10) {
                System.out.println("Hammurabi: Think again. You have only " + bushelsOfGrain + " of grain.  ");
                System.out.println("Re-enter the numbers of acres you wish to plant with seed: ");
                in = scanner.nextInt();
            }
            this.bushelsOfGrain-= in;
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
        int starvationDeaths(int population, int bushelsFedToPeople) {
            int numberOfStar = bushelsFedToPeople / 20 - population;
            if (numberOfStar >= 0) {
                return 0;
            } else {
                this.people -= Math.abs(numberOfStar);
                return Math.abs(numberOfStar);
            }
        }
        // Each person needs 20 bushels of grain to survive. If you feed them more than this, they are happy,
        // but the grain is still gone. You don't get any benefit from having happy subjects.
        // Return the number of deaths from starvation (possibly zero).

        boolean uprising(int population, int howManyPeopleStarved) {

            double starvingRate = (double) howManyPeopleStarved / population;
            if (starvingRate > 0.450) {
                this.gameOver = true;
            } else if (starvingRate <= 0.450) {
                this.gameOver = false;
            }

            return this.gameOver;


        }

        // Return true if more than 45% of the people starve. (This will cause you to be immediately thrown out of office, ending the game.)

        int immigrants(int population, int acresOwned, int grainInStorage) {

            if (starving == 0) {
                this.immigrants = (20 * acresOwned + grainInStorage) / (100 * population) + 1;
            }
            this.people +=immigrants;
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

        int harvest(int acres, int bushelsUsedAsSeed) {

            this.bushelsPerAcre = rand.nextInt(6) + 1;
            this.harvest = this.bushelsPerAcre * acres;
            this.bushelsOfGrain=this.bushelsOfGrain-bushelsUsedAsSeed+this.harvest;
            return harvest;

        }

        //Choose a random integer between 1 and 6, inclusive. Each acre that was planted with seed will yield this many bushels of grain.
        // (Example: if you planted 50 acres, and your number is 3, you harvest 150 bushels of grain). Return the number of bushels harvested.

        int grainEatenByRats(int bushels) {
            boolean ratInfestation = false;
            int ratEaten = 0;
            if (rand.nextFloat() * 100 <= 40) {
                ratInfestation = true;
            }
            if (ratInfestation) {
                ratEaten = bushels * (rand.nextInt(31 - 10) + 10) / 100;
            }
            this.ratEaten = ratEaten;
            return this.ratEaten;
        }

        //There is a 40% chance that you will have a rat infestation. When this happens, rats will eat somewhere between 10% and 30% of your grain. Return the amount of grain eaten by rats (possibly zero).

        int newCostOfLand() {
            int min = 17, max = 24;
            this.landValue = rand.nextInt(max - min) + min;
            return this.landValue;
        }

        public int getAcres() {
            return acres;
        }

        public void setAcres(int acres) {
            this.acres = acres;
        }

        public int getBushelsOfGrain() {
            return bushelsOfGrain;
        }

        public void setBushelsOfGrain(int bushelsOfGrain) {
            this.bushelsOfGrain = bushelsOfGrain;
        }

        public int getHarvest() {
            return harvest;
        }

        public void setHarvest(int harvest) {
            this.harvest = harvest;
        }

        public int getLandValue() {
            return landValue;
        }

        public void setLandValue(int landValue) {
            this.landValue = landValue;
        }

        public int getImmigrants() {
            return immigrants;
        }

        public void setImmigrants(int immigrants) {
            this.immigrants = immigrants;
        }

        public int getPeople() {
            return people;
        }

        public void setPeople(int people) {
            this.people = people;
        }

        public int getStarving() {
            return starving;
        }

        public void setStarving(int starving) {
            this.starving = starving;
        }

        public int getRatEaten() {
            return ratEaten;
        }

        public void setRatEaten(int ratEaten) {
            this.ratEaten = ratEaten;
        }

        public int getBushelsPerAcre() {
            return bushelsPerAcre;
        }

        public void setBushelsPerAcre(int bushelsPerAcre) {
            this.bushelsPerAcre = bushelsPerAcre;
        }
    }

