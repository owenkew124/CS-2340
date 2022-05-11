import java.lang.Math;
public class Cone implements IceCream {
    private int scoops;
    private String flavor;

    public Cone(int numScoops, String iCreamFlavor) {
        this.scoops = numScoops;
        this.flavor = iCreamFlavor;
    }

    public String getDescription() {
        String dOrS;
        if (scoops == 2) {
            dOrS = "double";
        } else {
            dOrS = "single";
        }
        return "A " + dOrS + " scoop of " + flavor.toLowerCase() + " ice cream";
    }
    public double getPrice() {
        double price;
        if (scoops == 2) {
            price = 3.99;
        } else {
            price = 2.79;
        }
        return Math.round(price*100) / 100.0;
    }
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
    public String getFlavor() {
        return flavor;
    }
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    public int getScoops() {
        return scoops;
    }
    public void setScoops(int scoops) {
        this.scoops = scoops;
    }
    
}
