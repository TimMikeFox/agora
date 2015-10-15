import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class EventRepositoryTest {

    @Test (expected = IllegalArgumentException.class)
    public void mustProvideAStoreImpl() {
        new EventRepository(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void willNotStoreEventsForNullHosts() {
        Map<User, List<Event>> mockStore = new HashMap<>();
        EventRepository repo = new EventRepository(mockStore);
        repo.newEvent(new Event());
    }

    @Test
    public void testNewEvent() {
        Map<User, List<Event>> mockStore = new HashMap<>();
        EventRepository repo = new EventRepository(mockStore);
        User host = new User();
        Event event = new Event();
        event.setHost(host);
        repo.newEvent(event);
        assertTrue(mockStore.containsKey(host));
        assertEquals(1, mockStore.get(host).size());
        assertTrue(mockStore.get(host).contains(event));
    }

    @Test
    public void testEventsHostedBy() {
        Map<User, List<Event>> mockStore = new HashMap<>();
        User theHost = new User();
        Event[] events = {new Event(), new Event(), new Event(), new Event(), new Event(), new Event()};
        for(Event e : events)
            e.setHost(theHost);
        mockStore.put(theHost, Arrays.asList(events));
        EventRepository repo = new EventRepository(mockStore);
        List<Event> theHostsEvents = repo.eventsHostedBy(theHost);
        assertEquals(events.length, theHostsEvents.size());
        for(Event e : events)
            assertTrue(theHostsEvents.contains(e));
    }

}
