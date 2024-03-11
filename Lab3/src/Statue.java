import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Statue extends Attraction implements Visitable{

    public Statue(String name) {
        super(name);
    }

    private Map<LocalDate, TimeInterval> timetable;
    @Override
    public Map<LocalDate,TimeInterval> getTimetable() {
        return timetable;
    }
    public void setTimetable(HashMap<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }
}
