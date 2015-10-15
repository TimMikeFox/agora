public class CreateEventAction {

    private EventRepository repository;

    private User host;

    public CreateEventAction(EventRepository repository) {
        this.repository = repository;
    }

    public void host(User theUser) {
        host = theUser;
    }

    public void create() {
        Event event = new Event();
        event.setHost(host);
        repository.newEvent(event);
    }
}
