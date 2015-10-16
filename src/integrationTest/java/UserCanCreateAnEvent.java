import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserCanCreateAnEvent {

     @Test public void userCanCreateAnEvent() {
         User theUser = new User();
         EventRepository repository = new InMemoryEventRepository();
         CreateEventAction newEvent = new CreateEventAction(repository);
         newEvent.host(theUser);
         newEvent.name("TEST EVENT");
         newEvent.create();
         List<Event> events = repository.eventsHostedBy(theUser);
         Assert.assertEquals(1, events.size());
         Event createdEvent = events.get(0);
         Assert.assertEquals(theUser, createdEvent.host());
    }

}
