import java.util.List;

public class EventRepositorySpy implements EventRepository {

    public boolean wasNewEventCalled = false;
    public Event newEventInput = null;

    @Override
    public List<Event> eventsHostedBy(User host) {
        return null;
    }

    @Override
    public void newEvent(Event event) {
        wasNewEventCalled = true;
        newEventInput = event;
    }
}
