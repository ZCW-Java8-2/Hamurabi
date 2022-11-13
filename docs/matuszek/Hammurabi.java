package hammurabi.docs.matuszek;//package Hammurabi;
import java.util.Random;         // imports go here
import java.util.Scanner;
import hammurabi.docs.matuszek.normalEvents.*;
import hammurabi.docs.matuszek.disasterEvents.*;

    public class Hammurabi {         // must save in a file named Hammurabi.java
        Random rand = new Random();  // this is an instance variable
        static Scanner scanner = new Scanner(System.in);

        private static int year = 0;
        private static boolean gameOver = false;
        private static int harvest = 0;
        private static int ratEaten = 0;
        private static int starving = 0;
        private static int immigrants = 0;
        private static int people = 100;
        private static int bushelsOfGrain = 2800;
        private static int acres = 1000;
        private static int landValue = 25;
        private static int bushelsPerAcre = 0;
        private static int peopleDeath = 0;
        private static int starvationPeopleDeath = 0;
        private static int acresToBuy =0;
        private static int acresToSell =0;
        private static int grainToFeed =0;
        private static int acresToPlant = 0;
        private static int plaguePeopleDeath =0;
        private static boolean uprisingPeople =false;
        private static int immigrantsPeople = 0;
        private static int harvestPeople = 0;
        private static int  grainEatenByRatsPeople =0;
        private static int newCostOfLandPeople =0;





        public Hammurabi(int peo,int bus, int acr, int lan){
            people=peo;
            bushelsOfGrain=bus;
            acres=acr;
            landValue=lan;

        }




        public void playGame() {

            while (!gameOver) {
                    year += 1;
                normalEvents.printStatus();
                normalEvents.playerTypeIn();
                disasterEvents.disasterCal();
                if (uprisingPeople) {
                    System.out.println("Too many people starved to death. Game Over!");
                    break;
                }
                if(starvationPeopleDeath > 0){
                    immigrantsPeople = normalEvents.immigrants(people, acres, bushelsOfGrain);
                }
                normalEvents.nextCal();
                if(year == 10){
                    gameOver = true;
                }
            }
        }

        //other methods go here





        public static int getYear() {
            return year;
        }

        public static void setYear(int year) {
            Hammurabi.year = year;
        }

        public static boolean isGameOver() {
            return gameOver;
        }

        public static void setGameOver(boolean gameOver) {
            Hammurabi.gameOver = gameOver;
        }

        public static int getHarvest() {
            return harvest;
        }

        public static void setHarvest(int harvest) {
            Hammurabi.harvest = harvest;
        }

        public static int getRatEaten() {
            return ratEaten;
        }

        public static void setRatEaten(int ratEaten) {
            Hammurabi.ratEaten = ratEaten;
        }

        public static int getStarving() {
            return starving;
        }

        public static void setStarving(int starving) {
            Hammurabi.starving = starving;
        }

        public static int getImmigrants() {
            return immigrants;
        }

        public static void setImmigrants(int immigrants) {
            Hammurabi.immigrants = immigrants;
        }

        public static int getPeople() {
            return people;
        }

        public static void setPeople(int people) {
            Hammurabi.people = people;
        }

        public static int getBushelsOfGrain() {
            return bushelsOfGrain;
        }

        public static void setBushelsOfGrain(int bushelsOfGrain) {
            Hammurabi.bushelsOfGrain = bushelsOfGrain;
        }

        public static int getAcres() {
            return acres;
        }

        public static void setAcres(int acres) {
            Hammurabi.acres = acres;
        }

        public static int getLandValue() {
            return landValue;
        }

        public static void setLandValue(int landValue) {
            Hammurabi.landValue = landValue;
        }

        public static int getBushelsPerAcre() {
            return bushelsPerAcre;
        }

        public static void setBushelsPerAcre(int bushelsPerAcre) {
            Hammurabi.bushelsPerAcre = bushelsPerAcre;
        }

        public static int getPeopleDeath() {
            return peopleDeath;
        }

        public static void setPeopleDeath(int peopleDeath) {
            Hammurabi.peopleDeath = peopleDeath;
        }

        public static int getStarvationPeopleDeath() {
            return starvationPeopleDeath;
        }

        public static void setStarvationPeopleDeath(int starvationPeopleDeath) {
            Hammurabi.starvationPeopleDeath = starvationPeopleDeath;
        }
        public static int getAcresToBuy() {
            return acresToBuy;
        }

        public static void setAcresToBuy(int acresToBuy) {
            Hammurabi.acresToBuy = acresToBuy;
        }

        public static int getAcresToSell() {
            return acresToSell;
        }

        public static void setAcresToSell(int acresToSell) {
            Hammurabi.acresToSell = acresToSell;
        }
        public static int getGrainToFeed() {
            return grainToFeed;
        }

        public static void setGrainToFeed(int grainToFeed) {
            Hammurabi.grainToFeed = grainToFeed;
        }

        public static int getAcresToPlant() {
            return acresToPlant;
        }

        public static void setAcresToPlant(int acresToPlant) {
            Hammurabi.acresToPlant = acresToPlant;
        }

        public static int getPlaguePeopleDeath() {
            return plaguePeopleDeath;
        }

        public static void setPlaguePeopleDeath(int plaguePeopleDeath) {
            Hammurabi.plaguePeopleDeath = plaguePeopleDeath;
        }
        public static boolean isUprisingPeople() {
            return uprisingPeople;
        }

        public static void setUprisingPeople(boolean uprisingPeople) {
            Hammurabi.uprisingPeople = uprisingPeople;
        }
        public static int getImmigrantsPeople() {
            return immigrantsPeople;
        }

        public static void setImmigrantsPeople(int immigrantsPeople) {
            Hammurabi.immigrantsPeople = immigrantsPeople;
        }

        public static int getHarvestPeople() {
            return harvestPeople;
        }

        public static void setHarvestPeople(int harvestPeople) {
            Hammurabi.harvestPeople = harvestPeople;
        }

        public static int getGrainEatenByRatsPeople() {
            return grainEatenByRatsPeople;
        }

        public static void setGrainEatenByRatsPeople(int grainEatenByRatsPeople) {
            Hammurabi.grainEatenByRatsPeople = grainEatenByRatsPeople;
        }

        public static int getNewCostOfLandPeople() {
            return newCostOfLandPeople;
        }

        public static void setNewCostOfLandPeople(int newCostOfLandPeople) {
            Hammurabi.newCostOfLandPeople = newCostOfLandPeople;
        }


    }

