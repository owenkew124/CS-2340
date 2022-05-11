import java.lang.Math;
public class Caramel extends IceCreamDecorator {
    public Caramel(IceCream newCone) {
        super(newCone);
    }
    public String getDescription() {
        return tempCone.getDescription() + ", caramel";
    }
    public double getPrice() {
        return Math.round((tempCone.getPrice() + 0.89) * 100) / 100.0;
    }
}
