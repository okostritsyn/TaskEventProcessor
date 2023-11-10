import java.util.LinkedList;

public class Main {
    public static void main(String[] strings) {
        LinkedList<Event> sharedQueue = new LinkedList<>();
        int size = 10;
        EventProducer eventProducer = new EventProducer(sharedQueue,size);
        Thread consThread = new Thread(new EventConsumer(sharedQueue), "EventConsumer");
        consThread.start();
        try {
            eventProducer.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
