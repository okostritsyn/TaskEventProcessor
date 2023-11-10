public class Event {
    private int id;
    private String type;
    private Object data;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    public String getType() {
        return type;
    }

    public Object getData() {
        return data;
    }

    public Event(int id, String type, Object data) {
        this.id = id;
        this.type = type;
        this.data = data;
    }
}
