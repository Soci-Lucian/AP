import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {

    Map<LocalDate, TimeInterval> getTimetable();
    default LocalTime getOpeningHour(LocalDate date) {
        TimeInterval timeInterval = getTimetable().get(date);
        if(timeInterval != null){
            return timeInterval.getFirst();
        } else{
            return null;
        }
    }

    default boolean isPayable() {
        return false; // By default, attractions are not payable
    }
}
