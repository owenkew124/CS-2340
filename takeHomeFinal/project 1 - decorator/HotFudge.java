import java.lang.Math;
public class HotFudge extends IceCreamDecorator {
    public HotFudge(IceCream newCone) {
        super(newCone);
    }
    public String getDescription() {
        return tempCone.getDescription() + ", hot fudge";
    }
    public double getPrice() {
        return Math.round((tempCone.getPrice() + 0.99) * 100) / 100.0;
    }
}
