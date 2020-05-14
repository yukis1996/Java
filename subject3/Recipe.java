public class Recipe {

    private String name;
    private double kl;

    public Recipe (String name, double kl) {
        this.name = name;
        this.kl = kl;
    }

    public String getName() {
        return this.name;
    }

    public double getCal() {
        return this.kl;
    }

}