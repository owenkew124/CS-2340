public abstract class Computer {
    private String brand;

    abstract void build();

    abstract void addMem();
    abstract void addHDD();
    abstract void addCPU();
    abstract void addGPU();
    abstract void addExtras();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}