public class EventHandlerFactory {
    public static EventHandler getHandler (String type) {
        EventHandler handler = null;

        switch (type) {
            case "log":
                handler = new EventHandlerTypeOne();
                break;
            default:
                handler = new EventHandlerTypeOne();
        }

        return handler;
    }
}
