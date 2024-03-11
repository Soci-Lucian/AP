import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

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

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Depot depot = (Depot) obj;
        return Objects.equals(location, depot.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, masini);
    }
}
