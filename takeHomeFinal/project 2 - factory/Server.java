public class Server extends Computer {
    private String brand;

    public Server(String newBrand) {
        this.brand = newBrand;
    }

    public String getBrand() {
        return brand;
    }

    public void build() {
        System.out.println("--- Making a " + brand + " server ---");
        this.addMem();
        this.addHDD();
        this.addCPU();
        this.addGPU();
        this.addExtras(); 
    }

    public void addExtras() {
        System.out.println("    adding a powerful " + brand + " network card");
    }
    public void addMem() {
        System.out.println("    adding multiple " + brand + " memory chips");
    }
    
    public void addHDD() {
        System.out.println("    adding multiple " + brand + " hdds");
    }

    public void addCPU() {
        System.out.println("    adding a powerful " + brand + " cpu with many cores");
    }

    public void addGPU() {
        System.out.println("    adding a generic " + brand + " gpu");
        
    }

}
