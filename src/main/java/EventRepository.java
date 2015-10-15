import java.util.List;

public interface EventRepository {
    List<Event> eventsHostedBy(User host);

    void newEvent(Event event);
}
