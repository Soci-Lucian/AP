import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Church church = new Church("Chicago Church");
        HashMap<LocalDate, TimeInterval> churchTimetable = new HashMap<>();
        churchTimetable.put(LocalDate.of(2024,4,7),new TimeInterval(LocalTime.of(8,0),LocalTime.of(20,0)));
        churchTimetable.put(LocalDate.of(2024,4,8),new TimeInterval(LocalTime.of(9,0),LocalTime.of(21,0)));
        church.setTimetable(churchTimetable);

        Statue statue = new Statue("Chicago Statue");
        HashMap<LocalDate, TimeInterval> statueTimetable = new HashMap<>();
        statueTimetable.put(LocalDate.of(2024,4,7),new TimeInterval(LocalTime.of(7,0),LocalTime.of(23,59)));
        statue.setTimetable(statueTimetable);

        Concert concert = new Concert("The Weeknd Concert");
        HashMap<LocalDate, TimeInterval> concertTimetable = new HashMap<>();
        concertTimetable.put(LocalDate.of(2024,4,7),new TimeInterval(LocalTime.of(19,0),LocalTime.of(21,00)));
        concert.setTimetable(concertTimetable);
        concert.setTicketPrice(50.00);

        Trip excursie= new Trip("Chicago",LocalDate.of(2024,1,1),LocalDate.of(2024,5,28), List.of(concert,church,statue));

        System.out.println(excursie);

        excursie.displayVisitableNonPayableLocations(LocalDate.of(2024,4,7));

        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addVisit(church, LocalDate.of(2024, 4, 8));
        travelPlan.addVisit(statue, LocalDate.of(2024, 4, 7));
        travelPlan.addVisit(concert, LocalDate.of(2024, 4, 7));

        System.out.println(travelPlan);
    }
}