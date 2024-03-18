import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Trip {
    private String city;
    private LocalDate start, end;
    private List<Attraction> attractions = new ArrayList<>();

    public Trip(String city, LocalDate start, LocalDate end, List<Attraction> attractions) {
        this.city = city;
        this.start = start;
        this.end = end;
        this.attractions = attractions;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "city='" + city + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", attractions=" + attractions +
                '}';
    }

    public void displayVisitableNonPayableLocations(LocalDate date) {
        List<Attraction> visitableNonPayableLocations = new ArrayList<>();

        // Filter visitable attractions that are not payable
        for (Attraction attraction : attractions) {
            if (attraction instanceof Visitable && !attraction.isPayable()) {
                visitableNonPayableLocations.add(attraction);
            }
        }

        // Sort the attractions by opening hours for the given date
        Collections.sort(visitableNonPayableLocations, new Comparator<Attraction>() {
            @Override
            public int compare(Attraction a1, Attraction a2) {
                LocalTime openingHour1 = a1.getOpeningHour(date);
                LocalTime openingHour2 = a2.getOpeningHour(date);
                return openingHour1.compareTo(openingHour2);
            }
        });

        // Display the locations
        System.out.println("Visitable Non-Payable Locations Sorted by Opening Hour on " + date + ":");
        for (Attraction attraction : visitableNonPayableLocations) {
            LocalTime openingHour = attraction.getOpeningHour(date);
            System.out.println("- " + attraction.getName() + " (Opens at " + openingHour + ")");
        }
    }

}
