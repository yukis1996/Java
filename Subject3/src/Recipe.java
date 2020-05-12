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

    public static void main(String[] args) throws Exception {
		Recipe r1 = new Recipe("ハンバーグ", 200.5);
        Recipe r2 = new Recipe("サーモン", 120);

        System.out.println(r1.getName()); //ハンバーグ
        System.out.println(r1.getCal()); //200.5
    }

}