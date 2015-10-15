public class Driver {
    public static void main(String... args) {
        User theUser = new User();
        theUser.setName("HOSTNAME");
        EventRepository repository = new InMemoryEventRepository();
        CreateEventAction newEvent = new CreateEventAction(repository);
        newEvent.host(theUser);
        newEvent.name("THE EVENT");
        Event event = newEvent.create();
        System.out.println(String.format("Event '%s' create for the host '%s'", event.name(), theUser.name()));
    }
}
