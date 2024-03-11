public class Truck extends Vehicle {
    private int capacity;

    public Truck(String marca, String culoare, int an, int capacity) {
        super(marca, culoare, an);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "capacity=" + capacity +
                '}';
    }
}