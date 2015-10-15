import java.util.*;

public class InMemoryEventRepository implements EventRepository {

    private Map<User, List<Event>> events;

    public InMemoryEventRepository() {
        this(new HashMap<>());
    }

    protected InMemoryEventRepository(Map<User, List<Event>> map) {
        if(map == null)
            throw new IllegalArgumentException("Must be initialized with a store map");
        events = map;
    }

    @Override
    public List<Event> eventsHostedBy(User host) {
        List<Event> hostedEvents = events.get(host);
        if(hostedEvents == null)
            hostedEvents = Collections.<Event>emptyList();
        return hostedEvents;
    }

    @Override
    public void newEvent(Event event) {
        if(event.host() == null)
            throw new IllegalArgumentException("Can not store an event without a host");
        List<Event> hostedEvents = events.get(event.host());
        if(hostedEvents == null)
            hostedEvents = new ArrayList<>();
        hostedEvents.add(event);
        events.put(event.host(), hostedEvents);
    }
}
