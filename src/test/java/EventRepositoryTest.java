import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
