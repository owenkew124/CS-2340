import java.lang.Math;
public class Sprinkles extends IceCreamDecorator {
    public Sprinkles(IceCream newCone) {
        super(newCone);
    }
    public String getDescription() {
        return tempCone.getDescription() + ", sprinkles";
    }
    public double getPrice() {
        return Math.round((tempCone.getPrice() + 0.79) * 100) / 100.0;
    }
}
