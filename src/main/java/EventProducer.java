import java.util.LinkedList;
import java.util.Queue;

public class EventProducer {
    private EventListener eventListener;

    public EventProducer(Queue<Event>  sharedQueue, int size) {
        this.eventListener = new EventListenerImpl(sharedQueue,size);
    }

    public void start() throws InterruptedException {
        eventListener.onEventReceived(new Event(1,"log","line 1"));
        eventListener.onEventReceived(new Event(2,"log","line 2"));
    }
}
