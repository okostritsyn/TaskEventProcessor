import java.util.Queue;

public class EventListenerImpl implements EventListener{
    private final Queue<Event> sharedQueue;
    private final int SIZE;

    public EventListenerImpl(Queue<Event> sharedQueue, int SIZE) {
        this.sharedQueue = sharedQueue;
        this.SIZE = SIZE;
    }

    @Override
    public void onEventReceived(Event event) throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.size() == SIZE) {
                sharedQueue.wait();
            }

            sharedQueue.add(event);

            sharedQueue.notifyAll();
        }
    }
}
