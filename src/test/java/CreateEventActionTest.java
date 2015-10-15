import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateEventActionTest {

    @Test (expected = IllegalArgumentException.class)
    public void needsARepository() {
        new CreateEventAction(null);
    }

    @Test (expected = IllegalStateException.class)
    public void needsToSetTheHostBeforeCreateIsCalled() {
        EventRepositorySpy spy = new EventRepositorySpy();
        CreateEventAction newAction = new CreateEventAction(spy);
        newAction.create();
    }

    @Test
    public void willCallIntoRepository() {
        EventRepositorySpy spy = new EventRepositorySpy();
        CreateEventAction newAction = new CreateEventAction(spy);
        User host = new User();
        newAction.host(host);
        newAction.create();
        assertTrue(spy.wasNewEventCalled);
        assertEquals(host, spy.newEventInput.host());
    }

}
