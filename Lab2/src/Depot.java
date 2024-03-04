import java.lang.reflect.Array;
import java.util.ArrayList;

public class Depot {
    private String location;
    private ArrayList<Vehicle> masini;

    public Depot(String location) {
        this.location = location;
        this.masini = new ArrayList<>();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Vehicle> getMasini() {
        return masini;
    }

    public void setMasini(ArrayList<Vehicle> masini) {
        this.masini = masini;
    }

    public void addVehicle(Vehicle masina){
        masini.add(masina);
    }

    @Override
    public String toString() {
        return "Depot{" +
                "location='" + location + '\'' +
                ", masini=" + masini +
                '}';
    }
}
