import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Church church = new Church("Pildesti Church");
        HashMap<LocalDate, TimeInterval> churchTimetable = new HashMap<>();
        churchTimetable.put(LocalDate.of(2024,4,7),new TimeInterval(LocalTime.of(7,0),LocalTime.of(21,0)));
        church.setTimetable(churchTimetable);

        Statue statue = new Statue("Pildesti Statue");
        HashMap<LocalDate, TimeInterval> statueTimetable = new HashMap<>();
        statueTimetable.put(LocalDate.of(2024,1,1),new TimeInterval(LocalTime.of(7,0),LocalTime.of(23,59)));
        statue.setTimetable(statueTimetable);

        Concert concert = new Concert("Smiley");
        HashMap<LocalDate, TimeInterval> concertTimetable = new HashMap<>();
        concertTimetable.put(LocalDate.of(2024,5,25),new TimeInterval(LocalTime.of(19,0),LocalTime.of(21,00)));
        concert.setTimetable(concertTimetable);
        concert.setTicketPrice(50.00);

        Trip excursie= new Trip("Roman",LocalDate.of(2024,1,1),LocalDate.of(2024,5,28), List.of(concert,church,statue));

        System.out.println(excursie);
    }
}