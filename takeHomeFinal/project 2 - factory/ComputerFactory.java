public class ComputerFactory {
    public Computer makeComputer(String brand, String type) {
        Computer computer = null;
        if (type.toUpperCase().equals("LAPTOP")) {
            computer = new Laptop(brand);
        } else if (type.toUpperCase().equals("WORKSTATION")) {
            computer = new Workstation(brand);
        } else if (type.toUpperCase().equals("SERVER")) {
            computer = new Server(brand);
        }
        return computer;

    }
}
