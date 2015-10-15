public class Event {
    private User host;
    private String name;

    public User host() {
        return host;
    }

    public String name() {
        return name;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public void setName(String name) {
        this.name = name;
    }
}
