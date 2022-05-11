public class IceCreamMaker {
    public static void main(String[] args) {
        IceCream iceCream1 = new Sprinkles(new HotFudge(new Cone(2, "Vanilla")));
        IceCream iceCream2 = new WhippedCream(new Caramel(new Cone(1, "Chocolate")));
        System.out.println(iceCream1.getDescription() + " $" + iceCream1.getPrice());
        System.out.println(iceCream2.getDescription() + " $" + iceCream2.getPrice());  
    }
}