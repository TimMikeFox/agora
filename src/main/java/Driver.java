import java.util.List;

public class Driver {
    public static void main(String... args) {
        User theUser = new User();
        EventRepository repository = new InMemoryEventRepository();
        CreateEventAction newEvent = new CreateEventAction(repository);
        newEvent.host(theUser);
        Event event = newEvent.create();
        System.out.println(String.format("Event %s create for the host %s", event, theUser));
    }
}
