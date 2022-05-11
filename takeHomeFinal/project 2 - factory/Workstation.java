public class Workstation extends Computer {
    private String brand;

    public Workstation(String newBrand) {
        this.brand = newBrand;
    }

    public String getBrand() {
        return brand;
    }


    @Override
    public void build() {
        System.out.println("--- Making a " + brand + " workstation ---");
        this.addMem();
        this.addHDD();
        this.addCPU();
        this.addGPU();
        this.addExtras(); 
    }

    public void addExtras() {
        System.out.println("    adding an audio card");
        System.out.println("    adding a generic network card");
    }
    public void addMem() {
        System.out.println("    adding " + brand + " memory");
    }
    
    public void addHDD() {
        System.out.println("    adding " + brand + " hdd");
    }

    public void addCPU() {
        System.out.println("    adding " + brand + " cpu");
    }

    public void addGPU() {
        System.out.println("    adding a powerful " + brand + " gpu");
        
    }
}
