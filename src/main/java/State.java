import java.util.Random;

public class State {
    int population, landsOwned, bushels, price, year;
    Random random = new Random();

    public State(){
    }

    public State(int population, int landsOwned, int bushels, int year, int price) {
        this.population = population;
        this.landsOwned = landsOwned;
        this.bushels = bushels;
        this.year = year;
        this.price = price;
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

}
