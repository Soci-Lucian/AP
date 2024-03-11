import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public class Concert extends Attraction implements Visitable, Payable{
    public Concert(String name) {
        super(name);
    }

    private Map<LocalDate, TimeInterval> timetable;
    private double ticketPrice;
    @Override
    public Map<LocalDate,TimeInterval> getTimetable() {
        return timetable;
    }
    public void setTimetable(HashMap<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }
    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
