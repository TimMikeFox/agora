public class CreateEventAction {

    private EventRepository repository;

    private User host;
    private String name;

    public CreateEventAction(EventRepository repository) {
        if(repository == null)
            throw new IllegalArgumentException("CreateEventAction needs to be constructed with an EventRepository");
        this.repository = repository;
    }

    public void host(User theUser) {
        host = theUser;
    }

    public void name(String eventName) { name = eventName; }

    public Event create() {
        if(host == null)
            throw new IllegalStateException("The host needs to be set before creating the Event");
        if(name == null)
            throw new IllegalStateException("The event name needs to be set before creating the Event");
        Event event = new Event();
        event.setHost(host);
        event.setName(name);
        repository.newEvent(event);
        return event;
    }
}
