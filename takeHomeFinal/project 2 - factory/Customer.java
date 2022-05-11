public class Customer {
    private String name;
    private ComputerFactory cF;
    public Customer(String newName, ComputerFactory newCF) {
        this.name = newName;
        this.cF = newCF;
    }
    public void order(String brand, String type) {
        System.out.println(name + " ordered a " + brand + " " + type);
        Computer c = cF.makeComputer(brand, type);
        c.build();
    }
}