import java.lang.Math;
public class WhippedCream extends IceCreamDecorator {
    public WhippedCream(IceCream newCone) {
        super(newCone);
    }
    public String getDescription() {
        return tempCone.getDescription() + ", whipped cream";
    }
    public double getPrice() {
        return Math.round((tempCone.getPrice() + 0.50) * 100) / 100.0;
    }
}
