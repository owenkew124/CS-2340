import java.lang.Math;
abstract class IceCreamDecorator implements IceCream {
    protected IceCream tempCone;
    public IceCreamDecorator(IceCream newCone) {
        tempCone = newCone;
    }
    public String getDescription() {
        return tempCone.getDescription();
    }
    public double getPrice() {
        return Math.round(tempCone.getPrice() * 100) / 100.0;
    }
}
