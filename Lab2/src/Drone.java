public class Drone extends Vehicle {
    private int maxFlightDuration;

    public Drone(String marca, String culoare, int an, int maxFlightDuration) {
        super(marca, culoare, an);
        this.maxFlightDuration = maxFlightDuration;
    }

    public int getMaxFlightDuration() {
        return maxFlightDuration;
    }

    public void setMaxFlightDuration(int maxFlightDuration) {
        this.maxFlightDuration = maxFlightDuration;
    }
}