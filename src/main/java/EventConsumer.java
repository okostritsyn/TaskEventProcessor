import java.util.Queue;

class EventConsumer implements Runnable {
    private final Queue<Event> sharedQueue;

    public EventConsumer(Queue<Event> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Event currEvent = consume();
                EventHandler handler = EventHandlerFactory.getHandler(currEvent.getType());
                EventHandlerStrategy strategy = EventHandlerStrategyFactory.getStrategy(currEvent);
                strategy.runStrategy(handler,currEvent.getData());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private Event consume() throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.isEmpty()) {
                sharedQueue.wait();
            }

            sharedQueue.notifyAll();
            return sharedQueue.poll();
        }
    }
}
