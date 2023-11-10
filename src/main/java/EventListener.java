public interface EventListener {
    void onEventReceived(Event event) throws InterruptedException;
}
