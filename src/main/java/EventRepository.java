import java.util.*;

public class EventRepository {

    private Map<User, List<Event>> events;

    public EventRepository() {
        events = new HashMap<>();
    }

    public List<Event> eventsHostedBy(User host) {
        List<Event> hostedEvents = events.get(host);
        if(hostedEvents == null)
            hostedEvents = Collections.<Event>emptyList();
        return hostedEvents;
    }

    public void newEvent(Event event) {
        List<Event> hostedEvents = events.get(event.host());
        if(hostedEvents == null)
            hostedEvents = new ArrayList<>();
        hostedEvents.add(event);
        events.put(event.host(), hostedEvents);
    }
}
