import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TravelPlan {
    private Map<Attraction, LocalDate> plan;

    public TravelPlan() {
        this.plan = new HashMap<>();
    }

    public void addVisit(Attraction attraction, LocalDate date) {
        plan.put(attraction, date);
    }

    public LocalDate getVisitDate(Attraction attraction) {
        return plan.get(attraction);
    }

    @Override
    public String toString() {
        return "TravelPlan{" +
                "plan=" + plan +
                '}';
    }
}
