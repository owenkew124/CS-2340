public class Laptop extends Computer {
    private String brand;

    public Laptop(String newBrand) {
        this.brand = newBrand;
    }

    public String getBrand() {
        return brand;
    }


    public void build() {
        System.out.println("--- Making a " + brand + " laptop ---");
        this.addMem();
        this.addHDD();
        this.addCPU();
        this.addGPU();
        this.addExtras();
    }

    public void addExtras() {
        System.out.println("    adding a light WiFi card");
    }

    public void addMem() {
        System.out.println("    adding a light " + brand + " memory");
    }

    public void addHDD() {
        System.out.println("    adding a light " + brand + " hdd");
    }

    public void addCPU() {
        System.out.println("    adding a light " + brand + " cpu");
    }

    public void addGPU() {
        System.out.println("    adding a light " + brand + " gpu");
        
    }
    
}
