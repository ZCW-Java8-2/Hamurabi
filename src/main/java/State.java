import java.util.Random;

public class State {
    int population, landsOwned, bushels, price, year;
    int pDeaths, sDeaths, immigrants, harvest, rats;
    Random random = new Random();

    public State(){
    }

    public State(int population, int landsOwned, int bushels, int year, int price, int pDeaths, int sDeaths, int immigrants, int harvest, int rats) {
        this.population = population;
        this.landsOwned = landsOwned;
        this.bushels = bushels;
        this.year = year;
        this.price = price;
        this.pDeaths = pDeaths;
        this.sDeaths = sDeaths;
        this.immigrants = immigrants;
        this.harvest = harvest;
        this.rats = rats;
    }

    public State(int population, int landsOwned, int bushels, int year, int price){
        this.population = population;
        this.landsOwned = landsOwned;
        this.bushels = bushels;
        this.year = year;
        this.price = price;
        this.pDeaths = 0;
        this.sDeaths = 0;
        this.immigrants = 0;
        this.harvest = 0;
        this.rats = 0;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void changePopulation(int populationChange) {
        this.population += populationChange;
    }

    public int getLandsOwned() {
        return landsOwned;
    }

    public void setLandsOwned(int landsOwned) {
        this.landsOwned = landsOwned;
    }

    public void changeLandsOwned(int acresToChange) {
        this.landsOwned += acresToChange;
    }

    public int newCostOfLand() {
        return random.nextInt(7)+17;
    }

    public int getBushels() {
        return bushels;
    }

    public void setBushels(int bushels) {
        this.bushels = bushels;
    }
    public void changeBushels(int bushelsChanged) {
        this.bushels += bushelsChanged;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void incrementYear() {
        this.year += 1;
    }
    public int getpDeaths() {
        return pDeaths;
    }

    public void setpDeaths(int pDeaths) {
        this.pDeaths = pDeaths;
    }

    public int getsDeaths() {
        return sDeaths;
    }

    public void setsDeaths(int sDeaths) {
        this.sDeaths = sDeaths;
    }

    public int getImmigrants() {
        return immigrants;
    }

    public void setImmigrants(int immigrants) {
        this.immigrants = immigrants;
    }

    public int getHarvest() {
        return harvest;
    }

    public void setHarvest(int harvest) {
        this.harvest = harvest;
    }

    public int getRats() {
        return rats;
    }

    public void setRats(int rats) {
        this.rats = rats;
    }
}
