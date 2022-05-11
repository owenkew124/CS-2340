public class ComputerTester {
    public static void main(String[] args) {
        ComputerFactory cF = new ComputerFactory();
        Customer Michael = new Customer("Michael", cF);
        Michael.order("Dellis", "Workstation");
        Customer Hanna = new Customer("Hanna", cF);
        Hanna.order("HPi", "Server");
        Customer Lenny = new Customer("Lenny", cF);
        Lenny.order("Lenovoi", "Laptop");
    }
 }
