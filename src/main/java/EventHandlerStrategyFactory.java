public class EventHandlerStrategyFactory {
    public static EventHandlerStrategy getStrategy (Event event) {
        EventHandlerStrategy strategy = null;

        switch (event.getId()) {
            case 1:
                strategy = new EventHandlerStrategyImpl();
                break;
            case 2:
                strategy = new EventHandlerStrategyIncrementImpl();
                break;
            default:
                strategy = new EventHandlerStrategyImpl();
        }

        return strategy;
    }
}
